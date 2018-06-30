package cmcc.hz.bigdata.controller;

import cmcc.hz.bigdata.pojo.Product;
import cmcc.hz.bigdata.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;
    private int intResult=-1;
    @RequestMapping( "/showAll")
    public List<Product> itemInsert(HttpServletRequest req){
        //定义字段
       /* String item=req.getParameter("item");
        String user=req.getParameter("user");
        String user_group=req.getParameter("user_group");

        Product tblItem=new Product(item,user,user_group);
        tblItem.setItem(req.getParameter("item"));
        intResult=itemService.itemInsert(tblItem);*/
       return itemService.itemSelectAll(10);
    }

    //@RequestMapping(value = "impala",method = RequestMethod.GET)
    public  String impalatest(HttpServletResponse httpServletResponse) {
        String DRIVER = "com.cloudera.impala.jdbc41.Driver";
        String URL = "jdbc:impala://192.168.50.2:21050/bigdataapp";
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL);
            pst = conn.prepareStatement("select * from tb_comm_app_service_div limit 20");
            rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(conn!=null){
                try {
                    conn.close();
                    pst.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }}
        }
        return  "connect impala finish";
    }

}
