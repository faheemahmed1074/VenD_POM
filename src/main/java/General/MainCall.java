package General;

import Objects.*;
import PreReq.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import dbConnection.dbConn;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import static Config.configProperties.BaseURI;
import static Config.configProperties.Environment;

public class MainCall {

    static ExtentReports extent;
    static Runtime run = Runtime.getRuntime();
    static File gitDir = new File(envGlobals.gitDirectory);

    public static ExtentReports startReport()
    {
        //ExtentReports(String filePath,Boolean replaceExisting)
        //filepath - path of the file, in .htm or .html format - path where your report needs to generate.
        //replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
        //True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
        //False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.
        extent = new ExtentReports(System.getProperty("user.dir") + "/reports/ExtentReport.html", true);

        //extent.addSystemInfo("Environment","Environment Name")
        extent.addSystemInfo("Environment", Environment);

        //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
        //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
        extent.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));

        return extent;
    }

    public static ExtentReports getExtentReport()
    {
        if (extent != null) {
            return extent;
        } else {
            throw new IllegalStateException("Extent Report object not initialized");
        }
    }

    public static void preReq() throws SQLException, IOException {
        // drop/delete db
        dbConn.dropDb();

        // create new db
        dbConn.createDb();
        dbConn.dbConnectionAutoDb();

        // Start localhosts
        commandExecution("lsof -ti:4007 | xargs kill", gitDir);
        commandExecution("lsof -ti:3000 | xargs kill", gitDir);
        commandExecution("npm run start_server", gitDir);
        commandExecution("npm run start_client_v2", gitDir);

    }

    public static void commandExecution(String command, File file) throws IOException {

        try {
            Runtime run = Runtime.getRuntime();
            System.out.println("Executing command: " + command);
            Process p = run.exec(command, null, file);
//            int result = p.waitFor();

//            System.out.println("Process exit code: " + result);

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

//            // Read the output from the command
//            System.out.println("Here is the standard output of the command:\n");
//            String s = null;
//            while ((s = stdInput.readLine()) != null) {
//                System.out.println(s);
//            }

//            // Read any errors from the attempted command
//            System.out.println("Here is the standard ERROR of the command (if any):\n");
//            while ((s = stdError.readLine()) != null) {
//                System.out.println(s);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setupPreReqs() throws SQLException {
        //Rest Assured config
        RestAssured.baseURI = BaseURI;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL);
        RestAssured.useRelaxedHTTPSValidation();

        TestBase.dataCreation();
        TestBase.setup();
    }


    public final static commonLocators commonLocators = new commonLocators();
    public final static loginPage loginPage = new loginPage();
    public final static navBarPage navBarPage = new navBarPage();
    public final static chipletPage chipletPage = new chipletPage();
    public final static systemPage systemPage = new systemPage();
    public final static schematicPage schematicPage = new schematicPage();
    public final static routerPage routerPage = new routerPage();
    public final static GenericFunctions genericFunctions = new GenericFunctions();
    public final static chipletLibraryPage chipletLibraryPage = new chipletLibraryPage();


}
