import java.sql.*;

public class JDBCDemoExecuteQuery {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/Student";
        String uname = "root";
        String password = "password";
        Connection con = DriverManager.getConnection(url,uname,password);
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery("select * from studentInfo");
        while (resultSet.next()){
            System.out.println("Student id: "+resultSet.getInt(1));
            System.out.println("Student Name: "+resultSet.getString(2));
            System.out.println("Student Address: "+resultSet.getString(3));
        }
    }
}

