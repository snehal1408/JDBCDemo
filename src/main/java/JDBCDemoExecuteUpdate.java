import java.sql.*;

public class JDBCDemoExecuteUpdate {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/Student";
        String uname = "root";
        String password = "password";
        Connection con = null;
        ResultSet resultSet = null;
        String query = "select * from studentInfo";
        String insertQuery = "insert into studentInfo values('44','ddd','US');";
        try{
            con = DriverManager.getConnection(url,uname,password);
            Statement st = con.createStatement();
            int count = st.executeUpdate(insertQuery);
            System.out.println("No. of rows affected: "+count);
        }finally {
            if(resultSet!=null)
                resultSet.close();
            if(con!=null)
                con.close();
        }
    }
}
