package cn.tangt.com.test5;

/**
 * @author : tgt
 * @version : 1.0
 * @class : StockChange
 * @description : StockChange
 * @date : 2022/4/3
 */
public class StockChange {
    public static void main(String[] args) {
        Stock stock = new Stock("ORCL","OracleCoporation");
        stock.setPreviousClosingPrice(34.5);
        stock.setCurrentPrice(34.35);
        System.out.println("市值变化的百分比为："+stock.getChangePercent()*100+"%");
    }

}
class Stock{
    public String symbol;//股票代码
    public String name;//股票名字
    public double previousClosingPrice;//前一日股票值
    public double currentPrice;//当时的股票值

    public Stock(String symbol,String name){
        this.symbol=symbol;
        this.name=name;
    }
    public double getPreviousClosingPrice(){
        return this.previousClosingPrice;
    }
    public double getCurrentPrice(){
        return this.currentPrice;
    }
    public double getChangePercent(){
        return (this.currentPrice-this.previousClosingPrice)/this.previousClosingPrice;
    }
    public void setCurrentPrice(double newCurrentPrice){
        this.currentPrice=newCurrentPrice;
    }
    public void setPreviousClosingPrice(double newPreviousClosingPrice){
        this.previousClosingPrice=newPreviousClosingPrice;
    }
}

