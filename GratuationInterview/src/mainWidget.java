import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField; 

public class mainWidget {
	public static void main(String[] args) {
        mainWidget w1=new mainWidget();
    }
	public mainWidget() {
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

        //初始化一个按钮
        JButton logout = new JButton("注销");
        logout.setFont(new Font("宋体",Font.PLAIN,16));
        logout.setBounds(400,250, 100, 35);
        panel.add(logout);
        logout.setFocusPainted(false);
        
        JButton start = new JButton("选题");
        start.setFocusPainted(false);
        start.setFont(new Font("宋体",Font.PLAIN,25));
        start.setBounds(250,100, 100, 75);
        panel.add(start);
 
        //把菜单添加到菜单栏
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);
        menuBar.add(menu5);
        //设置菜单栏
        frame.setJMenuBar(menuBar);
        
        panel.setLayout(null);
        
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
