import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

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
import javax.swing.table.DefaultTableModel;


public class admin {
    public static String url = "jdbc:mysql://localhost:3306/interview?useUnicode=true&characterencoding=GBK";
    public static String username = "manager";
    public static String password = "123456";
    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;
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
    String viewtable = "select * from password";
    try {
        try {
            rs = stmt.executeQuery(viewtable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (rs.next()) {
        }
    }

	    JTable table = new JTable(tableValues,columnNames);
	    table.setBounds(10,70,250,100);
	    table.setRowHeight(30);
	    table.setFont(new Font("",Font.PLAIN,16));
	    table.getTableHeader().setBounds(10, 50, 250, 20);
	    panel.add(table.getTableHeader());
	    panel.add(table);
	    
	    //输入文本框
	    JLabel userLabel = new JLabel("账号:");
        userLabel.setFont(new Font("",Font.PLAIN,16));
        userLabel.setBounds(300,40,250,25);
        panel.add(userLabel);
        
	    JTextField userText = new JTextField(20);
        userText.setBounds(350,40,165,25);
        panel.add(userText);


        JLabel passwordLabel = new JLabel("密码:");
        passwordLabel.setFont(new Font("",Font.PLAIN,16));
        passwordLabel.setBounds(300,70,80,25);
        panel.add(passwordLabel);


        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(350,70,165,25);
        panel.add(passwordText);
        
        JLabel classLabel = new JLabel("类别:");
        classLabel.setFont(new Font("",Font.PLAIN,16));
        classLabel.setBounds(300,100,80,25);
        panel.add(classLabel);
        
//        JComboBox comboBox=new JComboBox();
//        comboBox.setBounds(350,100,100,20);
//        comboBox.addItem("student");
//        comboBox.addItem("teacher");
//        panel.add(comboBox);

        JButton addButton = new JButton("添加");
        addButton.setFont(new Font("",Font.PLAIN,16));
        addButton.setBounds(300, 150, 70, 35);
        panel.add(addButton);
        
        JButton updateButton = new JButton("更新");
        updateButton.setFont(new Font("",Font.PLAIN,16));
        updateButton.setBounds(400, 150, 70, 35);
        panel.add(updateButton);
        
        JButton deleteButton = new JButton("删除");
        deleteButton.setFont(new Font("",Font.PLAIN,16));
        deleteButton.setBounds(500, 150, 70, 35);
        panel.add(deleteButton);
        

	    container.add(panel);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //添加账号密码
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passW = String.valueOf(passwordText.getPassword());
                if(!userText.getText().equals("")&&!passW.equals("")){
                    try {
                        if(userText.getText().length()==11||userText.getText().length()==6||userText.getText().length()==2) {
                            String addPass = "insert into password(ID,password) values('"+userText.getText()+"','"+passW+"')";
                            stmt.executeUpdate(addPass);

                        }
                        else{
                            System.out.println("账号长度不匹配");
                        }



                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }

            }
        });

	    //设置大小
	    frame.setSize(600,500);

	    //设置位置
	    frame.setLocation(100, 100);

	    //设置可见性
	    frame.setVisible(true);
}
}
