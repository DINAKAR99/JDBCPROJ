import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDemoResultSetMetadata {
    public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5433/Test";
        String username="postgres";
        String password="dinakar1.";
        try {
            Class.forName("org.postgresql.Driver");

            Connection conn=DriverManager.getConnection(url, username,password);
            String query="select * from emp where 1=2";
            // String createTable="create table emp(empno int primary key,ename varchar(30) ,salary decimal(7,2)  )";
            Statement stm= conn.createStatement();
            // stm.execute(insertCommand);

            ResultSet rs=stm.executeQuery(query);
            ResultSetMetaData rm=rs.getMetaData();
           int cols= rm.getColumnCount();

            for ( int i = 1; i < cols; i++) {
                System.out.print(rm.getColumnName(cols) +"\t");
                System.out.print(rm.getColumnType(cols) +"\t");
                System.out.print(rm.getColumnTypeName(cols) +"\t");
                System.out.println(rm.getColumnClassName(cols));
                
            }
            // System.out.println(stm.executeQuery(query) +".....");


           rs.close();
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
