import java.awt.Container;
import java.awt.Font;
import java.sql.*;
import java.awt.event.*;
import java.util.Vector;
//
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentDataset {
    public static String url = "jdbc:mysql://localhost:3306/interview?useUnicode=true&characterencoding=GBK";
    public static String username = "manager";
    public static String password = "123456";
    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;
    public static void main(String[] args) throws Exception {
        //连接数据库
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
        StudentDataset a = new StudentDataset();
    }

public StudentDataset() {
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
    JFrame frame = new JFrame("学生信息");

    //初始化一个菜单栏
    JMenuBar menuBar = new JMenuBar();

    //初始化菜单
//    JMenu menu1 = new JMenu("操作(O)");
//    menu1.setMnemonic('O');
//    menu1.setFont(new Font("宋体",Font.PLAIN,16));
//    JMenu menu2 = new JMenu("帮助(H)");
//    menu2.setMnemonic('H');
//    menu2.setFont(new Font("宋体",Font.PLAIN,16));
//    JMenu menu3 = new JMenu("查询(Q)");
//    menu3.setMnemonic('Q');
//    menu3.setFont(new Font("宋体",Font.PLAIN,16));
    JMenu menu4 = new JMenu("统计(S)");
    menu4.setMnemonic('S'); 
    menu4.setFont(new Font("宋体",Font.PLAIN,16));
    JMenuItem rank=new JMenuItem("总分排名");
    rank.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new orderedStudent();
        }
    });
    menu4.add(rank);
//    JMenu menu5 = new JMenu("维护(M)");
//    menu5.setMnemonic('M');
//    menu5.setFont(new Font("宋体",Font.PLAIN,16));
    //初始化一个panel
    JPanel panel = new JPanel();

    //初始化一个容器
    Container container = frame.getContentPane();
    //把菜单添加到菜单栏
//    menuBar.add(menu1);
//    menuBar.add(menu2);
//    menuBar.add(menu3);
    menuBar.add(menu4);
//    menuBar.add(menu5);
    //设置菜单栏
    frame.setJMenuBar(menuBar);
    
    panel.setLayout(null);
    
    JLabel label1=new JLabel("考号：");
    label1.setBounds(25,30,100,25);
    label1.setFont(new Font("",Font.PLAIN,16));
    JTextField text1 = new JTextField(20);
    text1.setBounds(100,30,150,25);
    panel.add(text1);
    
    JLabel label2=new JLabel("身份证号：");
    label2.setBounds(25,60,100,25);
    label2.setFont(new Font("",Font.PLAIN,16));   
    JTextField text2 = new JTextField(20);
    text2.setBounds(100,60,150,25);
    panel.add(text2);
    
    JLabel label6=new JLabel("专业成绩：");
    label6.setBounds(25,90,100,25);
    label6.setFont(new Font("",Font.PLAIN,16));   
    JTextField text6 = new JTextField(20);
    text6.setBounds(100,90,150,25);
    panel.add(text6);
    
    JLabel label3=new JLabel("姓名：");
    label3.setBounds(250,30,100,25);
    label3.setFont(new Font("",Font.PLAIN,16));
    JTextField text3 = new JTextField(20);
    text3.setBounds(325,30,150,25);
    panel.add(text3);
    
    JLabel label4=new JLabel("联系方式：");
    label4.setBounds(250,60,100,25);
    label4.setFont(new Font("",Font.PLAIN,16));
    JTextField text4 = new JTextField(20);
    text4.setBounds(325,60,150,25);
    panel.add(text4);
    
    JLabel label7=new JLabel("政治成绩：");
    label7.setBounds(250,90,100,25);
    label7.setFont(new Font("",Font.PLAIN,16));
    JTextField text7 = new JTextField(20);
    text7.setBounds(325,90,150,25);
    panel.add(text7);
    
    JLabel label5=new JLabel("性别：");
    label5.setBounds(485,30,100,25);
    label5.setFont(new Font("",Font.PLAIN,16));
    JTextField text5= new JTextField(20);
    text5.setBounds(555,30,150,25);
    panel.add(text5);
    
    JLabel label8=new JLabel("本科学校：");
    label8.setBounds(485,60,100,25);
    label8.setFont(new Font("",Font.PLAIN,16));
    JTextField text8= new JTextField(20);
    text8.setBounds(555,60,150,25);
    panel.add(text8);
    
    JLabel label9=new JLabel("英语成绩：");
    label9.setBounds(485,90,100,25);
    label9.setFont(new Font("",Font.PLAIN,16));
    JTextField text9= new JTextField(20);
    text9.setBounds(555,90,150,25);
    panel.add(text9);

    JLabel label10=new JLabel("报考专业：");
    label10.setBounds(720,30,100,25);
    label10.setFont(new Font("",Font.PLAIN,16));
    JComboBox combo=new JComboBox();
    combo.setBounds(790,30,150,25);
    combo.addItem("英语");
    combo.addItem("数学");
    combo.addItem("计算机");
    combo.addItem("物理");
    combo.addItem("化学");
    combo.addItem("政治");
    panel.add(combo);
    
    JLabel label11=new JLabel("面试成绩：");
    label11.setBounds(720,90,100,25);
    label11.setFont(new Font("",Font.PLAIN,16));
    JTextField text11= new JTextField(20);
    text11.setBounds(785,90,150,25);
    panel.add(text11);

    
    panel.add(label1);
    panel.add(label2);
    panel.add(label3);
    panel.add(label4);
    panel.add(label5);
    panel.add(label6);
    panel.add(label7);
    panel.add(label8);
    panel.add(label9);
    panel.add(label10);
    panel.add(label11);

    //分割线
    JSplitPane split1=new JSplitPane();
    split1.setBounds(1000, 0,1, 800);
    panel.add(split1);

//    //用表格显示题目
//    Object[] columnNames = {"考号","姓名","性别","报考专业","身份证号","联系方式","本科学校","专业成绩","政治成绩","英语成绩","面试成绩","flag",};// 定义表格列名数组
//    // 定义表格数据数组
//    String[] tableValues = {"0","Bob","男","数学","123","345","SCU","89","92","76","72","0"};
//    // 创建指定列名和数据的表格
//    JTable table=new JTable(tableValues,columnNames);


    final DefaultTableModel[] model = {new DefaultTableModel()};
    Vector data = new Vector(); // 数据行向量集，因为列表不止一行，往里面添加数据行向量，添加方法add(row)
    Vector names = new Vector();// 列名向量，使用它的add()方法添加列名
    JTable table = new JTable(model[0]);

    //显示数据库信息
    names.add("考号");
    names.add("姓名");
    names.add("性别");
    names.add("报考专业");
    names.add("身份证号");
    names.add("联系方式");
    names.add("本科学校");
    names.add("专业成绩");
    names.add("政治成绩");
    names.add("英语成绩");
    names.add("面试成绩");
    names.add("flag");
    String viewtable = "select * from student";
    try {
        rs = stmt.executeQuery(viewtable);
        while(rs.next()){
            String stu_id = rs.getString("S_stuID");
            String name = rs.getString("S_name");
            String polGrade = rs.getString("S_polGrade");
            String EngGrade = rs.getString("S_EngGrade");
            String majGrade = rs.getString("S_majGrade");
            String major = rs.getString("S_major");
            String intGrade = rs.getString("S_intGrade");
            String School = rs.getString("S_School");
            String ID = rs.getString("S_ID");
            String sex = rs.getString("S_sex");
            String phone = rs.getString("S_phone");
            String flag = rs.getString("S_flag");
            Vector row = new Vector(); // 数据行向量，使用它的add()添加元素，比如整数、String、Object等，有几行就new几个行向量
            row.add(stu_id);
            row.add(name);
            row.add(sex);
            row.add(major);
            row.add(ID);
            row.add(phone);
            row.add(School);
            row.add(majGrade);
            row.add(polGrade);
            row.add(EngGrade);
            row.add(intGrade);
            row.add(flag);
            data.add(row);
            model[0] = new DefaultTableModel(data, names);
            table.setModel(model[0]);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    model[0].setDataVector(data, names); // 设置模型中的元素，它会自动显示在列表中
    JScrollPane jsp = new JScrollPane(table); // 用列表创建可滚动的Panel，把这个Panel添加到窗口中
    jsp.setSize(1000, 200);
    jsp.setLocation(0, 220);
    panel.add(jsp);
    table.setBounds(0,220,1000,100);
    table.setFont(new Font("宋体",Font.PLAIN,16));
    table.setRowHeight(30);
    table.getTableHeader().setBounds(0,200,1000,20);
    table.getTableHeader().setFont(new Font("宋体",Font.PLAIN,16));



    //添加按钮
    JButton bt1=new JButton("添加");
    bt1.setBounds(0, 150, 100, 35);
    bt1.setFont(new Font("宋体",Font.PLAIN,16));;
    panel.add(bt1);
    JButton bt2=new JButton("更新");
    bt2.setBounds(200, 150, 100, 35);
    bt2.setFont(new Font("宋体",Font.PLAIN,16));;
    panel.add(bt2);
    JButton bt3=new JButton("删除");
    bt3.setBounds(400, 150, 100, 35);
    bt3.setFont(new Font("宋体",Font.PLAIN,16));;
    panel.add(bt3);
    JButton bt4=new JButton("浏览");
    bt4.setBounds(600, 150, 100, 35);
    bt4.setFont(new Font("宋体",Font.PLAIN,16));;
    panel.add(bt4);
    JButton bt5=new JButton("关闭");
    bt5.setBounds(800, 150, 100, 35);
    bt5.setFont(new Font("宋体",Font.PLAIN,16));;
    panel.add(bt5);

    //添加信息
    bt1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            if (text1.getText().length()==11&&(text3.getText().length()>=2)&&text2.getText().length()==18&&text4.getText().length()==11){
                String add_stuInfo = "insert into student(S_stuID,S_name,S_polGrade,S_EngGrade," +
                        "S_majGrade,S_major,S_School,S_ID,S_sex,S_phone" +
                        ") values('"+text1.getText()+"','"+text3.getText()+"','"+text7.getText()+"','"+text9.getText()+"'" +
                        ",'"+text6.getText()+"','"+combo.getSelectedItem()+"','"+text8.getText()+"','"+text2.getText()+"','"+text5.getText()+"'" +
                        ",'"+text4.getText()+"')";
                try {
                    stmt.executeUpdate(add_stuInfo);
                    Vector rowData5 = new Vector();
                    rowData5.add(text1.getText());
                    rowData5.add(text3.getText());
                    rowData5.add(text5.getText());
                    rowData5.add(combo.getSelectedIndex());
                    rowData5.add(text2.getText());
                    rowData5.add(text4.getText());
                    rowData5.add(text8.getText());
                    rowData5.add(text6.getText());
                    rowData5.add(text7.getText());
                    rowData5.add(text9.getText());
                    data.add(rowData5);
                    model[0] = new DefaultTableModel(data, names);
                    table.setModel(model[0]);
                    System.out.println("数据添加成功");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    System.out.println("数据添加失败");
                }
            }
            else{
                System.out.println("信息不符合规范");
            }
        }
    });

    //更新信息
    bt2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!text1.getText().equals("")){
                String selectInfo = "select S_stuID from student where S_stuID='"+text1.getText()+"'";
                try {
                    rs = stmt.executeQuery(selectInfo);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                try {
                    if(rs.next()){
                        //更新学生姓名
                        if (!text3.getText().equals("")) {
                            String updateInfo = "update student set S_name='" + text3.getText() + "' where S_stuID='" + text1.getText() + "'";
                            try {
                                stmt.executeUpdate(updateInfo);
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
                        }
                        //更新政治成绩
                        if (!text7.getText().equals("")) {
                            String updateInfo = "update student set S_polGrade='" + Integer.parseInt(text7.getText()) + "' where S_stuID='" + text1.getText() + "'";
                            try {
                                stmt.executeUpdate(updateInfo);
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
                        }
                        //更新英语成绩
                        if (!text9.getText().equals("")) {
                            String updateInfo = "update student set S_EngGrade='" + Integer.parseInt(text9.getText()) + "' where S_stuID='" + text1.getText() + "'";
                            try {
                                stmt.executeUpdate(updateInfo);
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
                        }
                        //更新专业成绩
                        if (!text6.getText().equals("")) {
                            String updateInfo = "update student set S_majGrade='" + Integer.parseInt(text6.getText()) + "' where S_stuID='" + text1.getText() + "'";
                            try {
                                stmt.executeUpdate(updateInfo);
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
                        }
                        //更新报考专业
                        if (!combo.getSelectedItem().equals("")) {
                            String updateInfo = "update student set S_major='" + combo.getSelectedItem() + "' where S_stuID='" + text1.getText() + "'";
                            try {
                                stmt.executeUpdate(updateInfo);
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
                        }
                        //更新面试成绩
                        if (!text11.getText().equals("")) {
                            System.out.println(text11.getText());
                            String updateInfo = "update student set S_intGrade='" + Integer.parseInt(text11.getText()) + "' where S_stuID='" + text1.getText() + "'";
                            try {
                                stmt.executeUpdate(updateInfo);
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
                        }
                        //更新本科学校
                        if (!text8.getText().equals("")) {
                            String updateInfo = "update student set S_School='" + text8.getText() + "' where S_stuID='" + text1.getText() + "'";
                            try {
                                stmt.executeUpdate(updateInfo);
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
                        }
                        //更新联系方式
                        if (!text4.getText().equals("")) {
                            String updateInfo = "update student set S_phone='" + text4.getText() + "' where S_stuID='" + text1.getText() + "'";
                            try {
                                stmt.executeUpdate(updateInfo);
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
                        }
                        //
                        String view = "select * from student";
                        try {
                            rs = stmt.executeQuery(view);
                            while(rs.next()) {
                                Vector rowData6 = new Vector();
                                String stu_id = rs.getString("S_stuID");
                                String name = rs.getString("S_name");
                                String polGrade = rs.getString("S_polGrade");
                                String EngGrade = rs.getString("S_EngGrade");
                                String majGrade = rs.getString("S_majGrade");
                                String major = rs.getString("S_major");
                                String intGrade = rs.getString("S_intGrade");
                                String School = rs.getString("S_School");
                                String ID = rs.getString("S_ID");
                                String sex = rs.getString("S_sex");
                                String phone = rs.getString("S_phone");
                                String flag = rs.getString("S_flag");
                                rowData6.add(stu_id);
                                rowData6.add(name);
                                rowData6.add(sex);
                                rowData6.add(major);
                                rowData6.add(ID);
                                rowData6.add(phone);
                                rowData6.add(School);
                                rowData6.add(majGrade);
                                rowData6.add(polGrade);
                                rowData6.add(EngGrade);
                                rowData6.add(intGrade);
                                rowData6.add(flag);
                                data.add(rowData6);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        System.out.println("数据更新成功");
                    }
                    else{
                        System.out.println("数据更新失败");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    });

    //删除数据
    bt3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!text1.getText().equals("")) {
                String selectInfo = "select S_stuID from student where S_stuID='" + text1.getText() + "'";
                try {
                    rs = stmt.executeQuery(selectInfo);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

            try {
                if(rs.next()){
                    String deleteInfo = "delete from student where S_stuID='"+text1.getText()+"'";
                    String deleteID = "delete from password where ID='"+text1.getText()+"'";
                    stmt.executeUpdate(deleteInfo);
                    stmt.executeUpdate(deleteID);
                    String view = "select * from student";
                    rs = stmt.executeQuery(view);
                    if(!data.isEmpty()) {
                        data.clear();
                        model[0] = new DefaultTableModel(data, names);
                        table.setModel(model[0]);
                    }
                    while(rs.next()){
                        String stu_id = rs.getString("S_stuID");
                        String name = rs.getString("S_name");
                        String polGrade = rs.getString("S_polGrade");
                        String EngGrade = rs.getString("S_EngGrade");
                        String majGrade = rs.getString("S_majGrade");
                        String major = rs.getString("S_major");
                        String intGrade = rs.getString("S_intGrade");
                        String School = rs.getString("S_School");
                        String ID = rs.getString("S_ID");
                        String sex = rs.getString("S_sex");
                        String flag = rs.getString("S_flag");
                        String phone = rs.getString("S_phone");
                        Vector rowData7 = new Vector();
                        rowData7.add(stu_id);
                        rowData7.add(name);
                        rowData7.add(sex);
                        rowData7.add(major);
                        rowData7.add(ID);
                        rowData7.add(phone);
                        rowData7.add(School);
                        rowData7.add(majGrade);
                        rowData7.add(polGrade);
                        rowData7.add(EngGrade);
                        rowData7.add(intGrade);
                        rowData7.add(flag);
                        data.add(rowData7);
                        model[0] = new DefaultTableModel(data, names);
                        table.setModel(model[0]);
                    }
                    System.out.println("信息删除成功");
                }
                else{
                    System.out.println("未查询到数据");
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    });
        //浏览学生表
    bt4.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            String view = "select * from student";
            try {
                rs = stmt.executeQuery(view);
                if(!data.isEmpty()){
                    data.clear();
                    model[0] = new DefaultTableModel(data, names);
                    table.setModel(model[0]);
                }
                while(rs.next()){
                    System.out.println("数据浏览成功！");
                    String stu_id = rs.getString("S_stuID");
                    String name = rs.getString("S_name");
                    String polGrade = rs.getString("S_polGrade");
                    String EngGrade = rs.getString("S_EngGrade");
                    String majGrade = rs.getString("S_majGrade");
                    String major = rs.getString("S_major");
                    String intGrade = rs.getString("S_intGrade");
                    String School = rs.getString("S_School");
                    String ID = rs.getString("S_ID");
                    String sex = rs.getString("S_sex");
                    String phone = rs.getString("S_phone");
                    String flag = rs.getString("S_flag");
                    Vector rowData4 = new Vector();
                    rowData4.add(stu_id);
                    rowData4.add(name);
                    rowData4.add(sex);
                    rowData4.add(major);
                    rowData4.add(ID);
                    rowData4.add(phone);
                    rowData4.add(School);
                    rowData4.add(majGrade);
                    rowData4.add(polGrade);
                    rowData4.add(EngGrade);
                    rowData4.add(intGrade);
                    rowData4.add(flag);
                    data.add(rowData4);
                    model[0] = new DefaultTableModel(data, names);
                    table.setModel(model[0]);
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
                System.out.println("数据浏览失败");
            }
        }
    });

    //查找
    JLabel Clabel1=new JLabel("考号：");
    Clabel1.setBounds(1020,90,100,25);
    Clabel1.setFont(new Font("",Font.PLAIN,16));
    JTextField Ctext1 = new JTextField(20);
    Ctext1.setBounds(1060,90,150,25);
    panel.add(Ctext1);
    
    JLabel Clabel2=new JLabel("姓名：");
    Clabel2.setBounds(1020,120,100,25);
    Clabel2.setFont(new Font("",Font.PLAIN,16));   
    JTextField Ctext2 = new JTextField(20);
    Ctext2.setBounds(1060,120,150,25);
    panel.add(Ctext2);
    
    JLabel Clabel3=new JLabel("查找");
    Clabel3.setBounds(1020,60,100,25);
    Clabel3.setFont(new Font("",Font.PLAIN,16));
    
    panel.add(Clabel1);
    panel.add(Clabel2);
    panel.add(Clabel3);

    //查询框按钮
    JButton Cbt1=new JButton("查询");
    Cbt1.setBounds(1020, 180, 100, 35);
    Cbt1.setFont(new Font("宋体",Font.PLAIN,16));;
    panel.add(Cbt1);
    JButton Cbt2=new JButton("重置");
    Cbt2.setBounds(1150, 180, 100, 35);
    Cbt2.setFont(new Font("宋体",Font.PLAIN,16));;
    panel.add(Cbt2);
    //把panel添加到容器
    container.add(panel);

    //查询信息
    Cbt1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            if((!Ctext1.getText().equals(""))&&(Ctext2.getText().equals(""))) {
                if(!data.isEmpty()){
                    data.clear();
                    model[0] = new DefaultTableModel(data, names);
                    table.setModel(model[0]);
                }
                String selectInfo = "select * from student where S_stuID like'%" + Ctext1.getText() + "%'";
                try {
                    rs = stmt.executeQuery(selectInfo);
                    while(rs.next()){
                        System.out.println("学号查询成功！");
                        String stu_id = rs.getString("S_stuID");
                        String name = rs.getString("S_name");
                        String polGrade = rs.getString("S_polGrade");
                        String EngGrade = rs.getString("S_EngGrade");
                        String majGrade = rs.getString("S_majGrade");
                        String major = rs.getString("S_major");
                        String intGrade = rs.getString("S_intGrade");
                        String School = rs.getString("S_School");
                        String ID = rs.getString("S_ID");
                        String sex = rs.getString("S_sex");
                        String phone = rs.getString("S_phone");
                        String flag = rs.getString("S_flag");
                        Vector rowData1 = new Vector();
                        rowData1.add(stu_id);
                        rowData1.add(name);
                        rowData1.add(sex);
                        rowData1.add(major);
                        rowData1.add(ID);
                        rowData1.add(phone);
                        rowData1.add(School);
                        rowData1.add(majGrade);
                        rowData1.add(polGrade);
                        rowData1.add(EngGrade);
                        rowData1.add(intGrade);
                        rowData1.add(flag);
                        data.add(rowData1);
                        model[0] = new DefaultTableModel(data, names);
                        table.setModel(model[0]);
                    }
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
                else if(Ctext1.getText().equals("")&&!Ctext2.getText().equals("")){
                if(!data.isEmpty()){
                    data.clear();
                    model[0] = new DefaultTableModel(data, names);
                    table.setModel(model[0]);
                }
                    String selectInfo = "select * from student where S_name like'%" + Ctext2.getText() + "%'";
                    try {
                        rs = stmt.executeQuery(selectInfo);
                        while(rs.next()){
                            System.out.println("姓名查询成功！");
                            String stu_id = rs.getString("S_stuID");
                            String name = rs.getString("S_name");
                            String polGrade = rs.getString("S_polGrade");
                            String EngGrade = rs.getString("S_EngGrade");
                            String majGrade = rs.getString("S_majGrade");
                            String major = rs.getString("S_major");
                            String intGrade = rs.getString("S_intGrade");
                            String School = rs.getString("S_School");
                            String ID = rs.getString("S_ID");
                            String sex = rs.getString("S_sex");
                            String phone = rs.getString("S_phone");
                            String flag = rs.getString("S_flag");
                            Vector rowData2 = new Vector();
                            rowData2.add(stu_id);
                            rowData2.add(name);
                            rowData2.add(sex);
                            rowData2.add(major);
                            rowData2.add(ID);
                            rowData2.add(phone);
                            rowData2.add(School);
                            rowData2.add(majGrade);
                            rowData2.add(polGrade);
                            rowData2.add(EngGrade);
                            rowData2.add(intGrade);
                            rowData2.add(flag);
                            data.add(rowData2);
                            model[0] = new DefaultTableModel(data, names);
                            table.getColumnModel().getColumn(4).setPreferredWidth(120);
                            table.setModel(model[0]);
                        }
                    } catch (SQLException e2) {
                        e2.printStackTrace();
                    }
                }
                else if(!Ctext1.getText().equals("")&&!Ctext2.getText().equals("")){
                if(!data.isEmpty()){
                    data.clear();
                    model[0] = new DefaultTableModel(data, names);
                    table.setModel(model[0]);
                }
                    String selectInfo = "select * from student where S_stuID='" + Ctext1.getText() + "'";
                    try {
                        rs = stmt.executeQuery(selectInfo);
                        while(rs.next()){
                            String stu_id = rs.getString("S_stuID");
                            String name = rs.getString("S_name");
                            System.out.println(name);
                            System.out.println(Ctext2.getText());
                            if(name.equals(Ctext2.getText())){
                                String polGrade = rs.getString("S_polGrade");
                                String EngGrade = rs.getString("S_EngGrade");
                                String majGrade = rs.getString("S_majGrade");
                                String major = rs.getString("S_major");
                                String intGrade = rs.getString("S_intGrade");
                                String School = rs.getString("S_School");
                                String ID = rs.getString("S_ID");
                                String sex = rs.getString("S_sex");
                                String phone = rs.getString("S_phone");
                                String flag = rs.getString("S_flag");
                                Vector rowData3 = new Vector();
                                rowData3.add(stu_id);
                                rowData3.add(name);
                                rowData3.add(sex);
                                rowData3.add(major);
                                rowData3.add(ID);
                                rowData3.add(phone);
                                rowData3.add(School);
                                rowData3.add(majGrade);
                                rowData3.add(polGrade);
                                rowData3.add(EngGrade);
                                rowData3.add(intGrade);
                                rowData3.add(flag);
                                data.add(rowData3);
                                model[0] = new DefaultTableModel(data, names);
                                table.getColumnModel().getColumn(4).setPreferredWidth(120);
                                table.setModel(model[0]);
                            }
                            else{
                                System.out.println("学号与姓名不匹配");
                            }
                        }
                    } catch (SQLException e2) {
                        e2.printStackTrace();
                    }

                }
            }
    });

    //重置查询信息
    Cbt2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
             Ctext1.setText("");
             Ctext2.setText("");
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
    frame.setSize(1300,700);

    //设置位置
    frame.setLocation(400, 200);

    //设置可见性
    frame.setVisible(true);
}
}
