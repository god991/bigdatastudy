package cmcc.hz.bigdata.service;

import cmcc.hz.bigdata.pojo.TerminalCount;
import cmcc.hz.bigdata.pojo.UserPersona;

import java.util.List;

public interface UserPersonaService {
    public UserPersona getUserPersonaByAcc_nbr(String acc_nbr);
    public List<UserPersona> getUserPersonaLimit(int limit);
    public List<UserPersona> getUserPersonaLeftLikeAcc_nbr(String acc_nbr);

    /**
     * 按手机号找到用户，并将用户属性转为中文，并附带权重。
     * @param acc_nbr
     * @return
     */
    public String getUserPersonaWeightInfoByAcc_nbr(String acc_nbr);

    /**
     * 终端品牌数量排名
     * @return
     */
    public List<TerminalCount> getTerminal_brandCount();

    //终端流量排名
    public  List<TerminalCount> getTerminal_sum_amount();
}
