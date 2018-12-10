import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

public class admin {
    public static String url = "jdbc:mysql://localhost:3306/interview?useUnicode=true&characterencoding=GBK";
    public static String username = "manager";
    public static String password = "123456";
    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;
<<<<<<< HEAD
    public static void main(String[]args) {
=======
public static void main(String[]args) throws SQLException {
    try {
        System.out.println("’À∫≈π‹¿Ì£∫");
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("º”‘ÿ«˝∂Ø≥…π¶");
    } catch (ClassNotFoundException var2) {
        System.out.println("º”‘ÿ«˝∂Ø ß∞‹!");
        var2.printStackTrace();
    }
    try {
        con = DriverManager.getConnection(url, username, password);
        stmt = con.createStatement();
        System.out.println("’À∫≈π‹¿Ì ˝æ›ø‚¡¨Ω”≥…π¶");
    } catch (SQLException var1) {
        System.out.println("’À∫≈π‹¿Ì ˝æ›ø‚¡¨Ω” ß∞‹!");
    }
	admin a=new admin();
}
public admin() {
	JFrame frame=new JFrame("π‹¿Ì‘±ΩÁ√Ê");
	//≥ı ºªØ“ª∏ˆ≤Àµ•¿∏
    JMenuBar menuBar = new JMenuBar();

    //≥ı ºªØ≤Àµ•
    JMenu menu1 = new JMenu("≤Ÿ◊˜(O)");
    menu1.setMnemonic('O');  
    menu1.setFont(new Font("ÀŒÃÂ",Font.PLAIN,16));
    JMenu menu2 = new JMenu("∞Ô÷˙(H)");
    menu2.setMnemonic('H'); 
    menu2.setFont(new Font("ÀŒÃÂ",Font.PLAIN,16));
    JMenu menu3 = new JMenu("≤È—Ø(Q)");
    menu3.setMnemonic('Q'); 
    menu3.setFont(new Font("ÀŒÃÂ",Font.PLAIN,16));
    JMenu menu4 = new JMenu("Õ≥º∆(S)");
    menu4.setMnemonic('S'); 
    menu4.setFont(new Font("ÀŒÃÂ",Font.PLAIN,16));
    JMenu menu5 = new JMenu("Œ¨ª§(M)");
    menu5.setMnemonic('M'); 
    menu5.setFont(new Font("ÀŒÃÂ",Font.PLAIN,16));
    //∞—≤Àµ•ÃÌº”µΩ≤Àµ•¿∏
    menuBar.add(menu1);
    menuBar.add(menu2);
    menuBar.add(menu3);
    menuBar.add(menu4);
    menuBar.add(menu5);
    //…Ë÷√≤Àµ•¿∏
    frame.setJMenuBar(menuBar);
    
    JPanel panel=new JPanel();
    Container container = frame.getContentPane();
	panel.setLayout(null);
	   
//	  Object[] columnNames = {"’À∫≈","√‹¬Î","¿‡±"};// ∂®“Â±Ì∏Ò¡–√˚ ˝◊È
//	    // ∂®“Â±Ì∏Ò ˝æ› ˝◊È
//	    String[][] tableValues = {{"001","123",null},{"002","234",null},{"003","562",null}};
//	    // ¥¥Ω®÷∏∂®¡–√˚∫Õ ˝æ›µƒ±Ì∏Ò
        final DefaultTableModel[] model = {new DefaultTableModel()};
        Vector data = new Vector(); //  ˝æ›––œÚ¡øºØ£¨“ÚŒ™¡–±Ì≤ª÷π“ª––£¨Õ˘¿Ô√ÊÃÌº” ˝æ›––œÚ¡ø£¨ÃÌº”∑Ω∑®add(row)
        Vector names = new Vector();// ¡–√˚œÚ¡ø£¨ π”√À¸µƒadd()∑Ω∑®ÃÌº”¡–√˚
        JTable table = new JTable(model[0]);
        names.add("’À∫≈");
        names.add("√‹¬Î");
        names.add("¿‡±");
    String viewtable = "select * from password";
>>>>>>> c1aeefb3f04ab20f4098d9c4dc5d773db1493b67
        try {
            System.out.println("ÁôªÂΩïÔºö");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Âä†ËΩΩÈ©±Âä®ÊàêÂäü");
        } catch (ClassNotFoundException var2) {
            System.out.println("Âä†ËΩΩÈ©±Âä®Â§±Ë¥•!");
            var2.printStackTrace();
        }
<<<<<<< HEAD

        try {
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            System.out.println("ËøûÊé•ÊàêÂäü");
        } catch (SQLException var1) {
            System.out.println("ËøûÊé•Â§±Ë¥•!");
        }
        admin a=new admin();
    }
    public admin() {
        try {
            System.out.println("ÁôªÂΩïÔºö");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Âä†ËΩΩÈ©±Âä®ÊàêÂäü");
        } catch (ClassNotFoundException var2) {
            System.out.println("Âä†ËΩΩÈ©±Âä®Â§±Ë¥•!");
            var2.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            System.out.println("ËøûÊé•ÊàêÂäü");
        } catch (SQLException var1) {
            System.out.println("ËøûÊé•Â§±Ë¥•!");
        }
        JFrame frame=new JFrame("ÁÆ°ÁêÜÂëòÁïåÈù¢");
        //ÂàùÂßãÂåñ‰∏Ä‰∏™ËèúÂçïÊ†è
        JMenuBar menuBar = new JMenuBar();

        //ÂàùÂßãÂåñËèúÂçï
        JMenu menu1 = new JMenu("Êìç‰Ωú(O)");
        menu1.setMnemonic('O');
        menu1.setFont(new Font("ÂÆã‰Ωì",Font.PLAIN,16));
        JMenu menu2 = new JMenu("Â∏ÆÂä©(H)");
        menu2.setMnemonic('H');
        menu2.setFont(new Font("ÂÆã‰Ωì",Font.PLAIN,16));
        JMenu menu3 = new JMenu("Êü•ËØ¢(Q)");
        menu3.setMnemonic('Q');
        menu3.setFont(new Font("ÂÆã‰Ωì",Font.PLAIN,16));
        JMenu menu4 = new JMenu("ÁªüËÆ°(S)");
        menu4.setMnemonic('S');
        menu4.setFont(new Font("ÂÆã‰Ωì",Font.PLAIN,16));
        JMenu menu5 = new JMenu("Áª¥Êä§(M)");
        menu5.setMnemonic('M');
        menu5.setFont(new Font("ÂÆã‰Ωì",Font.PLAIN,16));
        //ÊääËèúÂçïÊ∑ªÂä†Âà∞ËèúÂçïÊ†è
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);
        menuBar.add(menu5);
        //ËÆæÁΩÆËèúÂçïÊ†è
        frame.setJMenuBar(menuBar);

        JPanel panel=new JPanel();
        Container container = frame.getContentPane();
        panel.setLayout(null);

        JButton stuManageButton = new JButton("ÁÆ°ÁêÜÂ≠¶Áîü‰ø°ÊÅØ");
        stuManageButton.setFont(new Font("",Font.PLAIN,16));
        stuManageButton.setBounds(20, 20, 150, 35);
        stuManageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentDataset();
                frame.dispose();
=======
        model[0].setDataVector(data, names); // …Ë÷√ƒ£–Õ÷–µƒ‘™Àÿ£¨À¸ª·◊‘∂Øœ‘ æ‘⁄¡–±Ì÷–
        JScrollPane jsp = new JScrollPane(table); // ”√¡–±Ì¥¥Ω®ø…πˆ∂ØµƒPanel£¨∞—’‚∏ˆPanelÃÌº”µΩ¥∞ø⁄÷–
        jsp.setSize(200, 200);
        jsp.setLocation(10, 70);
        panel.add(jsp);
	    table.setBounds(10,70,200,200);
	    table.setRowHeight(30);
	    table.setFont(new Font("",Font.PLAIN,16));
	    table.getTableHeader().setBounds(10, 50, 250, 20);
	    
	    // ‰»ÎŒƒ±æøÚ
	    JLabel userLabel = new JLabel("’À∫≈:");
        userLabel.setFont(new Font("",Font.PLAIN,16));
        userLabel.setBounds(300,40,250,25);
        panel.add(userLabel);
        
	    JTextField userText = new JTextField(20);
        userText.setBounds(350,40,165,25);
        panel.add(userText);


        JLabel passwordLabel = new JLabel("√‹¬Î:");
        passwordLabel.setFont(new Font("",Font.PLAIN,16));
        passwordLabel.setBounds(300,70,80,25);
        panel.add(passwordLabel);


        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(350,70,165,25);
        panel.add(passwordText);

        JButton addButton = new JButton("ÃÌº”");
        addButton.setFont(new Font("",Font.PLAIN,16));
        addButton.setBounds(300, 150, 70, 35);
        panel.add(addButton);
        
        JButton updateButton = new JButton("∏¸–¬");
        updateButton.setFont(new Font("",Font.PLAIN,16));
        updateButton.setBounds(400, 150, 70, 35);
        panel.add(updateButton);
        
        JButton deleteButton = new JButton("…æ≥˝");
        deleteButton.setFont(new Font("",Font.PLAIN,16));
        deleteButton.setBounds(500, 150, 70, 35);
        panel.add(deleteButton);
        

	    container.add(panel);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //ÃÌº”’À∫≈√‹¬Î
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
                                    String addPass = "insert into password(ID,password,type) values('"+userText.getText()+"','"+passW+"','øº…˙')";
                                    String addstup = "update student set S_password = '"+passW+"' where S_stuID='"+userText.getText()+"'";
                                    stmt.executeUpdate(addPass);
                                    stmt.executeUpdate(addstup);
                                    Vector rowData1 = new Vector();
                                    rowData1.add(userText.getText());
                                    rowData1.add(passW);
                                    rowData1.add("øº…˙");
                                    data.add(rowData1);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
                                    System.out.println("øº…˙’À∫≈√‹¬ÎÃÌº”≥…π¶");
                                }
                                else{
                                    System.out.println("∏√øº…˙’À∫≈≤ª¥Ê‘⁄");
                                }
                            }
                            else if(userText.getText().length()==6){
                                String viewtable = "select T_TeaID from teacher where T_TeaID='"+userText.getText()+"'";
                                rs = stmt.executeQuery(viewtable);
                                if(rs.next()){
                                    String addPass = "insert into password(ID,password,type) values('"+userText.getText()+"','"+passW+"','µº ¶')";
                                    String addteap = "update teacher set T_password = '"+passW+"' where T_TeaID='"+userText.getText()+"'";
                                    stmt.executeUpdate(addPass);
                                    stmt.executeUpdate(addteap);
                                    Vector rowData2 = new Vector();
                                    rowData2.add(userText.getText());
                                    rowData2.add(passW);
                                    rowData2.add("µº ¶");
                                    data.add(rowData2);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
                                    System.out.println("µº ¶’À∫≈√‹¬ÎÃÌº”≥…π¶");
                                }
                                else{
                                    System.out.println("∏√µº ¶’À∫≈≤ª¥Ê‘⁄");
                                }
                            }
                            else if(userText.getText().length()==2){
                                String addPass = "insert into password(ID,password,type) values('"+userText.getText()+"','"+passW+"','π‹¿Ì‘±')";
                                String addmanp = "insert into manager(M_manID,M_password) values('"+userText.getText()+"','"+passW+"')";
                                stmt.executeUpdate(addPass);
                                stmt.executeUpdate(addmanp);
                                Vector rowData2 = new Vector();
                                rowData2.add(userText.getText());
                                rowData2.add(passW);
                                rowData2.add("π‹¿Ì‘±");
                                data.add(rowData2);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                                System.out.println("π‹¿Ì‘±’À∫≈√‹¬ÎÃÌº”≥…π¶");
                            }
                            else{
                                System.out.println("’À∫≈≥§∂»≤ª∆•≈‰");
                            }
                        }
                     else {
                            System.out.println("√‹¬ÎŒ™∞ÀŒª ˝");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else{
                    System.out.println("’À∫≈√‹¬Î–ËÕ¨ ±ÃÌº”");
                }
>>>>>>> c1aeefb3f04ab20f4098d9c4dc5d773db1493b67
            }
        });
        panel.add(stuManageButton);

<<<<<<< HEAD
        JButton teaManageButton = new JButton("ÁÆ°ÁêÜËÄÅÂ∏à‰ø°ÊÅØ");
        teaManageButton.setFont(new Font("",Font.PLAIN,16));
        teaManageButton.setBounds(20, 60, 150, 35);
        teaManageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new teacherManagement();
                frame.dispose();
=======
        //∏¸–¬’À∫≈√‹¬Î
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
                                        String addPass = "insert into password(ID,password,type) values('"+userText.getText()+"','"+passW+"','øº…˙')";
                                        String addstup = "update student set S_password = '"+passW+"' where S_stuID='"+userText.getText()+"'";
                                        stmt.executeUpdate(addPass);
                                        stmt.executeUpdate(addstup);
                                        Vector rowData1 = new Vector();
                                        rowData1.add(userText.getText());
                                        rowData1.add(passW);
                                        rowData1.add("øº…˙");
                                        data.add(rowData1);
                                        model[0] = new DefaultTableModel(data, names);
                                        table.setModel(model[0]);
                                        System.out.println("øº…˙’À∫≈√‹¬ÎÃÌº”≥…π¶");
                                    }
                                    else{
                                        System.out.println("∏√øº…˙’À∫≈≤ª¥Ê‘⁄");
                                    }
                                }
                                else if(userText.getText().length()==6){
                                    String viewtable = "select T_TeaID from teacher where T_TeaID='"+userText.getText()+"'";
                                    rs = stmt.executeQuery(viewtable);
                                    if(rs.next()){
                                        String addPass = "insert into password(ID,password,type) values('"+userText.getText()+"','"+passW+"','µº ¶')";
                                        String addteap = "update teacher set T_password = '"+passW+"' where T_TeaID='"+userText.getText()+"'";
                                        stmt.executeUpdate(addPass);
                                        stmt.executeUpdate(addteap);
                                        Vector rowData2 = new Vector();
                                        rowData2.add(userText.getText());
                                        rowData2.add(passW);
                                        rowData2.add("µº ¶");
                                        data.add(rowData2);
                                        model[0] = new DefaultTableModel(data, names);
                                        table.setModel(model[0]);
                                        System.out.println("µº ¶’À∫≈√‹¬ÎÃÌº”≥…π¶");
                                    }
                                    else{
                                        System.out.println("∏√µº ¶’À∫≈≤ª¥Ê‘⁄");
                                    }
                                }
                                else if(userText.getText().length()==2){
                                    String addPass = "insert into password(ID,password,type) values('"+userText.getText()+"','"+passW+"','π‹¿Ì‘±')";
                                    String addmanp = "insert into manager(M_manID,M_password) values('"+userText.getText()+"','"+passW+"')";
                                    stmt.executeUpdate(addPass);
                                    stmt.executeUpdate(addmanp);
                                    Vector rowData2 = new Vector();
                                    rowData2.add(userText.getText());
                                    rowData2.add(passW);
                                    rowData2.add("π‹¿Ì‘±");
                                    data.add(rowData2);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
                                    System.out.println("π‹¿Ì‘±’À∫≈√‹¬ÎÃÌº”≥…π¶");
                                }
                                else{
                                    System.out.println("’Àªß≤ª¥Ê‘⁄");
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
                        System.out.println("√‹¬Î±ÿ–ÎŒ™∞ÀŒª£°");
                    }
                }
>>>>>>> c1aeefb3f04ab20f4098d9c4dc5d773db1493b67
            }
        });
        panel.add(teaManageButton);

<<<<<<< HEAD
        JButton titleButton = new JButton("ÁÆ°ÁêÜÈ¢òÁõÆ‰ø°ÊÅØ");
        titleButton.setFont(new Font("",Font.PLAIN,16));
        titleButton.setBounds(20, 100, 150, 35);
        titleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new titleDataset();
                frame.dispose();
            }
        });
        panel.add(titleButton);

        JLabel label=new JLabel("ÈÄâÊã©Èù¢ËØïÁßëÁõÆÔºö");
        label.setBounds(20,140,100,25);
        label.setFont(new Font("",Font.PLAIN,16));
        JComboBox combo=new JComboBox();
        combo.setBounds(200,140,150,25);
        combo.addItem("Ëã±ËØ≠");
        combo.addItem("Êï∞Â≠¶");
        combo.addItem("ËÆ°ÁÆóÊú∫");
        combo.addItem("Áâ©ÁêÜ");
        combo.addItem("ÂåñÂ≠¶");
        combo.addItem("ÊîøÊ≤ª");
        panel.add(combo);
        panel.add(label);
        JButton commitButton = new JButton("Êèê‰∫§");
        commitButton.setFont(new Font("",Font.PLAIN,16));
        commitButton.setBounds(80, 180, 150, 35);

        panel.add(commitButton);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //ËÆæÁΩÆÂ§ßÂ∞è
        frame.setSize(600,500);

        //ËÆæÁΩÆ‰ΩçÁΩÆ
        frame.setLocation(100, 100);

        //ËÆæÁΩÆÂèØËßÅÊÄß
        frame.setVisible(true);
    }
=======
        //…æ≥˝’À∫≈√‹¬Î
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
                                    System.out.println("øº…˙’À∫≈√‹¬Î…æ≥˝≥…π¶");
                                } else {
                                    System.out.println("’À∫≈√‹¬Î≤ª∆•≈‰");
                                }
                            } else {
                                System.out.println("’À∫≈√‹¬Î≤ª¥Ê‘⁄");
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
                                    System.out.println("µº ¶’À∫≈√‹¬Î…æ≥˝≥…π¶");
                                } else {
                                    System.out.println("’À∫≈√‹¬Î≤ª∆•≈‰");
                                }
                            } else {
                                System.out.println("’À∫≈√‹¬Î≤ª¥Ê‘⁄");
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
                                    System.out.println("π‹¿Ì‘±’À∫≈√‹¬Î…æ≥˝≥…π¶");
                                } else {
                                    System.out.println("’À∫≈√‹¬Î≤ª∆•≈‰");
                                }
                            } else {
                                System.out.println("’À∫≈√‹¬Î≤ª¥Ê‘⁄");
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
                    System.out.println("…æ≥˝ ß∞‹£°");
                }
            } else {
                System.out.println("«Î ‰»Î’À∫≈∫Õ√‹¬Î");
            }
        }
    });
	    //…Ë÷√¥Û–°
	    frame.setSize(600,500);

	    //…Ë÷√Œª÷√
	    frame.setLocation(100, 100);

	    //…Ë÷√ø…º˚–‘
	    frame.setVisible(true);
}
>>>>>>> c1aeefb3f04ab20f4098d9c4dc5d773db1493b67
}
