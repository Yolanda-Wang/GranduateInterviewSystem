import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.sql.*;
import java.util.Date;

import javax.swing.*;

public class questionWidget {
    public static String url = "jdbc:mysql://localhost:3306/interview?useUnicode=true&characterencoding=GBK";
    public static String username = "manager";
    public static String password = "123456";
    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;
    public static MulticastSocket msr = null;
    public static InetAddress group;
    public static JTextArea  label6;
    public static DatagramPacket dp;
    public static byte[] buffer;
    public static String s;
    public static void main(String[] args) {
        questionWidget w1=new questionWidget();
    }
    public questionWidget() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("加载驱动成功");
        } catch (ClassNotFoundException var2) {
            System.out.println("加载驱动失败!");
            var2.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            System.out.println("数据库连接成功");
        } catch (SQLException var1) {
            System.out.println("数据库连接失败!");
        }
        //初始化一个jframe
        JFrame frame = new JFrame("学生端");

        //初始化一个panel
        JPanel panel = new JPanel();

        //初始化一个容器
        Container container = frame.getContentPane();


        JLabel label5=new JLabel("题目信息：");
        label5.setBounds(50,30,100,25);
        label5.setFont(new Font("",Font.PLAIN,16));
        label6=new JTextArea();
        label6.setLineWrap(true);
        label6.setBounds(80,60,450,200);
        label6.setFont(new Font("",Font.PLAIN,16));
        label6.setEditable(false);
        JTextArea label10=new JTextArea();
        label10.setLineWrap(true);
        label10.setBounds(80,300,450,50);
        label10.setFont(new Font("",Font.PLAIN,16));
        label10.setEditable(false);
        label10.setBackground(Color.lightGray);

        JButton bt3=new JButton("准备就绪");
        bt3.setBounds(450, 350, 100, 35);
        bt3.setFont(new Font("宋体",Font.PLAIN,16));
        panel.add(bt3);
        JMenu menu2 = new JMenu("帮助(H)");
        menu2.setMnemonic('H');
        menu2.setFont(new Font("宋体",Font.PLAIN,16));

        panel.add(menu2);
        panel.add(label5);
        panel.add(label6);
        panel.add(label10);
        label6.setText("综合面试其实主要考察考生的综合素质。包括考生本科期间的科研能力、知识结构、计算机操作能力、外语能力和应变能力等，在回答的时候并不要求十分精准的答案，但是要求考生流畅清楚以及有逻辑性的陈述。所以在综合面试之前相关信息的搜集、知识点的储备、以及勤加练习都是必不可少的。");
        label10.setText("若你已经准备好答题或准备好回答下一道题目，请点击“准备就绪”按钮，准备接收下一题目内容");
        panel.setLayout(null);


        //把panel添加到容器
        container.add(panel);


        //设置关闭方式
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //设置大小
        frame.setSize(600,500);

        //设置位置
        frame.setLocation(600, 250);

        //设置可见性
        frame.setVisible(true);

        //设置窗口大小不可变
        frame.setResizable(false);
        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    group = InetAddress.getByName("224.0.0.3");//组播地址
                    int port = 8888;
                    msr = new MulticastSocket(port);
                    msr.joinGroup(group);//加入连接
                    byte[] buffer = new byte[8192];
                    System.out.println("接收数据包启动！(启动时间: "+new Date()+")");
                    //建立一个指定缓冲区大小的数据包

                        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                        msr.receive(dp);
                        String s = new String(dp.getData(),0,dp.getLength());
                        //解码组播数据包
                        System.out.println(s);
                        label6.setText(s);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }finally{
                    if(msr!=null){
                        try {
                            msr.leaveGroup(group);
                            msr.close();
                        } catch (Exception e2) {
                            // TODO: handle exception
                        }
                    }
                }
            }
        });

        //broadcast();
    }
    public void broadcast(){
        try {
            group = InetAddress.getByName("224.0.0.3");//组播地址
            int port = 8888;
            msr = new MulticastSocket(port);
            msr.joinGroup(group);//加入连接
            byte[] buffer = new byte[8192];
            System.out.println("接收数据包启动！(启动时间: "+new Date()+")");
            //建立一个指定缓冲区大小的数据包
            while (true) {
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                msr.receive(dp);
                String s = new String(dp.getData(),0,dp.getLength());
                //解码组播数据包
                System.out.println(s);
                label6.setText(s);
           }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(msr!=null){
                try {
                    msr.leaveGroup(group);
                    msr.close();
                } catch (Exception e2) {
                    // TODO: handle exception
                }
            }
        }
    }
}
