
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class DBDemoInsertResultSet {
     public static void main(String[] args) throws Exception {
        String url="jdbc:postgresql://localhost:5433/Test";
        String username="postgres";
        String password="dinakar1.";
        
            Class.forName("org.postgresql.Driver");

            Connection conn=DriverManager.getConnection(url, username,password);
            Statement stm=conn.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE
            );

            String query="select * from emp";
        ResultSet rs=stm.executeQuery(query);

        rs.moveToInsertRow();
        rs.updateInt("empno", 115);
        rs.updateString("ename", "gunar");
        rs.updateInt("salary", 20000);

        rs.insertRow();
        System.out.println("row inserted ..--..--");
        rs.moveToCurrentRow();

        ResultSetMetaData rm=rs.getMetaData();
        int cols=rm.getColumnCount();
        for (int i = 1; i <cols; i++) {
            System.out.print(rm.getColumnName(i)+"\t");
            
        }

        System.out.println();

       
       
       while (rs.next()){
        for (int i = 1; i <cols; i++) {
            System.out.print(rs.getString(i)+"\t");
            
        }
        System.out.println();

       } 


rs.close();
stm.close();
conn.close();
          
          
        
    }
    
}
