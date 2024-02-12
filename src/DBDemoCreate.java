
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDemoCreate {
    public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5433/Test";
        String username="postgres";
        String password="dinakar1.";
        try {
            Class.forName("org.postgresql.Driver");

            Connection conn=DriverManager.getConnection(url, username,password);
            // String dropCommand="drop table if exists emp";
            // String createTable="create table emp(empno serial primary key,ename varchar(30) ,salary decimal(7,2)  )";
            String dropCommand="drop table if exists attachment";
            String createTable="create table attachment(id serial primary key,filename varchar(255),filedata bytea )";
            Statement stm= conn.createStatement();
            stm.execute(dropCommand);
            stm.execute(createTable);
            System.out.println("table kreated");
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
