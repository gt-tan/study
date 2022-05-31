package cn.tangt.com.test10;

import java.util.Date;

public class TestAccount {
    public static void main(String[] args) {
        Person p = new Person("George");
//创建⼀个储蓄账户account1
        SavingsAccount account1 = new SavingsAccount(p.getName(), 1122, 1000);
        account1.setAnnualInterestRate(5.5);
//创建⼀个和account1相同id的储蓄账户
        SavingsAccount account2 = new SavingsAccount(p.getName(), 1122, 1000);
//创建⼀个信⽤卡账户account3
        CheckingAccount account3 = new CheckingAccount(p.getName(), 2233, 0, 20000);
//加⼊account1
        p.addAccount(account1);
//⼀个⼈不能拥有相同的id的账户，account2不能加⼊成功
        p.addAccount(account2);
//加⼊account3
        p.addAccount(account3);
//在Person类中定printAllAccounts⽅法并补充完整
        p.printAllAccounts();
        account1.deposit(30);
        account1.deposit(40);
        account1.deposit(50);
        account1.withdraw(5);
        account1.withdraw(4);
        account1.withdraw(2);
//在测试类中定义printAllTrans⽅法，并补充完整
        printAllTrans(account1);
        account3.withdraw(3000);
        account3.withdraw(4000);
        account3.withdraw(5000);
//信⽤卡账户不能全部取出，这句话会输出”余额不⾜，⽆法取款”
        account3.withdraw(8000);
        printAllTrans(account3);
    }

    public static void printAllTrans(Account account) {
        System.out.println("Date AccountID Type Amount Balance");
        for (int j = 0; j < account.k; j++) {
            if (account.transactions[j] != null) {
                System.out.println(account.transactions[j].tradeTime + " " + account.transactions[j].accountId + " " + account.transactions[j].tradeType + " " + account.transactions[j].tradeAmount + " " + account.transactions[j].balance);
            } else {
                System.out.println("余额不⾜，⽆法取款");
            }
        }
    }
}

class Account {
    public int id;
    public double Balance;
    public String name;
    public int k = 0;
    public Transaction[] transactions = new Transaction[100];
    public Date DateCreated = new Date();

    Account() {
        for (int l = 0; l < 100; l++) {
            this.transactions[l] = new Transaction();
        }
    }
}

class SavingsAccount extends Account {
    private double annualInterestRate;

    SavingsAccount() {
    }

    SavingsAccount(String name, int id, double Balance) {
        this.name = name;
        this.id = id;
        this.Balance = Balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void deposit(double number) {
        Balance += number;
        transactions[k].accountId = this.id;
        transactions[k].tradeTime = new Date();
        transactions[k].tradeType = 'D';
        transactions[k].balance = this.Balance;
        transactions[k].tradeAmount = number;
        k++;
    }

    public void withdraw(double number) {
        if (Balance - number >= 0) {
            Balance -= number;
            transactions[k].accountId = this.id;
            transactions[k].tradeTime = new Date();
            transactions[k].tradeType = 'W';
            transactions[k].balance = this.Balance;
            transactions[k].tradeAmount = number;
            k++;
        } else {
            transactions[k] = null;
        }
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "MonthlyInterest=" + Balance * annualInterestRate / 100 / 12 +
                ",id=" + id +
                ", Balance=" + Balance +
                ", name='" + name + '\'' +
                ", DateCreated=" + DateCreated +
                '}';
    }
}

class CheckingAccount extends Account {
    private double creditAmount;

    CheckingAccount() {
    }

    CheckingAccount(String name, int id, double Balance, double creditAmount) {
        this.name = name;
        this.id = id;
        this.creditAmount = creditAmount;
        this.Balance = Balance;
    }

    public void deposit(double number) {
        Balance += number;
        transactions[k].accountId = this.id;
        transactions[k].tradeTime = new Date();
        transactions[k].tradeType = 'D';
        transactions[k].balance = this.Balance;
        transactions[k].tradeAmount = number;
        k++;
    }

    public void withdraw(double number) {
        if (creditAmount - number > 0) {
            Balance -= number;
            creditAmount -= number;
            transactions[k].accountId = this.id;
            transactions[k].tradeTime = new Date();
            transactions[k].tradeType = 'W';
            transactions[k].balance = this.Balance;
            transactions[k].tradeAmount = number;
            k++;
        } else {
            transactions[k] = null;
            k++;
        }
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                ", creditAmount=" + creditAmount +
                ",id=" + id +
                ", Balance=" + Balance +
                ", name='" + name + '\'' +
                ", DateCreated=" + DateCreated +
                '}';
    }
}

class Transaction {
    public int accountId;
    public Date tradeTime;
    public char tradeType;
    public double tradeAmount;
    public double balance;
}

class Person {
    private String name;
    private int i = 0;
    private final Account[] accounts = new Account[100];

    public Person() {
        for (int a = 0; a < 100; a++) {
            this.accounts[a] = new Account();
        }
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addAccount(Account account) {
        if (i == 0) {
            accounts[i] = account;
            i++;
        } else {
            for (int j = 0; j < i; j++) {
                if (accounts[j].id == account.id) {
                    return;
                }
            }
            accounts[i] = account;
            i++;
        }
    }

    public void printAllAccounts() {
        if (i == 0)
            System.out.println(this.name + " has " + i + " account:");
        else if (i == 1) {
            System.out.println(this.name + " has " + i + " account:");
            System.out.println(accounts[0].toString());
        } else {
            System.out.println(this.name + " has " + i + " accounts:");
            for (int m = 0; m < i; m++) {
                System.out.println(accounts[m].toString());
            }
        }
    }
}