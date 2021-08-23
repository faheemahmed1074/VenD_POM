package dbConnection;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.util.Objects;
import java.util.stream.Stream;

import static config.ConfigProperties.*;

public class DbConn {

    static String url = dbUrl;
    static String username = dbUsername;
    static String password = dbPassword;
    static String port = dbPort;
    private static Statement statement;


    private static Connection connection = null;


    public static void connectDb(String url, String username, String password, String port) throws ClassNotFoundException, SQLException {

        if (db.equals("mysql")) {
            MysqlDataSource dataSource = new MysqlDataSource();
            if (Stream.of(url, username, password, port).anyMatch(Objects::isNull) || Stream.of(url, username, password, port).anyMatch(i -> i.isEmpty())) {
                System.out.println("Failed to read credentials for sonar DB. Please make sure the credentials are present in either config.properties or environmental variables");
            } else {
                dataSource.setServerName(url);
                dataSource.setUser(username);
                dataSource.setPassword(password);
                dataSource.setPortNumber(Integer.parseInt(port));
                dataSource.setDatabaseName("sonardb");
                dataSource.setUseSSL(false);

                try {
                    connection = dataSource.getConnection();

                } catch (Exception ex) {
                    System.out.println("Database Connection Creation Failed : " + ex.getMessage());
                }
            }
        }
        else if(db.equals("postgres"))
        {
            String userDb ="jdbc:postgresql://"+url+"?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory&user="+username+"&password="+password;
            try {
                connection = DriverManager.getConnection(userDb);
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
        else
        {
            System.out.print("Database is not connected");
        }
    }

    public static void getValueFromColumn(String query) throws SQLException  // use to get the overall values of the column
    {
        try {

            connectDb(url, username, password, port);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String Project_Name = resultSet.getString("PROJECT_NAME");
                String Build = resultSet.getString("Build");
                String platform = resultSet.getString("platform");
            }
            resultSet.close();

        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Connection Failed!");

            e.printStackTrace();
        } finally {
            statement.close();
            connection.close();
        }
    }
}

