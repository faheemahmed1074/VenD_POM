package Testcases;

import General.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Config.configProperties.UserName;
import static Config.configProperties.Password;

public class loginTests extends baseTest {

    @Test(description = "124640")
    public static void loginIntoApplication()
    {
        logStep("User is logged in successfully");
        System.out.println("TestCase 01");
        Assert.assertEquals(1,1);
    }

//    @Test(description = "Sign Up")
    public static void signApplication() throws InterruptedException{
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

    @Test (description = "124640")
    public static void Scrolling() throws InterruptedException {
        WebDriverFactory.getDriver().get("https://webkul.com/blog/how-to-scroll-in-a-specific-element-using-selenium-webdriver/");
        WebDriverFactory.getDriver().manage().window().maximize();

        Thread.sleep(5000);

        //scroll by 500
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,500)");

        //scroll by using Action class
//        Actions actions = new Actions(driver);
//        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();


        //scroll by element
        ((JavascriptExecutor)WebDriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView();", WebDriverFactory.getDriver().findElement(By.className("crayon-pre")));


        Thread.sleep(5000);
//        driver.quit();
    }
    @Test (description = "124640")
    public static void ListBoxDemo() throws InterruptedException {
        WebDriverFactory.getDriver().get("https://www.seleniumeasy.com/test/jquery-dual-list-box-demo.html");
        WebDriverFactory.getDriver().manage().window().maximize();
        WebElement select = WebDriverFactory.getDriver().findElement(By.className("pickListSelect"));
        Select option = new Select(select);
        option.selectByVisibleText("Alice");
        option.selectByVisibleText("Isis");
        WebDriverFactory.getDriver().findElement(By.className("pAdd")).click();
        Thread.sleep(5000);
    }



}