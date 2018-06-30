package cmcc.hz.bigdata.dao;

import cmcc.hz.bigdata.pojo.UserGPS;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.MultipleColumnPrefixFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: bigdata
 * @description:
 * @author: liminjie
 * @create: 2018-06-20 13:55
 * tb_gps2表使用的是日期+手机号作为rowkey
 * scan的筛选，包括startrow，不包括stoprow
 **/

@Service("HbaseDaoImpl2")
public class HbaseDaoImpl2 implements HbaseDao{
    Connection connection = null;
    Table table=null;

    //@Value("${hbase.zookeeper.quorum}")
    private String hbasezookeeper="quickstart.cloudera:2181";
    //    @Value("${hbase.usertable1}")
    private String hbaseTable="tb_gps2";
    //    @Value("${hbase.usertable1.cf}")
    private String columnFamily="gps";

    public HbaseDaoImpl2() {

    }

    /**
     *
     * @param startRow
     * @param stopRow
     * @param multipleColumnPrefixFilter  模糊匹配，可模糊匹配多个值
     * @param cls
     * @return
     * @throws Exception
     * HBase中tb_gps2表中存储的rowkey为手机号+日期。
     * 从tb_gps2表中使用scan方式读取数据。
     */
    @Override
    public List<Object> getHbaseData(String startRow,String stopRow, String[] multipleColumnPrefixFilter,Class cls) throws Exception {

        if (table==null){
            if(!this.connectToDB())
                return  null;
        }

        byte[] cf1 = Bytes.toBytes(columnFamily);//列族
        byte[] row1 = Bytes.toBytes(startRow);//行键start
        byte[] row2 = Bytes.toBytes(stopRow);//行键end
        //row1 = Bytes.toBytes("15802550181");
        //row2 = Bytes.toBytes("15802550181");
        byte[] qf1 = Bytes.toBytes("gps_"); //列限定符
        //byte[] qf2 = Bytes.toBytes("2008-02-");//列限定符
        byte[][] prefixes = new byte[][] {qf1};

       /* byte[][] prefixes=new byte[multipleColumnPrefixFilter.length][];
        for (int i = 0; i <multipleColumnPrefixFilter.length ; i++) {
            prefixes[i]=Bytes.toBytes(multipleColumnPrefixFilter[i]);
        }*/

       //返回所有行中以name或者age打头的列的数据
        MultipleColumnPrefixFilter ff = new MultipleColumnPrefixFilter(prefixes);
        Scan scan = new Scan(row1,row2);
        scan.setFilter(ff);
        scan.addFamily(cf1);
        ResultScanner results=null;
        //System.out.println("查询tb_gps2表: starttime:" + System.currentTimeMillis());
        long sttime=System.currentTimeMillis();

        results = table.getScanner(scan);
        List<Object> objectList=new ArrayList();
        for (Result result : results) {
            String row = Bytes.toString(result.getRow());
            String acc_nbr=row.substring(0,11);
            String strdate=row.substring(11);
            //System.out.println("Row: " + row + " ");
            for(Cell c:result.rawCells()){
                UserGPS obj=new UserGPS();
                obj.setAcc_nbr(acc_nbr);
                String gpsTime=Bytes.toString(CellUtil.cloneQualifier(c));
                gpsTime=strdate+" "+gpsTime.split("_")[1];
                obj.setStrGPSTime(gpsTime);
                String  tmp=Bytes.toString(CellUtil.cloneValue(c));
                String[] lng_lat=Bytes.toString(CellUtil.cloneValue(c)).split("\\|");
                obj.setLng(lng_lat[0]);
                obj.setLat(lng_lat[1]);
                objectList.add(obj);
            }
        }
        //System.out.println("查询tb_gps2表: endtime:"  +System.currentTimeMillis());
        sttime=System.currentTimeMillis()-sttime;
        System.out.println("查询tb_gps2表条数："+objectList.size()+"用时:" +sttime);

        results.close();
        return objectList;
    }

    private boolean connectToDB(){
        Configuration conf= HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum",hbasezookeeper);
        try {
            connection = ConnectionFactory.createConnection(conf);
            //建立表的连接
            table = connection.getTable(TableName.valueOf(hbaseTable));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
