package cmcc.hz.bigdata.dao;

import cmcc.hz.bigdata.pojo.UserPersona;

import java.util.List;

public interface HbaseDao {
   public List<Object> getHbaseData(String startRow,String stopRow, String[] multipleColumnPrefixFilter,Class cls) throws Exception;

}
