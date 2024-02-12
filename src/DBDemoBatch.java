import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDemoBatch {
    public static void main(String[] args) throws Exception {
        String url="jdbc:postgresql://localhost:5433/Test";
        String username="postgres";
        String password="dinakar1.";
        
            Class.forName("org.postgresql.Driver");

            Connection conn=DriverManager.getConnection(url, username,password);
           
            // String createTable="create table emp(empno int primary key,ename varchar(30) ,salary decimal(7,2)  )";
            Statement stm= conn.createStatement();
            stm.addBatch("INSERT INTO emp VALUES(107,'A7',10000)");
            stm.addBatch("INSERT INTO emp VALUES(108,'A8',10000)");
            stm.addBatch("INSERT INTO emp VALUES(109,'A9',10000)");
            int count[];
        try{
            count= stm.executeBatch();
        }
        
       catch (BatchUpdateException e) {
            // TODO Auto-generated catch block
            count=e.getUpdateCounts();
        }

        System.out.println();
        for (int i = 0; i < count.length; i++) {

            switch (count[i]) {
                case Statement.SUCCESS_NO_INFO:
                System.out.println("SUCCESS_NO_INFO");
                    
                    break;
                case Statement.EXECUTE_FAILED:
                System.out.println("EXECUTE_FAILED");
                    
                    break;
            
                default:
                    System.out.println(count[i]+"rows affected");
                    break;
            }
            
        }

        stm.close();
        conn.close();
    }


}
