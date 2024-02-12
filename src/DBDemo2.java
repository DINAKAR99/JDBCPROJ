import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBDemo2 {
    public static void main(String[] args) {
        
       String url="jdbc:postgresql://localhost:5433/Test";
       Properties p=new Properties();
    //    p.put("user":"postgres");
       p.put("user", "postgres");
       p.put("password", "dinakar1.");
    //    p.put("password":"dinakar1.");



       try{
        Class.forName("org.postgresql.Driver");
        Connection conn=DriverManager.getConnection(url, p);
    System.out.println("conn  established");
    conn.close();
       }

       catch(ClassNotFoundException e){
        e.printStackTrace();
       }
       catch( SQLException e){
        e.printStackTrace();
       }
    }
}
