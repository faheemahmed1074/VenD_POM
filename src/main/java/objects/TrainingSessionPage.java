package objects;

import general.MainCall;
import org.openqa.selenium.By;
public class TrainingSessionPage {
    public static By byAlertButton = By.className("btn-primary");
    public static By bySlideBar = By.id("slider3");
    public static By byRange =By.name("range");
    public static By bySuccess = By.id("rangeSuccess");
    public static By byPromptAlertButton = By.className("btn-default");
    public static By byFirstName = By.name("first_name");
    public static By byLastName = By.name("last_name");
    public static By byEmail = By.name("email");
    public static By byPhone = By.name("phone");
    public static By byAddress = By.name("address");
    public static By byCity = By.name("city");
    public static By byState = By.name("state");
    public static By byZip  = By.name("zip");
    public static By byWebsite = By.name("website");
    public static By byRadioButton = By.cssSelector("input[type='radio']");

    public TrainingSessionPage() {
    }

  public void openMultipleModalAlert()
  {

      MainCall.genericFunctions.clickSpecificElementFromList(byAlertButton,2);
  }
  public void slideThirdRangeSlider()
  {

      MainCall.genericFunctions.slideBar(bySlideBar,byRange,60,0);
  }

  public void verifySuccessMessage()
  {

      MainCall.genericFunctions.assertion(bySuccess,"66");
  }

  public void EnterTextInAlertBox() throws InterruptedException {
      MainCall.genericFunctions.clickSpecificElementFromList(byPromptAlertButton,2);
      MainCall.webDriverWaits.sleep(2000);
      MainCall.genericFunctions.inputTextAlert("Training Session 02");
      MainCall.webDriverWaits.sleep(2000);
      MainCall.genericFunctions.acceptAlert();
      MainCall.webDriverWaits.sleep(2000);
  }
  public void fillForm() throws InterruptedException {
      MainCall.webDriverFactory.getDriver().findElement(byFirstName).sendKeys("firstnme");
      MainCall.webDriverFactory.getDriver().findElement(byLastName).sendKeys("lastname");
      MainCall.webDriverFactory.getDriver().findElement(byEmail).sendKeys("spider@gmail.com");
      MainCall.webDriverFactory.getDriver().findElement(byPhone).sendKeys("(92)3336401111");
      MainCall.webDriverFactory.getDriver().findElement(byAddress).sendKeys("my home address");
      MainCall.webDriverFactory.getDriver().findElement(byCity).sendKeys("My city");
      MainCall.genericFunctions.selectElementFromDropDownByText(byState,"California");
      MainCall.webDriverFactory.getDriver().findElement(byZip).sendKeys("86400");
      MainCall.webDriverFactory.getDriver().findElement(byWebsite).sendKeys("https://www.google.com");
      MainCall.genericFunctions.radioButtonClick(byRadioButton,1);
      MainCall.webDriverWaits.sleep(2000);
  }
}
