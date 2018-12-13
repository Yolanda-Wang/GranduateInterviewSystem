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

public class teacherManagement {
    public static String url = "jdbc:mysql://localhost:3306/interview?useUnicode=true&characterencoding=GBK";
    public static String username = "manager";
    public static String password = "123456";
    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;
	public static void main(String[] args) {
        //连接数据库
        try {
            System.out.println("导师信息：");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("加载驱动成功!");
        } catch (ClassNotFoundException var2) {
            System.out.println("加载驱动失败!");
            var2.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            System.out.println("导师信息数据库连接成功");
        } catch (SQLException var1) {
            System.out.println("导师信息数据库连接失败!");
        }
	    teacherManagement w1=new teacherManagement();
    }
public teacherManagement() {
    try {
        System.out.println("导师信息：");
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("加载驱动成功!");
    } catch (ClassNotFoundException var2) {
        System.out.println("加载驱动失败!");
        var2.printStackTrace();
    }

    try {
        con = DriverManager.getConnection(url, username, password);
        stmt = con.createStatement();
        System.out.println("导师信息数据库连接成功");
    } catch (SQLException var1) {
        System.out.println("导师信息数据库连接失败!");
    }

	//初始化一个jframe
    JFrame frame = new JFrame("导师信息管理");

    //初始化一个菜单栏
    JMenuBar menuBar = new JMenuBar();

    //初始化菜单

    //初始化一个panel
    JPanel panel = new JPanel();

    //初始化一个容器
    Container container = frame.getContentPane();
    //把菜单添加到菜单栏

    //设置菜单栏
    frame.setJMenuBar(menuBar);
    
    panel.setLayout(null);
    
    JLabel label1=new JLabel("姓名:");
    label1.setBounds(25,30,100,25);
    label1.setFont(new Font("",Font.PLAIN,16));
    JTextField text1 = new JTextField(20);
    text1.setBounds(65,30,150,25);
    panel.add(text1);
    
    JLabel label2=new JLabel("工号:");
    label2.setBounds(25,60,100,25);
    label2.setFont(new Font("",Font.PLAIN,16));   
    JTextField text2 = new JTextField(20);
    text2.setBounds(65,60,150,25);
    panel.add(text2);
    
    JLabel label3=new JLabel("专业：");
    label3.setBounds(300,30,100,25);
    label3.setFont(new Font("",Font.PLAIN,16));
    JTextField text3 = new JTextField(20);
    text3.setBounds(340,30,150,25);
    panel.add(text3);

    JLabel label4=new JLabel("组长：");
    label4.setBounds(300,60,100,25);
    label4.setFont(new Font("",Font.PLAIN,16));
    JComboBox comboBox=new JComboBox();
    comboBox.setBounds(340,60,150,25);
    comboBox.addItem("");
    comboBox.addItem("是");
    comboBox.addItem("否");
    panel.add(comboBox);



    panel.add(label1);
    panel.add(label2);
    panel.add(label3);
    panel.add(label4);

    //分割线
    JSplitPane split1=new JSplitPane();
    split1.setBounds(500, 0,1, 800);
    panel.add(split1);
    


    // 创建指定列名和数据的表格
    final DefaultTableModel[] model = {new DefaultTableModel()};
    Vector data = new Vector(); // 数据行向量集，因为列表不止一行，往里面添加数据行向量，添加方法add(row)
    Vector names = new Vector();// 列名向量，使用它的add()方法添加列名
    JTable table = new JTable(model[0]);

    names.add("工号");
    names.add("姓名");
    names.add("专业");
    names.add("组长");

    String viewtable = "select * from teacher";
    try {
        rs = stmt.executeQuery(viewtable);
        while(rs.next()){
            String tea_id = rs.getString("T_TeaID");
            String name = rs.getString("T_name");
            String major = rs.getString("T_major");
            String flag = rs.getString("T_flag");
            Vector row = new Vector(); // 数据行向量，使用它的add()添加元素，比如整数、String、Object等，有几行就new几个行向量
            row.add(tea_id);
            row.add(name);
            row.add(major);
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
    jsp.setSize(500, 250);
    jsp.setLocation(0, 180);
    panel.add(jsp);
    table.setBounds(0,190,500,150);
    table.setRowHeight(30);
    table.setFont(new Font("宋体",Font.PLAIN,16));
    table.getTableHeader().setBounds(0, 160, 500, 30);
    table.getTableHeader().setFont(new Font("宋体",Font.PLAIN,16));
    panel.add(table.getTableHeader());

    //添加按钮
    JButton bt1=new JButton("添加");
    bt1.setBounds(0, 100, 100, 35);
    bt1.setFont(new Font("宋体",Font.PLAIN,16));;
    panel.add(bt1);
    JButton bt2=new JButton("更新");
    bt2.setBounds(100, 100, 100, 35);
    bt2.setFont(new Font("宋体",Font.PLAIN,16));;
    panel.add(bt2);
    JButton bt3=new JButton("删除");
    bt3.setBounds(200, 100, 100, 35);
    bt3.setFont(new Font("宋体",Font.PLAIN,16));;
    panel.add(bt3);
    JButton bt4=new JButton("浏览");
    bt4.setBounds(300, 100, 100, 35);
    bt4.setFont(new Font("宋体",Font.PLAIN,16));;
    panel.add(bt4);
    JButton bt5=new JButton("关闭");
    bt5.setBounds(400, 100, 100, 35);
    bt5.setFont(new Font("宋体",Font.PLAIN,16));;
    panel.add(bt5);

    
    //查找
    JLabel Clabel1=new JLabel("工号：");
    Clabel1.setBounds(520,60,100,25);
    Clabel1.setFont(new Font("",Font.PLAIN,16));
    JTextField Ctext1 = new JTextField(20);
    Ctext1.setBounds(560,60,150,25);
    panel.add(Ctext1);
    
    JLabel Clabel2=new JLabel("姓名：");
    Clabel2.setBounds(520,90,100,25);
    Clabel2.setFont(new Font("",Font.PLAIN,16));   
    JTextField Ctext2 = new JTextField(20);
    Ctext2.setBounds(560,90,150,25);
    panel.add(Ctext2);
    

    JLabel Clabel3=new JLabel("查找");
    Clabel3.setBounds(520,30,100,25);
    Clabel3.setFont(new Font("",Font.PLAIN,16));
    

    panel.add(Clabel1);
    panel.add(Clabel2);
    panel.add(Clabel3);
 
    //查询框按钮
    JButton Cbt1=new JButton("查询");
    Cbt1.setBounds(520, 250, 100, 35);
    Cbt1.setFont(new Font("宋体",Font.PLAIN,16));;
    panel.add(Cbt1);
    JButton Cbt2=new JButton("重置");
    Cbt2.setBounds(650, 250, 100, 35);
    Cbt2.setFont(new Font("宋体",Font.PLAIN,16));;
    panel.add(Cbt2);
    //把panel添加到容器
    container.add(panel);

    JMenu menu2 = new JMenu("帮助(H)");
    menu2.setMnemonic('H');
    menu2.setFont(new Font("宋体",Font.PLAIN,16));
    menuBar.add(menu2);
    //添加信息
    bt1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (text2.getText().length() == 6&&text1.getText().length()>=2&&!comboBox.getSelectedItem().equals("")) {
                String add_teaInfo = "insert into teacher(T_TeaID,T_name,T_major,T_flag) values('"+text2.getText()+"','"+text1.getText()+"','"+text3.getText()+"','"+comboBox.getSelectedItem()+"')";
                try {
                    stmt.executeUpdate(add_teaInfo);
                    Vector rowData1 = new Vector();
                    rowData1.add(text2.getText());
                    rowData1.add(text1.getText());
                    rowData1.add(text3.getText());
                    rowData1.add(comboBox.getSelectedItem());
                    data.add(rowData1);
                    model[0] = new DefaultTableModel(data, names);
                    table.setModel(model[0]);
                    System.out.println("数据添加成功");
                    JOptionPane.showMessageDialog(null,"数据添加成功","提示",JOptionPane.PLAIN_MESSAGE);

                } catch (SQLException e1) {
                    e1.printStackTrace();
                    System.out.println("数据添加失败");
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"信息不符合规范","提示",JOptionPane.PLAIN_MESSAGE);
            }
        }
    });

    //更新信息
    bt2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!text1.getText().equals("")){
                String selectInfo = "select T_teaID from teacher where T_TeaID='"+text2.getText()+"'";
                try {
                    rs = stmt.executeQuery(selectInfo);
                    if(rs.next()){
                        //更新导师姓名
                        if (!text1.getText().equals("")&&text1.getText().length()>=2) {
                            String updateInfo = "update teacher set T_name='" + text1.getText() + "' where T_TeaID='" + text2.getText() + "'";
                            stmt.executeUpdate(updateInfo);
                        }
                        //更新导师专业
                        if(!text3.getText().equals("")){
                            String updateInfo = "update teacher set T_major='" + text3.getText() + "' where T_TeaID='" + text2.getText() + "'";
                            stmt.executeUpdate(updateInfo);
                        }
                        //更新导师组长情况
                        if(!comboBox.getSelectedItem().equals("")){
                            String updateInfo = "update teacher set T_flag='" + comboBox.getSelectedItem() + "' where T_TeaID='" + text2.getText() + "'";
                            stmt.executeUpdate(updateInfo);
                        }
                        //显示导师表
                        if(!data.isEmpty()) {
                            data.clear();
                            model[0] = new DefaultTableModel(data, names);
                            table.setModel(model[0]);
                        }
                        String view = "select * from teacher";
                        rs = stmt.executeQuery(view);
                        while(rs.next()) {
                            Vector rowData2 = new Vector();
                            String Tea_id = rs.getString("T_teaID");
                            String name = rs.getString("T_name");
                            String major = rs.getString("T_major");
                            String flag = rs.getString("T_flag");
                            rowData2.add(Tea_id);
                            rowData2.add(name);
                            rowData2.add(major);
                            rowData2.add(flag);
                            data.add(rowData2);
                            model[0] = new DefaultTableModel(data, names);
                            table.setModel(model[0]);
                        }
                        JOptionPane.showMessageDialog(null,"数据更新成功","提示",JOptionPane.PLAIN_MESSAGE);
//                        System.out.println("数据更新成功");
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
            //需不需要完善删除信息
            try {
                if (!text2.getText().equals("")) {
                    String selectInfo = "select T_TeaID from teacher where T_TeaID='" + text2.getText() + "'";
                    rs = stmt.executeQuery(selectInfo);
                    if(rs.next()){
                        String deleteInfo = "delete from teacher where T_TeaID='"+text2.getText()+"'";
                        String deleteID = "delete from password where ID='"+text2.getText()+"'";
                        stmt.executeUpdate(deleteInfo);
                        stmt.executeUpdate(deleteID);
                        String view = "select * from teacher";
                        rs = stmt.executeQuery(view);
                        if(!data.isEmpty()) {
                            data.clear();
                            model[0] = new DefaultTableModel(data, names);
                            table.setModel(model[0]);
                        }
                        while(rs.next()){
                            String tea_id = rs.getString("T_TeaID");
                            String name = rs.getString("T_name");
                            String major = rs.getString("T_major");
                            String flag = rs.getString("T_flag");
                            Vector rowData3 = new Vector(); // 数据行向量，使用它的add()添加元素，比如整数、String、Object等，有几行就new几个行向量
                            rowData3.add(tea_id);
                            rowData3.add(name);
                            rowData3.add(major);
                            rowData3.add(flag);
                            data.add(rowData3);
                            model[0] = new DefaultTableModel(data, names);
                            table.setModel(model[0]);
                        }
//                        System.out.println("信息删除成功");
                        JOptionPane.showMessageDialog(null,"信息删除成功","提示",JOptionPane.PLAIN_MESSAGE);
                    }
                }
                else{
                    System.out.println("未查询到数据");
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    });


    //浏览导师表
    bt4.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            String view = "select * from teacher";
            try {
                rs = stmt.executeQuery(view);
                if(!data.isEmpty()) {
                    data.clear();
                    model[0] = new DefaultTableModel(data, names);
                    table.setModel(model[0]);
                }
                while(rs.next()){
                    String tea_id = rs.getString("T_TeaID");
                    String name = rs.getString("T_name");
                    String major = rs.getString("T_major");
                    String flag = rs.getString("T_flag");
                    Vector rowData4 = new Vector(); // 数据行向量，使用它的add()添加元素，比如整数、String、Object等，有几行就new几个行向量
                    rowData4.add(tea_id);
                    rowData4.add(name);
                    rowData4.add(major);
                    rowData4.add(flag);
                    data.add(rowData4);
                    model[0] = new DefaultTableModel(data, names);
                    table.setModel(model[0]);
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    });

    //查询
    Cbt1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            if((!Ctext1.getText().equals(""))&&(Ctext2.getText().equals(""))) {
                if(!data.isEmpty()){
                    data.clear();
                    model[0] = new DefaultTableModel(data, names);
                    table.setModel(model[0]);
                }
                String selectInfo = "select * from teacher where T_TeaID like'%" + Ctext1.getText() + "%'";
                try {
                    rs = stmt.executeQuery(selectInfo);
                    while(rs.next()){
                        System.out.println("信息查询成功");
                        String tea_id = rs.getString("T_TeaID");
                        String name = rs.getString("T_name");
                        String major = rs.getString("T_major");
                        String flag = rs.getString("T_flag");
                        Vector rowData5 = new Vector(); // 数据行向量，使用它的add()添加元素，比如整数、String、Object等，有几行就new几个行向量
                        rowData5.add(tea_id);
                        rowData5.add(name);
                        rowData5.add(major);
                        rowData5.add(flag);
                        data.add(rowData5);
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
                String selectInfo = "select * from teacher where T_name like'%" + Ctext2.getText() + "%'";
                try {
                    rs = stmt.executeQuery(selectInfo);
                    while(rs.next()){
                        System.out.println("信息查询成功");
                        String tea_id = rs.getString("T_TeaID");
                        String name = rs.getString("T_name");
                        String major = rs.getString("T_major");
                        String flag = rs.getString("T_flag");
                        Vector rowData6 = new Vector(); // 数据行向量，使用它的add()添加元素，比如整数、String、Object等，有几行就new几个行向量
                        rowData6.add(tea_id);
                        rowData6.add(name);
                        rowData6.add(major);
                        rowData6.add(flag);
                        data.add(rowData6);
                        model[0] = new DefaultTableModel(data, names);
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
                String selectInfo = "select * from teacher where T_TeaID='" + Ctext1.getText() + "'";
                try {
                    rs = stmt.executeQuery(selectInfo);
                    while(rs.next()){
                        String tea_id = rs.getString("T_TeaID");
                        String name = rs.getString("T_name");
                        if(name.equals(Ctext2.getText())){
                            String major = rs.getString("T_major");
                            String flag = rs.getString("T_flag");
                            Vector rowData7 = new Vector(); // 数据行向量，使用它的add()添加元素，比如整数、String、Object等，有几行就new几个行向量
                            rowData7.add(tea_id);
                            rowData7.add(name);
                            rowData7.add(major);
                            rowData7.add(flag);
                            data.add(rowData7);
                            model[0] = new DefaultTableModel(data, names);
                            table.setModel(model[0]);
                        }
                        else{
                            System.out.println("工号与姓名不匹配");
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
                table.getColumnModel().getColumn(4).setPreferredWidth(120);
            }
        }
    });

    //重置
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
    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);


    //设置大小
    frame.setSize(800,500);

    //设置位置
    frame.setLocation(500, 300);

    //设置可见性
    frame.setVisible(true);

    //设置窗口大小不可变
    frame.setResizable(false);
}
}
