import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class login {
    
    public static void main(String[] args) {    
        // 创建 JFrame 实例
        JFrame frame = new JFrame("登录");
        // Setting the width and height of frame
        frame.setSize(450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* 创建面板，这个类似于 HTML 的 div 标签
         * 我们可以创建多个面板并在 JFrame 中指定位置
         * 面板中我们可以添加文本字段，按钮及其他组件。
         */
        JPanel panel = new JPanel();    
        // 添加面板
        frame.add(panel);
        /* 
         * 调用用户定义的方法并添加组件到面板
         */
        placeComponents(panel);

        // 设置界面可见
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        /* 布局部分我们这边不多做介绍
         * 这边设置布局为 null
         */
        panel.setLayout(null);

        // 创建 JLabel
        JLabel userLabel = new JLabel("User:");
        userLabel.setFont(new Font("",Font.PLAIN,16));
        userLabel.setBounds(100,60,250,25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(140,60,165,25);
        panel.add(userText);


        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("",Font.PLAIN,16));
        passwordLabel.setBounds(60,100,80,25);
        panel.add(passwordLabel);


        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(140,100,165,25);
        panel.add(passwordText);

        JButton loginButton = new JButton("login");
        loginButton.setFont(new Font("",Font.PLAIN,16));
        loginButton.setBounds(170, 180, 100, 35);
        panel.add(loginButton);
        
        JLabel classLabel = new JLabel("类别:");
        classLabel.setFont(new Font("",Font.PLAIN,16));
        classLabel.setBounds(100,140,80,25);
        panel.add(classLabel);
        
        JComboBox comboBox=new JComboBox();
        comboBox.setBounds(140,140,100,20);
        comboBox.addItem("student");
        comboBox.addItem("teacher");
        panel.add(comboBox);

    }

}