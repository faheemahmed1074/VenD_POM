package General;

import PreReq.TestBase;
import Testcases.loginTests;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import dbConnection.dbConn;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.LogHelper;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import static Config.configProperties.IsEnableRecording;
import static Config.configProperties.IsEnableReporting;
import static Config.configProperties.Url;

public class baseTest extends LogHelper {

    ExtentTest logger;
    boolean chipUpdateQuery = false;

    @BeforeSuite
    public void startReport() throws SQLException, IOException, AWTException {
        if(IsEnableReporting.equals("true"))
            MainCall.startReport();

        if(IsEnableRecording.equals("true"))
            Recorder.deleteRecordings();

        // connect db connection
        dbConn.dbConnection();

        // API's to be executed
//        MainCall.setupPreReqs();

        WebDriverFactory.getInstance();
        loginTests.loginIntoApplication();
    }

    @BeforeMethod
    public void beforeTest(Method method) throws Exception {
        if(IsEnableRecording.equals("true"))
            Recorder.startRecording(method.getName());

//        WebDriverFactory.getInstance();

        if(IsEnableReporting.equals("true")) {
            logger = MainCall.getExtentReport().startTest(method.getName(), "");
            logger.setStartedTime(getTime());
        }
    }

    @AfterMethod
    public void QuitDriver(ITestResult result) throws Exception {
        if(IsEnableReporting.equals("true")) {
            if (result.getStatus() == ITestResult.FAILURE) {
                logger.log(LogStatus.FAIL, "Test Case Failed reason is: " + result.getThrowable());
                logger.log(LogStatus.INFO, "StackTrace Result: " + Arrays.toString(result.getThrowable().getStackTrace()));
                logger.log(LogStatus.FAIL, logger.addScreenCapture(Screenshots.takeScreenshot(result.getMethod().getMethodName())));
            }
            else if (result.getStatus() == ITestResult.SKIP)
            {
                logger.log(LogStatus.SKIP, "Test Case Skipped is: " + result.getName());
            }
            else
            {
                logger.log(LogStatus.PASS, result.getMethod().getMethodName() + " is Passed");
            }

            logger.setEndedTime(getTime());
            MainCall.getExtentReport().endTest(logger);
        }


        if(IsEnableRecording.equals("true"))
            Recorder.stopRecording();
    }

    private Date getTime(){
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    @AfterSuite
    public void tearDown() {

        if(IsEnableReporting.equals("true")) {
            MainCall.getExtentReport().flush();
            MainCall.getExtentReport().close();
        }

        WebDriverFactory.finishDriver();

    }

}
