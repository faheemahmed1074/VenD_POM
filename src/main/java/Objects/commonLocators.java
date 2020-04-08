package Objects;

import General.MainCall;
import General.WebDriverFactory;
import General.WebDriverWaits;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static General.WebDriverFactory.action;
import static General.WebDriverFactory.robot;
import static utils.LogHelper.logStep;


public class commonLocators {
    public commonLocators(){}

    public static String passIcon = "data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz4KPHN2ZyB3aWR0aD0iMjBweCIgaGVpZ2h0PSIyMHB4IiB2aWV3Qm94PSIwIDAgMjAgMjAiIHZlcnNpb249IjEuMSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayI+CiAgICA8IS0tIEdlbmVyYXRvcjogU2tldGNoIDUyLjUgKDY3NDY5KSAtIGh0dHA6Ly93d3cuYm9oZW1pYW5jb2RpbmcuY29tL3NrZXRjaCAtLT4KICAgIDx0aXRsZT5iYXNlbGluZS1jaGVja19jaXJjbGUtMjRweDwvdGl0bGU+CiAgICA8ZGVzYz5DcmVhdGVkIHdpdGggU2tldGNoLjwvZGVzYz4KICAgIDxnIGlkPSJQYWdlLTEiIHN0cm9rZT0ibm9uZSIgc3Ryb2tlLXdpZHRoPSIxIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxnIGlkPSJiYXNlbGluZS1jaGVja19jaXJjbGUtMjRweCIgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoLTIuMDAwMDAwLCAtMi4wMDAwMDApIj4KICAgICAgICAgICAgPHBvbHlnb24gaWQ9IlBhdGgiIHBvaW50cz0iMCAwIDI0IDAgMjQgMjQgMCAyNCI+PC9wb2x5Z29uPgogICAgICAgICAgICA8cGF0aCBkPSJNMTIsMiBDNi40OCwyIDIsNi40OCAyLDEyIEMyLDE3LjUyIDYuNDgsMjIgMTIsMjIgQzE3LjUyLDIyIDIyLDE3LjUyIDIyLDEyIEMyMiw2LjQ4IDE3LjUyLDIgMTIsMiBaIiBpZD0iU2hhcGUiIGZpbGw9IiMyN0FFNjAiIGZpbGwtcnVsZT0ibm9uemVybyI+PC9wYXRoPgogICAgICAgICAgICA8cG9seWdvbiBpZD0iUGF0aCIgZmlsbD0iI0ZGRkZGRiIgZmlsbC1ydWxlPSJub256ZXJvIiBwb2ludHM9IjEwIDE3IDUgMTIgNi40MSAxMC41OSAxMCAxNC4xNyAxNy41OSA2LjU4IDE5IDgiPjwvcG9seWdvbj4KICAgICAgICA8L2c+CiAgICA8L2c+Cjwvc3ZnPg==";
    public static String failIcon = "data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz4KPHN2ZyB3aWR0aD0iMjBweCIgaGVpZ2h0PSIyMHB4IiB2aWV3Qm94PSIwIDAgMjAgMjAiIHZlcnNpb249IjEuMSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayI+CiAgICA8IS0tIEdlbmVyYXRvcjogU2tldGNoIDUyLjUgKDY3NDY5KSAtIGh0dHA6Ly93d3cuYm9oZW1pYW5jb2RpbmcuY29tL3NrZXRjaCAtLT4KICAgIDx0aXRsZT5iYXNlbGluZS1jYW5jZWwtMjRweDwvdGl0bGU+CiAgICA8ZGVzYz5DcmVhdGVkIHdpdGggU2tldGNoLjwvZGVzYz4KICAgIDxnIGlkPSJQYWdlLTEiIHN0cm9rZT0ibm9uZSIgc3Ryb2tlLXdpZHRoPSIxIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxnIGlkPSJiYXNlbGluZS1jYW5jZWwtMjRweCIgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoLTIuMDAwMDAwLCAtMi4wMDAwMDApIj4KICAgICAgICAgICAgPHBhdGggZD0iTTEyLDIgQzYuNDcsMiAyLDYuNDcgMiwxMiBDMiwxNy41MyA2LjQ3LDIyIDEyLDIyIEMxNy41MywyMiAyMiwxNy41MyAyMiwxMiBDMjIsNi40NyAxNy41MywyIDEyLDIgWiIgaWQ9IlNoYXBlIiBmaWxsPSIjRTc0QzNDIiBmaWxsLXJ1bGU9Im5vbnplcm8iPjwvcGF0aD4KICAgICAgICAgICAgPHBvbHlnb24gaWQ9IlBhdGgiIGZpbGw9IiNGRkZGRkYiIGZpbGwtcnVsZT0ibm9uemVybyIgcG9pbnRzPSIxNyAxNS41OSAxNS41OSAxNyAxMiAxMy40MSA4LjQxIDE3IDcgMTUuNTkgMTAuNTkgMTIgNyA4LjQxIDguNDEgNyAxMiAxMC41OSAxNS41OSA3IDE3IDguNDEgMTMuNDEgMTIiPjwvcG9seWdvbj4KICAgICAgICAgICAgPHBvbHlnb24gaWQ9IlBhdGgiIHBvaW50cz0iMCAwIDI0IDAgMjQgMjQgMCAyNCI+PC9wb2x5Z29uPgogICAgICAgIDwvZz4KICAgIDwvZz4KPC9zdmc+";

    //Common Locators
    public static By byYes = By.name("YES-BUTTON");
    public static By bySave = By.className("modal-btn-blue");
    public static By bySet = By.className("modal-btn-primary");
    public static By byNext = By.name("next");
    public static By byPrevious = By.name("prev");
    public static By bySubmitDesign = By.className("btn-submit");
    public static By byCross = By.className("close-modal");

    public static By byNetnameSave = By.id("net-name-save");
    public static By byNetnameCancel = By.id("net-name-cancel");

    public static By byNotif = By.className("s-alert-top-right");
    public static By byNotifClose = By.className("s-alert-close");

    public static By byRightContainer = By.className("collapse-btn-right");

    public static By byFit = By.id("btn-fit");
    public static By byPan = By.id("pan");
    public static By byMove = By.id("none");

    public static By byPromptTitle = By.id("alert-dialog-title");

    public static By byImg = By.tagName("img");
    public static By byDiv = By.tagName("div");
    public static By bySpan = By.tagName("span");
    public static By byThead = By.tagName("thead");
    public static By byTable = By.tagName("tbody");
    public static By byTr = By.tagName("tr");
    public static By byTd = By.tagName("td");
    public static By byTh = By.tagName("th");
    public static By byFooter = By.tagName("tfoot");
    public static By bySvg = By.tagName("svg");
    public static By byButton = By.tagName("button");
    public static By byChipletLibHeaderButtons = By.className("add-chiplet-btn");

    //Upload Mechanical CSV and IO file
    public static By byChipletLibraryButton = By.className("btn-primary");

    //Chiplet Library Alert Notifications
    public static By byWarningNotification = By.className("s-alert-warning");
    public static By byErrorNotification = By.className("s-alert-error");
    public static By bySuccessNotification = By.className("s-alert-success");
    String warningMessage = "No. of IO's don't match";
    String failureMessage = "Request failed with status code 400";
    String successMessage = "Chiplet Added";
    String updateMessage = "Chiplet updated";
    String error = "Wrong or No Alert Message Shown";
    public static By byButtons = By.className("btn-link");
    public static By byDropDown = By.className("dropdown-menu");
    public static By byUl = By.tagName("ul");
    public static By byLi = By.tagName("li");
    public static By byList = By.className("list-action");
    public static By byInput = By.tagName("input");
    public static By byDropdwnButtons = By.className("btn-link");
    public static By bylogo = By.className("app-logo");

    //Common Functions

    public void selectYes(){
        logStep("User clicks on Yes button");

        WebDriverWaits.waitUntilElementIsClickable(WebDriverFactory.getDriver().findElement(byYes));
        WebDriverFactory.getDriver().findElement(byYes).click();
    }

    public void selectSave(){
        logStep("User clicks on Save button");
        WebDriverFactory.getDriver().findElement(bySave).click();
    }

    public void selectNextButton(){
        logStep("User clicks on Next button");
        WebDriverFactory.getDriver().findElement(byNext).click();
    }
    public void selectPreviousButton(){
        logStep("User clicks on Previous button");
        WebDriverFactory.getDriver().findElement(byPrevious).click();
    }
    public void selectSubmitDesignButton(){
        logStep("User clicks on Submit Design button");
        WebDriverFactory.getDriver().findElement(bySubmitDesign).click();
    }

    public void selectNetnameSave(){
        WebDriverWaits.waitUntilElementIsClickable(WebDriverFactory.getDriver().findElement(byNetnameSave));
        logStep("User clicks on Save button on Netname modal");
        WebDriverFactory.getDriver().findElement(byNetnameSave).click();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.commonLocators.verifySuccessNotif();
    }

    public void selectNetnameCancel(){
        WebDriverWaits.waitUntilElementIsClickable(WebDriverFactory.getDriver().findElement(byNetnameCancel));
        logStep("User clicks on Cancel button on Netname modal");
        WebDriverFactory.getDriver().findElement(byNetnameCancel).click();
    }

    public void selectSet(){
        logStep("User clicks on Set button");
        WebDriverFactory.getDriver().findElement(bySet).click();
    }

    public void selectCross(){
        logStep("User clicks on cross button");
        WebDriverFactory.getDriver().findElement(byCross).click();
        WebDriverWaits.sleep250();
    }

    public void clearField(WebElement element){
        int input = element.getAttribute("value").length();

        for(int i=0; i<input ;i++){
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    public void selectFit(){
        logStep("User clicks on Fit option");
        WebDriverFactory.getDriver().findElement(byFit).click();
    }
    public void selectPan(){
        logStep("User clicks on Pan option");
        WebDriverFactory.getDriver().findElement(byPan).click();
    }
    public void selectMove(){
        logStep("User clicks on Move option");
        WebDriverFactory.getDriver().findElement(byMove).click();
    }

    public WebElement promptTitle(){
        return WebDriverFactory.getDriver().findElement(byPromptTitle);
    }

    public void escape(){
        action.sendKeys(Keys.ESCAPE).perform();
    }

    public void delete(){
//        action = new Actions(WebDriverFactory.getDriver());
        action.sendKeys(Keys.DELETE).perform();
    }

    public void verifySuccessNotif(){
        logStep("Success message displayed successfully");
        WebDriverWaits.sleep500();

        if (WebDriverFactory.getDriver().getPageSource().contains("s-alert-close") &&
                WebDriverFactory.getDriver().findElements(byNotif).get(0).findElement(byImg).getAttribute("src").equals(passIcon)) {
            do {
                logStep("Closing success message");
                WebDriverFactory.getDriver().findElements(byNotifClose).get(0).click();
                WebDriverWaits.sleep1000();
            } while (WebDriverFactory.getDriver().getPageSource().contains("s-alert-close"));
        } else
            MainCall.navBarPage.fetchNotifErrors();
    }

    public void verifyErrorNotif(String errorMessage){
        logStep("Error message displayed successfully: " + errorMessage);

        WebElement notifImage = WebDriverFactory.getDriver().findElement(byNotif).findElement(byImg);

        WebDriverWaits.sleep500();
        WebDriverWaits.visibilityOf(notifImage);
        Assert.assertTrue(notifImage.getAttribute("src").equals(failIcon));
//        Assert.assertTrue(WebDriverFactory.getDriver().findElement(byNotif).getText().contains(errorMessage));

        WebDriverFactory.getDriver().findElement(byNotifClose).click();
        WebDriverWaits.sleep1000();

        MainCall.navBarPage.fetchNotifErrors();
    }

    public WebElement rightContainer(){
        return WebDriverFactory.getDriver().findElement(byRightContainer);
    }
    public void verifyRightContainer(){
        logStep("Open right container");

        if (!rightContainer().findElement(byImg).getAttribute("class").equals("")) {
            rightContainer().findElement(byImg).click();
        }
    }

    public void checkPromptOpen(String pinCircle){
        WebDriverWaits.visibilityOf(MainCall.commonLocators.promptTitle());
        Assert.assertTrue(MainCall.commonLocators.promptTitle().getText().contains(pinCircle));
    }

    public void fileSelectionForMac(String path) throws AWTException, InterruptedException {
        logStep("User searches and selects file to import");

        String dir = System.getProperty("user.dir");
        StringSelection StringSelection = new StringSelection(dir + path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(StringSelection, null);

        //Open Goto window
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_SHIFT);

        //Paste the clipboard value
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_V);

        //Press Enter key to close the Goto window and Upload window
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    //File upload by Robot Class
    public void uploadFileWithRobot (String filePath) throws AWTException {
        Robot robot = new Robot();

        String dir = System.getProperty("user.dir");
        dir = dir.substring(2, dir.length());
//        type(dir + envGlobals.chottaFilePath);
////        robot.keyPress(KeyEvent.VK_SHIFT);
//        robot.keyPress(KeyEvent.VK_UNDERSCORE);
////        robot.keyRelease(KeyEvent.VK_SHIFT);
//        robot.keyRelease(KeyEvent.VK_UNDERSCORE);
//        type(dir + envGlobals.chottaFilePath2);

        StringSelection stringSelection = new StringSelection(filePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        robot.delay(2000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.delay(1000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    //Functions

    //Robot functions
    public void type(int i) throws AWTException{
        Robot robot = new Robot();
        robot.delay(60);
        robot.keyPress(i);
        robot.keyRelease(i);
    }
    public static void type(String s) throws AWTException{
        Robot robot = new Robot();
        byte[] bytes = s.getBytes();
        for (byte b : bytes){
            int code = b;
// keycode only handles [A-Z] (which is ASCII decimal [65-90])
            if (code > 96 && code < 123)
                code = code - 32;
            robot.delay(100);
            robot.keyPress(code);
            robot.keyRelease(code);
        }
    }

    public void assertWarningMessageToast()
    {
        String warningText = WebDriverFactory.getDriver().findElement(byWarningNotification).getText();
        Assert.assertEquals(error,warningText,warningMessage);
        WebDriverWaits.sleep1000();

    }

    public void assertEditChipletMessageToast()
    {
//        String editText = WebDriverFactory.getDriver().findElement(bySuccessNotification).getText();
//        System.out.println(editText);
//        Assert.assertEquals(error,editText,updateMessage);
//        WebDriverFactory.getDriver().findElement(byNotifClose).click();
//        WebDriverWaits.sleep(1000);
    }

    public void assertAddChipletMessageToast()
    {
        WebElement successNotif = WebDriverFactory.getDriver().findElement(bySuccessNotification);
        Assert.assertTrue(successNotif.isDisplayed());
//        String successText = WebDriverFactory.getDriver().findElement(bySuccessNotification).getText();
//        System.out.println(successText);
//        Assert.assertEquals(error,successText,successMessage);
//        WebDriverWaits.sleep1000();
    }

    public void assertFailChipletMessageToast()
    {
        String failText = WebDriverFactory.getDriver().findElement(byErrorNotification).getText();
        System.out.println(failText);
        Assert.assertEquals(error,failText,failureMessage);
        WebDriverWaits.sleep1000();
    }

    public void verifyNotif(){
        logStep("Success message displayed successfully");

        WebElement notifImage = WebDriverFactory.getDriver().findElement(byNotif).findElement(byImg);

        if (WebDriverFactory.getDriver().getPageSource().contains("s-alert-close") && notifImage.getAttribute("src").equals(passIcon)) {
            do {
                System.out.println("Print");
                WebDriverFactory.getDriver().findElement(byNotifClose).click();
                WebDriverWaits.sleep500();
            } while (WebDriverFactory.getDriver().getPageSource().contains("s-alert-close"));
        }

    }

}