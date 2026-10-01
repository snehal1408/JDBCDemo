import java.sql.*;

public class JDBCDemoExecute {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/Student";
        String uname = "root";
        String password = "password";
        Connection con = null;
        ResultSet resultSet = null;
        String query = "select * from studentInfo";//DQL
        String insertQuery = "insert into studentInfo values('44','ddd','US');";//DML
        try{
            con = DriverManager.getConnection(url,uname,password);
            Statement st = con.createStatement();
//            boolean execute = st.execute(query);
            boolean execute = st.execute(insertQuery);
            if(execute){
                ResultSet rs = st.getResultSet();
                while(rs.next()){
                System.out.println("Name of Students are:"+ rs.getString(2));
                }
            }else {
                System.out.println("No. of record updated: "+st.getUpdateCount());
            }
        }finally {
            if(resultSet!=null)
                resultSet.close();
            if(con!=null)
                con.close();
        }
    }
}
