package cn.tangt.com.test5;

import java.util.Calendar;
import java.util.Date;

/**
 * @author : tgt
 * @version : 1.0
 * @class : Account
 * @description : Account
 * @date : 2022/4/3
 */
public class Interest{
    public static void main(String[] args) {
        System.out.println("Account id 1122 Balance is 20500.0");
        Account people1 = new Account(1122, 20500.0, 4.5);
        System.out.println("Monthly interest is: "+people1.getMonthlyInterest());
        System.out.print("This account was created at ");
        people1.showDate();
        System.out.println("*****************************************");
        System.out.println("Account id 2233 Balance is 30000.0");
        Account people2 = new Account(2233, 30000.0, 4.5);
        System.out.println("Monthly interest is: "+people2.getMonthlyInterest());
        System.out.print("This account was created at ");
        people2.showDate();
        System.out.println("*****************************************");
        people1.setAnnualInterestRate(3.95);
        people2.setAnnualInterestRate(3.95);
        System.out.println("Account id "+people1.getID()+" Monthly interest is "+people1.getMonthlyInterest());
        System.out.println("Account id "+people2.getID()+" Monthly interest is "+people2.getMonthlyInterest());
    }
}

class Account {
    private final int id;//账户
    private double balance;//余额
    private double annualInterestRate;//当前利率
    private final Date dataCreated;//账户开户日期
    public Account(int id,double balance,double annualInterestRate){
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        Calendar calendar = Calendar.getInstance();
        this.dataCreated = calendar.getTime();
    }
    public void showDate(){
        System.out.println(dataCreated);
    }
    public int getID(){
        return this.id;
    }
    public double getBalance(){
        return this.balance;
    }
    public double getAnnualInterestRate(){
        return annualInterestRate;
    }
    public void setAnnualInterestRate(double temp){
        this.annualInterestRate = temp;
    }
    public Date getDataCreated(){
        return dataCreated;
    }
    public double getMonthlyInterest(){
        return annualInterestRate/1200*balance;
    }
    public void withDraw(double number){
        this.balance-=number;
    }
    public void deposit(double number){
        this.balance+=number;
    }
}
