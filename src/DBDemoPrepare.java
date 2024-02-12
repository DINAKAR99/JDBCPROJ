import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDemoPrepare {
     public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5433/Test";
        String username="postgres";
        String password="dinakar1.";
        try {
            Class.forName("org.postgresql.Driver");

            Connection conn=DriverManager.getConnection(url, username,password);
            String insertCommand="insert into emp values(?,?,?)";
            // String createTable="create table emp(empno int primary key,ename varchar(30) ,salary decimal(7,2)  )";
            PreparedStatement p = conn.prepareStatement(insertCommand);
            p.setLong(1, 101);
            p.setString(2, "abrahm");
            p.setLong(3, 10000);


           int count= p.executeUpdate();
            System.out.println(count+"rows inserted.........");
       ///////////////////////////////////////////////    
            p.setLong(1, 102);
            p.setString(2, "peter");
            p.setLong(3, 10040);


           int count2= p.executeUpdate();
            System.out.println(count2+"rows inserted.........");

          
            p.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
