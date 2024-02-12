import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBDemoInsertBinary2 {
     public static void main(String[] args) throws Exception {
        String url="jdbc:postgresql://localhost:5433/Test";
        String username="postgres";
        String password="dinakar1.";
         Class.forName("org.postgresql.Driver");

            Connection conn=DriverManager.getConnection(url, username,password);
            String insertCommand="insert into attachment (filename,filedata) values (?,?)";
            PreparedStatement p=conn.prepareStatement(insertCommand,Statement.RETURN_GENERATED_KEYS);
            File file=new File("img-2.png");
            String Filename=file.getName();
            int Filelength=(int) file.length();

            byte[] data=new byte[Filelength] ;

        //    InputStream source= new FileInputStream (file);
        //    source.read(data,0,Filelength);
        //    source.close();
           p.setString(1, Filename);
          p.setBytes(2,data);
          int count= p.executeUpdate();

          if(count>0){
            System.out.println("the rows inserted"+ count);
         ResultSet rs=   p.getGeneratedKeys();
         rs.next();
         int GeneratedKey=rs.getInt(1);
         System.out.println("id assigned"+GeneratedKey);
          }

          p.close();
          conn.close();



        
    }
    
}
