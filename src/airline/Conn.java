package airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {


    String url = "jdbc:mysql://localhost:3306/AMS";
    String username = "root";
    String password = "Srgakv996";

    Connection con;
    Statement stm;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            stm = con.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
