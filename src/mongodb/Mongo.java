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
        CallableStatement cstmt = connection.prepareCall("AddDocument");
        cstmt.setString("collection", "Newmongodb");
        cstmt.setString("document", "{\"buffer\": {\n" +
                " \"$binary\": {\n" +
                " \"base64\": \"46d989eaf0bde5258029534bc2dc2089\",\n" +
                " \"subType\": \"00\"\n" +
                " }}}");
        boolean ret = cstmt.execute();
        if (ret) {
            int count = cstmt.getUpdateCount();
            if (count != -1) {
                System.out.println("Affected rows: " + count);
            }
        }
        ResultSet rs = cstmt.getResultSet();
    }
}