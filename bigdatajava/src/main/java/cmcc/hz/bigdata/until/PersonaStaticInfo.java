package cmcc.hz.bigdata.until;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: bigdata
 * @description:
 * @author: liminjie
 * @create: 2018-06-20 23:19
 **/
public class PersonaStaticInfo {
    //消费分档
    public static final Map<Integer, String> CHARGE_DIV_MAP;
    static
    {
        CHARGE_DIV_MAP = new HashMap<Integer, String>();
        CHARGE_DIV_MAP.put(1, "高消费用户");
        CHARGE_DIV_MAP.put(2, "中消费用户");
        CHARGE_DIV_MAP.put(3, "低消费用户");
    }

    //流量分档
    public static final Map<Integer, String> DURATION_LEVEL_MAP;
    static
    {
        DURATION_LEVEL_MAP = new HashMap<Integer, String>();
        DURATION_LEVEL_MAP.put(1, "高流量用户");
        DURATION_LEVEL_MAP.put(2, "中流量用户");
        DURATION_LEVEL_MAP.put(3, "低流量用户");
    }

    //通话时长分档
    public static final Map<Integer, String> AMOUNT_LEVEL_MAP;
    static
    {
        AMOUNT_LEVEL_MAP = new HashMap<Integer, String>();
        AMOUNT_LEVEL_MAP.put(1, "高通话时长");
        AMOUNT_LEVEL_MAP.put(2, "中通话时长");
        AMOUNT_LEVEL_MAP.put(3, "低通话时长");
    }

    /**
     * 1早上业务活跃2上午业务活跃3中午业务活跃4下午业务活跃5前半夜业务活跃6后半夜业务活跃7凌晨业务活跃8业务活跃时段未知
     */
    public static final Map<Integer, String> ACTIVE_TIME_MAP;
    static
    {
        ACTIVE_TIME_MAP = new HashMap<Integer, String>();
        ACTIVE_TIME_MAP.put(1, "早上业务活跃");
        ACTIVE_TIME_MAP.put(2, "上午业务活跃");
        ACTIVE_TIME_MAP.put(3, "中午业务活跃");
        ACTIVE_TIME_MAP.put(4, "下午业务活跃");
        ACTIVE_TIME_MAP.put(5, "前半夜业务活跃");
        ACTIVE_TIME_MAP.put(6, "后半夜业务活跃");
        ACTIVE_TIME_MAP.put(7, "凌晨业务活跃");
        ACTIVE_TIME_MAP.put(8, "业务活跃时段未知");
    }

    //APP使用频次
    public static final Map<Integer, String> APP_FRE_DIV_MAP;
    static
    {
        APP_FRE_DIV_MAP = new HashMap<Integer, String>();
        APP_FRE_DIV_MAP.put(1, "高频次APP用户");
        APP_FRE_DIV_MAP.put(2, "中频次APP用户");
        APP_FRE_DIV_MAP.put(3, "低频次APP用户");
    }

    //APP使用时长分档
    public static final Map<Integer, String> APP_TIME_LEVEL_MAP;
    static
    {
        APP_TIME_LEVEL_MAP = new HashMap<Integer, String>();
        APP_TIME_LEVEL_MAP.put(1, "长时间使用APP用户");
        APP_TIME_LEVEL_MAP.put(2, "中档时间使用APP用户");
        APP_TIME_LEVEL_MAP.put(3, "短时间使用APP用户");
    }

}
