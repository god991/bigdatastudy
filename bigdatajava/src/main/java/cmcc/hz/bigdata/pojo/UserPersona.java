package cmcc.hz.bigdata.pojo;

import cmcc.hz.bigdata.until.PersonaStaticInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @program: bigdata
 * @description: bigdataApp
 * @author: liminjie
 * @create: 2018-06-20 14:42
 **/
public class UserPersona {
    public String	acc_nbr	;
    public  String	subst_id	;
    public String	branch_id	;
    public  String	strat_grp_dl	;
    public  String	serv_grp_type	;
    public  String	fee_id	;
    public  String	develop_channel	;
    public String	cz_flag	;
    public  String	online_time	;
    public String	state	;
    public  String	terminal_net_type	;
    public  String	terminal_brand	;
    public  String	terminal_cd 	;
    public int	is_active_user	;
    public int	is_new_user	;
    public int	is_online_user	;
    public int	charge_div	;
    public int	duration_level	;
    public int	amount_level	;
    public int	active_time	;
    public  int	fre_div	;
    public int	time_level	;
    //public  String app_times	;
    public  int	total_change_terminal_days	;
    //public String	terminal_line	;

    public UserPersona() {

    }



    public String getAcc_nbr() {
        return acc_nbr;
    }

    public void setAcc_nbr(String acc_nbr) {
        this.acc_nbr = acc_nbr;
    }

    public String getSubst_id() {
        return subst_id;
    }

    public void setSubst_id(String subst_id) {
        this.subst_id = subst_id;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getStrat_grp_dl() {
        return strat_grp_dl;
    }

    public void setStrat_grp_dl(String strat_grp_dl) {
        this.strat_grp_dl = strat_grp_dl;
    }

    public String getServ_grp_type() {
        return serv_grp_type;
    }

    public void setServ_grp_type(String serv_grp_type) {
        this.serv_grp_type = serv_grp_type;
    }

    public String getFee_id() {
        return fee_id;
    }

    public void setFee_id(String fee_id) {
        this.fee_id = fee_id;
    }

    public String getDevelop_channel() {
        return develop_channel;
    }

    public void setDevelop_channel(String develop_channel) {
        this.develop_channel = develop_channel;
    }

    public String getCz_flag() {
        return cz_flag;
    }

    public void setCz_flag(String cz_flag) {
        this.cz_flag = cz_flag;
    }

    public String getOnline_time() {
        return online_time;
    }

    public void setOnline_time(String online_time) {
        this.online_time = online_time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTerminal_net_type() {
        return terminal_net_type;
    }

    public void setTerminal_net_type(String terminal_net_type) {
        this.terminal_net_type = terminal_net_type;
    }

    public String getTerminal_brand() {
        return terminal_brand;
    }

    public void setTerminal_brand(String terminal_brand) {
        this.terminal_brand = terminal_brand;
    }

    public String getTerminal_cd() {
        return terminal_cd;
    }

    public void setTerminal_cd(String terminal_cd) {
        this.terminal_cd = terminal_cd;
    }

    public int getIs_active_user() {
        return is_active_user;
    }

    public void setIs_active_user(int is_active_user) {
        this.is_active_user = is_active_user;
    }

    public int getIs_new_user() {
        return is_new_user;
    }

    public void setIs_new_user(int is_new_user) {
        this.is_new_user = is_new_user;
    }

    public int getIs_online_user() {
        return is_online_user;
    }

    public void setIs_online_user(int is_online_user) {
        this.is_online_user = is_online_user;
    }

    public int getCharge_div() {
        return charge_div;
    }

    public void setCharge_div(int charge_div) {
        this.charge_div = charge_div;
    }

    public int getDuration_level() {
        return duration_level;
    }

    public void setDuration_level(int duration_level) {
        this.duration_level = duration_level;
    }

    public int getAmount_level() {
        return amount_level;
    }

    public void setAmount_level(int amount_level) {
        this.amount_level = amount_level;
    }

    public int getActive_time() {
        return active_time;
    }

    public void setActive_time(int active_time) {
        this.active_time = active_time;
    }

    public int getFre_div() {
        return fre_div;
    }

    public void setFre_div(int fre_div) {
        this.fre_div = fre_div;
    }

    public int getTime_level() {
        return time_level;
    }

    public void setTime_level(int time_level) {
        this.time_level = time_level;
    }


    public int getTotal_change_terminal_days() {
        return total_change_terminal_days;
    }

    public void setTotal_change_terminal_days(int total_change_terminal_days) {
        this.total_change_terminal_days = total_change_terminal_days;
    }

    @Override
    public String toString() {
        return "UserPersona{" +
                "acc_nbr='" + acc_nbr + '\'' +
                ", subst_id='" + subst_id + '\'' +
                ", branch_id='" + branch_id + '\'' +
                ", strat_grp_dl='" + strat_grp_dl + '\'' +
                ", serv_grp_type='" + serv_grp_type + '\'' +
                ", fee_id='" + fee_id + '\'' +
                ", develop_channel='" + develop_channel + '\'' +
                ", cz_flag='" + cz_flag + '\'' +
                ", online_time='" + online_time + '\'' +
                ", state='" + state + '\'' +
                ", terminal_net_type='" + terminal_net_type + '\'' +
                ", terminal_brand='" + terminal_brand + '\'' +
                ", terminal_cd='" + terminal_cd + '\'' +
                ", is_active_user=" + is_active_user +
                ", is_new_user=" + is_new_user +
                ", is_online_user=" + is_online_user +
                ", charge_div=" + charge_div +
                ", duration_level=" + duration_level +
                ", amount_level=" + amount_level +
                ", active_time=" + active_time +
                ", fre_div=" + fre_div +
                ", time_level=" + time_level +
                ", total_change_terminal_days=" + total_change_terminal_days +
                '}';
    }

    public String toCommentJsonString() {
        return "{" +
                "\"acc_nbr\":\"" + acc_nbr + '\"' +
                ", \"subst_id\":\"" + subst_id + '\"' +
                ", \"branch_id\":\"" + branch_id + '\"' +
                ", \"strat_grp_dl\":\"" + strat_grp_dl + '\"' +
                ", \"serv_grp_type\":\"" + serv_grp_type + '\"' +
                ", \"fee_id\":\"" + fee_id + '\"' +
                ", \"develop_channel\":\"" + develop_channel + '\"' +
                ", \"cz_flag\":\"" + cz_flag + '\"' +
                ", \"online_time\":\"" + online_time + '\"' +
                ", \"state\":\"" + state + '\"' +
                ", \"terminal_net_type\":\"" + terminal_net_type + '\"' +
                ", \"terminal_brand\":\"" + terminal_brand + '\"' +
                ", \"terminal_cd\":\"" + terminal_cd + '\"' +
                ", \"is_active_user\":" + is_active_user +
                ", \"is_new_user\":" + is_new_user +
                ", \"is_online_user\":" + is_online_user +
                ", \"charge_div\":\"" + PersonaStaticInfo.CHARGE_DIV_MAP.get(charge_div) + '\"' +
                ", \"duration_level\":\"" + PersonaStaticInfo.DURATION_LEVEL_MAP.get(duration_level) + '\"' +
                ", \"amount_level\":\"" + PersonaStaticInfo.AMOUNT_LEVEL_MAP.get(amount_level) + '\"' +
                ", \"active_time\":\"" + PersonaStaticInfo.ACTIVE_TIME_MAP.get(active_time)  + '\"' +
                ", \"fre_div\":\"" + PersonaStaticInfo.APP_FRE_DIV_MAP.get(fre_div) + '\"' +
                ", \"time_level\":\"" + PersonaStaticInfo.APP_TIME_LEVEL_MAP.get(time_level)  + '\"' +
                ", \"total_change_terminal_days\":" + total_change_terminal_days +
                '}';
    }

    public String getCharge_div_Comment() {
        if(this.charge_div<=PersonaStaticInfo.CHARGE_DIV_MAP.size())
            return PersonaStaticInfo.CHARGE_DIV_MAP.get(charge_div);
        else
            return "未知消费类型码："+Integer.toString(charge_div);
    }

    public String getDuration_level_Comment() {
        if(this.duration_level<=PersonaStaticInfo.DURATION_LEVEL_MAP.size())
            return PersonaStaticInfo.DURATION_LEVEL_MAP.get(duration_level);
        else
            return "未知DURATION_LEVEL_MAP类型码："+Integer.toString(duration_level);
    }

    public String getAmount_level_Comment() {
        if(this.amount_level<=PersonaStaticInfo.AMOUNT_LEVEL_MAP.size())
            return PersonaStaticInfo.AMOUNT_LEVEL_MAP.get(amount_level);
        else
            return "未知AMOUNT_LEVEL_MAP类型码："+Integer.toString(amount_level);
    }

    public String getActive_time_Comment() {
        if(this.active_time<=PersonaStaticInfo.ACTIVE_TIME_MAP.size())
            return PersonaStaticInfo.ACTIVE_TIME_MAP.get(active_time);
        else
            return "未知ACTIVE_TIME_MAP类型码："+Integer.toString(active_time);
    }

    public String getFre_div_Comment() {
        if(this.fre_div<=PersonaStaticInfo.APP_FRE_DIV_MAP.size())
            return PersonaStaticInfo.APP_FRE_DIV_MAP.get(fre_div);
        else
            return "未知APP_FRE_DIV_MAP类型码："+Integer.toString(fre_div);
    }

    public String getTime_level_Comment() {
        if(this.time_level<=PersonaStaticInfo.APP_TIME_LEVEL_MAP.size())
            return PersonaStaticInfo.APP_TIME_LEVEL_MAP.get(time_level);
        else
            return "未知APPTime_level类型码："+Integer.toString(time_level);
    }

}
