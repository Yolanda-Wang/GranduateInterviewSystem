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
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 4850ae774c435ed590eb701117713f0e6a1b52c2
    public static void main(String[]args) {
        try {
            System.out.println("登录：");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("加载驱动成功");
        } catch (ClassNotFoundException var2) {
            System.out.println("加载驱动失败!");
            var2.printStackTrace();
        }
<<<<<<< HEAD

        try {
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            System.out.println("连接成功");
        } catch (SQLException var1) {
            System.out.println("连接失败!");
=======
=======
<<<<<<< HEAD
    public static void main(String[]args) {
=======
public static void main(String[]args) throws SQLException {
    try {
        System.out.println("账号管理：");
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("加载驱动成功");
    } catch (ClassNotFoundException var2) {
        System.out.println("加载驱动失败!");
        var2.printStackTrace();
    }
    try {
        con = DriverManager.getConnection(url, username, password);
        stmt = con.createStatement();
        System.out.println("账号管理数据库连接成功");
    } catch (SQLException var1) {
        System.out.println("账号管理数据库连接失败!");
    }
	admin a=new admin();
}
public admin() {
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
	   
//	  Object[] columnNames = {"账号","密码","类别"};// 定义表格列名数组
//	    // 定义表格数据数组
//	    String[][] tableValues = {{"001","123",null},{"002","234",null},{"003","562",null}};
//	    // 创建指定列名和数据的表格
        final DefaultTableModel[] model = {new DefaultTableModel()};
        Vector data = new Vector(); // 数据行向量集，因为列表不止一行，往里面添加数据行向量，添加方法add(row)
        Vector names = new Vector();// 列名向量，使用它的add()方法添加列名
        JTable table = new JTable(model[0]);
        names.add("账号");
        names.add("密码");
        names.add("类别");
    String viewtable = "select * from password";
>>>>>>> c1aeefb3f04ab20f4098d9c4dc5d773db1493b67
        try {
            System.out.println("鐧诲綍锛�");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("鍔犺浇椹卞姩鎴愬姛");
        } catch (ClassNotFoundException var2) {
            System.out.println("鍔犺浇椹卞姩澶辫触!");
            var2.printStackTrace();
        }
<<<<<<< HEAD

        try {
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            System.out.println("杩炴帴鎴愬姛");
        } catch (SQLException var1) {
            System.out.println("杩炴帴澶辫触!");
>>>>>>> 4850ae774c435ed590eb701117713f0e6a1b52c2
        }
        admin a=new admin();
    }
    public admin() {
        try {
<<<<<<< HEAD
            System.out.println("登录：");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("加载驱动成功");
        } catch (ClassNotFoundException var2) {
            System.out.println("加载驱动失败!");
            var2.printStackTrace();
        }
=======
            System.out.println("鐧诲綍锛�");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("鍔犺浇椹卞姩鎴愬姛");
        } catch (ClassNotFoundException var2) {
            System.out.println("鍔犺浇椹卞姩澶辫触!");
            var2.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            System.out.println("杩炴帴鎴愬姛");
        } catch (SQLException var1) {
            System.out.println("杩炴帴澶辫触!");
        }
        JFrame frame=new JFrame("绠＄悊鍛樼晫闈�");
        //鍒濆鍖栦竴涓彍鍗曟爮
        JMenuBar menuBar = new JMenuBar();

        //鍒濆鍖栬彍鍗�
        JMenu menu1 = new JMenu("鎿嶄綔(O)");
        menu1.setMnemonic('O');
        menu1.setFont(new Font("瀹嬩綋",Font.PLAIN,16));
        JMenu menu2 = new JMenu("甯姪(H)");
        menu2.setMnemonic('H');
        menu2.setFont(new Font("瀹嬩綋",Font.PLAIN,16));
        JMenu menu3 = new JMenu("鏌ヨ(Q)");
        menu3.setMnemonic('Q');
        menu3.setFont(new Font("瀹嬩綋",Font.PLAIN,16));
        JMenu menu4 = new JMenu("缁熻(S)");
        menu4.setMnemonic('S');
        menu4.setFont(new Font("瀹嬩綋",Font.PLAIN,16));
        JMenu menu5 = new JMenu("缁存姢(M)");
        menu5.setMnemonic('M');
        menu5.setFont(new Font("瀹嬩綋",Font.PLAIN,16));
        //鎶婅彍鍗曟坊鍔犲埌鑿滃崟鏍�
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);
        menuBar.add(menu5);
        //璁剧疆鑿滃崟鏍�
        frame.setJMenuBar(menuBar);

        JPanel panel=new JPanel();
        Container container = frame.getContentPane();
        panel.setLayout(null);

        JButton stuManageButton = new JButton("绠＄悊瀛︾敓淇℃伅");
        stuManageButton.setFont(new Font("",Font.PLAIN,16));
        stuManageButton.setBounds(20, 20, 150, 35);
        stuManageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentDataset();
                frame.dispose();
=======
        model[0].setDataVector(data, names); // 设置模型中的元素，它会自动显示在列表中
        JScrollPane jsp = new JScrollPane(table); // 用列表创建可滚动的Panel，把这个Panel添加到窗口中
        jsp.setSize(200, 200);
        jsp.setLocation(10, 70);
        panel.add(jsp);
	    table.setBounds(10,70,200,200);
	    table.setRowHeight(30);
	    table.setFont(new Font("",Font.PLAIN,16));
	    table.getTableHeader().setBounds(10, 50, 250, 20);
	    
	    //输入文本框
	    JLabel userLabel = new JLabel("账号:");
        userLabel.setFont(new Font("",Font.PLAIN,16));
        userLabel.setBounds(300,40,250,25);
        panel.add(userLabel);
        
	    JTextField userText = new JTextField(20);
        userText.setBounds(350,40,165,25);
        panel.add(userText);
>>>>>>> 4498caa156ac25db4b5753417aad8318df51e1b6
>>>>>>> 4850ae774c435ed590eb701117713f0e6a1b52c2

        try {
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            System.out.println("连接成功");
        } catch (SQLException var1) {
            System.out.println("连接失败!");
        }
<<<<<<< HEAD
        JFrame frame=new JFrame("管理员界面");
        //初始化一个菜单栏
        JMenuBar menuBar = new JMenuBar();

        //初始化菜单

        JMenu menu2 = new JMenu("帮助(H)");
        menu2.setMnemonic('H');
        menu2.setFont(new Font("宋体",Font.PLAIN,16));

        //把菜单添加到菜单栏
        menuBar.add(menu2);

        //设置菜单栏
        frame.setJMenuBar(menuBar);

        JPanel panel=new JPanel();
        Container container = frame.getContentPane();
        panel.setLayout(null);

        JButton stuManageButton = new JButton("管理学生信息");
        stuManageButton.setFont(new Font("",Font.PLAIN,16));
        stuManageButton.setBounds(200, 20, 150, 35);
        stuManageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentDataset();

=======
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
<<<<<<< HEAD
                new teacherManagement();
                frame.dispose();
            }
        });
        panel.add(teaManageButton);

        JButton titleButton = new JButton("管理题目信息");
        titleButton.setFont(new Font("",Font.PLAIN,16));
        titleButton.setBounds(20, 100, 150, 35);
        titleButton.addActionListener(new ActionListener() {
=======
                String passW = String.valueOf(passwordText.getPassword());
                if(!userText.getText().equals("")&&!passW.equals("")){
                    try {
                        if(passW.length()==8){
                            if(userText.getText().length()==11) {
                                String viewtable = "select S_stuID from student where S_stuID='"+userText.getText()+"'";
                                rs = stmt.executeQuery(viewtable);
                                if(rs.next()){
                                    String addPass = "insert into password(ID,password,type) values('"+userText.getText()+"','"+passW+"','考生')";
                                    String addstup = "update student set S_password = '"+passW+"' where S_stuID='"+userText.getText()+"'";
                                    stmt.executeUpdate(addPass);
                                    stmt.executeUpdate(addstup);
                                    Vector rowData1 = new Vector();
                                    rowData1.add(userText.getText());
                                    rowData1.add(passW);
                                    rowData1.add("考生");
                                    data.add(rowData1);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
//                                    System.out.println("考生账号密码添加成功");
                                    JOptionPane.showMessageDialog(null,"考生账号密码添加成功","提示",JOptionPane.PLAIN_MESSAGE);
                                }
                                else{
                                    System.out.println("该考生账号不存在");
                                }
                            }
                            else if(userText.getText().length()==6){
                                String viewtable = "select T_TeaID from teacher where T_TeaID='"+userText.getText()+"'";
                                rs = stmt.executeQuery(viewtable);
                                if(rs.next()){
                                    String addPass = "insert into password(ID,password,type) values('"+userText.getText()+"','"+passW+"','导师')";
                                    String addteap = "update teacher set T_password = '"+passW+"' where T_TeaID='"+userText.getText()+"'";
                                    stmt.executeUpdate(addPass);
                                    stmt.executeUpdate(addteap);
                                    Vector rowData2 = new Vector();
                                    rowData2.add(userText.getText());
                                    rowData2.add(passW);
                                    rowData2.add("导师");
                                    data.add(rowData2);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
//                                    System.out.println("导师账号密码添加成功");
                                    JOptionPane.showMessageDialog(null,"导师账号密码添加成功","提示",JOptionPane.PLAIN_MESSAGE);
                                }
                                else{
                                    System.out.println("该导师账号不存在");
                                }
                            }
                            else if(userText.getText().length()==2){
                                String addPass = "insert into password(ID,password,type) values('"+userText.getText()+"','"+passW+"','管理员')";
                                String addmanp = "insert into manager(M_manID,M_password) values('"+userText.getText()+"','"+passW+"')";
                                stmt.executeUpdate(addPass);
                                stmt.executeUpdate(addmanp);
                                Vector rowData2 = new Vector();
                                rowData2.add(userText.getText());
                                rowData2.add(passW);
                                rowData2.add("管理员");
                                data.add(rowData2);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
//                                System.out.println("管理员账号密码添加成功");
                                JOptionPane.showMessageDialog(null,"管理员账号密码添加成功","提示",JOptionPane.PLAIN_MESSAGE);
                            }
                            else{
                                System.out.println("账号长度不匹配");
                            }
                        }
                     else {
                            System.out.println("密码为八位数");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else{
                    System.out.println("账号密码需同时添加");
                }
>>>>>>> c1aeefb3f04ab20f4098d9c4dc5d773db1493b67
>>>>>>> 4850ae774c435ed590eb701117713f0e6a1b52c2
            }
        });
        panel.add(stuManageButton);

<<<<<<< HEAD
        JButton teaManageButton = new JButton("管理老师信息");
        teaManageButton.setFont(new Font("",Font.PLAIN,16));
        teaManageButton.setBounds(200, 90, 150, 35);
        teaManageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new teacherManagement();

            }
        });
        panel.add(teaManageButton);

        JButton titleButton = new JButton("管理题目信息");
        titleButton.setFont(new Font("",Font.PLAIN,16));
        titleButton.setBounds(200, 160, 150, 35);
        titleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new titleDataset();

            }
        });
        panel.add(titleButton);

        JLabel label=new JLabel("选择面试科目：");
        label.setBounds(20,260,200,25);
        label.setFont(new Font("",Font.PLAIN,16));
        JComboBox combo=new JComboBox();
        combo.setBounds(200,260,150,25);
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
        commitButton.setBounds(350, 300, 150, 35);
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
=======
<<<<<<< HEAD
        JButton teaManageButton = new JButton("绠＄悊鑰佸笀淇℃伅");
        teaManageButton.setFont(new Font("",Font.PLAIN,16));
        teaManageButton.setBounds(20, 60, 150, 35);
        teaManageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new teacherManagement();
                frame.dispose();
=======
        //更新账号密码
        updateButton.addActionListener(new ActionListener() {
>>>>>>> 4498caa156ac25db4b5753417aad8318df51e1b6
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
<<<<<<< HEAD

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
=======
                            else{
                                if(userText.getText().length()==11) {
                                    String viewtable = "select S_stuID from student where S_stuID='"+userText.getText()+"'";
                                    rs = stmt.executeQuery(viewtable);
                                    if(rs.next()){
                                        String addPass = "insert into password(ID,password,type) values('"+userText.getText()+"','"+passW+"','考生')";
                                        String addstup = "update student set S_password = '"+passW+"' where S_stuID='"+userText.getText()+"'";
                                        stmt.executeUpdate(addPass);
                                        stmt.executeUpdate(addstup);
                                        Vector rowData1 = new Vector();
                                        rowData1.add(userText.getText());
                                        rowData1.add(passW);
                                        rowData1.add("考生");
                                        data.add(rowData1);
                                        model[0] = new DefaultTableModel(data, names);
                                        table.setModel(model[0]);
//                                        System.out.println("考生账号密码添加成功");
                                        JOptionPane.showMessageDialog(null,"考生账号密码更新成功","提示",JOptionPane.PLAIN_MESSAGE);
                                    }
                                    else{
                                        System.out.println("该考生账号不存在");
                                    }
                                }
                                else if(userText.getText().length()==6){
                                    String viewtable = "select T_TeaID from teacher where T_TeaID='"+userText.getText()+"'";
                                    rs = stmt.executeQuery(viewtable);
                                    if(rs.next()){
                                        String addPass = "insert into password(ID,password,type) values('"+userText.getText()+"','"+passW+"','导师')";
                                        String addteap = "update teacher set T_password = '"+passW+"' where T_TeaID='"+userText.getText()+"'";
                                        stmt.executeUpdate(addPass);
                                        stmt.executeUpdate(addteap);
                                        Vector rowData2 = new Vector();
                                        rowData2.add(userText.getText());
                                        rowData2.add(passW);
                                        rowData2.add("导师");
                                        data.add(rowData2);
                                        model[0] = new DefaultTableModel(data, names);
                                        table.setModel(model[0]);
//                                        System.out.println("导师账号密码添加成功");
                                        JOptionPane.showMessageDialog(null,"导师账号密码更新成功","提示",JOptionPane.PLAIN_MESSAGE);
                                    }
                                    else{
                                        System.out.println("该导师账号不存在");
                                    }
                                }
                                else if(userText.getText().length()==2){
                                    String addPass = "insert into password(ID,password,type) values('"+userText.getText()+"','"+passW+"','管理员')";
                                    String addmanp = "insert into manager(M_manID,M_password) values('"+userText.getText()+"','"+passW+"')";
                                    stmt.executeUpdate(addPass);
                                    stmt.executeUpdate(addmanp);
                                    Vector rowData2 = new Vector();
                                    rowData2.add(userText.getText());
                                    rowData2.add(passW);
                                    rowData2.add("管理员");
                                    data.add(rowData2);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
//                                    System.out.println("管理员账号密码添加成功");
                                    JOptionPane.showMessageDialog(null,"管理员账号密码添加成功","提示",JOptionPane.PLAIN_MESSAGE);
                                }
                                else{
                                    System.out.println("账户不存在");
                                }
>>>>>>> 4498caa156ac25db4b5753417aad8318df51e1b6
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
<<<<<<< HEAD
                }  catch (Exception e2) {
                // TODO: handle exception
            }
            }
        });
        panel.add(commitButton);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

=======

                    else{
                        System.out.println("密码必须为八位！");
                    }
                }
>>>>>>> c1aeefb3f04ab20f4098d9c4dc5d773db1493b67
            }
        });
        panel.add(teaManageButton);

<<<<<<< HEAD
        JButton titleButton = new JButton("绠＄悊棰樼洰淇℃伅");
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

        JLabel label=new JLabel("閫夋嫨闈㈣瘯绉戠洰锛�");
        label.setBounds(20,140,100,25);
        label.setFont(new Font("",Font.PLAIN,16));
        JComboBox combo=new JComboBox();
        combo.setBounds(200,140,150,25);
        combo.addItem("鑻辫");
        combo.addItem("鏁板");
        combo.addItem("璁＄畻鏈�");
        combo.addItem("鐗╃悊");
        combo.addItem("鍖栧");
        combo.addItem("鏀挎不");
        panel.add(combo);
        panel.add(label);
        JButton commitButton = new JButton("鎻愪氦");
        commitButton.setFont(new Font("",Font.PLAIN,16));
        commitButton.setBounds(80, 180, 150, 35);

        panel.add(commitButton);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //璁剧疆澶у皬
        frame.setSize(600,500);

        //璁剧疆浣嶇疆
        frame.setLocation(100, 100);

        //璁剧疆鍙鎬�
        frame.setVisible(true);
    }
=======
        //删除账号密码
    deleteButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String passW = String.valueOf(passwordText.getPassword());
            if (!userText.getText().equals("") && !passW.equals("")) {
                if (passW.length() == 8) {
                    if (userText.getText().length() == 11) {
                        String select = "select password from password where ID='" + userText.getText() + "'";
                        try {
                            rs = stmt.executeQuery(select);
                            if (rs.next()) {
                                if (rs.getString("password").equals(passW)) {
                                    String delete = "delete from password where ID = '" + userText.getText() + "'";
                                    stmt.executeUpdate(delete);
                                    String delete_stu = "update student set S_password='' where S_stuID = '" + userText.getText() + "'";
                                    stmt.executeUpdate(delete_stu);
//                                    System.out.println("考生账号密码删除成功");
                                    JOptionPane.showMessageDialog(null,"考生账号密码删除成功","提示",JOptionPane.PLAIN_MESSAGE);
                                } else {
                                    System.out.println("账号密码不匹配");
                                }
                            } else {
                                System.out.println("账号密码不存在");
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    } else if (userText.getText().length() == 6) {
                        String select = "select password from password where ID='" + userText.getText() + "'";
                        try {
                            rs = stmt.executeQuery(select);
                            if (rs.next()) {
                                if (rs.getString("password").equals(passW)) {
                                    String delete = "delete from password where ID = '" + userText.getText() + "'";
                                    stmt.executeUpdate(delete);
                                    String delete_stu = "update teacher set T_password='' where T_TeaID = '" + userText.getText() + "'";
                                    stmt.executeUpdate(delete_stu);
//                                    System.out.println("导师账号密码删除成功");
                                    JOptionPane.showMessageDialog(null,"导师账号密码删除成功","提示",JOptionPane.PLAIN_MESSAGE);
                                } else {
                                    System.out.println("账号密码不匹配");
                                }
                            } else {
                                System.out.println("账号密码不存在");
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                    else if(userText.getText().length() ==2){
                        String select = "select password from password where ID='" + userText.getText() + "'";
                        try {
                            rs = stmt.executeQuery(select);
                            if (rs.next()) {
                                if (rs.getString("password").equals(passW)) {
                                    String delete = "delete from password where ID = '" + userText.getText() + "'";
                                    stmt.executeUpdate(delete);
                                    String delete_stu = "update manager set M_password='' where M_manID = '" + userText.getText() + "'";
                                    stmt.executeUpdate(delete_stu);
                                    System.out.println("管理员账号密码删除成功");
                                    JOptionPane.showMessageDialog(null,"管理员账号密码删除成功","提示",JOptionPane.PLAIN_MESSAGE);
                                } else {
                                    System.out.println("账号密码不匹配");
                                }
                            } else {
                                System.out.println("账号密码不存在");
>>>>>>> 4850ae774c435ed590eb701117713f0e6a1b52c2
                            }
                        }

                    }
                }  catch (Exception e2) {
                // TODO: handle exception
            }
<<<<<<< HEAD
            }
        });
        panel.add(commitButton);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //设置大小
        frame.setSize(600,500);

=======
        }
    });
	    //设置大小
	    frame.setSize(600,500);
>>>>>>> 4498caa156ac25db4b5753417aad8318df51e1b6

        //设置大小
        frame.setSize(600,500);

<<<<<<< HEAD
>>>>>>> 4850ae774c435ed590eb701117713f0e6a1b52c2
        //设置位置
        frame.setLocation(600, 300);

        //设置可见性
        frame.setVisible(true);
<<<<<<< HEAD

        //设置窗口大小不可变
        frame.setResizable(false);
    }
=======
    }
=======
	    //设置可见性
	    frame.setVisible(true);
}
>>>>>>> c1aeefb3f04ab20f4098d9c4dc5d773db1493b67
>>>>>>> 4498caa156ac25db4b5753417aad8318df51e1b6
>>>>>>> 4850ae774c435ed590eb701117713f0e6a1b52c2
}
