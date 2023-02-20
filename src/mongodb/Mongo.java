package mongodb;
import java.sql.*;
public class Mongo {
    public static void main(String[] args) throws SQLException {
        Connection connection;
        connection = DriverManager.getConnection("jdbc:mongodb:Server=localhost;Database=Manitest;");
        Statement stat = connection.createStatement();
        CallableStatement cstmt = connection.prepareCall("AddDocument");
        cstmt.setString("collection", "dummy");
        cstmt.setString("document", "{_id:\"some-id\",buffer:\"hello\"}");
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