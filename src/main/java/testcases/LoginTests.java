package testcases;

import general.*;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(description = "124640")
    public static void loginIntoApplication() throws InterruptedException {
        MainCall.logHelper.logStep("User is logged in successfully");
        MainCall.genericFunctions.assertion(1,1);
        MainCall.genericFunctions.PercyCapture("loginIntoApplication");
    }

//    @Test(description = "Sign Up")
    public static void signApplication() throws InterruptedException{
        MainCall.logHelper.logStep("User sign up");
        MainCall.loginPage.selectNewUser();
        MainCall.loginPage.fillSignUp();
        MainCall.loginPage.selectSignUpSumbit();
    }

//    @Test(description = "Forget/Reset Password")
    public static void forgetPassword() throws InterruptedException{
        MainCall.logHelper.logStep("User reset passowrd");
        MainCall.loginPage.selectForgetPassword();
        MainCall.loginPage.enterEmail(EnvGlobals.email);
        MainCall.loginPage.selectForgetPasswordSumbit();
    }

    @Test (description = "124640")
    public static void Scrolling() throws InterruptedException {
        MainCall.genericFunctions.driverStart("https://webkul.com/blog/how-to-scroll-in-a-specific-element-using-selenium-webdriver/");
        MainCall.webDriverWaits.sleep(5000);
        MainCall.loginPage.scrollToElement();
        Thread.sleep(5000);
    }
    @Test (description = "124640")
    public static void ListBoxDemo() throws InterruptedException {
        MainCall.genericFunctions.driverStart("https://www.seleniumeasy.com/test/jquery-dual-list-box-demo.html");
        MainCall.webDriverWaits.sleep(2000);
        MainCall.loginPage.selectValues("Alice","Isis");
        MainCall.webDriverWaits.sleep(2000);
        MainCall.genericFunctions.PercyCapture("ListBox");
    }



}