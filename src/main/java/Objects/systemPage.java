package Objects;

import General.GenericFunctions;
import General.MainCall;
import General.WebDriverFactory;
import General.WebDriverWaits;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import static Config.configProperties.chipSystem;
import static Testcases.loginTests.loginIntoZGlueApplication;
import static Testcases.systemTests.saveAsName;
import static utils.LogHelper.logStep;

public class systemPage {
    public systemPage(){}

    //System Page Functions

    public static By byChipSystemPage = By.className("elementbox");
    public static By byChipletSystemName = By.className("primary-heading");

    public static By bySystemNameField = By.name("name");
    public static By byFormInput = By.className("form-input");
    public static By byArchitecture = By.className("architecture-select-box");
    public static By byTileSize = By.className("tilesize-select-box");
    public static By byDropDownOptions = By.cssSelector("ul[role='listbox']");
    public static By byImportsystem = By.id("system-file-input");

    public static By byH2 = By.tagName("h2");
    public static By byLi = By.tagName("li");
    public static By byButton = By.tagName("button");

    public static By byAlert = By.className("message-text-dropdown");

    public static By byListAction = By.className("list-action");
    public static By byToggleLeftMenu = By.className("toggle-left-menu");
    public static By bySearchField = By.id("input-with-icon-textfield");

    public static void enterSystemName(String name){
        logStep("User enters system name");
        WebDriverFactory.getDriver().findElement(bySystemNameField).sendKeys(name);
    }

    public void selectArchitectureDropDown(){
        logStep("User selects Architecture dropdown");
        WebDriverFactory.getDriver().findElement(byArchitecture).findElement(byFormInput).click();
    }
    public void selectTileSizeDropDown(){
        logStep("User selects Tile Size dropdown");
        WebDriverFactory.getDriver().findElement(byTileSize).findElement(byFormInput).click();
    }

    public void verifySystemSearched(String search){
        logStep("Verify system is searchable successfully " + search);
        WebDriverFactory.getDriver().findElement(bySearchField).sendKeys(search);
        Assert.assertTrue(getChipletHeadingsList().get(0).getText().contains(search));
    }

    public void selectDropDownOption(int no){
        WebDriverWaits.sleep250();
        WebDriverFactory.getDriver().findElement(byDropDownOptions).findElements(byLi).get(no).click();
        WebDriverWaits.sleep250();
    }

    public void selectImportSystem(){
        logStep("User selects Import From File");
        WebDriverFactory.getDriver().findElement(byImportsystem).click();
        WebDriverWaits.sleep1000();
    }

    public void selectDeleteSystem(){
        logStep("User selects Delete Zip");
        WebDriverFactory.getDriver().findElement(byListAction).findElements(byButton).get(4).click();
    }

    public static void selectFromDropDown(String option){
        List<WebElement> list = WebDriverFactory.getDriver().findElement(byToggleLeftMenu).findElements(byButton);

        for (int i=0; i<list.size() ; i++) {
            if (list.get(i).getText().equals(option)) {
                list.get(i).click();
            }
        }
    }

    public List<WebElement> chipletList(){
        return WebDriverFactory.getDriver().findElements(byChipSystemPage);
    }

    public void selectChiplet(int no){
        logStep("User selects chiplet number '" + no + "' from System page");
        chipletList().get(no).click();
    }

    public List<WebElement> getChipletHeadingsList(){
        return WebDriverFactory.getDriver().findElements(byChipletSystemName);
    }

    public void selectSystemByName(String chipName){
        logStep("User selects chiplet " + chipName);
        String chipHeading = "";

        for (int i=0; i<getChipletHeadingsList().size() ; i++){
            chipHeading = StringUtils.substringBefore(getChipletHeadingsList().get(i).getText(), " ("); // returns chipHeading before "("

            if (chipHeading.equals(chipName)){
                selectChiplet(i);
                break;
            }
        }

        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.chipletPage.openAllContainers();
    }

    public void selectTestSystemByName(String systemId){
        logStep("User selects chiplet id " + systemId);
        String chipHeading = "";

        for (int i=0; i<getChipletHeadingsList().size() ; i++){
            chipHeading = StringUtils.substringBetween(getChipletHeadingsList().get(i).getText(), "(Id: ", ")"); // returns chipHeading between

            if (chipHeading.equals(systemId)){
                selectChiplet(i);
                break;
            }
        }

        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.chipletPage.openAllContainers();
    }

    public void verifySystemDeleted(String chipName) throws InterruptedException {
        logStep("Verify system is deleted successfully");

//        check 1st system board
        Assert.assertFalse(getChipletHeadingsList().get(0).getText().equals(chipName));

////        check all system boards
//        for (int i=0; i<getChipletHeadingsList().size() ; i++){
//            Assert.assertFalse(getChipletHeadingsList().get(i).getText().equals(chipName));
//        }
    }

    public void deleteSystem(){
        MainCall.navBarPage.selectSystemName();
        MainCall.systemPage.selectFromDropDown("Delete ZiP");
        MainCall.commonLocators.selectYes();

        WebDriverWaits.waitUntilLoaderDisapears();
    }

    public void selectDefaultSystem(){
        // FROM GIT
//        loginIntoZGlueApplication();
//        MainCall.navBarPage.selectDeveloperRole();

        MainCall.systemPage.selectSystemByName(chipSystem);
        WebDriverWaits.waitUntilLoaderDisapears();

//        MainCall.chipletPage.fillMarginValuesAndSave(marginValues);
        MainCall.commonLocators.verifyRightContainer();


//        // NEW WORK
//        String systemName = chipSystem.toString();
//
//        loginIntoZGlueApplication();
//
//        MainCall.navBarPage.selectDeveloperRole();
//        selectSystemByName(systemName);
//
//        WebDriverWaits.waitUntilElementIsClickable(MainCall.navBarPage.systemName());
//        MainCall.chipletPage.removeAllChiplets();
    }

    public void searchAndSelectSystem(String sysName){
        verifySystemSearched(sysName);

        selectSystemByName(sysName);

        WebDriverWaits.waitUntilElementIsClickable(MainCall.navBarPage.systemName());
        MainCall.navBarPage.verifySystemNameTitle(sysName);
    }

    public void saveAsTestSystem(String sysName){
        saveAsName = "_Save-As" + GenericFunctions.generateRandomNum(5);

        MainCall.navBarPage.selectSystemName();
        systemPage.selectFromDropDown("Save As");

        systemPage.enterSystemName(saveAsName);
        MainCall.commonLocators.selectSave();

        WebDriverWaits.waitUntilLoaderDisapears();
        while (WebDriverFactory.getDriver().getPageSource().contains("s-alert-close")) {
            MainCall.commonLocators.verifySuccessNotif();
        }
        MainCall.navBarPage.verifySystemNameTitle(sysName+saveAsName);
    }

}
