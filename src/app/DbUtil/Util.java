package app.DbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Piotr Urban on 14.01.2017.
 */
public class Util {

    private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String dbPath = "";
    private static final String user = "";
    private static final String password = "";

    public static Connection dbConnect() throws ClassNotFoundException, SQLException {

        Class.forName(driver);
        Connection conn = DriverManager.getConnection(dbPath, user, password);

        return conn;
    }

}
