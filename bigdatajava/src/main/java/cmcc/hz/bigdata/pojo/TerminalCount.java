package cmcc.hz.bigdata.pojo;

/**
 * @program: bigdata
 * @description: 终端类型统计
 * @author: liminjie
 * @create: 2018-06-21 12:24
 **/
public class TerminalCount {

    public String terminal_brand;
    public int counts;

    public String getTerminal_brand() {
        return terminal_brand;
    }

    public void setTerminal_brand(String terminal_brand) {
        this.terminal_brand = terminal_brand;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    @Override
    public String toString() {
        return "TerminalCount{" +
                "terminal_brand='" + terminal_brand + '\'' +
                ", counts=" + counts +
                '}';
    }
}
