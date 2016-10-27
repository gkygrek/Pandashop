//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class DBC {
//    String JDBC_DRIVER = "org.postgresql.Driver";
//    //Credentials. Might differ for each database.
//    String DB_URL = "95.85.17.247/phppgadmin/5432";
//    String USER = "postgres";
//    String PASS = "pandashop";
//    String DB = "PandaWebShop";
//    String connectionString = DB_URL + DB + "?user=" + USER + "&password=" + PASS + "&useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false&maxReconnects=10";
//    //Public variable to establish SQL connection
//    Connection conn;
//
//    public void Connection() {
//        //Connection
//        try {
//            //Driver name + credentials + ip address check.
//            Class.forName(JDBC_DRIVER).newInstance();
//            conn = DriverManager.getConnection(connectionString);
//        }
//        //When something goes horribly wrong
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
