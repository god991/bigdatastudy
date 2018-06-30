package cmcc.hz.bigdata.pojo;

/**
 * @program: bigdata
 * @description:
 * @author: liminjie
 * @create: 2018-06-24 15:59
 **/
public class UserGPS {
    public String acc_nbr;
    public String strGPSTime;
    public String lng; //经度
    public String lat;//维度

    public String getAcc_nbr() {
        return acc_nbr;
    }

    public void setAcc_nbr(String acc_nbr) {
        this.acc_nbr = acc_nbr;
    }

    public String getStrGPSTime() {
        return strGPSTime;
    }

    public void setStrGPSTime(String strGPSTime) {
        this.strGPSTime = strGPSTime;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "UserGPS{" +
                "acc_nbr='" + acc_nbr + '\'' +
                ", strGPSTime='" + strGPSTime + '\'' +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                '}';
    }

    public UserGPS() {
    }

    public UserGPS(String acc_nbr, String strGPSTime, String lng, String lat) {
        this.acc_nbr = acc_nbr;
        this.strGPSTime = strGPSTime;
        this.lng = lng;
        this.lat = lat;
    }

    public UserGPS(String acc_nbr) {
        this.acc_nbr = acc_nbr;
    }
}
