import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

public class admin {
    public static String url = "jdbc:mysql://localhost:3306/interview?useUnicode=true&characterencoding=GBK";
    public static String username = "manager";
    public static String password = "123456";
    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;
    public static void main(String[]args) {
        try {
            System.out.println("登录：");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("加载驱动成功");
        } catch (ClassNotFoundException var2) {
            System.out.println("加载驱动失败!");
            var2.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            System.out.println("连接成功");
        } catch (SQLException var1) {
            System.out.println("连接失败!");
        }
        admin a=new admin();
    }
    public admin() {
        try {
            System.out.println("登录：");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("加载驱动成功");
        } catch (ClassNotFoundException var2) {
            System.out.println("加载驱动失败!");
            var2.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            System.out.println("连接成功");
        } catch (SQLException var1) {
            System.out.println("连接失败!");
        }
        JFrame frame=new JFrame("管理员界面");
        //初始化一个菜单栏
        JMenuBar menuBar = new JMenuBar();

        //初始化菜单
        JMenu menu1 = new JMenu("操作(O)");
        menu1.setMnemonic('O');
        menu1.setFont(new Font("宋体",Font.PLAIN,16));
        JMenu menu2 = new JMenu("帮助(H)");
        menu2.setMnemonic('H');
        menu2.setFont(new Font("宋体",Font.PLAIN,16));
        JMenu menu3 = new JMenu("查询(Q)");
        menu3.setMnemonic('Q');
        menu3.setFont(new Font("宋体",Font.PLAIN,16));
        JMenu menu4 = new JMenu("统计(S)");
        menu4.setMnemonic('S');
        menu4.setFont(new Font("宋体",Font.PLAIN,16));
        JMenu menu5 = new JMenu("维护(M)");
        menu5.setMnemonic('M');
        menu5.setFont(new Font("宋体",Font.PLAIN,16));
        //把菜单添加到菜单栏
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);
        menuBar.add(menu5);
        //设置菜单栏
        frame.setJMenuBar(menuBar);

        JPanel panel=new JPanel();
        Container container = frame.getContentPane();
        panel.setLayout(null);

        JButton stuManageButton = new JButton("管理学生信息");
        stuManageButton.setFont(new Font("",Font.PLAIN,16));
        stuManageButton.setBounds(20, 20, 150, 35);
        stuManageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentDataset();
                frame.dispose();
            }
        });
        panel.add(stuManageButton);

        JButton teaManageButton = new JButton("管理老师信息");
        teaManageButton.setFont(new Font("",Font.PLAIN,16));
        teaManageButton.setBounds(20, 60, 150, 35);
        teaManageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new teacherManagement();
                frame.dispose();
            }
        });
        panel.add(teaManageButton);

        JButton titleButton = new JButton("管理题目信息");
        titleButton.setFont(new Font("",Font.PLAIN,16));
        titleButton.setBounds(20, 100, 150, 35);
        titleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new titleDataset();
                frame.dispose();
            }
        });
        panel.add(titleButton);

        JLabel label=new JLabel("选择面试科目：");
        label.setBounds(20,140,100,25);
        label.setFont(new Font("",Font.PLAIN,16));
        JComboBox combo=new JComboBox();
        combo.setBounds(200,140,150,25);
        combo.addItem("英语");
        combo.addItem("cs");
        combo.addItem("计算机");
        combo.addItem("物理");
        combo.addItem("化学");
        combo.addItem("政治");
        panel.add(combo);
        panel.add(label);
        JButton commitButton = new JButton("提交");
        commitButton.setFont(new Font("",Font.PLAIN,16));
        commitButton.setBounds(80, 180, 150, 35);
        commitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectNum="select count(*) from student where S_major='"+combo.getSelectedItem()+"'and S_flag=0";
                try{
                    rs=stmt.executeQuery(selectNum);
                    if(rs.next()){
                        int num=rs.getInt("count(*)");
                        if(num>5){
                            List<String> sID=new ArrayList<>();
                            String chooseStu = "select S_stuID from student where S_major='"+combo.getSelectedItem()+"'and S_flag=0";
                            rs=stmt.executeQuery(chooseStu);
                            int n=0;
                            List<Integer> numbers = new ArrayList<>();
                            for(int i = 0; i < num; i ++)
                                numbers.add(i);

                            while(rs.next()){
                                       sID.add(rs.getString("S_stuID"));

                            }

                            int index =0;
                            for(int i = 0; i < 5; i++){
                                Random random = new Random();
                                int r = random.nextInt(num - i);
                                index = numbers.get(r);
                                System.out.print(index);
                                String chooseStu2="insert into choosestu values("+(i+1)+",'"+sID.get(index)+"')";
                                stmt.executeUpdate(chooseStu2);
                                String chooseStu3="update student set S_flag=1 where S_stuID='"+sID.get(index)+"'";
                                stmt.executeUpdate(chooseStu3);
                                numbers.remove(r);
                            }
                        }else{

                            String sID;
                            String chooseStu = "select S_stuID from Student where S_major='"+combo.getSelectedItem()+"'and S_flag=0";
                            rs=stmt.executeQuery(chooseStu);
                            int n=1;
                            while(rs.next()){
                                sID=rs.getString("S_stuID");
                                String chooseStu2="insert into choosestu values("+n+",'"+sID+"')";
                                stmt.executeUpdate(chooseStu2);
                                String chooseStu3="update student set S_flag=1 where S_stuID='"+sID+"'";
                                stmt.executeUpdate(chooseStu3);
                                n++;
                            }
                        }

                    }
                }  catch (Exception e2) {
                // TODO: handle exception
            }
            }
        });
        panel.add(commitButton);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //设置大小
        frame.setSize(600,500);

        //设置位置
        frame.setLocation(600, 300);

        //设置可见性
        frame.setVisible(true);
    }
}
