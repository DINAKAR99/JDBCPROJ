import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDemoSelect2 {
     public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5433/Test";
        String username="postgres";
        String password="dinakar1.";
        try {
            Class.forName("org.postgresql.Driver");

            Connection conn=DriverManager.getConnection(url, username,password);
            String query="select * from emp ";
            // String createTable="create table emp(empno int primary key,ename varchar(30) ,salary decimal(7,2)  )";
            Statement stm= conn.createStatement();
            // stm.execute(insertCommand);

            ResultSet rs=stm.executeQuery(query);
            ResultSetMetaData rm=rs.getMetaData();
           int cols= rm.getColumnCount();

            for ( int i = 1; i < cols; i++) {
                System.out.print(rm.getColumnName(i) +"\t");

                
                
            }
System.out.println();
            while (rs.next()){
                int empNo=rs.getInt(1);
                String ename= rs.getString(2);
                Double sal= rs.getDouble(3);
                String salDisplay;
                boolean salIsNull=rs.wasNull();
                if(salIsNull){
                    salDisplay="null";
                }
                else{
                    salDisplay=String.valueOf(sal);
                }

                
                System.out.println(empNo+'\t'+ename+'\t'+salDisplay+'\t');
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
