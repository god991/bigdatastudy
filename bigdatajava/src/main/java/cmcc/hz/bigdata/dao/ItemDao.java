package cmcc.hz.bigdata.dao;

import cmcc.hz.bigdata.pojo.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ItemDao {
    //1.insert
    /*@Insert("insert into tblItem(item,user) values(#{item},#{user})")
    public int itemInsert(TblItem tblItem);
    //2.delete
    @Delete("delete from tblItem where id = #{id} limit 1")
    public int itemDelete(int id);
    //3.update
    @Update("update tblItem set user=#{user} where id = #{id} limit 1")
    public int itemUpdate(TblItem tblItem);
    //4.select
    @Select("select * from tblItem where id = #{id} order by id desc limit 1")
    public TblItem itemSelect(int id);
    //5.selectall*/
    @Select("SELECT * FROM  product")
    public List<Product> itemSelectAll(int np);
}
