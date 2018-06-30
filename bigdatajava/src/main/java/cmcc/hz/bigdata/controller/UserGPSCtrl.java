package cmcc.hz.bigdata.controller;

import cmcc.hz.bigdata.pojo.TerminalCount;
import cmcc.hz.bigdata.pojo.UserGPS;
import cmcc.hz.bigdata.pojo.UserPersona;
import cmcc.hz.bigdata.service.HbaseService;
import cmcc.hz.bigdata.service.UserPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("gps")
public class UserGPSCtrl {
    @Autowired
    private HbaseService hbaseService;
    private int intResult=-1;

    @RequestMapping("getUserGPSDate")
    public List<UserGPS> getUserPersona(HttpServletRequest req){
        //System.out.println(acc_nbr);
        //return(contentService.contentSelectOne(Integer.parseInt(req.getParameter("id"))));
        //需要参数有：手机号、开始日期、结束日期
        String acc_nbr = req.getParameter("acc_nbr");
        String stDate = req.getParameter("stdate");
        String endDate = req.getParameter("enddate");

        String isgps2=req.getParameter("gps2");
        if(isgps2==null) {
            return hbaseService.getUserGPS(acc_nbr, stDate, endDate);
        }else{
            return hbaseService.getUserGPS2(acc_nbr, stDate, endDate);
        }
    }

}
