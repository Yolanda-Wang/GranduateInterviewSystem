import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;
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
        names.add("类别");
    String viewtable = "select * from password";
        try {
            rs = stmt.executeQuery(viewtable);
            while (rs.next()) {
                String ID = rs.getString("ID");
                String passWord = rs.getString("password");
                String type = rs.getString("type");
                Vector row = new Vector();
                row.add(ID);
                row.add(passWord);
                row.add(type);
                data.add(row);
                model[0] = new DefaultTableModel(data, names);
                table.setModel(model[0]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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


        JLabel passwordLabel = new JLabel("密码:");
        passwordLabel.setFont(new Font("",Font.PLAIN,16));
        passwordLabel.setBounds(300,70,80,25);
        panel.add(passwordLabel);


        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(350,70,165,25);
        panel.add(passwordText);

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
            }
        });

        //更新账号密码
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passW = String.valueOf(passwordText.getPassword());
                if(!userText.getText().equals("")&&!passW.equals("")){
                    if (passW.length()==8){
                        String select = "select * from password where ID = '"+userText.getText()+"'";
                        try {
                            rs = stmt.executeQuery(select);
                            if(rs.next()){
                                if (userText.getText().length()==11){
                                    String update ="update password set password = '"+passW+"' where ID = '"+userText.getText()+"'";
                                    String update_stu = "update student set S_password = '"+passW+"' where S_stuID = '"+userText.getText()+"'";
                                    stmt.executeUpdate(update);
                                    stmt.executeUpdate(update_stu);
                                }
                                else if(userText.getText().length()==6){
                                    String update ="update password set password = '"+passW+"' where ID = '"+userText.getText()+"'";
                                    String update_tea = "update teacher set T_password = '"+passW+"' where T_TeaID = '"+userText.getText()+"'";
                                    stmt.executeUpdate(update);
                                    stmt.executeUpdate(update_tea);
                                }
                                else if(userText.getText().length()==2){
                                    String update ="update password set password = '"+passW+"' where ID = '"+userText.getText()+"'";
                                    String update_man = "update manager set M_password = '"+passW+"' where M_manID = '"+userText.getText()+"'";
                                    stmt.executeUpdate(update);
                                    stmt.executeUpdate(update_man);
                                }
                            }
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
                            }
                            String selectall = "select * from password";
                            data.clear();
                            rs = stmt.executeQuery(selectall);
                            while(rs.next()){
                                String pass = rs.getString("password");
                                String id = rs.getString("ID");
                                String type = rs.getString("type");
                                Vector rowData3 = new Vector();
                                rowData3.add(id);
                                rowData3.add(pass);
                                rowData3.add(type);
                                data.add(rowData3);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }

                    }

                    else{
                        System.out.println("密码必须为八位！");
                    }
                }
            }
        });

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
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                    data.clear();
                    String select = "select * from password";
                    try {
                        rs = stmt.executeQuery(select);
                        while(rs.next()){
                            String pass = rs.getString("password");
                            String id = rs.getString("ID");
                            String type = rs.getString("type");
                            Vector rowData4 = new Vector();
                            rowData4.add(id);
                            rowData4.add(pass);
                            rowData4.add(type);
                            data.add(rowData4);
                            model[0] = new DefaultTableModel(data, names);
                            table.setModel(model[0]);
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    System.out.println("删除失败！");
                }
            } else {
                System.out.println("请输入账号和密码");
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
