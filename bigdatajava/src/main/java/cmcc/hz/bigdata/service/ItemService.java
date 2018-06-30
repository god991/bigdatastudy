package cmcc.hz.bigdata.service;

import cmcc.hz.bigdata.pojo.Product;

import java.util.List;

public interface ItemService {
/*    public int itemInsert(TblItem tblItem);
    public int itemDelete(int id);
    public int itemUpdate(TblItem tblItem);
    public TblItem itemSelect(int id);*/
    public List<Product> itemSelectAll(int np) ;

}
