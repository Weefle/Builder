package net.jrbudda.builder.libs.utils;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLUtils {
    /**
     * Creates a new connection to a MySQL database.
     * @param host the IP address or hostname of its MySQL server (the default is localhost or 127.0.0.1)
     * @param port the TCP/IP port which is listening by its MySQL server (the default is 3306)
     * @param database the name of the database
     * @param useSSL uses to enable SSL encryption
     * @param user the name of an user
     * @param pass the password of an user
     */
    public Connection createMySQLConnection(String host, int port, String database, boolean useSSL, String user, String pass) throws SQLException, ClassNotFoundException {
        ExceptionThrower.ifNull(host, new Exception("Hostname must not be null"));
        ExceptionThrower.ifNull(database, new Exception("Database name must not be null"));
        ExceptionThrower.ifNull(user, new Exception("Username must not be null"));
        ExceptionThrower.ifNull(pass, new Exception("Password must not be null"));
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?useSSL="+useSSL, user, pass);
    }

    /**
     * Creates a new connection to a SQLite database
     * @param dbfile database file.
     */
    public Connection createSQLiteConnection(File dbfile) throws SQLException, ClassNotFoundException {
        ExceptionThrower.ifNull(dbfile, new Exception("Database file must not be null"));
        ExceptionThrower.ifFalse(dbfile.exists(), new Exception("Database file must be existed"));
        Class.forName("org.sqlite.JDBC");
        return DriverManager.getConnection("jdbc:sqlite:" + dbfile.getPath());
    }
}
