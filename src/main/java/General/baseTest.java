package General;

import PreReq.TestBase;
import Testcases.TrainingSession;
import Testcases.loginTests;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.venturedive.base.config.BaseConfigProperties;
import com.venturedive.base.exception.APIException;
import com.venturedive.base.utility.JIRA;
import com.venturedive.base.utility.ReusableFunctions;
import com.venturedive.base.utility.TestRail;
import dbConnection.dbConn;
import static General.envGlobals.Differnce;
import org.testng.ITestContext;
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
import static Config.configProperties.LogTestRail;
import static Config.configProperties.Url;

public class baseTest extends LogHelper {

    ExtentTest logger;
    boolean chipUpdateQuery = false;

    //    For Reporting to insert into database
    static Date startTime = null;
    static Date endTime = null;
    static Integer passedCount = 0;
    static Integer failedCount = 0;
    static Integer skippedCount = 0;



    @BeforeSuite
    public void beforesuite(ITestContext ctx) throws SQLException, IOException, AWTException, APIException {
        if(IsEnableReporting.equals("true"))
            MainCall.startReport();
        if(IsEnableRecording.equals("true"))
            Recorder.deleteRecordings();
        // connect db connection
//        dbConn.dbConnection();
        startReport();
        if (LogTestRail.equals("true")){
            TestRail.createSuite(ctx);
        }
        WebDriverFactory.getInstance();
        loginTests.loginIntoApplication();
    }
    public void startReport() {
        if (IsEnableReporting.equals("true")) {
            MainCall.startReport();
        }
        startTime = getTime(); // For reporting into db
    }

    @BeforeMethod
    public void beforeTest(Method method) throws Exception {
        if(IsEnableRecording.equals("true"))
            Recorder.startRecording(method.getName());

//        WebDriverFactory.getInstance();

        // To set Base url & content type
        if (LogTestRail.equals("true")){
            MainCall.restAssuredPreReq();
        }
        if(IsEnableReporting.equals("true")) {
            logger = MainCall.getExtentReport().startTest(method.getName(), "");
            logger.setStartedTime(getTime());
        }
    }

    @AfterMethod
    public void QuitDriver(ITestResult result, ITestContext ctx, Method method) throws Exception {
        if (LogTestRail.equals("true")){
            TestRail.posttotestrail(result, ctx, method);
        }
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

            if (IsEnableReporting.equals("true")) {

                if (result.getStatus() == ITestResult.FAILURE) {

                    failedCount++;
                    logger.log(LogStatus.FAIL, "Test Case Failed reason is: " + result.getThrowable());
                    logger.log(LogStatus.FAIL, "Test Case Failed reason is: " + Differnce.toString());

                    if (BaseConfigProperties.LogJIRA.equals("True"))
                    {
                        JIRA.CreateJira(result);
                    }

//                logger.log(LogStatus.FAIL, logger.addScreenCapture(Screenshots.takeScreenshot(result.getMethod()
//                        .getMethodName())));
                } else if (result.getStatus() == ITestResult.SKIP) {

                    skippedCount++;
                    logger.log(LogStatus.SKIP, "Test Case Skipped is: " + result.getName());
                } else if (result.getStatus() == ITestResult.SUCCESS) {

                    passedCount++;
                    logger.log(LogStatus.PASS, result.getMethod().getMethodName() + " is Passed");
                    logger.log(LogStatus.PASS, "All the Assertions have been Passed");

//                    logger.log(LogStatus.PASS, ReusableFunctions.getResponse());
                }

                logger.setEndedTime(getTime());
                MainCall.getExtentReport().endTest(logger);

                // Enable below line to print response of every API
//                System.out.println("method name: " + result.getMethod().getMethodName());
//                ReusableFunctions.printResponse();
            }
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
