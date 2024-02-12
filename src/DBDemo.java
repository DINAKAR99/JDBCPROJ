import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBDemo {
    public static void main(String[] args) {
        // String url="jdbc:postgresql://localhost:5433/Test";
        // String username="postgres";
        // String password="dinakar1.";
        
        try{
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://localhost:5433/Test?user=postgres&password=dinakar1.";
            // Connection conn=DriverManager.getConnection(url,username,password);
            Connection conn=DriverManager.getConnection(url);
            System.out.println("connection established");
            conn.close();
        }

        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
