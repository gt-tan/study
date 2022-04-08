package cn.tangt.com.parking_lot;

import cn.tangt.com.parking_lot.sub_car.Ferrari;
import cn.tangt.com.parking_lot.sub_car.HongGuang;
import cn.tangt.com.parking_lot.sub_car.Porsche;
import cn.tangt.com.parking_lot.sub_car.RollsRoyce;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author : tgt
 * @version : 1.0
 * @class : Park
 * @description : Park
 * @date : 2022/4/3
 */
public class Park {

    public static int count = 1;
    private static final List<Transaction> existCars = new CopyOnWriteArrayList<>();
    private static final List<Transaction> historyTransactions = new CopyOnWriteArrayList<>();
    private static final AtomicReference<Park> INSTANCE = new AtomicReference<>();

    private Park() {

    }

    public static Park getInstance() {
        if (INSTANCE.get() == null) {
            Park newInstance = new Park();
            INSTANCE.compareAndSet(null, newInstance);
        }
        return INSTANCE.get();
    }

    public void init() {
        //反序列化
        try {
            List<Transaction> existCars = deserializeExistCars();
            List<Transaction> historyTransactions = deserializeHistory();
            count = deserializeId();
            Park.existCars.addAll(existCars);
            Park.historyTransactions.addAll(historyTransactions);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        //序列化
        try {
            List<Transaction> existCars = new ArrayList<>(Park.existCars);
            serializeExistCars(existCars);
            List<Transaction> historyTransactions = new ArrayList<>(Park.historyTransactions);
            serializeHistory(historyTransactions);
            serializeId(count);
            FileOutputStream fos = new FileOutputStream("src\\main\\java\\cn\\tangt\\com\\parking_lot\\record.txt");
            for (Transaction historyTransaction : Park.historyTransactions) {
                fos.write((historyTransaction.toString() + "\n").getBytes(StandardCharsets.UTF_8));
            }
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void menu() {
        System.out.println("*******欢迎进入停车场管理系统*******");
        System.out.println("|1.停车\t\t\t\t\t\t\t|");
        System.out.println("|2.查看停车时长\t\t\t\t\t|");
        System.out.println("|3.查看已停车辆信息\t\t\t\t|");
        System.out.println("|4.离开并缴费\t\t\t\t\t\t|");
        System.out.println("|5.查看已出库订单信息\t\t\t\t|");
        System.out.println("|6.查看符合规范的车辆类型\t\t\t|");
        System.out.println("|0.退出系统\t\t\t\t\t\t|");
        System.out.println("*********************************");
        System.out.println("请选择服务：");
    }

    public void Menu() {
        Scanner scanner = new Scanner(System.in);
        init();
        while (true) {
            int choice;
            menu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    //停车
                    fun1();
                    break;
                case 2:
                    //查看停车时长
                    fun2();
                    break;
                case 3:
                    //查看已停车辆信息
                    fun3();
                    break;
                case 4:
                    //离开并缴费
                    fun4();
                    break;
                case 5:
                    //查看已出库订单信息
                    fun5();
                    break;
                case 6:
                    fun6();
                    break;
                case 0:
                    //退出系统
                    fun0();
                    return;
                default:
                    System.out.println("你的输入有误，请重新输入");
                    break;
            }
        }
    }

    //停车
    public void fun1() {
        Scanner scanner = new Scanner(System.in);
        //用户输入车辆信息
        System.out.println("请输入车牌号: ");
        String number = scanner.next();
        System.out.println("请输入车辆品牌: ");
        String brand = scanner.next();
        System.out.println("请输入车辆型号: ");
        String model = scanner.next();
        //判断车辆是否符合要求
        if (isValid(brand, model)) {
            //得到该车的实例对象
            Car car = makeCar(number, brand, model);
            //判断车库中是否已存在
            if (isExist(car)) {
                System.out.println("该车已存在与车库中, 车牌: " + car.getNumber() + "入库失败!");
            } else {
                //将车入库
                Transaction transaction = new Transaction(Integer.toString(count), car);
                new Thread(new Enter(transaction)).start();
            }
        } else {
            System.out.println("车辆信息不符合要求!");
        }
    }

    //查看停车时长
    public void fun2() {
        Scanner scanner = new Scanner(System.in);
        //用户输入车辆信息
        System.out.println("请输入车牌号: ");
        String number = scanner.next();
        //根据number得到车辆实例
        Car car = getCarByNumber(number);
        //判断实例对象是否存在
        if (car == null) {
            System.out.println("该车不存在于车库中!");
        } else {
            for (Transaction existCar : existCars) {
                if (existCar.getCar().equals(car)) {
                    Date now = new Date();
                    long ms = now.getTime() - existCar.getEnterTime().getTime();
                    long hour = ms / 1000 / 60 / 60;
                    long min = ms / 1000 / 60;
                    System.out.println("车牌: " + car.getNumber() + ", 停车时长为" + hour + "小时" + min + "分钟");
                }
            }
        }
    }

    //查看已停车辆信息
    public void fun3() {
        if (existCars.isEmpty()) {
            System.out.println("车库为空!");
        } else {
            for (Transaction exitCar : existCars) {
                System.out.println("订单号: " + exitCar.getOrderId() +
                        ", 入库时间: " + exitCar.getSdfEnterTime() +
                        ", " + exitCar.getCar());
            }
        }
    }

    //离开并缴费
    public void fun4() {
        Scanner scanner = new Scanner(System.in);
        //用户输入车辆信息
        System.out.println("请输入车牌号: ");
        String number = scanner.next();
        //根据number得到车辆实例
        Car car = getCarByNumber(number);
        //判断实例对象是否存在
        if (car == null) {
            System.out.println("该车不存在与车库中, 车牌号: " + number + " 出库失败！");
        } else {
            //将车出库
            for (Transaction existCar : existCars) {
                if (existCar.getCar().equals(car)) {
                    //将这条事务存入历史订单中
                    new Thread(new Exit(existCar)).start();
                }
            }
        }
    }

    //查看已出库订单信息
    public void fun5() {
        if (historyTransactions.isEmpty()) {
            System.out.println("暂无历史订单");
        } else {
            for (Transaction historyTransaction : historyTransactions) {
                System.out.println(historyTransaction.toString());
            }
        }
    }

    //查看车辆类型
    public void fun6() {
        System.out.println("_____________________");
        System.out.println("|\t车辆品牌\t车辆型号\t|");
        System.out.println("|1\t五菱宏光\t面包车\t|");
        System.out.println("|2\t法拉利\t跑车\t\t|");
        System.out.println("|3\t保时捷\tSUV\t\t|");
        System.out.println("|4\t劳斯莱斯\t轿车\t\t|");
        System.out.println("|-------------------|\n");
    }

    //退出系统
    public void fun0() {
        System.out.println("退出成功----");
        destroy();
    }

    //判断汽车类型是否符合要求
    public boolean isValid(String brand, String model) {
        List<String> types = new ArrayList<>();
        types.add("五菱宏光面包车");
        types.add("劳斯莱斯轿车");
        types.add("法拉利跑车");
        types.add("保时捷SUV");
        String str = brand + model;
        return types.contains(str);
    }

    //根据用户输入信息创建车辆
    public Car makeCar(String number, String brand, String model) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "五菱宏光面包车");
        map.put(2, "劳斯莱斯轿车");
        map.put(3, "保时捷SUV");
        map.put(4, "法拉利跑车");
        int type = 0;
        for (int i : map.keySet()) {
            String str = brand + model;
            if (map.get(i).equals(str)) {
                type = i;
                break;
            }
        }
        Car car = null;
        if (type == 1) {
            car = new HongGuang(number);
        } else if (type == 2) {
            car = new RollsRoyce(number);
        } else if (type == 3) {
            car = new Porsche(number);
        } else if (type == 4) {
            car = new Ferrari(number);
        }
        return car;
    }

    //判断汽车是否存在于车库中
    public boolean isExist(Car car) {
        for (Transaction existCar : existCars) {
            if (existCar.getCar().equals(car) || existCar.getCar().getNumber().equals(car.getNumber())) {
                return true;
            }
        }
        return false;
    }

    //根据车牌号返回实例对象
    public Car getCarByNumber(String number) {
        for (Transaction existCar : existCars) {
            if (existCar.getCar().getNumber().equals(number)) {
                return existCar.getCar();
            }
        }
        return null;
    }

    //序列化库中车辆
    public static void serializeExistCars(Object obj) throws IOException {
        FileOutputStream fos = new FileOutputStream("src\\main\\java\\cn\\tangt\\com\\parking_lot\\existCars.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        oos.flush();
        oos.close();
        fos.close();
    }

    //反序列化库中车辆
    public static List<Transaction> deserializeExistCars() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("src\\main\\java\\cn\\tangt\\com\\parking_lot\\existCars.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        return (List<Transaction>) ois.readObject();
    }

    //序列化历史事务
    public static void serializeHistory(Object obj) throws IOException {
        FileOutputStream fos = new FileOutputStream("src\\main\\java\\cn\\tangt\\com\\parking_lot\\historyTransactions.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        oos.flush();
        oos.close();
        fos.close();
    }

    //反序列化历史事务
    public static List<Transaction> deserializeHistory() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("src\\main\\java\\cn\\tangt\\com\\parking_lot\\historyTransactions.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        return (List<Transaction>) ois.readObject();
    }

    //序列化订单Id
    public static void serializeId(int count) throws IOException {
        FileOutputStream fos = new FileOutputStream("src\\main\\java\\cn\\tangt\\com\\parking_lot\\orderId.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(count);
        oos.flush();
        oos.close();
        fos.close();
    }

    //反序列化订单Id
    public static int deserializeId() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("src\\main\\java\\cn\\tangt\\com\\parking_lot\\orderId.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        return (int) ois.readObject();
    }

    private class Enter implements Runnable {
        private final Transaction transaction;

        public Enter(Transaction transaction) {
            this.transaction = transaction;
        }

        @Override
        public void run() {

            synchronized ("aa") {
                if (isExist(transaction.getCar())) {
                    System.out.println("车牌号：" + transaction.getCar().getNumber() + "入库失败！该车正在入库中.....");
                } else {
                    transaction.setOrderId(Integer.toString(count++));
                    transaction.setEnterTime(new Date());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //将该车信息入库
                    existCars.add(transaction);
                    System.out.println("车牌：" + transaction.getCar().getNumber() + "入库成功！");
                }
            }
        }
    }

    private class Exit implements Runnable {
        private final Transaction transaction;

        public Exit(Transaction transaction) {
            this.transaction = transaction;
        }

        @Override
        public void run() {
            synchronized ("aa") {
                if (!isExist(transaction.getCar())) {
                    System.out.println("车牌号：" + transaction.getCar().getNumber() + "出库失败！该车正在出库中.....");
                } else {
                    //将这条事务存入历史订单中
                    transaction.setExitTime(new Date());
                    long ms = transaction.getExitTime().getTime() - transaction.getEnterTime().getTime();
                    double charge = ms * 0.000001;
                    transaction.setCharge(charge);
                    historyTransactions.add(transaction);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //将该车从车库中移除
                    existCars.remove(transaction);
                    System.out.println("车牌号：" + transaction.getCar().getNumber() + " 出库成功！缴费" + charge + "元");
                }
            }
        }
    }
}
