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

public class titleDataset {
    public static String url = "jdbc:mysql://localhost:3306/interview?useUnicode=true&characterencoding=GBK";
    public static String username = "manager";
    public static String password = "123456";
    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;
	public static void main(String[] args) {
        //连接数据库
        try {
            System.out.println("题目信息：");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("加载驱动成功");
        } catch (ClassNotFoundException var2) {
            System.out.println("加载驱动失败!");
            var2.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            System.out.println("题目信息数据库连接成功!");
        } catch (SQLException var1) {
            System.out.println("题目信息数据库连接失败!");
        }
       titleDataset w1=new titleDataset();
    }

public titleDataset() {
    try {
        System.out.println("题目信息：");
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("加载驱动成功");
    } catch (ClassNotFoundException var2) {
        System.out.println("加载驱动失败!");
        var2.printStackTrace();
    }
    try {
        con = DriverManager.getConnection(url, username, password);
        stmt = con.createStatement();
        System.out.println("题目信息数据库连接成功!");
    } catch (SQLException var1) {
        System.out.println("题目信息数据库连接失败!");
    }
	//初始化一个jframe
    JFrame frame = new JFrame("题目信息");

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
    //初始化一个panel
    JPanel panel = new JPanel();

    //初始化一个容器
    Container container = frame.getContentPane();
    //把菜单添加到菜单栏
    menuBar.add(menu1);
    menuBar.add(menu2);
    menuBar.add(menu3);
    menuBar.add(menu4);
    menuBar.add(menu5);
    //设置菜单栏
    frame.setJMenuBar(menuBar);
    
    panel.setLayout(null);
    
    JLabel label1=new JLabel("题号：");
    label1.setBounds(25,30,100,25);
    label1.setFont(new Font("",Font.PLAIN,16));
    JTextField text1 = new JTextField(20);
    text1.setBounds(65,30,150,25);
    panel.add(text1);
    
    JLabel label2=new JLabel("难度：");
    label2.setBounds(25,60,100,25);
    label2.setFont(new Font("",Font.PLAIN,16));   
    JTextField text2 = new JTextField(20);
    text2.setBounds(65,60,150,25);
    panel.add(text2);
    
    JLabel label3=new JLabel("分类：");
    label3.setBounds(300,30,100,25);
    label3.setFont(new Font("",Font.PLAIN,16));
    JComboBox comboBox1=new JComboBox();
    comboBox1.setBounds(340,30,150,25);
    comboBox1.addItem("");
    comboBox1.addItem("专业类");
    comboBox1.addItem("英语类");
    comboBox1.addItem("政治类");
    panel.add(comboBox1);
    
    JLabel label4=new JLabel("专业：");
    label4.setBounds(300,60,100,25);
    label4.setFont(new Font("",Font.PLAIN,16));
    JTextField text4 = new JTextField(20);
    text4.setBounds(340,60,150,25);
    panel.add(text4);
    
    JLabel label5=new JLabel("内容：");
    label5.setBounds(25,90,100,25);
    label5.setFont(new Font("",Font.PLAIN,16));
    JTextField text5= new JTextField(2000);
    text5.setBounds(65,90,400,150);
    panel.add(text5);
    
    panel.add(label1);
    panel.add(label2);
    panel.add(label3);
    panel.add(label4);
    panel.add(label5);
    //分割线
    JSplitPane split1=new JSplitPane();
    split1.setBounds(600, 0,1, 800);
    panel.add(split1);
    
    
    //用表格显示题目
    Object[] columnNames = {"题号","分类","专业","难度","内容","flag"};// 定义表格列名数组
    // 定义表格数据数组
    String[][] tableValues = {{"1","专业类","数学","4",null,"0"},{"20","英语","英语","2",null,"0"},{"55","政治","政治","3",null,"0"},{"23","专业类","计算机","4",null,"0"},{"1","专业类","化学","4",null,"0"},{"44","专业类","物理","4",null,"0"},{"24","英语","英语","3",null,"0"}};
    // 创建指定列名和数据的表格

    final DefaultTableModel[] model = {new DefaultTableModel()};
    Vector data = new Vector(); // 数据行向量集，因为列表不止一行，往里面添加数据行向量，添加方法add(row)
    Vector names = new Vector();// 列名向量，使用它的add()方法添加列名
    JTable table = new JTable(model[0]);
    //显示数据库信息
    names.add("题号");
    names.add("分类");
    names.add("专业");
    names.add("难度");
    names.add("内容");
    names.add("flag");
    //专业类题目
    String viewtable = "select * from majque";
    try {
        rs = stmt.executeQuery(viewtable);
        while(rs.next()){
            String No = rs.getString("M_No");
            String major = rs.getString("M_Major");
            String level = rs.getString("M_level");
            String content = rs.getString("M_content");
            String flag = rs.getString("M_flag");
            Vector row = new Vector(); // 数据行向量，使用它的add()添加元素，比如整数、String、Object等，有几行就new几个行向量
            row.add(No);
            row.add("专业类");
            row.add(major);
            row.add(level);
            row.add(content);
            row.add(flag);
            data.add(row);
            model[0] = new DefaultTableModel(data, names);
            table.setModel(model[0]);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    //英语类题目
    String vieweng = "select * from engque";
    try {
        rs = stmt.executeQuery(vieweng);
        while(rs.next()){
            String No = rs.getString("E_No");
            String level = rs.getString("E_level");
            String content = rs.getString("E_content");
            String flag = rs.getString("E_flag");
            Vector row2 = new Vector(); // 数据行向量，使用它的add()添加元素，比如整数、String、Object等，有几行就new几个行向量
            row2.add(No);
            row2.add("英语类");
            row2.add("");
            row2.add(level);
            row2.add(content);
            row2.add(flag);
            data.add(row2);
            model[0] = new DefaultTableModel(data, names);
            table.setModel(model[0]);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    //政治类题目
    String viewpol = "select * from polque";
    try {
        rs = stmt.executeQuery(viewpol);
        while(rs.next()){
            String No = rs.getString("P_No");
            String level = rs.getString("P_level");
            String content = rs.getString("P_content");
            String flag = rs.getString("P_flag");
            Vector row2 = new Vector(); // 数据行向量，使用它的add()添加元素，比如整数、String、Object等，有几行就new几个行向量
            row2.add(No);
            row2.add("政治类");
            row2.add("");
            row2.add(level);
            row2.add(content);
            row2.add(flag);
            data.add(row2);
            model[0] = new DefaultTableModel(data, names);
            table.setModel(model[0]);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }


    model[0].setDataVector(data, names); // 设置模型中的元素，它会自动显示在列表中
    JScrollPane jsp = new JScrollPane(table); // 用列表创建可滚动的Panel，把这个Panel添加到窗口中
    jsp.setSize(600, 150);
    jsp.setLocation(0, 320);
    panel.add(jsp);

    table.setBounds(0,320,600,150);
    table.getTableHeader().setBounds(0, 300, 600, 20);
    panel.add(table.getTableHeader());



    //添加按钮
    JButton bt1=new JButton("添加");
    bt1.setBounds(0, 250, 100, 35);
    bt1.setFont(new Font("宋体",Font.PLAIN,16));;
    panel.add(bt1);
    JButton bt2=new JButton("更新");
    bt2.setBounds(100, 250, 100, 35);
    bt2.setFont(new Font("宋体",Font.PLAIN,16));;
    panel.add(bt2);
    JButton bt3=new JButton("删除");
    bt3.setBounds(200, 250, 100, 35);
    bt3.setFont(new Font("宋体",Font.PLAIN,16));;
    panel.add(bt3);
    JButton bt4=new JButton("浏览");
    bt4.setBounds(300, 250, 100, 35);
    bt4.setFont(new Font("宋体",Font.PLAIN,16));;
    panel.add(bt4);
    JButton bt5=new JButton("关闭");
    bt5.setBounds(400, 250, 100, 35);
    bt5.setFont(new Font("宋体",Font.PLAIN,16));;
    panel.add(bt5);
    JButton bt6=new JButton("置零");
    bt6.setBounds(500, 250, 100, 35);
    bt6.setFont(new Font("宋体",Font.PLAIN,16));;
    panel.add(bt6);
    
    //查找
    JLabel Clabel1=new JLabel("题号：");
    Clabel1.setBounds(620,60,100,25);
    Clabel1.setFont(new Font("",Font.PLAIN,16));
    JTextField Ctext1 = new JTextField(20);
    Ctext1.setBounds(660,60,150,25);
    panel.add(Ctext1);
    
    JLabel Clabel2=new JLabel("难度：");
    Clabel2.setBounds(620,90,100,25);
    Clabel2.setFont(new Font("",Font.PLAIN,16));   
    JTextField Ctext2 = new JTextField(20);
    Ctext2.setBounds(660,90,150,25);
    panel.add(Ctext2);
    
    JLabel Clabel3=new JLabel("分类：");
    Clabel3.setBounds(620,120,100,25);
    Clabel3.setFont(new Font("",Font.PLAIN,16));
//    JTextField Ctext3 = new JTextField(20);
//    Ctext3.setBounds(660,120,150,25);
//    panel.add(Ctext3);
    
    JLabel Clabel4=new JLabel("专业：");
    Clabel4.setBounds(620,150,100,25);
    Clabel4.setFont(new Font("",Font.PLAIN,16));
    JTextField Ctext4 = new JTextField(20);
    Ctext4.setBounds(660,150,150,25);
    panel.add(Ctext4);
    
    JLabel Clabel5=new JLabel("查找");
    Clabel5.setBounds(620,30,100,25);
    Clabel5.setFont(new Font("",Font.PLAIN,16));

    JComboBox comboBox=new JComboBox();
    comboBox.setBounds(660,120,150,25);
    comboBox.addItem("");
    comboBox.addItem("专业类");
    comboBox.addItem("英语类");
    comboBox.addItem("政治类");
    panel.add(comboBox);


    panel.add(Clabel1);
    panel.add(Clabel2);
    panel.add(Clabel3);
    panel.add(Clabel4);
    panel.add(Clabel5);
    //查询框按钮
    JButton Cbt1=new JButton("查询");
    Cbt1.setBounds(620, 250, 100, 35);
    Cbt1.setFont(new Font("宋体",Font.PLAIN,16));;
    panel.add(Cbt1);
    JButton Cbt2=new JButton("重置");
    Cbt2.setBounds(750, 250, 100, 35);
    Cbt2.setFont(new Font("宋体",Font.PLAIN,16));;
    panel.add(Cbt2);
    //把panel添加到容器
    container.add(panel);

    //添加题目
    bt1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            if (text1.getText().length()<=4&&!text1.getText().equals("")&&!text2.getText().equals("")&&!text5.getText().equals("")){
                if(comboBox1.getSelectedItem().equals("专业类")){
                    if (!text4.getText().equals("")){
                        String add_queInfo = "insert into majque(M_No,M_content,M_level,M_major) values('"+text1.getText()+"','"+text5.getText()+"'" +
                                ",'"+text2.getText()+"','"+text4.getText()+"')";
                        try {
                            stmt.executeUpdate(add_queInfo);
                            Vector rowData1 = new Vector();
                            rowData1.add(text1.getText());
                            rowData1.add("专业类");
                            rowData1.add(text4.getText());
                            rowData1.add(text2.getText());
                            rowData1.add(text5.getText());
                            data.add(rowData1);
                            model[0] = new DefaultTableModel(data, names);
                            table.setModel(model[0]);
//                            System.out.println("专业类添加成功");
                            JOptionPane.showMessageDialog(null,"专业类题目添加成功","提示",JOptionPane.PLAIN_MESSAGE);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                            System.out.println("专业类添加失败");
                        }
                    }
                else{
//                        System.out.println("请选择专业");
                        JOptionPane.showMessageDialog(null,"请选择专业","提示",JOptionPane.PLAIN_MESSAGE);
                    }
            }
                else if (comboBox1.getSelectedItem().equals("英语类")){
                    String add_queInfo = "insert into engque(E_No,E_content,E_level) values('"+text1.getText()+"','"+text5.getText()+"'" +
                            ",'"+text2.getText()+"')";
                    try {
                        stmt.executeUpdate(add_queInfo);
                        Vector rowData2 = new Vector();
                        rowData2.add(text1.getText());
                        rowData2.add("英语类");
                        rowData2.add("");
                        rowData2.add(text2.getText());
                        rowData2.add(text5.getText());
                        data.add(rowData2);
                        model[0] = new DefaultTableModel(data, names);
                        table.setModel(model[0]);
//                        System.out.println("英语类添加成功");
                        JOptionPane.showMessageDialog(null,"英语类题目添加成功","提示",JOptionPane.PLAIN_MESSAGE);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                        System.out.println("英语类添加失败");
                    }
                }
                else if (comboBox1.getSelectedItem().equals("政治类")){
                    String add_queInfo = "insert into polque(P_No,P_content,P_level) values('"+text1.getText()+"','"+text5.getText()+"'" +
                            ",'"+text2.getText()+"')";
                    try {
                        stmt.executeUpdate(add_queInfo);
                        Vector rowData3 = new Vector();
                        rowData3.add(text1.getText());
                        rowData3.add("政治类");
                        rowData3.add("");
                        rowData3.add(text2.getText());
                        rowData3.add(text5.getText());
                        data.add(rowData3);
                        model[0] = new DefaultTableModel(data, names);
                        table.setModel(model[0]);
//                        System.out.println("政治类添加成功");
                        JOptionPane.showMessageDialog(null,"政治类题目添加成功","提示",JOptionPane.PLAIN_MESSAGE);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                        System.out.println("政治类添加失败");
                    }
                }
                else{
//                    System.out.println("请选择题目类型");
                    JOptionPane.showMessageDialog(null,"请选择题目类型","提示",JOptionPane.PLAIN_MESSAGE);
                }
        }
            else{
                System.out.println("信息不符合规范");
            }

        }
    });

    //更新题目信息
    bt2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!text1.getText().equals("")) {
                if (comboBox1.getSelectedItem().equals("专业类")){
                    String selectInfo = "select M_No from majque where M_No='"+text1.getText()+"'";
                    try {
                        rs = stmt.executeQuery(selectInfo);
                        if(rs.next()){
                            //更新难度
                            if(!text2.getText().equals("")){
                                String updateMlevel = "update majque set M_level = '"+text2.getText()+"' where M_No = '"+text1.getText()+"'";
                                stmt.executeUpdate(updateMlevel);
                            }
                            //更新内容
                            if(!text5.getText().equals("")){
                                String updateMcontent = "update majque set M_content = '"+text5.getText()+"' where M_No = '"+text1.getText()+"'";
                                stmt.executeUpdate(updateMcontent);
                            }
                            System.out.println("更新成功");
                        }
                        else{
                            System.out.println("题号不存在，更新失败");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else if (comboBox1.getSelectedItem().equals("英语类")){
                    String selectInfo = "select E_No from engque where E_No='"+text1.getText()+"'";
                    try {
                        rs = stmt.executeQuery(selectInfo);
                        if(rs.next()){
                            //更新难度
                            if(!text2.getText().equals("")){
                                String updateElevel = "update engque set E_level = '"+text2.getText()+"' where E_No = '"+text1.getText()+"'";
                                stmt.executeUpdate(updateElevel);
                            }
                            //更新内容
                            if(!text5.getText().equals("")){
                                String updateEcontent = "update engque set E_content = '"+text5.getText()+"' where E_No = '"+text1.getText()+"'";
                                stmt.executeUpdate(updateEcontent);
                            }
                            System.out.println("更新成功");
                        }
                        else{
                            System.out.println("题号不存在，更新失败");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else if(comboBox1.getSelectedItem().equals("政治类")){
                    String selectInfo = "select P_No from polque where P_No='"+text1.getText()+"'";
                    try {
                        rs = stmt.executeQuery(selectInfo);
                        if(rs.next()){
                            //更新难度
                            if(!text2.getText().equals("")){
                                String updatePlevel = "update polque set P_level = '"+text2.getText()+"' where P_No = '"+text1.getText()+"'";
                                stmt.executeUpdate(updatePlevel);
                            }
                            //更新内容
                            if(!text5.getText().equals("")){
                                String updateEcontent = "update polque set P_content = '"+text5.getText()+"' where P_No = '"+text1.getText()+"'";
                                stmt.executeUpdate(updateEcontent);
                            }
                            System.out.println("更新成功");
                        }
                        else{
                            System.out.println("题号不存在，更新失败");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else{
//                    System.out.println("请选择题目类型");
                    JOptionPane.showMessageDialog(null,"请选择题目类型","提示",JOptionPane.PLAIN_MESSAGE);
                }
                if(!data.isEmpty()){
                    data.clear();
                    model[0] = new DefaultTableModel(data, names);
                    table.setModel(model[0]);
                }
                //专业类题目
                String viewtable = "select * from majque";
                try {
                    rs = stmt.executeQuery(viewtable);
                    while(rs.next()){
                        String No = rs.getString("M_No");
                        String major = rs.getString("M_Major");
                        String level = rs.getString("M_level");
                        String content = rs.getString("M_content");
                        String flag = rs.getString("M_flag");
                        Vector row = new Vector();
                        row.add(No);
                        row.add("专业类");
                        row.add(major);
                        row.add(level);
                        row.add(content);
                        row.add(flag);
                        data.add(row);
                        model[0] = new DefaultTableModel(data, names);
                        table.setModel(model[0]);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                //英语类题目
                String vieweng = "select * from engque";
                try {
                    rs = stmt.executeQuery(vieweng);
                    while(rs.next()){
                        String No = rs.getString("E_No");
                        String level = rs.getString("E_level");
                        String content = rs.getString("E_content");
                        String flag = rs.getString("E_flag");
                        Vector row2 = new Vector(); // 数据行向量，使用它的add()添加元素，比如整数、String、Object等，有几行就new几个行向量
                        row2.add(No);
                        row2.add("英语类");
                        row2.add("");
                        row2.add(level);
                        row2.add(content);
                        row2.add(flag);
                        data.add(row2);
                        model[0] = new DefaultTableModel(data, names);
                        table.setModel(model[0]);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                //政治类题目
                String viewpol = "select * from polque";
                try {
                    rs = stmt.executeQuery(viewpol);
                    while(rs.next()){
                        String No = rs.getString("P_No");
                        String level = rs.getString("P_level");
                        String content = rs.getString("P_content");
                        String flag = rs.getString("P_flag");
                        Vector row2 = new Vector(); // 数据行向量，使用它的add()添加元素，比如整数、String、Object等，有几行就new几个行向量
                        row2.add(No);
                        row2.add("政治类");
                        row2.add("");
                        row2.add(level);
                        row2.add(content);
                        row2.add(flag);
                        data.add(row2);
                        model[0] = new DefaultTableModel(data, names);
                        table.setModel(model[0]);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    });


    //浏览题目信息
    bt4.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!data.isEmpty()){
                data.clear();
                model[0] = new DefaultTableModel(data, names);
                table.setModel(model[0]);
            }
            //专业类题目
            String viewtable = "select * from majque";
            try {
                rs = stmt.executeQuery(viewtable);
                while(rs.next()){
                    String No = rs.getString("M_No");
                    String major = rs.getString("M_Major");
                    String level = rs.getString("M_level");
                    String content = rs.getString("M_content");
                    String flag = rs.getString("M_flag");
                    Vector row = new Vector();
                    row.add(No);
                    row.add("专业类");
                    row.add(major);
                    row.add(level);
                    row.add(content);
                    row.add(flag);
                    data.add(row);
                    model[0] = new DefaultTableModel(data, names);
                    table.setModel(model[0]);
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            //英语类题目
            String vieweng = "select * from engque";
            try {
                rs = stmt.executeQuery(vieweng);
                while(rs.next()){
                    String No = rs.getString("E_No");
                    String level = rs.getString("E_level");
                    String content = rs.getString("E_content");
                    String flag = rs.getString("E_flag");
                    Vector row2 = new Vector(); // 数据行向量，使用它的add()添加元素，比如整数、String、Object等，有几行就new几个行向量
                    row2.add(No);
                    row2.add("英语类");
                    row2.add("");
                    row2.add(level);
                    row2.add(content);
                    row2.add(flag);
                    data.add(row2);
                    model[0] = new DefaultTableModel(data, names);
                    table.setModel(model[0]);
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            //政治类题目
            String viewpol = "select * from polque";
            try {
                rs = stmt.executeQuery(viewpol);
                while(rs.next()){
                    String No = rs.getString("P_No");
                    String level = rs.getString("P_level");
                    String content = rs.getString("P_content");
                    String flag = rs.getString("P_flag");
                    Vector row2 = new Vector(); // 数据行向量，使用它的add()添加元素，比如整数、String、Object等，有几行就new几个行向量
                    row2.add(No);
                    row2.add("政治类");
                    row2.add("");
                    row2.add(level);
                    row2.add(content);
                    row2.add(flag);
                    data.add(row2);
                    model[0] = new DefaultTableModel(data, names);
                    table.setModel(model[0]);
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    });

    //删除题目信息
    bt3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!text1.getText().equals("")) {
                if (comboBox1.getSelectedItem().equals("专业类")){
                    String selectInfo = "select M_No from majque where M_No='"+text1.getText()+"'";
                    try {
                        rs = stmt.executeQuery(selectInfo);
                        if(rs.next()){
                            String deleteM = "delete from majque where M_No ='"+text1.getText()+"'";
                            stmt.executeUpdate(deleteM);
//                            System.out.println("删除成功");
                            JOptionPane.showMessageDialog(null,"删除成功","提示",JOptionPane.PLAIN_MESSAGE);
                        }
                        else{
                            System.out.println("题号不存在，删除失败");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else if (comboBox1.getSelectedItem().equals("英语类")){
                    String selectInfo = "select E_No from engque where E_No='"+text1.getText()+"'";
                    try {
                        rs = stmt.executeQuery(selectInfo);
                        if(rs.next()){
                            String deleteE = "delete from engque where E_No ='"+text1.getText()+"'";
                            stmt.executeUpdate(deleteE);
//                            System.out.println("删除成功");
                            JOptionPane.showMessageDialog(null,"删除成功","提示",JOptionPane.PLAIN_MESSAGE);
                        }
                        else{
                            System.out.println("题号不存在，删除失败");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else if(comboBox1.getSelectedItem().equals("政治类")){
                    String selectInfo = "select P_No from polque where P_No='"+text1.getText()+"'";
                    try {
                        rs = stmt.executeQuery(selectInfo);
                        if(rs.next()){
                            String deleteP = "delete from polque where P_No ='"+text1.getText()+"'";
                            stmt.executeUpdate(deleteP);
                            JOptionPane.showMessageDialog(null,"删除成功","提示",JOptionPane.PLAIN_MESSAGE);
//                            System.out.println("删除成功");
                        }
                        else{
                            System.out.println("题号不存在，删除失败");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else{
                    System.out.println("请选择题目类型");
                }
                if(!data.isEmpty()){
                    data.clear();
                    model[0] = new DefaultTableModel(data, names);
                    table.setModel(model[0]);
                }
                //专业类题目
                String viewtable = "select * from majque";
                try {
                    rs = stmt.executeQuery(viewtable);
                    while(rs.next()){
                        String No = rs.getString("M_No");
                        String major = rs.getString("M_Major");
                        String level = rs.getString("M_level");
                        String content = rs.getString("M_content");
                        String flag = rs.getString("M_flag");
                        Vector row = new Vector();
                        row.add(No);
                        row.add("专业类");
                        row.add(major);
                        row.add(level);
                        row.add(content);
                        row.add(flag);
                        data.add(row);
                        model[0] = new DefaultTableModel(data, names);
                        table.setModel(model[0]);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                //英语类题目
                String vieweng = "select * from engque";
                try {
                    rs = stmt.executeQuery(vieweng);
                    while(rs.next()){
                        String No = rs.getString("E_No");
                        String level = rs.getString("E_level");
                        String content = rs.getString("E_content");
                        String flag = rs.getString("E_flag");
                        Vector row2 = new Vector(); // 数据行向量，使用它的add()添加元素，比如整数、String、Object等，有几行就new几个行向量
                        row2.add(No);
                        row2.add("英语类");
                        row2.add("");
                        row2.add(level);
                        row2.add(content);
                        row2.add(flag);
                        data.add(row2);
                        model[0] = new DefaultTableModel(data, names);
                        table.setModel(model[0]);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                //政治类题目
                String viewpol = "select * from polque";
                try {
                    rs = stmt.executeQuery(viewpol);
                    while(rs.next()){
                        String No = rs.getString("P_No");
                        String level = rs.getString("P_level");
                        String content = rs.getString("P_content");
                        String flag = rs.getString("P_flag");
                        Vector row2 = new Vector(); // 数据行向量，使用它的add()添加元素，比如整数、String、Object等，有几行就new几个行向量
                        row2.add(No);
                        row2.add("政治类");
                        row2.add("");
                        row2.add(level);
                        row2.add(content);
                        row2.add(flag);
                        data.add(row2);
                        model[0] = new DefaultTableModel(data, names);
                        table.setModel(model[0]);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            else{
//                System.out.println("请输入题号");
                JOptionPane.showMessageDialog(null,"请输入题号","提示",JOptionPane.PLAIN_MESSAGE);
            }
        }
    });

    //flag置零
    bt6.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //专业类
            String setflagM = "update majque set M_flag = 0";
            try {
                stmt.executeUpdate(setflagM);
                //英语类
                String setflagE = "update engque set E_flag = 0";
                stmt.executeUpdate(setflagE);
                //政治类
                String setflagP = "update polque set P_flag = 0";
                stmt.executeUpdate(setflagP);
                int r = table.getRowCount();
                for (int i = 0;i<r;i++){
                    model[0].setValueAt(0,i,5);
                }

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    });


    //查找题目信息
    Cbt1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!data.isEmpty()){
                data.clear();
                model[0] = new DefaultTableModel(data, names);
                table.setModel(model[0]);
            }
            if (comboBox.getSelectedItem().equals("")){
                if (Ctext4.getText().equals("")){
                    if (!Ctext1.getText().equals("")&&Ctext2.getText().equals("")){
                        //每个类型只有唯一一题
                        //专业类
                        try {
                            String select = "select * from majque where M_No = '"+Ctext1.getText()+"'";
                            rs = stmt.executeQuery(select);
                            if (rs.next()){
                                String M_No = rs.getString("M_No");
                                String M_content = rs.getString("M_content");
                                String M_level = rs.getString("M_level");
                                String M_Major = rs.getString("M_Major");
                                String M_flag = rs.getString("M_flag");
                                Vector data1 = new Vector();
                                data1.add(M_No);
                                data1.add("专业类");
                                data1.add(M_Major);
                                data1.add(M_level);
                                data1.add(M_content);
                                data1.add(M_flag);
                                data.add(data1);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                            else{
                                System.out.println("专业题号不存在");
                            }
                            //英语类
                            String selectE = "select * from engque where E_No = '"+Ctext1.getText()+"'";
                            rs = stmt.executeQuery(selectE);
                            if (rs.next()){
                                String E_No = rs.getString("E_No");
                                String E_content = rs.getString("E_content");
                                String E_level = rs.getString("E_level");
                                String E_flag = rs.getString("E_flag");
                                Vector data1 = new Vector();
                                data1.add(E_No);
                                data1.add("英语类");
                                data1.add("");
                                data1.add(E_level);
                                data1.add(E_content);
                                data1.add(E_flag);
                                data.add(data1);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                            else{
                                System.out.println("英语题号不存在");
                            }
                            //政治类
                            String selectP = "select * from polque where P_No = '"+Ctext1.getText()+"'";
                            rs = stmt.executeQuery(selectP);
                            if (rs.next()){
                                String P_No = rs.getString("P_No");
                                String P_content = rs.getString("P_content");
                                String P_level = rs.getString("P_level");
                                String P_flag = rs.getString("P_flag");
                                Vector data1 = new Vector();
                                data1.add(P_No);
                                data1.add("政治类");
                                data1.add("");
                                data1.add(P_level);
                                data1.add(P_content);
                                data1.add(P_flag);
                                data.add(data1);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                            else{
                                System.out.println("政治题号不存在");
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                    else if (Ctext1.getText().equals("")&&!Ctext2.getText().equals("")){
                        //难度为x的题*3
                        //专业类
                        try {
                            String select = "select * from majque where M_level = '"+Ctext2.getText()+"'";
                            rs = stmt.executeQuery(select);
                            if (rs.next()){
                                String M_No = rs.getString("M_No");
                                String M_content = rs.getString("M_content");
                                String M_level = rs.getString("M_level");
                                String M_Major = rs.getString("M_Major");
                                String M_flag = rs.getString("M_flag");
                                Vector data1 = new Vector();
                                data1.add(M_No);
                                data1.add("专业类");
                                data1.add(M_Major);
                                data1.add(M_level);
                                data1.add(M_content);
                                data1.add(M_flag);
                                data.add(data1);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                            else{
                                System.out.println("该难度专业题不存在");
                            }
                            //英语类
                            String selectE = "select * from engque where E_level = '"+Ctext2.getText()+"'";
                            rs = stmt.executeQuery(selectE);
                            if (rs.next()){
                                String E_No = rs.getString("E_No");
                                String E_content = rs.getString("E_content");
                                String E_level = rs.getString("E_level");
                                String E_flag = rs.getString("E_flag");
                                Vector data1 = new Vector();
                                data1.add(E_No);
                                data1.add("英语类");
                                data1.add("");
                                data1.add(E_level);
                                data1.add(E_content);
                                data1.add(E_flag);
                                data.add(data1);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                            else{
                                System.out.println("该难度英语题不存在");
                            }
                            //政治类
                            String selectP = "select * from polque where P_level = '"+Ctext2.getText()+"'";
                            rs = stmt.executeQuery(selectP);
                            if (rs.next()){
                                String P_No = rs.getString("P_No");
                                String P_content = rs.getString("P_content");
                                String P_level = rs.getString("P_level");
                                String P_flag = rs.getString("P_flag");
                                Vector data1 = new Vector();
                                data1.add(P_No);
                                data1.add("政治类");
                                data1.add("");
                                data1.add(P_level);
                                data1.add(P_content);
                                data1.add(P_flag);
                                data.add(data1);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                            else{
                                System.out.println("该难度政治题不存在");
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                    else if (!Ctext1.getText().equals("")&&!Ctext2.getText().equals("")){
                        //先找到题号，再对比难度是否相同*3
                        try {
                            String select = "select * from majque where M_No = '"+Ctext1.getText()+"'";
                            rs = stmt.executeQuery(select);
                            while (rs.next()){
                                String M_No = rs.getString("M_No");
                                String M_content = rs.getString("M_content");
                                String M_level = rs.getString("M_level");
                                String M_Major = rs.getString("M_Major");
                                String M_flag = rs.getString("M_flag");
                                if (M_level.equals(Ctext2.getText())){
                                    Vector data1 = new Vector();
                                    data1.add(M_No);
                                    data1.add("专业类");
                                    data1.add(M_Major);
                                    data1.add(M_level);
                                    data1.add(M_content);
                                    data1.add(M_flag);
                                    data.add(data1);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
                                }
                                else{
                                    System.out.println("未查找到相关记录");
                                }
                            }

                            //英语类
                            String selectE = "select * from engque where E_No = '"+Ctext1.getText()+"'";
                            rs = stmt.executeQuery(selectE);
                            while (rs.next()){
                                String E_No = rs.getString("E_No");
                                String E_content = rs.getString("E_content");
                                String E_level = rs.getString("E_level");
                                String E_flag = rs.getString("E_flag");
                                Vector data1 = new Vector();
                                if (E_level.equals(Ctext2.getText())){
                                    data1.add(E_No);
                                    data1.add("英语类");
                                    data1.add("");
                                    data1.add(E_level);
                                    data1.add(E_content);
                                    data1.add(E_flag);
                                    data.add(data1);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
                                }
                                else{
                                    System.out.println("未查找到相关记录");
                                }
                            }
                            //政治类
                            String selectP = "select * from polque where P_No = '"+Ctext1.getText()+"'";
                            rs = stmt.executeQuery(selectP);
                            while (rs.next()){
                                String P_No = rs.getString("P_No");
                                String P_content = rs.getString("P_content");
                                String P_level = rs.getString("P_level");
                                String P_flag = rs.getString("P_flag");
                                if (P_level.equals(Ctext2.getText())){
                                    Vector data1 = new Vector();
                                    data1.add(P_No);
                                    data1.add("政治类");
                                    data1.add("");
                                    data1.add(P_level);
                                    data1.add(P_content);
                                    data1.add(P_flag);
                                    data.add(data1);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
                                }
                                else{
                                    System.out.println("未查找到相关记录");
                                }
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
                else {
                    //在专业类里找专业，再匹配其他项
                    String select = "select * from majque where M_Major = '"+Ctext4.getText()+"'";
                    try {
                        rs = stmt.executeQuery(select);
                        while (rs.next()){
                            String M_No = rs.getString("M_No");
                            String M_content = rs.getString("M_content");
                            String M_level = rs.getString("M_level");
                            String M_Major = rs.getString("M_Major");
                            String M_flag = rs.getString("M_flag");
                            if (Ctext1.getText().equals("")&&Ctext2.getText().equals("")){
                                Vector data1 = new Vector();
                                data1.add(M_No);
                                data1.add("专业类");
                                data1.add(M_Major);
                                data1.add(M_level);
                                data1.add(M_content);
                                data1.add(M_flag);
                                data.add(data1);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                            else if (!Ctext1.getText().equals("")&&Ctext2.getText().equals("")){
                                if (Ctext1.getText().equals(M_No)){
                                    Vector data1 = new Vector();
                                    data1.add(M_No);
                                    data1.add("专业类");
                                    data1.add(M_Major);
                                    data1.add(M_level);
                                    data1.add(M_content);
                                    data1.add(M_flag);
                                    data.add(data1);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
                                }
                            }
                            else if (Ctext1.getText().equals("")&&!Ctext2.getText().equals("")){
                                if (Ctext2.getText().equals(M_level)){
                                    Vector data1 = new Vector();
                                    data1.add(M_No);
                                    data1.add("专业类");
                                    data1.add(M_Major);
                                    data1.add(M_level);
                                    data1.add(M_content);
                                    data1.add(M_flag);
                                    data.add(data1);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
                                }
                            }
                            else if (!Ctext1.getText().equals("")&&!Ctext2.getText().equals("")){
                                if (Ctext1.getText().equals(M_No)&&Ctext2.getText().equals(M_level)){
                                    Vector data1 = new Vector();
                                    data1.add(M_No);
                                    data1.add("专业类");
                                    data1.add(M_Major);
                                    data1.add(M_level);
                                    data1.add(M_content);
                                    data1.add(M_flag);
                                    data.add(data1);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
                                }
                            }
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            else if (comboBox.getSelectedItem().equals("专业类")){
                if (Ctext4.getText().equals("")){
                    if (Ctext1.getText().equals("")&&Ctext2.getText().equals("")){
                        //显示专业类所有题
                        //专业类题目
                        String viewtable = "select * from majque";
                        try {
                            rs = stmt.executeQuery(viewtable);
                            while(rs.next()){
                                String No = rs.getString("M_No");
                                String major = rs.getString("M_Major");
                                String level = rs.getString("M_level");
                                String content = rs.getString("M_content");
                                String flag = rs.getString("M_flag");
                                Vector row = new Vector(); // 数据行向量，使用它的add()添加元素，比如整数、String、Object等，有几行就new几个行向量
                                row.add(No);
                                row.add("专业类");
                                row.add(major);
                                row.add(level);
                                row.add(content);
                                row.add(flag);
                                data.add(row);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                    else if (!Ctext1.getText().equals("")&&Ctext2.getText().equals("")){
                        //只有唯一一题
                        //专业类
                        try {
                            String select = "select * from majque where M_No = '"+Ctext1.getText()+"'";
                            rs = stmt.executeQuery(select);
                            if (rs.next()){
                                String M_No = rs.getString("M_No");
                                String M_content = rs.getString("M_content");
                                String M_level = rs.getString("M_level");
                                String M_Major = rs.getString("M_Major");
                                String M_flag = rs.getString("M_flag");
                                Vector data1 = new Vector();
                                data1.add(M_No);
                                data1.add("专业类");
                                data1.add(M_Major);
                                data1.add(M_level);
                                data1.add(M_content);
                                data1.add(M_flag);
                                data.add(data1);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                            else{
                                System.out.println("专业题号不存在");
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                    else if (Ctext1.getText().equals("")&&!Ctext2.getText().equals("")){
                        //专业类难度为x的题
                        try {
                            String select = "select * from majque where M_level = '"+Ctext2.getText()+"'";
                            rs = stmt.executeQuery(select);
                            while (rs.next()){
                                String M_No = rs.getString("M_No");
                                String M_content = rs.getString("M_content");
                                String M_level = rs.getString("M_level");
                                String M_Major = rs.getString("M_Major");
                                String M_flag = rs.getString("M_flag");
                                Vector data1 = new Vector();
                                data1.add(M_No);
                                data1.add("专业类");
                                data1.add(M_Major);
                                data1.add(M_level);
                                data1.add(M_content);
                                data1.add(M_flag);
                                data.add(data1);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                    else if (!Ctext1.getText().equals("")&&!Ctext2.getText().equals("")){
                        //先找到题号，再对比难度是否相同
                        try {
                            String select = "select * from majque where M_No = '"+Ctext1.getText()+"'";
                            rs = stmt.executeQuery(select);
                            if (rs.next()){
                                String M_No = rs.getString("M_No");
                                String M_content = rs.getString("M_content");
                                String M_level = rs.getString("M_level");
                                String M_Major = rs.getString("M_Major");
                                String M_flag = rs.getString("M_flag");
                                if (Ctext2.getText().equals(M_level)){
                                    Vector data1 = new Vector();
                                    data1.add(M_No);
                                    data1.add("专业类");
                                    data1.add(M_Major);
                                    data1.add(M_level);
                                    data1.add(M_content);
                                    data1.add(M_flag);
                                    data.add(data1);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
                                }
                            }
                            else{
                                System.out.println("专业类难度不存在");
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
                else {
                    //找专业，再匹配其他项
                    //在专业类里找专业，再匹配其他项
                    String select = "select * from majque where M_Major = '"+Ctext4.getText()+"'";
                    try {
                        rs = stmt.executeQuery(select);
                        while (rs.next()){
                            String M_No = rs.getString("M_No");
                            String M_content = rs.getString("M_content");
                            String M_level = rs.getString("M_level");
                            String M_Major = rs.getString("M_Major");
                            String M_flag = rs.getString("M_flag");
                            if (Ctext1.getText().equals("")&&Ctext2.getText().equals("")){
                                Vector data1 = new Vector();
                                data1.add(M_No);
                                data1.add("专业类");
                                data1.add(M_Major);
                                data1.add(M_level);
                                data1.add(M_content);
                                data1.add(M_flag);
                                data.add(data1);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                            else if (!Ctext1.getText().equals("")&&Ctext2.getText().equals("")){
                                if (Ctext1.getText().equals(M_No)){
                                    Vector data1 = new Vector();
                                    data1.add(M_No);
                                    data1.add("专业类");
                                    data1.add(M_Major);
                                    data1.add(M_level);
                                    data1.add(M_content);
                                    data1.add(M_flag);
                                    data.add(data1);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
                                }
                            }
                            else if (Ctext1.getText().equals("")&&!Ctext2.getText().equals("")){
                                if (Ctext2.getText().equals(M_level)){
                                    Vector data1 = new Vector();
                                    data1.add(M_No);
                                    data1.add("专业类");
                                    data1.add(M_Major);
                                    data1.add(M_level);
                                    data1.add(M_content);
                                    data1.add(M_flag);
                                    data.add(data1);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
                                }
                            }
                            else if (!Ctext1.getText().equals("")&&!Ctext2.getText().equals("")){
                                if (Ctext1.getText().equals(M_No)&&Ctext2.getText().equals(M_level)){
                                    Vector data1 = new Vector();
                                    data1.add(M_No);
                                    data1.add("专业类");
                                    data1.add(M_Major);
                                    data1.add(M_level);
                                    data1.add(M_content);
                                    data1.add(M_flag);
                                    data.add(data1);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
                                }
                            }
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            else if (comboBox.getSelectedItem().equals("英语类")){
                if (Ctext1.getText().equals("")&&Ctext2.getText().equals("")) {
                    //显示英语类所有题
                    String vieweng = "select * from engque";
                    try {
                        rs = stmt.executeQuery(vieweng);
                        while (rs.next()) {
                            String No = rs.getString("E_No");
                            String level = rs.getString("E_level");
                            String content = rs.getString("E_content");
                            String flag = rs.getString("E_flag");
                            Vector row2 = new Vector(); // 数据行向量，使用它的add()添加元素，比如整数、String、Object等，有几行就new几个行向量
                            row2.add(No);
                            row2.add("英语类");
                            row2.add("");
                            row2.add(level);
                            row2.add(content);
                            row2.add(flag);
                            data.add(row2);
                            model[0] = new DefaultTableModel(data, names);
                            table.setModel(model[0]);
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else if (!Ctext1.getText().equals("")&&Ctext2.getText().equals("")){
                    //只有唯一一题
                    String vieweng = "select * from engque where E_No = '"+Ctext1.getText()+"'";
                    try {
                        rs = stmt.executeQuery(vieweng);
                        if (rs.next()) {
                            String No = rs.getString("E_No");
                            String level = rs.getString("E_level");
                            String content = rs.getString("E_content");
                            String flag = rs.getString("E_flag");
                            Vector row2 = new Vector(); // 数据行向量，使用它的add()添加元素，比如整数、String、Object等，有几行就new几个行向量
                            row2.add(No);
                            row2.add("英语类");
                            row2.add("");
                            row2.add(level);
                            row2.add(content);
                            row2.add(flag);
                            data.add(row2);
                            model[0] = new DefaultTableModel(data, names);
                            table.setModel(model[0]);
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else if (Ctext1.getText().equals("")&&!Ctext2.getText().equals("")){
                    //难度为x的题
                    String vieweng = "select * from engque where E_level = '"+Ctext2.getText()+"'";
                    try {
                        rs = stmt.executeQuery(vieweng);
                        while (rs.next()) {
                            String No = rs.getString("E_No");
                            String level = rs.getString("E_level");
                            String content = rs.getString("E_content");
                            String flag = rs.getString("E_flag");
                            Vector row2 = new Vector(); // 数据行向量，使用它的add()添加元素，比如整数、String、Object等，有几行就new几个行向量
                            row2.add(No);
                            row2.add("英语类");
                            row2.add("");
                            row2.add(level);
                            row2.add(content);
                            row2.add(flag);
                            data.add(row2);
                            model[0] = new DefaultTableModel(data, names);
                            table.setModel(model[0]);
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else if (!Ctext1.getText().equals("")&&!Ctext2.getText().equals("")){
                    //先找到题号，再对比难度是否相同
                    String vieweng = "select * from engque where E_No = '"+Ctext1.getText()+"'";
                    try {
                        rs = stmt.executeQuery(vieweng);
                        if (rs.next()) {
                            String No = rs.getString("E_No");
                            String level = rs.getString("E_level");
                            String content = rs.getString("E_content");
                            String flag = rs.getString("E_flag");
                            if (level.equals(Ctext2.getText())){
                                Vector row2 = new Vector(); // 数据行向量，使用它的add()添加元素，比如整数、String、Object等，有几行就new几个行向量
                                row2.add(No);
                                row2.add("英语类");
                                row2.add("");
                                row2.add(level);
                                row2.add(content);
                                row2.add(flag);
                                data.add(row2);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                            else{
                                System.out.println("题号难度不匹配");
                            }
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            else if (comboBox.getSelectedItem().equals("政治类")){
                if (Ctext1.getText().equals("")&&Ctext2.getText().equals("")){
                    //显示政治类所有题
                    //政治类题目
                    String viewpol = "select * from polque";
                    try {
                        rs = stmt.executeQuery(viewpol);
                        while(rs.next()){
                            String No = rs.getString("P_No");
                            String level = rs.getString("P_level");
                            String content = rs.getString("P_content");
                            String flag = rs.getString("P_flag");
                            Vector row2 = new Vector(); // 数据行向量，使用它的add()添加元素，比如整数、String、Object等，有几行就new几个行向量
                            row2.add(No);
                            row2.add("政治类");
                            row2.add("");
                            row2.add(level);
                            row2.add(content);
                            row2.add(flag);
                            data.add(row2);
                            model[0] = new DefaultTableModel(data, names);
                            table.setModel(model[0]);
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else if (!Ctext1.getText().equals("")&&Ctext2.getText().equals("")){
                    //只有唯一一题
                    String selectP = "select * from polque where P_No = '"+Ctext1.getText()+"'";
                    try {
                        rs = stmt.executeQuery(selectP);
                        if (rs.next()){
                            String P_No = rs.getString("P_No");
                            String P_content = rs.getString("P_content");
                            String P_level = rs.getString("P_level");
                            String P_flag = rs.getString("P_flag");
                            Vector data1 = new Vector();
                            data1.add(P_No);
                            data1.add("政治类");
                            data1.add("");
                            data1.add(P_level);
                            data1.add(P_content);
                            data1.add(P_flag);
                            data.add(data1);
                            model[0] = new DefaultTableModel(data, names);
                            table.setModel(model[0]);
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else if (Ctext1.getText().equals("")&&!Ctext2.getText().equals("")){
                    //难度为x的题
                    String selectP = "select * from polque where P_level = '"+Ctext2.getText()+"'";
                    try {
                        rs = stmt.executeQuery(selectP);
                        while (rs.next()){
                            String P_No = rs.getString("P_No");
                            String P_content = rs.getString("P_content");
                            String P_level = rs.getString("P_level");
                            String P_flag = rs.getString("P_flag");
                            Vector data1 = new Vector();
                            data1.add(P_No);
                            data1.add("政治类");
                            data1.add("");
                            data1.add(P_level);
                            data1.add(P_content);
                            data1.add(P_flag);
                            data.add(data1);
                            model[0] = new DefaultTableModel(data, names);
                            table.setModel(model[0]);
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else if (!Ctext1.getText().equals("")&&!Ctext2.getText().equals("")){
                    //先找到题号，再对比难度是否相同
                    String selectP = "select * from polque where P_No = '"+Ctext1.getText()+"'";
                    try {
                        rs = stmt.executeQuery(selectP);
                        if (rs.next()){
                            String P_No = rs.getString("P_No");
                            String P_content = rs.getString("P_content");
                            String P_level = rs.getString("P_level");
                            String P_flag = rs.getString("P_flag");
                            if (P_level.equals(Ctext2.getText())){
                                Vector data1 = new Vector();
                                data1.add(P_No);
                                data1.add("政治类");
                                data1.add("");
                                data1.add(P_level);
                                data1.add(P_content);
                                data1.add(P_flag);
                                data.add(data1);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                            else{
                                System.out.println("未查找到相关记录");
                            }
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
    });

    //重置
    Cbt2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            Ctext1.setText("");
            Ctext2.setText("");
            comboBox.setSelectedItem("");
            Ctext4.setText("");
            if(!data.isEmpty()){
                data.clear();
                model[0] = new DefaultTableModel(data, names);
                table.setModel(model[0]);
            }
        }
    });

    //设置关闭方式
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    //设置大小
    frame.setSize(900,700);

    //设置位置
    frame.setLocation(400, 200);

    //设置可见性
    frame.setVisible(true);
}
}
