import java.io.InputStream;
import java.util.Arrays;
import java.sql.*;
import java.util.Base64;
public class Mongo {
    public static void main(String[] args) throws SQLException {
        //Registering the Driver
        Connection connection;
        connection = DriverManager.getConnection("jdbc:mongodb:Server=localhost;Database=Manitest;");
        Statement stat = connection.createStatement();
        String cmd = "INSERT INTO Manitest.Testdrill (buffer) VALUES (?)";
        PreparedStatement pstmt = connection.prepareStatement(cmd);
        String base64 = "46d989eaf0bde5258029534bc2dc2089";
        byte[] binaryData = Base64.getDecoder().decode(base64);
        pstmt.setBytes(1, binaryData);
        int count = pstmt.executeUpdate();
        System.out.println(count + " rows were affected");
        connection.close();
    }
}