package mongodb;

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
        PreparedStatement pstmt = null;
        String rs = null;
        try {
            String cmd = "Execute AddDocument @collection='Account', @document='{_id : 44, val1: \"Hello world!\", val2: 3.14}'";
            pstmt = connection.prepareStatement(cmd);
            rs = String.valueOf(pstmt.execute(cmd));
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }
}