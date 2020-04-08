package dbConnection;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Config.configProperties.*;
import static utils.LogHelper.logStep;

public class dbConn {
    //DB Credentials
    private static String autoName = dbAutoName;
    private static String name = dbName;
    private static String url = dbUrl;
    private static String username = dbUsername;
    private static String password = dbPassword;

    private static Connection connection = null;
    private static ResultSet resultSet = null;
    private static Statement statement = null;

    private static String query = "";

    private static File folder = new File("./dbScripts/zGlue DB");
    private static List<String> fileNames = new ArrayList<>();


    public static void connectDb(String url, String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver"); // load postgresql driver
        connection = DriverManager.getConnection(url, username, password); //DB connection
    }

    public static void dbConnection() {
        try {
            connectDb(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        }
    }

    public static void dbConnectionAutoDb() {
        try {
            connectDb(url+autoName, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        }
    }

    public static void getSchema() throws SQLException {

        // --- LISTING DATABASE SCHEMA NAMES ---
        ResultSet resultSet = connection.getMetaData().getCatalogs();
        while (resultSet.next()) {
            logStep("Schema Name = " + resultSet.getString("TABLE_CAT"));
        }
        resultSet.close();
        // --- LISTING DATABASE TABLE NAMES ---
        String[] types = { "TABLE" };
        resultSet = connection.getMetaData()
                .getTables(name, null, "%", types);
        String tableName = "";
        while (resultSet.next()) {
            tableName = resultSet.getString(3);
            logStep("Table Name = " + tableName);
        }
        resultSet.close();
        // --- LISTING DATABASE COLUMN NAMES ---
        DatabaseMetaData meta = connection.getMetaData();
        resultSet = meta.getColumns(name, null, tableName, "%");
        while (resultSet.next()) {
            logStep("Column Name of table " + tableName + " = "
                    + resultSet.getString(4));
        }
    }

    public static void createDb() throws SQLException {
        statement = connection.createStatement();
        query = "CREATE DATABASE " + autoName + ";";
        statement.executeUpdate(query);
        logStep("New DB created : " + autoName);
    }

    public static void switchDb() throws SQLException {
        connection.setCatalog(autoName);
        logStep("DB switched to " + autoName);
    }

    public static void dropDb() throws SQLException {
        statement = connection.createStatement();
        query = "DROP DATABASE " + autoName + ";";
        statement.executeUpdate(query);
        logStep("DB dropped/deleted : " + autoName);
    }

    public static void addDatabaseDump() throws SQLException, IOException {
//        statement = connection.createStatement();
//        query = readFile();
//        statement.executeUpdate(query);
//        logStep("Schema query executed successfully");

        listFilesForFolder(folder);
        Collections.sort(fileNames);

        for (int i=1 ; i<fileNames.size() ; i++) {
            File file = new File(folder  + "/" + fileNames.get(i));
            query  = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println(fileNames.get(i) + " executed successfully");
        }
        logStep("Data Dump queries executed successfully");
    }

    public static String readFile() throws IOException {
        File file = new File("./dbScripts/Schema.txt");
        return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
    }

    public static void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                fileNames.add(fileEntry.getName());
            }
        }
    }

    public static int getChipletId() throws SQLException {
        int chipId = 0;
        String query = "select id from chips where mpn='SIT1552';";

        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            chipId = resultSet.getInt("id");
        }
        resultSet.close();

        System.out.println("chiplet id = " + chipId);

        return chipId;
    }

    public static void updateChipsStatus() throws SQLException {
        statement = connection.createStatement();
        query = "update chips set status = 'enabled';";
        statement.executeUpdate(query);
        logStep("Chips status updated successfully");
    }

    public static List<String> getSystemIds(String name) throws SQLException {
        List<String> ids = new ArrayList<>();

        String query = "select zcad_system_id, arch_id, arch_tile_id from sys where name='" + name + "';";

        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            ids.add(String.valueOf(resultSet.getInt("zcad_system_id")));
            ids.add(String.valueOf(resultSet.getInt("arch_id")));
            ids.add(String.valueOf(resultSet.getInt("arch_tile_id")));
        }
        resultSet.close();

        return ids;
    }


}

