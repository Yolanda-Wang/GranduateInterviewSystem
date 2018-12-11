import java.awt.Container;
import java.awt.Font;
import java.sql.*;
import java.awt.event.*;
import java.util.Vector;
//
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class orderedStudent {
    public static String url = "jdbc:mysql://localhost:3306/interview?useUnicode=true&characterencoding=GBK";
    public static String username = "manager";
    public static String password = "123456";
    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;

    public static void main(String[]args){
        orderedStudent o=new orderedStudent();
    }
   public orderedStudent() {
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


        //初始化一个jframe
        JFrame frame = new JFrame("总分排名");

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
        JMenuItem rank=new JMenuItem("总分排名");
        menu4.add(rank);
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
        names.add("总分成绩");
        names.add("flag");
        String viewtable = "select *,S_majGrade+S_engGrade+S_polGrade+S_intGrade as totalScore from student order by S_majGrade+S_engGrade+S_polGrade+S_intGrade desc";
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
                String totalGrade=rs.getString("totalScore");
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
                row.add(totalGrade);
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
        jsp.setSize(1000, 500);
        jsp.setLocation(10, 0);
        panel.add(jsp);
        table.setBounds(10,20,1000,100);
        table.setFont(new Font("宋体",Font.PLAIN,16));
        table.setRowHeight(30);
        table.getTableHeader().setBounds(10,0,1000,20);
        table.getTableHeader().setFont(new Font("宋体",Font.PLAIN,16));






       frame.add(panel);
        //设置关闭方式
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);


        //设置大小
        frame.setSize(1050,500);

        //设置位置
       frame.setLocation(400, 200);

        //设置可见性
        frame.setVisible(true);
    }
}
