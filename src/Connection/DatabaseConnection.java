package Connection;
import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseConnection {
   static Connection conn = null;
   public static Connection getConnection() {
      if (conn != null) return conn;
//      String database = "university";
      String database = "tests";
      String Username = "root";
      String password = "root";
      return getConnection(database, Username, password);
   }
   private static Connection getConnection(String databaseName, String UserName, String password) {
      try {
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName + "?user=" + UserName + "&password=" + password);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return conn;
   }
}