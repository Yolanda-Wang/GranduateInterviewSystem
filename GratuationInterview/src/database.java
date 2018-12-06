import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class database {
    public static String url = "jdbc:mysql://localhost:3306/tpc-h?useUnicode=true&characterencoding=GBK";
    public static String username = "manager";
    public static String password = "123456";
    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;

    public static void main(String[] args) throws SQLException {
        connect(url,username,password);
        stmt = con.createStatement();
        stmt.executeUpdate("create database Interview");
        stmt.close();
        con.close();
        url = "jdbc:mysql://localhost:3306/Interview?useUnicode=true&characterEncoding=utf-8";
        con = DriverManager.getConnection(url, "manager", "123456");
        stmt = con.createStatement();
        String sql_Stu = "create table student(S_stuID char(11),S_name varchar(20),S_polGrade SMALLINT,S_EngGrade SMALLINT,S_majGrade SMALLINT,S_major char(10),S_intGrade SMALLINT,S_School varchar(20),S_ID char(18),S_sex char(1),S_phone char(11),S_password char(8),S_flag SMALLINT,PRIMARY KEY(S_stuID));";
        stmt.executeUpdate(sql_Stu);
        String sql_majQue = "create table majQue(M_No char(9),M_content char(100),M_level char(2),M_Major char(10),M_flag SMALLINT,primary key(M_No));";
        stmt.executeUpdate(sql_majQue);
        String sql_EngQue = "create table EngQue(E_No char(9),E_content char(100),E_level char(2),E_flag SMALLINT,primary key(E_No));";
        stmt.executeUpdate(sql_EngQue);
        String sql_polQue = "create table polQue(P_No char(9),P_content char(100),P_level char(2),P_flag SMALLINT,primary key(P_No));";
        stmt.executeUpdate(sql_polQue);
        String sql_Tea = "create table Teacher(T_TeaID char(6),T_name varchar(20),T_major char(10),T_password char(8),primary key(T_TeaID));";
        stmt.executeUpdate(sql_Tea);
        String sql_Man = "create table Manager(M_manID char(2),M_password char(8),primary key(M_manID));";
        stmt.executeUpdate(sql_Man);
    }

    public static void connect(String url,String username,String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("加载驱动成功!");
        } catch (ClassNotFoundException var2) {
            System.out.println("加载驱动失败!");
            var2.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            System.out.println("数据库连接成功!");
        } catch (SQLException var1) {
            System.out.println("数据库连接失败!");
        }

    }

    public static void select(String sql) {
        try {
            rs = stmt.executeQuery(sql);
            ResultSetMetaData meta_data = rs.getMetaData();

            int i_col;
            for(i_col = 1; i_col <= meta_data.getColumnCount(); ++i_col) {
                System.out.print(meta_data.getColumnLabel(i_col) + "....");
            }

            System.out.println();

            while(rs.next()) {
                for(i_col = 1; i_col <= meta_data.getColumnCount(); ++i_col) {
                    System.out.print(rs.getString(i_col) + "....");
                }

                System.out.println();
            }

            rs.close();
        } catch (Exception var3) {
            System.out.println("数据查询失败!");
            var3.printStackTrace();
        }

    }

    public static void insert(String sql) {
        try {
            stmt.clearBatch();
            stmt.addBatch(sql);
            stmt.executeBatch();
            System.out.println("数据插入成功!");
        } catch (Exception var2) {
            System.out.println("数据插入失败!");
            var2.printStackTrace();
        }

    }

    public static void update(String sql) {
        try {
            stmt.executeUpdate(sql);
            System.out.println("数据更新成功!");
        } catch (Exception var2) {
            System.out.println("数据更新失败!");
        }

    }
}
