import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
public class titleDataset {
    public static String url = "jdbc:mysql://localhost:3306/interview?useUnicode=true&characterencoding=GBK";
    public static String username = "manager";
    public static String password = "123456";
    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;
	public static void main(String[] args) {
       titleDataset w1=new titleDataset();
    }
public titleDataset() {
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
    JTextField text3 = new JTextField(20);
    text3.setBounds(340,30,150,25);
    panel.add(text3);
    
    JLabel label4=new JLabel("专业：");
    label4.setBounds(300,60,100,25);
    label4.setFont(new Font("",Font.PLAIN,16));
    JTextField text4 = new JTextField(20);
    text4.setBounds(340,60,150,25);
    panel.add(text4);
    
    JLabel label5=new JLabel("内容：");
    label5.setBounds(25,90,100,25);
    label5.setFont(new Font("",Font.PLAIN,16));
    JTextField text5= new JTextField(1000);
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
    JTable table = new JTable(tableValues,columnNames);
    table.setBounds(0,320,600,150);
    table.getTableHeader().setBounds(0, 300, 600, 20);
    panel.add(table.getTableHeader());
    panel.add(table);
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
    JTextField Ctext3 = new JTextField(20);
    Ctext3.setBounds(660,120,150,25);
    panel.add(Ctext3);
    
    JLabel Clabel4=new JLabel("专业：");
    Clabel4.setBounds(620,150,100,25);
    Clabel4.setFont(new Font("",Font.PLAIN,16));
    JTextField Ctext4 = new JTextField(20);
    Ctext4.setBounds(660,150,150,25);
    panel.add(Ctext4);
    
    JLabel Clabel5=new JLabel("查找");
    Clabel5.setBounds(620,30,100,25);
    Clabel5.setFont(new Font("",Font.PLAIN,16));
    
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

    //添加账号密码


    //设置关闭方式
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    //设置大小
    frame.setSize(900,700);

    //设置位置
    frame.setLocation(100, 100);

    //设置可见性
    frame.setVisible(true);
}
}
