package Testcases;

import General.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static Config.configProperties.UserName;
import static Config.configProperties.Password;

public class loginTests extends baseTest {

    @Test(description = "Login App")
    public static void loginIntoZGlueApplication(){
        logStep("User is logged in successfully");

        MainCall.loginPage.clickLoginOnWelcomeScreen();
        WebDriverFactory.getDriver().findElement(By.id("log-in")).click();
        MainCall.loginPage.enterUserDetails("james@zglue.com", "Zip110ana~vd");
        MainCall.loginPage.clickGotIt();
        MainCall.loginPage.clickLogin();
        WebDriverWaits.waitUntilLoaderDisapears();
        WebDriverWaits.waitUntilElementIsClickable(MainCall.systemPage.getChipletHeadingsList().get(0));
        MainCall.loginPage.selectSkipButton();
        WebDriverWaits.waitUntilLoaderDisapears();
        WebDriverWaits.waitUntilElementIsClickable(MainCall.navBarPage.appLogo());
        MainCall.navBarPage.selectDeveloperRole();
    }

    @Test(description = "Logout App")
    public static void logoutZGlueApplication() throws InterruptedException{
//        loginIntoZGlueApplication();

        MainCall.navBarPage.selectSettingsIcon("open");
        MainCall.navBarPage.selectLogout();
        MainCall.commonLocators.selectYes();

        logStep("User is logged out successfully");
    }

//    @Test(description = "Sign Up")
    public static void signUpZGlueApplication() throws InterruptedException{
        logStep("User sign up");

        MainCall.loginPage.selectNewUser();

        String rand = GenericFunctions.generateRandomNum(3);
        envGlobals.firstName = "AutoFirst" + rand;
        envGlobals.lastName = "AutoLast" + rand;
        envGlobals.email = "AutoEmail" + rand + "@abc.com";
        envGlobals.password = "Admin123!";
        envGlobals.company = "Comapny ABC" + rand;

        MainCall.loginPage.fillSignUp(
                envGlobals.firstName, envGlobals.lastName,
                envGlobals.email, envGlobals.password,
                envGlobals.company);

        MainCall.loginPage.selectSignUpSumbit();
    }

//    @Test(description = "Forget/Reset Password")
    public static void forgetPassword() throws InterruptedException{
        logStep("User reset passowrd");

        MainCall.loginPage.selectForgetPassword();

        MainCall.loginPage.enterEmail(envGlobals.email);

        MainCall.loginPage.selectForgetPasswordSumbit();
    }

}