import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Date;
import javax.swing.*;

public class teachersWidget {
    public static String url = "jdbc:mysql://localhost:3306/interview?useUnicode=true&characterencoding=GBK";
    public static String username = "manager";
    public static String password = "123456";
    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;
    public String Tea_ID;
    public static MulticastSocket msr = null;
    public static InetAddress group;
    public static InetAddress group2;
    public static MulticastSocket msr2 = null;
    public static boolean flag = false;
    public static boolean flag2 = true;
    public static Integer count = 0;
    public static void main(String[] args) {
        teachersWidget w1=new teachersWidget("123");
    }
    public teachersWidget(String TeaID) {
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
        Tea_ID = TeaID;

        //初始化一个jframe
        JFrame frame = new JFrame("教师端");

        //初始化一个菜单栏
        JMenuBar menuBar = new JMenuBar();

        //初始化菜单
        JMenu menu1 = new JMenu("操作(O)");
        menu1.setMnemonic('O');
        menu1.setFont(new Font("宋体", Font.PLAIN, 16));
        JMenuItem logout = new JMenuItem("注销");
        menu1.add(logout);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.sql.Timestamp time = new java.sql.Timestamp(System.currentTimeMillis());
                String time1 = time.toString();
                String logoutInfo = "insert into log values('" + Tea_ID + "','-','" + time1 + "')";
                try {
                    stmt.executeUpdate(logoutInfo);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                frame.dispose();
                new login();
            }
        });

        //初始化一个panel
        JPanel panel = new JPanel();

        //初始化一个容器
        Container container = frame.getContentPane();
        //把菜单添加到菜单栏
        menuBar.add(menu1);
//        menuBar.add(menu2);
//        menuBar.add(menu3);
//        menuBar.add(menu4);
//        menuBar.add(menu5);
        //设置菜单栏
        frame.setJMenuBar(menuBar);

        panel.setLayout(null);

        JLabel label1 = new JLabel("考号：");
        label1.setBounds(50, 40, 100, 25);
        label1.setFont(new Font("", Font.PLAIN, 16));
        JLabel label2 = new JLabel("姓名：");
        label2.setBounds(50, 70, 100, 25);
        label2.setFont(new Font("", Font.PLAIN, 16));
        JLabel label3 = new JLabel("专业：");
        label3.setBounds(50, 100, 100, 25);
        label3.setFont(new Font("", Font.PLAIN, 16));
        JTextArea label10 = new JTextArea("\n若您认为该考生对此题的回答您已经满意，请点击“下一题”按钮，准备接收下一题目内容\n\n若您对该考生已经没有任何疑问，请点击“下一位”，准备接收下一位考生信息");
        label10.setLineWrap(true);
        label10.setBounds(30, 180, 250, 200);
        label10.setFont(new Font("", Font.PLAIN, 16));
        label10.setEditable(false);

        JLabel label5 = new JLabel("题目信息：");
        label5.setBounds(320, 20, 100, 25);
        label5.setFont(new Font("", Font.PLAIN, 16));
        JTextArea label6 = new JTextArea();
        //label9.setSize(5000,5000);
        label6.setLineWrap(true);
        label6.setBounds(320, 50, 250, 280);
        label6.setFont(new Font("", Font.PLAIN, 16));
        label6.setEditable(false);

        JLabel label9 = new JLabel(" ");
        label9.setBounds(100, 30, 100, 25);
        label9.setFont(new Font("", Font.PLAIN, 16));
        //传值给姓名
        JLabel label7 = new JLabel(" ");
        label7.setBounds(100, 60, 100, 25);
        label7.setFont(new Font("", Font.PLAIN, 16));
        //传值给专业
        JLabel label8 = new JLabel(" ");
        label8.setBounds(100, 90, 100, 25);
        label8.setFont(new Font("", Font.PLAIN, 16));

        JButton bt2=new JButton("下一题");
        bt2.setBounds(320, 350, 100, 35);
        bt2.setFont(new Font("宋体",Font.PLAIN,16));
        panel.add(bt2);
        JButton bt3=new JButton("下一位");
        bt3.setBounds(450, 350, 100, 35);
        bt3.setFont(new Font("宋体",Font.PLAIN,16));
        panel.add(bt3);

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label5);
        panel.add(label6);
        panel.add(label7);
        panel.add(label8);
        panel.add(label9);
        panel.add(label10);
        label6.setText("综合面试其实主要考察考生的综合素质。包括考生本科期间的科研能力、知识结构、计算机操作能力、外语能力和应变能力等，在回答的时候并不要求十分精准的答案，但是要求考生流畅清楚以及有逻辑性的陈述。所以在综合面试之前相关信息的搜集、知识点的储备、以及勤加练习都是必不可少的。");

        //分割线
        JSplitPane split1 = new JSplitPane();
        split1.setBounds(300, 0, 1, 500);
        panel.add(split1);
        //把panel添加到容器
        container.add(panel);
        //设置关闭方式
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置大小
        frame.setSize(600, 500);
        //设置位置
        frame.setLocation(600, 300);

        //设置可见性
        frame.setVisible(true);
        //设置窗口大小不可变
        frame.setResizable(false);
        //考生信息接收
        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    group2 = InetAddress.getByName("224.0.0.2");//组播地址
                    int port = 8888;
                    msr2 = new MulticastSocket(port);
                    msr2.joinGroup(group2);//加入连接
                    byte[] buffer2 = new byte[8192];
                    int count = 0;
                    System.out.println("接收数据包启动！(启动时间: " + new Date() + ")" + group2);
                        DatagramPacket dp2 = new DatagramPacket(buffer2, buffer2.length);
                        msr2.receive(dp2);
                        String s2 = new String(dp2.getData(), 0, dp2.getLength());
                        //解码组播数据包
                        System.out.println(s2);
                        label9.setText(s2);
                        DatagramPacket dp3 = new DatagramPacket(buffer2, buffer2.length);
                        msr2.receive(dp3);
                        String s3 = new String(dp3.getData(), 0, dp3.getLength());
                        //解码组播数据包
                        System.out.println(s3);
                        label7.setText(s3);
                        DatagramPacket dp4 = new DatagramPacket(buffer2, buffer2.length);
                        msr2.receive(dp4);
                        String s4 = new String(dp4.getData(), 0, dp4.getLength());
                        //解码组播数据包
                        System.out.println(s4);
                        label8.setText(s4);
                } catch (Exception e2) {
                    e2.printStackTrace();
                } finally {
                    if (msr2 != null) {
                        try {
                            msr2.leaveGroup(group2);
                            msr2.close();
                        } catch (Exception e2) {
                            // TODO: handle exception
                        }
                    }
                }
            }
        });

            //题目信息接收
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    group = InetAddress.getByName("224.0.0.3");//组播地址
                    int port = 8888;
                    msr = new MulticastSocket(port);
                    msr.joinGroup(group);//加入连接
                    byte[] buffer = new byte[8192];
                    System.out.println("接收数据包启动！(启动时间: " + new Date() + ")" + group);
                        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                        msr.receive(dp);
                        String s = new String(dp.getData(), 0, dp.getLength());
                        //解码组播数据包
                        System.out.println(s);
                        label6.setText(s);
                } catch (Exception e3) {
                    e3.printStackTrace();
                } finally {
                    if (msr != null) {
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
    }
}
