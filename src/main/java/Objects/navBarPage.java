package Objects;

import General.MainCall;
import General.WebDriverFactory;
import General.WebDriverWaits;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static utils.LogHelper.logStep;

public class navBarPage {
    public navBarPage(){}

    //navBar Page Functions

    public static By byAppLogo = By.className("app-logo");

    public static By byNotificationIcon = By.id("notification-button");
    public static By byNewSystemIcon = By.id("add-system-icon");
    public static By byInfoIcon = By.id("info-button");
    public static By byChipletLibraryIcon = By.id("chiplet-library-button");
    public static By bySettingsIcon = By.id("settings-button");

    public static By byUserSettings = By.className("user-settings");
    public static By byProfile = By.id("profile-link");
    public static By byFeedback = By.id("feedback-link");
    public static By byApplicationNotes = By.id("application-notes-link");
    public static By byRole = By.cssSelector(".user-settings li:nth-child(4)");
    public static By byLogout = By.id("logout-link");

    public static By byDropDown = By.className("dropdown-lg");
    public static By byAlertContainer = By.className("alert-container");

    public static By byUl = By.tagName("ul");
    public static By byLi = By.tagName("li");
    public static By byP = By.tagName("p");
    public static By bySpan = By.tagName("span");
    public static By bySvg = By.tagName("svg");

    public static By byAdmin = By.id("admin");
    public static By byDevelepor = By.id("developer");
    public static By byBusiness = By.id("business");
    public static By byManufacturer = By.id("manufacturer");
    public static By bySupplier = By.id("supplier");

    public static By bySystemName = By.id("system-button");
    public static By bySystemNameTitle = By.className("system-name-title");

    public static By bySelect = By.id("view-select");
    public static By byBuild = By.id("view-build");
    public static By byOptimize = By.id("view-optimize");
    public static By byCode = By.id("view-code");
    public static By byMake = By.id("view-make");

    public WebElement appLogo() {
        return WebDriverFactory.getDriver().findElement(byAppLogo);
    }

    public void selectAppLogo() {
        logStep("User clicks on App Logo on Nav bar");
        WebDriverFactory.getDriver().findElement(byAppLogo).click();
    }

    public void selectNewSystemIcon() {
        logStep("User clicks on New System icon on Nav bar");
        WebDriverFactory.getDriver().findElement(byNewSystemIcon).click();
    }
    public void selectInfoIcon() {
        logStep("User clicks on Info icon on Nav bar");
        WebDriverFactory.getDriver().findElement(byInfoIcon).click();
    }
    public void selectChipletLibraryIcon() {
        logStep("User clicks on Chiplet Library icon on Nav bar");
        WebDriverFactory.getDriver().findElement(byChipletLibraryIcon).click();
    }
    public void selectSettingsIcon(String display) {
        logStep("User clicks on Settings icon on Nav bar");
        WebDriverFactory.getDriver().findElement(bySettingsIcon).click();
        if (display.equalsIgnoreCase("open"))
            WebDriverWaits.visibilityOf(WebDriverFactory.getDriver().findElement(byUserSettings));
    }
    public void selectNotificationIcon() {
        logStep("User clicks on Notification icon on Nav bar");
        WebDriverFactory.getDriver().findElement(byNotificationIcon).click();
    }

    public void selectProfile() {
        logStep("User clicks on Profile");
        WebDriverFactory.getDriver().findElement(byProfile).click();
    }
    public void selectFeedback() {
        logStep("User clicks on Feedback");
        WebDriverFactory.getDriver().findElement(byFeedback).click();
    }
    public void selectApplicationNotes() {
        logStep("User clicks on Application Notes");
        WebDriverFactory.getDriver().findElement(byApplicationNotes).click();
    }
    public WebElement selectRole() {
        logStep("User clicks on Role");
        List<WebElement> userSettingsList = WebDriverFactory.getDriver().findElement(byUserSettings).findElements(byLi);
        for (int i=0 ; i<userSettingsList.size() ; i++) {
            if (userSettingsList.get(i).getText().equals("Role")) {
//                userSettingsList.get(i).click();
                return userSettingsList.get(i);
//                break;
            }
        }
        return null;
    }
    public void selectLogout() {
        logStep("User clicks on Logout");
        WebDriverFactory.getDriver().findElement(byLogout).click();
    }

    public void selectAdmin() {
        logStep("User clicks on Admin");
        WebDriverFactory.getDriver().findElement(byAdmin).click();
    }
    public void selectDeveloper() {
        logStep("User clicks on Developer");
        WebDriverFactory.getDriver().findElement(byDevelepor).click();
    }
    public void selectBusiness() {
        logStep("User clicks on Business");
        WebDriverFactory.getDriver().findElement(byBusiness).click();
    }
    public void selectManufacturer() {
        logStep("User clicks on Manufacturer");
        WebDriverFactory.getDriver().findElement(byManufacturer).click();
    }
    public void selectSupplier() {
        logStep("User clicks on Supplier");
        WebDriverFactory.getDriver().findElement(bySupplier).click();
    }

    public void selectRoleDropDown(){
        selectSettingsIcon("open");
        selectRole().click();
    }
    public void selectDeveloperRole() {
        selectRoleDropDown();
        WebElement developer = WebDriverFactory.getDriver().findElement(byDevelepor);
//        if (!developer.getAttribute("class").contains("SettingsButton-ListItem")) {
            do {
                selectDeveloper();
                WebDriverWaits.sleep(2000);
            } while (!developer.getCssValue("font-weight").equals("500"));
//            WebDriverWaits.waitUntilRoleSelected(developer);
//        }
        selectSettingsIcon("close");
    }

    public void selectAdminRole() {
        selectRoleDropDown();
        if (!WebDriverFactory.getDriver().findElement(byAdmin).getAttribute("class").contains("SettingsButton-ListItem")) {
            selectAdmin();
            WebDriverWaits.sleep(3000);
//            WebDriverWaits.waitUntilRoleSelected(byDevelepor);
        }
    }

    public WebElement systemName() {
        return WebDriverFactory.getDriver().findElement(bySystemName);
    }
    public void selectSystemName() {
        logStep("User clicks on System Name");
        WebDriverFactory.getDriver().findElement(bySystemName).click();
    }
    public void verifySystemNameTitle(String name){
        logStep("Verify system is created successfully: " + name);
        Assert.assertTrue(WebDriverFactory.getDriver().findElement(bySystemNameTitle).getText().equals(name));
        WebDriverWaits.visibilityOfMainBoard();
    }

    public void fetchNotifErrors(){
        WebElement notif = WebDriverFactory.getDriver().findElement(byNotificationIcon);
        List<WebElement> list = new ArrayList<>();
        List<WebElement> errorsListContainer = new ArrayList<>();
        List<String> errorListText = new ArrayList<>();
        List<WebElement> errorList = new ArrayList<>();

        if (notif.findElement(bySpan).getAttribute("class").contains("red")){
            logStep("Check error messages");

            selectNotificationIcon();
            list = WebDriverFactory.getDriver().findElement(byDropDown).findElement(byUl).findElements(byLi);
            for (int i=0 ; i<list.size() ; i++) {
//                list.get(i).click();

                errorsListContainer = list.get(i).findElements(byAlertContainer);
                for (int j=0; j<errorsListContainer.size() ; j++){
                    errorList = errorsListContainer.get(j).findElements(byP);

                    for (int k=0 ; k<errorList.size() ; k++) {
                        if (errorList.get(k).getAttribute("class").contains("error"))
                            errorListText.add(errorList.get(k).getText());
                    }
                }
            }
        }

        for (int i=0 ; i<errorListText.size() ; i++)
            logStep(errorListText.get(i));

    }

    public void selectSelect() {
        logStep("User clicks on Select on Nav bar");
        WebDriverFactory.getDriver().findElement(bySelect).click();
    }
    public void selectBuild() {
        logStep("User clicks on Build on Nav bar");
        WebDriverFactory.getDriver().findElement(byBuild).click();
        WebDriverWaits.visibilityOfSchematicView();
    }
    public void selectOptimize() {
        logStep("User clicks on Optimize on Nav bar");
        WebDriverFactory.getDriver().findElement(byOptimize).click();
        MainCall.chipletPage.openAllContainers();
    }
    public void selectCode() {
        logStep("User clicks on Code on Nav bar");
        WebDriverFactory.getDriver().findElement(byCode).click();
    }
    public void selectMake() {
        logStep("User clicks on Make on Nav bar");
        WebDriverFactory.getDriver().findElement(byMake).click();
    }

}
