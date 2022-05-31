package cn.tangt.com.bigwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 用户聊天界面及数据处理器
 *
 * @author tan
 * @date 2022/05/30 12:54
 */
public class ClientHandle extends JFrame implements ActionListener, KeyListener, Runnable {
    private JTextArea jta;    // 文本域
    private JTextField jtf;    // 文本框

    private final Socket socket;    // 用户端口
    private final String userName;    // 用户名


    //构造方法
    public ClientHandle(String userName, Socket socket) {
        this.userName = userName;
        this.socket = socket;
        this.init();    // 初始化
    }

    /**
     * 初始化
     */
    public void init() {
        // 初始化组件
        jta = new JTextArea();    // 文本域，需要将文本域添加到滚动条中，实现滚动效果
        Font font = new Font("楷体", Font.BOLD, 36);
        jta.setFont(font);
        // 滚动条
        JScrollPane jsp = new JScrollPane(jta);    // 滚动条
        // 面板
        JPanel jp = new JPanel();    // 面板
        jtf = new JTextField(10);   // 文本框大小
        jtf.setFont(font);
        // 按钮
        JButton jb = new JButton("发送");// 按钮名称
        jb.setFont(font);
        // 将文本框与按钮添加到面板中
        jp.add(jtf);
        jp.add(jb);
        // 将滚动条和面板添加到窗体中
        this.add(jsp, BorderLayout.CENTER);
        this.add(jp, BorderLayout.SOUTH);

        // 设置 标题、大小、位置、关闭、是否可见
        this.setTitle(userName + "的聊天框");// 标题
        this.setSize(800, 800);// 宽,高
        this.setLocation(700, 300);// 水平 垂直
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 窗体关闭 程序退出
        this.setVisible(true);//是否可见

        // 给"发送"按钮绑定一个监听点击事件
        jb.addActionListener(this);//让当前对象监听
        // 给文本框绑定一个键盘点击事件
        jtf.addKeyListener(this);

    }

    @Override
    public void run() {
        Scanner scanner = null;
        try {
            while (true) {
                scanner = new Scanner(socket.getInputStream());    // 获取接收服务器信息的扫描器
                while (scanner.hasNext()) {
                    jta.append(scanner.next() + System.lineSeparator());    // 将受到的信息显示出来，换行
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // 点击发送按钮时发送会话框中的内容
        // 发送数据到socket通道中
        sendDataToServer();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // 键盘按下回车键时将会话框中的内容发送出去
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            // 发送数据到socket通道中
            sendDataToServer();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    // 数据发送给Server服务端
    private void sendDataToServer() {
        String text = jtf.getText();    // 获取文本框中发送的内容
        jta.append("我：" + text + "\n");   // 在自己的聊天界面中显示
        try {
            // 发送数据
            // 输出流
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println(text);
            ps.flush();
            // 清空自己当前的会话框
            jtf.setText("");
        } catch (IOException el) {
            el.printStackTrace();
        }
    }
}
