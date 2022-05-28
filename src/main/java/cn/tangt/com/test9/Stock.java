package cn.tangt.com.test9;

/**
 * @author tan
 * @date 2022/05/05 20:12
 */
public class Stock {
    private String symbol;
    private int totalShares;
    private double totalCost;

    // Initializes a new Stock with no shares purchased.
    public Stock(String theSymbol) {
        symbol = theSymbol;
        totalShares = 0;
        totalCost = 0.0;
    }

    // Returns the total shares purchased of this stock.
    public int getTotalShares() {
        return totalShares;
    }

    // Returns the total profit or loss earned on this stock.
    public double getProfit(double currentPrice) {
        double marketValue = totalShares * currentPrice;
        return marketValue - totalCost;
    }

    // Records purchase of the given shares at the given price.
    public void purchase(int shares, double pricePerShare) {
        totalShares += shares;
        totalCost += shares * pricePerShare;
    }

    @Override
    public String toString() {
        return "Stock [symbol=" + symbol + ", totalShares=" + totalShares + ", totalCost=" + totalCost + "]";
    }

//getter和setter方法自己补充

    public void setTotalShares(int totalShares) {
        this.totalShares = totalShares;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}