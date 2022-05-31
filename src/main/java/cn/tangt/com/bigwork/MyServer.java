package cn.tangt.com.bigwork;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 服务端管理器
 *
 * @author tan
 * @date 2022/05/30 12:56
 */
public class MyServer extends JFrame {
    private static JTextArea jta; //文本域
    private final int serverPort;  //服务端的端口号

    //构造方法
    public MyServer(int serverPort) {
        this.serverPort = serverPort;
        this.init();    // 初始化
        this.execute();    // 执行
    }

    /**
     * 初始化
     */
    public void init() {
        jta = new JTextArea();    //文本域 注意：需要将文本域添加到滚动条中，实现滚动效果
        Font font = new Font("楷体", Font.BOLD, 36);
        jta.setFont(font);
        //滚动条
        JScrollPane jsp = new JScrollPane(jta);    //滚动条

        //将滚动条和面板添加到窗体中
        this.add(jsp);
        //设置 标题、大小、位置、关闭、是否可见
        this.setTitle("聊天程序的服务端");    //标题
        this.setSize(800, 800);    // 宽 高
        this.setLocation(200, 100);    // 水平 垂直
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //窗体关闭 程序退出
        this.setVisible(true);    //设为可见
    }

    /**
     * 执行
     */
    public void execute() {
        ServerSocket serverSocket = null;    // 创建服务端套接字
        try {
            serverSocket = new ServerSocket(serverPort);
            // 创建线程池,从而可以处理多个客户端
            ExecutorService executorService = Executors.newFixedThreadPool(20);
            resetText("聊天程序启动了");    // 输出提示信息
            while (true) {
                Socket socket = serverSocket.accept();    // 监听客户端的情况，等待客户端连接
                resetText("又有新朋友加入了哦");
                executorService.execute(new SocketHandler(socket));    // 对每一个客户端，创建一个套接字处理器线程
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();    // 关闭serverSocket通道
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void resetText(String info) {
        jta.append(info + "\n");
    }

    public static void main(String[] args) {
        new MyServer(8888);
    }
}