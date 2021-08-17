package objects;

import general.MainCall;
import general.WebDriverFactory;
import general.WebDriverWaits;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static config.ConfigProperties.Url;
import static config.ConfigProperties.appConfig;
import static utils.LogHelper.logStep;

public class LoginPage
{
    public LoginPage() {}

    public static By byLoginWelcome = By.id("logout-link");

    public static By byEmail = By.name("useremail");
    public static By byPassword = By.name("password");
    public static By byLogin = By.cssSelector("span[class*='jss']");
    public static By bySkip = By.cssSelector("button[title='Skip']");
    public static By byHelpPopUpCross = By.className("help-cross-btn");

    public static By byNewUser = By.partialLinkText("New User");
    public static By byForgetPassword = By.partialLinkText("Forgot your password");

    public static By byFirstName = By.name("firstname");
    public static By byLastName = By.name("lastname");
    public static By byCompany = By.name("account_name");
    public static By byTermsAndConditionCheck = By.cssSelector("input[type='checkbox']");
    public static By bySubmit = By.className("undefined");

    public static By byH4 = By.tagName("h4");
    public static By byButton = By.tagName("button");
    public static By bySpan = By.tagName("span");
    public static By byGotItButton = By.className("cc-btn");
    public static By byButtonScroll = By.xpath("//a[text()='Discuss on Helpdesk']");
    public static By bySelector = By.className("pickListSelect");
    public static By byAdd = By.className("pAdd");

    public void enterUserDetails(String userMail, String pwd) {
        MainCall.logHelper.logStep("User enters email and password");
        MainCall.webDriverFactory.getDriver().findElement(byEmail).sendKeys(userMail);
        MainCall.webDriverFactory.getDriver().findElement(byPassword).sendKeys(pwd);
    }

    public void clickGotIt()
    {
        if (appConfig.getDevice().equals("Windows")) {
            MainCall.genericFunctions.click(byGotItButton);
          //  MainCall.webDriverFactory.getDriver().findElement(byGotItButton).click();
            MainCall.webDriverWaits.sleep(1000);
        } else {
        }
    }

    public void clickLogin(){
        MainCall.logHelper.logStep("User clicks on Login button");
        WebElement elements = MainCall.webDriverFactory.getDriver().findElement(byLogin);
        elements.click();
    }

    public void clickLoginOnWelcomeScreen(){
        MainCall.logHelper.logStep("User clicks on Login in Welcome Screen");

        if (Url.contains("localhost"))
            MainCall.webDriverFactory.getDriver().findElement(byLoginWelcome).click();
    }
    public void verifyWelcomeScreen(){
        MainCall.logHelper.logStep("Verify Welcome Screen");
        MainCall.webDriverFactory.getDriver().findElement(byLoginWelcome).click();
    }

    public void selectHelpPopUpCross(){
        MainCall.logHelper.logStep("User clicks on cross on help popup");
        MainCall.webDriverFactory.getDriver().findElement(byHelpPopUpCross).click();
    }

    public void selectSkipButton(){
        MainCall.logHelper.logStep("User clicks on Skip button");
        if (MainCall.webDriverFactory.getDriver().getPageSource().contains("title=\"Skip\"")){
            MainCall.genericFunctions.assertionToDisplayed(bySkip);
            MainCall.webDriverFactory.getDriver().findElement(bySkip).click();
        }
    }

    public void selectNewUser(){
        WebDriverFactory.getDriver().findElement(byNewUser).click();
    }

    public void selectForgetPassword(){
        MainCall.webDriverFactory.getDriver().findElement(byForgetPassword).click();
        MainCall.genericFunctions.assertion(byH4,"Reset Password");
    }

    public void enterEmail(String email){
        MainCall.webDriverFactory.getDriver().findElement(byEmail).sendKeys(email);
    }

    public void fillSignUp(){
        String rand = MainCall.genericFunctions.generateRandomNum(3);
        MainCall.envGlobals.firstName = "AutoFirst" + rand;
        MainCall.envGlobals.lastName = "AutoLast" + rand;
        MainCall.envGlobals.email = "AutoEmail" + rand + "@abc.com";
        MainCall.envGlobals.password = "Admin123!";
        MainCall.envGlobals.company = "Comapny ABC" + rand;
        MainCall.webDriverFactory.getDriver().findElement(byFirstName).sendKeys(MainCall.envGlobals.firstName);
        MainCall.webDriverFactory.getDriver().findElement(byLastName).sendKeys( MainCall.envGlobals.lastName);
        MainCall.webDriverFactory.getDriver().findElement(byEmail).sendKeys(MainCall.envGlobals.email );
        MainCall.webDriverFactory.getDriver().findElement(byPassword).sendKeys(MainCall.envGlobals.password );
        MainCall.webDriverFactory.getDriver().findElement(byCompany).sendKeys(MainCall.envGlobals.company);
        MainCall.webDriverFactory.getDriver().findElement(byTermsAndConditionCheck).click();
    }

    public void selectForgetPasswordSumbit(){
        MainCall.webDriverFactory.getDriver().findElements(byButton).get(1).findElements(bySpan).get(1).click();
    }

    public void selectSignUpSumbit(){

        MainCall.webDriverFactory.getDriver().findElement(bySubmit).click();
    }

    public void scrollToElement()
     {
    MainCall.genericFunctions.scrollToElement(byButtonScroll);
     }
    public void selectValues(String value1,String value2)
    {
        MainCall.genericFunctions.selectElementFromDropDownByText(bySelector,value1);
        MainCall.genericFunctions.selectElementFromDropDownByText(bySelector,value2);
        MainCall.webDriverFactory.getDriver().findElement(byAdd).click();
    }
}

