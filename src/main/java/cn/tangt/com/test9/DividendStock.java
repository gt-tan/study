package cn.tangt.com.test9;

/**
 * @author tan
 * @date 2022/05/05 20:13
 */
public class DividendStock extends Stock {
    private double dividends;

    //带参构造方法，访问父类的symbol
    public DividendStock(String theSymbol) {
        super(theSymbol);
    }

    //获取利润
    public double getProfit(double currentPrice) {
        return super.getProfit(currentPrice) + dividends;
    }

    //计算分红
    public void payDividend(double amountPerShare) {
        dividends = amountPerShare * super.getTotalShares();
    }

    //重写toString
    public String toString() {
        return "DividendStock [symbol=" + getSymbol() + ", totalShares=" + getTotalShares() + ", totalCost=" + getTotalCost() + ", dividends=" + dividends + "]";
    }
}