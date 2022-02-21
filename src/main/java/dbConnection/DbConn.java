package dbConnection;
import com.venturedive.base.database.connection.SonarDB;
import java.sql.*;
public class DbConn {

    static SonarDB dbconn= new SonarDB();
    private static Statement statement;
    public static Connection connection;
    public static void getValueFromColumn(String query) throws SQLException  // use to get the overall values of the column
    {
        try {
            connection = dbconn.connectDb();
            ResultSet resultSet;
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("PROJECT_NAME"));
                System.out.println(resultSet.getString("Build"));
                System.out.println(resultSet.getString("platform"));
            }
            resultSet.close();

        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        } finally {
            statement.close();
            connection.close();
        }
    }
}

