package cmcc.hz.bigdata.controller;

import cmcc.hz.bigdata.pojo.Product;
import cmcc.hz.bigdata.pojo.TerminalCount;
import cmcc.hz.bigdata.pojo.UserGPS;
import cmcc.hz.bigdata.pojo.UserPersona;
import cmcc.hz.bigdata.service.HbaseService;
import cmcc.hz.bigdata.service.ItemService;
import cmcc.hz.bigdata.service.UserPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserPersonaCtrl {
    @Autowired
    private UserPersonaService userPersonaService;
    private int intResult=-1;

    @RequestMapping(value = "getUserPersona/{acc_nbr}",method = RequestMethod.GET)
    public String getUserPersona(@PathVariable String acc_nbr, HttpServletResponse httpServletResponse){
        //System.out.println(acc_nbr);
        String strJson= userPersonaService.getUserPersonaWeightInfoByAcc_nbr(acc_nbr);
        return "["+strJson+"]";
    }

    @RequestMapping(value = "getUserNbr/{acc_nbr}",method = RequestMethod.GET)
    public List<UserPersona> getMultitermUserPersona(@PathVariable String acc_nbr, HttpServletResponse httpServletResponse){
        //System.out.println(acc_nbr);
        return userPersonaService.getUserPersonaLeftLikeAcc_nbr(acc_nbr);
    }

    @RequestMapping( "getTerCount")
    public List<TerminalCount> getTerCount(HttpServletRequest req){
        return  userPersonaService.getTerminal_brandCount();
    }

    @RequestMapping( "getTerAmount")
    public List<TerminalCount> getTerAmount(HttpServletRequest req){
        return  userPersonaService.getTerminal_sum_amount();
    }


}
