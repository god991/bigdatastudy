package cmcc.hz.bigdata.dao;

import cmcc.hz.bigdata.pojo.UserPersona;

import java.util.List;

public interface ImpalaDao {
    public List<Object> getImpalaData(String sql, Class cls);
    public UserPersona getAppPersonaByAcc_nbr(String acc_nbr);
}
