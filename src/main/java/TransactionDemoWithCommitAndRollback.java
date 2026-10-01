import java.sql.*;
import java.util.Scanner;

public class TransactionDemoWithCommitAndRollback {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/Transaction";
        String uname = "root";
        String password = "password";
        Connection con = DriverManager.getConnection(url,uname,password);
        Statement st = con.createStatement();
        System.out.println("Data before transaction");
        System.out.println("-----------------------------");
        ResultSet resultSet = st.executeQuery("select * from accounts");
        while (resultSet.next()){
            System.out.println(resultSet.getString(1)+resultSet.getInt(2));
        }
        System.out.println("Transaction begins...");
        con.setAutoCommit(false);
        st.executeUpdate("update accounts set balance = balance-2000 where Name='Milan'");
        st.executeUpdate("update accounts set balance = balance+2000 where Name='Anushka'");
        System.out.println("can you please confirm this txn of 2000?[yes/no]");
        Scanner sc = new Scanner(System.in);
        String option = sc.next();
        if(option.equalsIgnoreCase("yes")){
            con.commit();
            System.out.println("Txn committed");
        }
        else{
            con.rollback();
            System.out.println("Txn rolled back");
        }
        System.out.println("Data after Txn performed");
        System.out.println("---------------------------");
        ResultSet resultSet1 = st.executeQuery("select * from accounts");
        while (resultSet1.next()){
            System.out.println(resultSet1.getString(1)+resultSet1.getInt(2));
        }
    }
}
