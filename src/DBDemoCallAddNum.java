import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class DBDemoCallAddNum {
     public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5433/Test";
        String username="postgres";
        String password="dinakar1.";
        try {
            Class.forName("org.postgresql.Driver");

            Connection conn=DriverManager.getConnection(url, username,password);
           
           CallableStatement cs= conn.prepareCall("call spAddNum(?,?,?)");
           cs.setInt(1, 5);
           cs.setInt(2, 5);
        //    cs.setInt(3, 5);
           cs.registerOutParameter(3, Types.INTEGER);
           cs.execute();

           int result=cs.getInt(3);
           System.out.println("sum is "+result);
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
