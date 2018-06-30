package cmcc.hz.bigdata.service;

import cmcc.hz.bigdata.dao.HbaseDao;
import cmcc.hz.bigdata.pojo.UserGPS;
import org.apache.avro.generic.GenericData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: bigdata
 * @description:
 * @author: liminjie
 * @create: 2018-06-24 15:57
 **/
@Service
public class HbaseServiceImpl implements HbaseService{
    @Resource(name="HbaseDaoImpl")
    private  HbaseDao hbaseDao;

    @Override
    public List<UserGPS> getUserGPS(String acc_nbr,String stdate, String enddate) {
        String[] clumnPrexs;
        //调用Hbase时，需要将每天的日期或按月传入，所以先计算日期数组
        //计算天数,把每天日期存入数组
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1=simpleDateFormat.parse(stdate);
            Calendar cdate1 = new   GregorianCalendar();
            cdate1.setTime(date1);

            Date date2=simpleDateFormat.parse(enddate);
            long difference =  (date2.getTime()-date1.getTime())/86400000;
            int days= (int)Math.abs(difference);
            //int days=cdate2.get(Calendar.DAY_OF_YEAR)-cdate1.get(Calendar.DAY_OF_YEAR);
            //System.out.println(days);
            if(days<0){
                //日期不对，返回一个空数组
                List<UserGPS> gpsList=new ArrayList<>();
                gpsList.add(new UserGPS("结束日期<开始日期啦！"));
                return gpsList;
            }
            else if (days==0)
                days=1; //同一天时，也需要两个数组值
            clumnPrexs=new String[days+1];
            clumnPrexs[0]=stdate;
            Calendar ctmp=null;
            for (int i = 0; i <days-1 ; i++) {
                cdate1.add(Calendar.DATE, 1);
                clumnPrexs[i+1]=simpleDateFormat.format(cdate1.getTime());
            }
            clumnPrexs[days]=enddate;
        } catch (ParseException e) {
            e.printStackTrace();
            return  null;
        }

        try {
            return  (List<UserGPS>)(List)hbaseDao.getHbaseData(acc_nbr,acc_nbr,clumnPrexs,UserGPS.class);
        } catch (Exception e) {
            System.out.println("查询Hbase出错！");
            e.printStackTrace();
        }
        return null;
    }

    @Resource(name="HbaseDaoImpl2")
    private HbaseDao hbaseDao2;

    @Override
    public List<UserGPS> getUserGPS2(String acc_nbr, String stdate, String enddate) {
        String clumnPrexs[]={""};
        //scan的筛选，包括startrow，不包括stoprow,因此结束日期需要加1天
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date1= null;

        try {
            Date date2 = simpleDateFormat.parse(enddate);
            Calendar cdate2 = new   GregorianCalendar();
            cdate2.setTime(date2);
            cdate2.add(Calendar.DATE, 1);
            String strEndDate=simpleDateFormat.format(cdate2.getTime());
            return  (List<UserGPS>)(List)hbaseDao2.getHbaseData(acc_nbr+stdate,acc_nbr+strEndDate,clumnPrexs,UserGPS.class);
        } catch (Exception e) {
            System.out.println("查询Hbase出错！");
            e.printStackTrace();
        }
        return null;
    }
}
