package cmcc.hz.bigdata.service;

import cmcc.hz.bigdata.pojo.Product;
import cmcc.hz.bigdata.pojo.UserGPS;

import java.util.List;

public interface HbaseService {
/*    public int itemInsert(TblItem tblItem);
    public int itemDelete(int id);
    public int itemUpdate(TblItem tblItem);
    public TblItem itemSelect(int id);*/
    //public List<Product> itemSelectAll(int np) ;
    public List<UserGPS> getUserGPS(String acc_nbr,String stdate, String enddate);

    //**调用gps2表
    public List<UserGPS> getUserGPS2(String acc_nbr,String stdate, String enddate);

}
