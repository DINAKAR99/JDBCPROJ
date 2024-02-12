import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDemoCreateGetSal{
    public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5433/Test";
        String username="postgres";
        String password="dinakar1.";
        try {
            Class.forName("org.postgresql.Driver");

            Connection conn=DriverManager.getConnection(url, username,password);
           
            // String createTable="create table emp(empno int primary key,ename varchar(30) ,salary decimal(7,2)  )";
            Statement stm= conn.createStatement();
            String drop_spGetSal="DROP PROCEDURE IF EXISTS spGetSal";
            String create_spGetSal="create procedure spGetSal(in  p_empno  int ,  inout p_sal decimal(7,2)) language plpgsql as $$ "
                                       +"begin "+
                                       "select salary into p_sal from emp where empno=p_empno;"+
                                       "end ;$$";

           stm.execute(drop_spGetSal);
           stm.execute(create_spGetSal);

           System.out.println("procedure created");
           


           
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