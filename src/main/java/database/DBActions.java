package database;

import com.venturedive.base.database.connection.SonarDB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBActions {

    public static String selectQuery = "select * from sonardb.automation_report where id =270926;";
    public static String updateQuery = "update sonardb.automation_report set PROJECT_NAME = 'vital' where id =270926;";
    public static String deleteQuery = "delete from  sonardb.automation_report where id =272947;";
    static SonarDB dbConn= new SonarDB();

    public static  void selectQuery() throws SQLException {
        ResultSet resultSet = dbConn.getResult(selectQuery);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("PROJECT_NAME"));
            System.out.println(resultSet.getString("Build"));
            System.out.println(resultSet.getString("platform"));
        }
    }
    public static  void updateQuery() throws SQLException {
        dbConn.executeQuery(updateQuery);
    }
    public static  void deleteQuery() throws SQLException {
        dbConn.executeQuery(deleteQuery);
    }
}
