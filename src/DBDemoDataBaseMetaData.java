import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class DBDemoDataBaseMetaData  {
     public static void main(String[] args) throws Exception {
        String url="jdbc:postgresql://localhost:5433/Test";
        String username="postgres";
        String password="dinakar1.";
         Class.forName("org.postgresql.Driver");

            Connection conn=DriverManager.getConnection(url, username,password);
            DatabaseMetaData dm=conn.getMetaData();
           System.out.println( dm.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE));
       
    }
}
