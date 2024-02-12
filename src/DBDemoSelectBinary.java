import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBDemoSelectBinary {
    public static void main(String[] args) throws Exception {
         String url="jdbc:postgresql://localhost:5433/Test";
        String username="postgres";
        String password="dinakar1.";
      
            Class.forName("org.postgresql.Driver");

            Connection conn=DriverManager.getConnection(url, username,password);
            String selectCommand="select filename,filedata from attachment where id=1";
        
            Statement stm= conn.createStatement();
            ResultSet rs= stm.executeQuery(selectCommand);
            String saveDir="./temp";
            while(rs.next()){
                String filename=rs.getString("filename");
                File saveFile=new File(saveDir,filename);
                OutputStream dest=new FileOutputStream(saveFile);
              InputStream source=  rs.getBinaryStream("filedata");
              byte[] buffer=new byte[8192];
              int bytesRead=0;
              while((bytesRead=source.read(buffer,0,8192))!=-1){
                dest.write(buffer,0,bytesRead);
              }

              source.close();
              dest.flush();
              dest.close();
              System.out.println("file saved as-------"+saveFile.getCanonicalPath());
            }
    }
}
