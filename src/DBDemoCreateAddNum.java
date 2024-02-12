import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDemoCreateAddNum {
     public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5433/Test";
        String username="postgres";
        String password="dinakar1.";
        try {
            Class.forName("org.postgresql.Driver");

            Connection conn=DriverManager.getConnection(url, username,password);
           
            // String createTable="create table emp(empno int primary key,ename varchar(30) ,salary decimal(7,2)  )";
            Statement stm= conn.createStatement();
            String drop_spAddNum="DROP PROCEDURE IF EXISTS spAddNum";
            String create_spAddNum="create procedure spAddNum(  a  int,  b int, inout c int) language plpgsql as $$ "
                                       +"begin "+
                                       "c:=a+b;"+
                                       "end ;$$";

           stm.execute(drop_spAddNum);
           stm.execute(create_spAddNum);

           System.out.println("procedure created");
           


           
            stm.close();
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
