package cmcc.hz.bigdata.service;

import cmcc.hz.bigdata.dao.ImpalaDao;
import cmcc.hz.bigdata.dao.ImpalaDaoImpl;
import cmcc.hz.bigdata.pojo.TerminalCount;
import cmcc.hz.bigdata.pojo.UserPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bigdata
 * @description:
 * @author: liminjie
 * @create: 2018-06-20 15:17
 **/

@Service
public class UserPersonaServiceImpl implements UserPersonaService{
    @Autowired
    ImpalaDao impalaDao;

    @Override
    public UserPersona getUserPersonaByAcc_nbr(String acc_nbr) {
        return impalaDao.getAppPersonaByAcc_nbr(acc_nbr);
    }

    @Override
    public List<UserPersona> getUserPersonaLimit(int limit) {
        return null;
    }

    @Override
    public List<UserPersona> getUserPersonaLeftLikeAcc_nbr(String acc_nbr) {
        int acclen=acc_nbr.length();
        String sql="select * from  bigdataapp.tb_comm_app_persona2 ";
        sql +=" where substr(acc_nbr,1,"+Integer.toString(acclen)+")='"+acc_nbr+"' ";
        sql +=" limit 20";
        System.out.println(sql);
        //List<UserPersona> userPersonaList=(List<UserPersona>)(List)impalaDao.getImpalaData(sql,UserPersona.class);
        return (List<UserPersona>)(List)impalaDao.getImpalaData(sql,UserPersona.class);
    }

    @Override
    public String getUserPersonaWeightInfoByAcc_nbr(String acc_nbr) {
        UserPersona userPersona=impalaDao.getAppPersonaByAcc_nbr(acc_nbr);
        //转换为用户画像所需要的json格式。
        /**
         {name: "Jayfee",
         value: 666
         },
         {name: "Nancy",
         value: 520
         },
         **/
        if (userPersona==null){
            return  null;
        }
        String strJson="{";
        strJson+="\"acc_nbr\":\""+userPersona.getAcc_nbr()+"\"";
        strJson+=",\"personaValue\":[";
        strJson+="{\"name\":\""+userPersona.getTerminal_cd()+"\",\"value\":300}";
        strJson+=",{\"name\":\""+userPersona.getCharge_div_Comment()+"\",\"value\":"+Integer.toString(1000-userPersona.getCharge_div()*100)+"}";
        strJson+=",{\"name\":\""+userPersona.getDuration_level_Comment()+"\",\"value\":"+Integer.toString(1000-userPersona.getDuration_level()*100)+"}";
        strJson+=",{\"name\":\""+userPersona.getAmount_level_Comment()+"\",\"value\":"+Integer.toString(1000-userPersona.getAmount_level()*100)+"}";
        strJson+=",{\"name\":\""+userPersona.getActive_time_Comment()+"\",\"value\":"+Integer.toString(1000-userPersona.getActive_time()*100)+"}";
        strJson+=",{\"name\":\""+userPersona.getFre_div_Comment()+"\",\"value\":"+Integer.toString(1000-userPersona.getFre_div()*100)+"}";
        strJson+=",{\"name\":\""+userPersona.getTime_level_Comment()+"\",\"value\":"+Integer.toString(1000-userPersona.getTime_level()*100)+"}";
        strJson+=",{\"name\":\"更换"+Integer.toString(userPersona.getTotal_change_terminal_days())+"次终端\",\"value\":";
        if(userPersona.getTotal_change_terminal_days()>10)
            strJson+="200}";
        else
            strJson+="50}";
        strJson+="]}";
        return strJson;
    }

    @Override
    public List<TerminalCount> getTerminal_brandCount() {
        String sql="select  terminal_brand,count(1) as counts \n" +
                "from  bigdataapp.tb_comm_app_persona2 as  w \n" +
                "group by terminal_brand";
        return  (List<TerminalCount>)(List)impalaDao.getImpalaData(sql,TerminalCount.class);
    }

    @Override
    public List<TerminalCount> getTerminal_sum_amount() {
        String sql="select  terminal_brand,count(sum_amount) as counts\n" +
                "from  bigdatacomm.tb_comm_billing_month\n" +
                "group by terminal_brand\n" +
                "order by counts desc";

        return (List<TerminalCount>)(List)impalaDao.getImpalaData(sql,TerminalCount.class);
    }

}
