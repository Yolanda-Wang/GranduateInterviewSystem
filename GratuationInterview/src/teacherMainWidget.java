import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Date;

public class teacherMainWidget {
    public static String url = "jdbc:mysql://localhost:3306/interview?useUnicode=true&characterencoding=GBK";
    public static String username = "manager";
    public static String password = "123456";
    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;
    public static Integer countque = 0;
    public static String majNo;
    public static String polNo;
    public static String EngNo;
    public static String eng_content;
    public static String pol_content;
    public static String maj_content;
    public static String que_content;
    public static MulticastSocket mss = null;
    public static InetAddress group;
    public static MulticastSocket mss2 = null;
    public static InetAddress group2;
    public static String maj;
    public static String name;
    public static Integer count_stu = 0;
    public static String next_stuID = " ";
<<<<<<< HEAD
    public String Tea_ID;
//    public static void main(String[] args) {
//        //连接数据库
//        try {
//            System.out.println("教师可视端：");
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("加载驱动成功");
//        } catch (ClassNotFoundException var2) {
//            System.out.println("加载驱动失败!");
//            var2.printStackTrace();
//        }
//
//        try {
//            con = DriverManager.getConnection(url, username, password);
//            stmt = con.createStatement();
//            System.out.println("连接成功");
//        } catch (SQLException var1) {
//            System.out.println("连接失败");
//        }
//	    teacherMainWidget w1=new teacherMainWidget();
//    }
    public teacherMainWidget(String TeaID){
        Tea_ID=TeaID;
=======
    public static void main(String[] args) {
        //连接数据库
>>>>>>> 4498caa156ac25db4b5753417aad8318df51e1b6
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
        teacherMainWidget(stmt);
    }
    public void teacherMainWidget(Statement stmt) {
    //初始化一个jframe
    JFrame frame = new JFrame("教师端");

    //初始化一个菜单栏
    JMenuBar menuBar = new JMenuBar();

    //初始化菜单
        JMenu menu1 = new JMenu("操作(O)");
        menu1.setMnemonic('O');
        JMenuItem logout=new JMenuItem("注销");
        menu1.add(logout);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.sql.Timestamp time=new java.sql.Timestamp(System.currentTimeMillis());
                String time1=time.toString();
                String logoutInfo="insert into log values('"+Tea_ID+"','-','"+time1+"')";
                try{
                    stmt.executeUpdate(logoutInfo);
                }catch (SQLException e1) {
                    e1.printStackTrace();
                }
                frame.dispose();
                new login();
            }
        });
        menu1.setFont(new Font("宋体",Font.PLAIN,16));

    JPanel panel = new JPanel();

    //初始化一个容器
    Container container = frame.getContentPane();
    //把菜单添加到菜单栏
    menuBar.add(menu1);

    frame.setJMenuBar(menuBar);
    
    panel.setLayout(null);
    
    JLabel label1=new JLabel("考号：");
    label1.setBounds(50,30,100,25);
    label1.setFont(new Font("",Font.PLAIN,16));
    JLabel label2=new JLabel("姓名：");
    label2.setBounds(50,60,100,25);
    label2.setFont(new Font("",Font.PLAIN,16));
    JLabel label3=new JLabel("专业：");
    label3.setBounds(50,90,100,25);
    label3.setFont(new Font("",Font.PLAIN,16));
    JLabel label4=new JLabel("面试分数");
    label4.setBounds(25,200,100,25);
    label4.setFont(new Font("",Font.PLAIN,16));
    JLabel label5=new JLabel("题目信息");
    label5.setBounds(320,20,100,25);
    label5.setFont(new Font("",Font.PLAIN,16));
    //set传值给考号
    JLabel label6=new JLabel(" ");
    label6.setBounds(100,30,100,25);
    label6.setFont(new Font("",Font.PLAIN,16));
    //传值给姓名
    JLabel label7=new JLabel(" ");
    label7.setBounds(100,60,100,25);
    label7.setFont(new Font("",Font.PLAIN,16));
    //传值给专业
    JLabel label8=new JLabel(" ");
    label8.setBounds(100,90,100,25);
    label8.setFont(new Font("",Font.PLAIN,16));

    //题目内容
        JTextArea label9=new JTextArea();
        //label9.setSize(5000,5000);
        label9.setLineWrap(true);
        label9.setBounds(320,50,250,280);
        label9.setFont(new Font("",Font.PLAIN,16));
        label9.setEditable(false);
    panel.add(label1);
    panel.add(label2);
    panel.add(label3);
    panel.add(label4);
    panel.add(label5);
    panel.add(label6);
    panel.add(label7);
    panel.add(label8);
    panel.add(label9);
    label9.setText("综合面试其实主要考察考生的综合素质。包括考生本科期间的科研能力、知识结构、计算机操作能力、外语能力和应变能力等，在回答的时候并不要求十分精准的答案，但是要求考生流畅清楚以及有逻辑性的陈述。所以在综合面试之前相关信息的搜集、知识点的储备、以及勤加练习都是必不可少的。");
    //分割线
    JSplitPane split1=new JSplitPane();
    split1.setBounds(300, 0,1, 500);
    panel.add(split1);
    //面试分数输入框
    JTextField gradeText = new JTextField(20);
    gradeText.setBounds(100,200,100,30);
    panel.add(gradeText);
    //按钮
    JButton bt1=new JButton("提交");
    bt1.setBounds(100, 250, 100, 35);
    bt1.setFont(new Font("宋体",Font.PLAIN,16));
    panel.add(bt1);
    JButton bt2=new JButton("下一题");
    bt2.setBounds(320, 350, 100, 35);
    bt2.setFont(new Font("宋体",Font.PLAIN,16));
    panel.add(bt2);
        JButton bt3=new JButton("下一位");
        bt3.setBounds(450, 350, 100, 35);
        bt3.setFont(new Font("宋体",Font.PLAIN,16));
        panel.add(bt3);
    //把panel添加到容器
    container.add(panel);

    //设置关闭方式
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //设置大小
    frame.setSize(600,500);

    //设置位置
    frame.setLocation(100, 100);

    //设置可见性
    frame.setVisible(true);

    //显示题目信息
<<<<<<< HEAD
        //下一位
        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count_stu++;
                ResultSet rst;
                String next_stu = "select * from choosestu where Num='"+count_stu+"'";
                try {
                    rst = stmt.executeQuery(next_stu);
                    if(rst.next()){
                        next_stuID = rst.getString("stuID");
                        System.out.println(next_stuID);
                    }
                }catch (Exception e2){
                    e2.printStackTrace();
                }
                if (count_stu == 10){
                    count_stu = 0;
                    //清空表
                    String delete = "delete from choosestu";
                    try {
                        stmt.executeUpdate(delete);
                    }catch (Exception exc){
                        exc.printStackTrace();
                    }

=======


        //下一位
        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count_stu++;
                ResultSet rst;
                String next_stu = "select * from choosestu where Num='"+count_stu+"'";
                try {
                    rst = stmt.executeQuery(next_stu);
                    if(rst.next()){
                        next_stuID = rst.getString("stuID");
                        System.out.println(next_stuID);
                    }
                }catch (Exception e2){
                    e2.printStackTrace();
                }
                if (count_stu == 10){
                    count_stu = 0;
                    //清空表
                    String delete = "delete from choosestu";
                    try {
                        stmt.executeUpdate(delete);
                    }catch (Exception exc){
                        exc.printStackTrace();
                    }

>>>>>>> 4498caa156ac25db4b5753417aad8318df51e1b6
                }

                //读取学生信息
                String information = "select * from student where S_stuID='"+next_stuID+"'";
                try {
                    rs = stmt.executeQuery(information);
                    if (rs.next()){
                        name = rs.getString("S_name");
                        System.out.println(name);
                        maj = rs.getString("S_major");
                        System.out.println(maj);
                    }
                    String select = "select * from queno where S_stuID='"+next_stuID+"'";
                    rs = stmt.executeQuery(select);
                    if (rs.next()){
                        majNo = rs.getString("majNo");
                        System.out.println(majNo);
                        polNo = rs.getString("polNo");
                        System.out.println(polNo);
                        EngNo = rs.getString("EngNo");
                        System.out.println(EngNo);

                        ResultSet rs1, rs2;
                        String selectMaj ="select M_content from majque where M_No = '"+majNo+"'";
                        rs = stmt.executeQuery(selectMaj);
                        if (rs.next()){
                            maj_content = rs.getString("M_content");
                            System.out.println(maj_content);
                        }
                        String selectEng ="select E_content from engque where E_No = '"+EngNo+"'";
                        rs1 = stmt.executeQuery(selectEng);
                        if (rs1.next()){
                            eng_content = rs1.getString("E_content");
                            System.out.println(eng_content);
                        }
                        String selectpol ="select P_content from polque where P_No = '"+polNo+"'";
                        rs2 = stmt.executeQuery(selectpol);
                        if (rs2.next()){
                            pol_content = rs2.getString("P_content");
                            System.out.println(pol_content);
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                label6.setText(next_stuID);
                label7.setText(name);
                label8.setText(maj);
                countque = 0;

                try {
                    group2 = InetAddress.getByName("224.0.0.2");//组播地址
                    int port = 8888;
                    mss2 = new MulticastSocket(port);
                    mss2.joinGroup(group2);
                    System.out.println("发送数据包启动！（启动时间" + new Date() + ")");
                    String message2 = next_stuID;
                    byte[] buffer2 = message2.getBytes();
                    DatagramPacket dp2 = new DatagramPacket(buffer2, buffer2.length, group2, port);
                    mss2.send(dp2);
                    System.out.println("发送数据包给 " + group2 + ":" + port);
                    Thread.sleep(1000);

                    message2 = name;
                    buffer2 = message2.getBytes();
                    DatagramPacket dp3 = new DatagramPacket(buffer2, buffer2.length, group2, port);
                    mss2.send(dp3);
                    System.out.println("发送数据包给 " + group2 + ":" + port);
                    Thread.sleep(1000);

                    message2 = maj;
                    buffer2 = message2.getBytes();
                    DatagramPacket dp4 = new DatagramPacket(buffer2, buffer2.length, group2, port);
                    mss2.send(dp4);
                    System.out.println("发送数据包给 " + group2 + ":" + port);
                    Thread.sleep(1000);
                } catch (Exception e2) {
                    e2.printStackTrace();
                } finally {
<<<<<<< HEAD
                    try {
                        if (mss2 != null) {
                            mss2.leaveGroup(group2);
                            mss2.close();
                        }
                    } catch (Exception e2) {
                        // TODO: handle exception
                    }
                }
            }
        });
        //下一题
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(rs);
                //String select2 = "select * from queno where S_stuID='"+label6.getText()+"'";
//            try {
                //rs = stmt.executeQuery(select2);
                switch (countque) {
                    case 0:
                        System.out.println(maj_content);
                        que_content = maj_content;
                        label9.setText(que_content);
=======
                    try {
                        if (mss2 != null) {
                            mss2.leaveGroup(group2);
                            mss2.close();
                        }
                    } catch (Exception e2) {
                        // TODO: handle exception
                    }
                }
            }
        });
    //下一题
    bt2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //System.out.println(rs);
            //String select2 = "select * from queno where S_stuID='"+label6.getText()+"'";
//            try {
            //rs = stmt.executeQuery(select2);
            switch (countque) {
                case 0:
                    System.out.println(maj_content);
                    que_content = maj_content;
                    label9.setText(que_content);
                    try {
                        group = InetAddress.getByName("224.0.0.1");//组播地址
                        int port = 8888;
                        mss = new MulticastSocket(port);
                        mss.joinGroup(group);
                        System.out.println("发送数据包启动！（启动时间" + new Date() + ")");
                        String message = que_content;
                        //message = "12345";
                        byte[] buffer = message.getBytes();
                        DatagramPacket dp = new DatagramPacket(buffer, buffer.length, group, port);
                        mss.send(dp);
                        System.out.println("发送数据包给 " + group + ":" + port);
                        Thread.sleep(1000);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    } finally {
>>>>>>> 4498caa156ac25db4b5753417aad8318df51e1b6
                        try {
                            group = InetAddress.getByName("224.0.0.3");//组播地址
                            int port = 8888;
                            mss = new MulticastSocket(port);
                            mss.joinGroup(group);
                            System.out.println("发送数据包启动！（启动时间" + new Date() + ")");
                            String message = que_content;
                            //message = "12345";
                            byte[] buffer = message.getBytes();
                            DatagramPacket dp = new DatagramPacket(buffer, buffer.length, group, port);
                            mss.send(dp);
                            System.out.println("发送数据包给 " + group + ":" + port);
                            Thread.sleep(1000);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        } finally {
                            try {
                                if (mss != null) {
                                    mss.leaveGroup(group);
                                    mss.close();
                                }
                            } catch (Exception e2) {
                                // TODO: handle exception
                            }
                        }
<<<<<<< HEAD
                        countque++;
                        break;
                    case 1:
                        System.out.println(pol_content);
                        que_content = pol_content;
                        label9.setText(que_content);
=======
                    }
                    countque++;
                    break;
                case 1:
                    System.out.println(pol_content);
                    que_content = pol_content;
                    label9.setText(que_content);
                    try {
                        group = InetAddress.getByName("224.0.0.1");//组播地址
                        int port = 8888;
                        mss = new MulticastSocket(port);
                        mss.joinGroup(group);
                        System.out.println("发送数据包启动！（启动时间" + new Date() + ")");
                        String message = que_content;
                        byte[] buffer = message.getBytes();
                        DatagramPacket dp = new DatagramPacket(buffer, buffer.length, group, port);
                        mss.send(dp);
                        System.out.println("发送数据包给 " + group + ":" + port);
                        Thread.sleep(1000);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    } finally {
>>>>>>> 4498caa156ac25db4b5753417aad8318df51e1b6
                        try {
                            group = InetAddress.getByName("224.0.0.3");//组播地址
                            int port = 8888;
                            mss = new MulticastSocket(port);
                            mss.joinGroup(group);
                            System.out.println("发送数据包启动！（启动时间" + new Date() + ")");
                            String message = que_content;
                            byte[] buffer = message.getBytes();
                            DatagramPacket dp = new DatagramPacket(buffer, buffer.length, group, port);
                            mss.send(dp);
                            System.out.println("发送数据包给 " + group + ":" + port);
                            Thread.sleep(1000);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        } finally {
                            try {
                                if (mss != null) {
                                    mss.leaveGroup(group);
                                    mss.close();
                                }
                            } catch (Exception e2) {
                                // TODO: handle exception
                            }
                        }
<<<<<<< HEAD
                        countque++;
                        break;
                    case 2:
                        System.out.println(eng_content);
                        que_content = eng_content;
                        label9.setText(que_content);
=======
                    }
                    countque++;
                    break;
                case 2:
                    System.out.println(eng_content);
                    que_content = eng_content;
                    label9.setText(que_content);
                    try {
                        group = InetAddress.getByName("224.0.0.1");//组播地址
                        int port = 8888;
                        mss = new MulticastSocket(port);
                        mss.joinGroup(group);
                        System.out.println("发送数据包启动！（启动时间" + new Date() + ")");
                        String message = que_content;
                        byte[] buffer = message.getBytes();
                        DatagramPacket dp = new DatagramPacket(buffer, buffer.length, group, port);
                        mss.send(dp);
                        System.out.println("发送数据包给 " + group + ":" + port);
                        Thread.sleep(1000);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    } finally {
>>>>>>> 4498caa156ac25db4b5753417aad8318df51e1b6
                        try {
                            group = InetAddress.getByName("224.0.0.3");//组播地址
                            int port = 8888;
                            mss = new MulticastSocket(port);
                            mss.joinGroup(group);
                            System.out.println("发送数据包启动！（启动时间" + new Date() + ")");
                            String message = que_content;
                            byte[] buffer = message.getBytes();
                            DatagramPacket dp = new DatagramPacket(buffer, buffer.length, group, port);
                            mss.send(dp);
                            System.out.println("发送数据包给 " + group + ":" + port);
                            Thread.sleep(1000);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        } finally {
                            try {
                                if (mss != null) {
                                    mss.leaveGroup(group);
                                    mss.close();
                                }
                            } catch (Exception e2) {
                                // TODO: handle exception
                            }
                        }
<<<<<<< HEAD
                        countque++;
                        break;
                    default:
                        System.out.println("end");
                }
            }
        });
=======
                    }
                    countque++;
                    break;
                default:
                    System.out.println("end");
            }
        }
    });
>>>>>>> 4498caa156ac25db4b5753417aad8318df51e1b6


    //提交分数
    bt1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e1) {
            int grade = Integer.parseInt(gradeText.getText());
            if(!gradeText.getText().equals("")&&grade<100&&grade>=0){
                String select="select S_intGrade from student where S_stuID = '"+label6.getText()+"'";
                try {
                    rs = stmt.executeQuery(select);
                    if(rs.next()){
                        if(rs.getString("S_intGrade")==null){
                            String add_grade = "update student set S_intGrade = '"+gradeText.getText()+"' where S_stuID = '"+label6.getText()+"'";
                            String update_flag ="update student set S_flag = 1  where S_stuID = '"+label6.getText()+"'";
                        stmt.executeUpdate(add_grade);
                        stmt.executeUpdate(update_flag);
//                            System.out.println("分数提交成功");
                            JOptionPane.showMessageDialog(null,"分数提交成功","提示",JOptionPane.PLAIN_MESSAGE);
                        }
                        else{
//                            System.out.println("已打分");
                            JOptionPane.showMessageDialog(null,"已打分","提示",JOptionPane.PLAIN_MESSAGE);
                        }
                    }

                } catch (SQLException e2) {
                    e2.printStackTrace();
                }

            }
            else{
//                System.out.println("grade is out of range!");
                JOptionPane.showMessageDialog(null,"分数应在0-100分","提示",JOptionPane.PLAIN_MESSAGE);
            }
        }
    });
}

//    public void server() throws Exception{
//        InetAddress group = InetAddress.getByName("224.0.0.2");//组播地址
//        int port = 8888;
//        MulticastSocket mss = null;;
//
//        try {
//            mss = new MulticastSocket(port);
//            mss.joinGroup(group);
//            System.out.println("发送数据包启动！（启动时间"+new Date()+")");
//            String message = que_content;
//            byte[] buffer = message.getBytes();
//            DatagramPacket dp = new DatagramPacket(buffer, buffer.length,group,port);
//            mss.send(dp);
//            System.out.println("发送数据包给 "+group+":"+port);
//            Thread.sleep(1000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally{
//            try {
//                if(mss!=null){
//                    mss.leaveGroup(group);
//                    mss.close();
//                }
//            } catch (Exception e2) {
//                // TODO: handle exception
//            }
//        }
//    }
}

