import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

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

public class teacherMainWidget {
	public static void main(String[] args) {
        teacherMainWidget w1=new teacherMainWidget();
    }
public teacherMainWidget() {
	//初始化一个jframe
    JFrame frame = new JFrame("学生端");

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
    
    JLabel label1=new JLabel("考号：");
    label1.setBounds(50,30,100,25);
    label1.setFont(new Font("",Font.PLAIN,16));
    JLabel label2=new JLabel("姓名：");
    label2.setBounds(50,60,100,25);
    label2.setFont(new Font("",Font.PLAIN,16));
    JLabel label3=new JLabel("专业：");
    label3.setBounds(50,90,100,25);
    label3.setFont(new Font("",Font.PLAIN,16));
    JLabel label4=new JLabel("面试分数：");
    label4.setBounds(25,200,100,25);
    label4.setFont(new Font("",Font.PLAIN,16));
    JLabel label5=new JLabel("题目信息：");
    label5.setBounds(320,20,100,25);
    label5.setFont(new Font("",Font.PLAIN,16));
    panel.add(label1);
    panel.add(label2);
    panel.add(label3);
    panel.add(label4);
    panel.add(label5);
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
    bt1.setFont(new Font("宋体",Font.PLAIN,16));;
    panel.add(bt1);
    JButton bt2=new JButton("下一题");
    bt2.setBounds(400, 250, 100, 35);
    bt2.setFont(new Font("宋体",Font.PLAIN,16));;
    panel.add(bt2);
    
    //用表格显示题目
    Object[] columnNames = {"题目类别","题号","查看详细"};// 定义表格列名数组
    // 定义表格数据数组
    String[][] tableValues = {{"数学","1",null},{"英语","20",null},{"政治","32",null}};
    // 创建指定列名和数据的表格
    JTable table = new JTable(tableValues,columnNames);
    table.setBounds(320,70,250,50);
    table.getTableHeader().setBounds(320, 50, 250, 20);
    panel.add(table.getTableHeader());
    panel.add(table);

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
}
}
