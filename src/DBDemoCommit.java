import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.plaf.nimbus.State;

public class DBDemoCommit {
      public static void main(String[] args) throws Exception {
         String url="jdbc:postgresql://localhost:5433/Test";
        String username="postgres";
        String password="dinakar1.";
      
            Class.forName("org.postgresql.Driver");

            Connection conn=DriverManager.getConnection(url, username,password);
            conn.setAutoCommit(false);
            String deleteCommand=" DELETE FROM emp WHERE empno=2";
            Statement stm=conn.createStatement();
            int count=stm.executeUpdate(deleteCommand);

            if(count>0)
            System.out.println("employee deleted :)");

            else
            {
                System.out.println("no such employee :(");

            }


            conn.rollback();
            System.out.println("transaction roll back : |");

            conn.setAutoCommit(true);
            stm.close();
            conn.close();
           
    }
}
