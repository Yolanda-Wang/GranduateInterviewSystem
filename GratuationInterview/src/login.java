import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;


public class login {
        public static String url = "jdbc:mysql://localhost:3306/interview?useUnicode=true&characterencoding=GBK";
        public static String username = "manager";
        public static String password = "123456";
        public static Connection con;
        public static Statement stmt;
        public static ResultSet rs;
    public static void main(String[] args) {


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
        login s = new login();
    }

    public login() {
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
<<<<<<< HEAD
        frame.add(panel);
        /*
         * 调用用户定义的方法并添加组件到面板
         */

        // 设置界面可见
        frame.setVisible(true);

=======
>>>>>>> c1aeefb3f04ab20f4098d9c4dc5d773db1493b67
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

<<<<<<< HEAD
=======
        frame.add(panel);
        /*
         * 调用用户定义的方法并添加组件到面板
         */

        // 设置界面可见
        frame.setVisible(true);



>>>>>>> c1aeefb3f04ab20f4098d9c4dc5d773db1493b67
        //登录
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passW = String.valueOf(passwordText.getPassword());
                if(userText.getText().equals("")){
//                    System.out.println("请输入账号");
                    JOptionPane.showMessageDialog(null,"请输入账号","提示",JOptionPane.PLAIN_MESSAGE);
                }
                else if(passW.equals("")){
//                    System.out.println("请输入密码");
                    JOptionPane.showMessageDialog(null,"请输入密码","提示",JOptionPane.PLAIN_MESSAGE);
                }
                else{
                    if(userText.getText().length()==11){
                        String select = "select S_stuID,S_password from student where S_stuID='"+userText.getText()+"'";
                        try {
                            rs = stmt.executeQuery(select);
                            if(rs.next()){
                                if(rs.getString("S_password")==null){
                                    System.out.println("未分配密码");
                                }
                                else{
                                    if(rs.getString("S_password").equals(passW)){
                                        /*登陆成功跳转界面





                                         */
                                    }
                                    else{
//                                        System.out.println("密码错误！");
                                        JOptionPane.showMessageDialog(null,"密码错误","提示",JOptionPane.PLAIN_MESSAGE);
                                    }
                                }
                            }
                            else{
                                System.out.println("该考生未登记");
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                    else if(userText.getText().length()==6){
                        String select = "select T_TeaID,T_password from teacher where T_TeaID='"+userText.getText()+"'";
                        try {
                            rs = stmt.executeQuery(select);
                            if(rs.next()){
                                if(rs.getString("T_password")==null){
                                    System.out.println("未分配密码");
                                }
                                else{
                                    if(rs.getString("T_password").equals(passW)){
                                        /*登陆成功跳转界面





                                         */
                                    }
                                    else{
//                                        System.out.println("密码错误！");
                                        JOptionPane.showMessageDialog(null,"密码错误","提示",JOptionPane.PLAIN_MESSAGE);
                                    }
                                }
                            }
                            else{
                                System.out.println("该导师未登记");
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                    else if(userText.getText().length()==2){
                        String select = "select M_manID,M_password from manager where M_manID='"+userText.getText()+"'";
                        try {
                            rs = stmt.executeQuery(select);
                            if(rs.next()){
                                if(rs.getString("M_password")==null){
                                    System.out.println("未分配密码");
                                }
                                else{
                                    if(rs.getString("M_password").equals(passW)){
                                        /*登陆成功跳转界面





                                         */
                                    }
                                    else{
//                                        System.out.println("密码错误！");
                                        JOptionPane.showMessageDialog(null,"密码错误","提示",JOptionPane.PLAIN_MESSAGE);
                                    }
                                }
                            }
                            else{
                                System.out.println("该管理员不存在");
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });

    }
}


