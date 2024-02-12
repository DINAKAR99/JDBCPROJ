import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDemoInsert2 {
    public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5433/Test";
        String username="postgres";
        String password="dinakar1.";
        try {
            Class.forName("org.postgresql.Driver");

            Connection conn=DriverManager.getConnection(url, username,password);
            String insertCommand="insert into  emp values ("+Integer.parseInt(args[0])+",'"+args[1]+"',"+Integer.parseInt(args[2])+")";
            // String createTable="create table emp(empno int primary key,ename varchar(30) ,salary decimal(7,2)  )";
            Statement stm= conn.createStatement();
            // stm.execute(insertCommand);

            System.out.println(stm.executeUpdate(insertCommand));


           
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
