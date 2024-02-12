import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class DBDemoCallGetSal {
     public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5433/Test";
        String username="postgres";
        String password="dinakar1.";
        try {
            Class.forName("org.postgresql.Driver");

            Connection conn=DriverManager.getConnection(url, username,password);
           
           CallableStatement cs= conn.prepareCall("call spGetSal(?,?)");
           cs.setInt(1, 101);
         
        //    cs.setInt(3, 5);
           cs.registerOutParameter(2, Types.DECIMAL);


cs.execute();
        //    try{

        //        cs.execute();
        //    }

           BigDecimal salary=cs.getBigDecimal(2);


           if (cs.wasNull()){
            System.out.println("sal is null");
           }
           else{
            System.out.println("sal is "+salary);
           }


         
            conn.close();


        }
        
        
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
