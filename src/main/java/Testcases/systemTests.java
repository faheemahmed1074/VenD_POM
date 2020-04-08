package Testcases;

import General.*;
import org.testng.annotations.Test;

import java.awt.*;

import static Config.configProperties.chipSystem;
import static Testcases.loginTests.loginIntoZGlueApplication;

public class systemTests extends baseTest {

    public static String sysName = "";
    public static String saveAsName = "";
    public static String importedSystem = "";

    @Test(description = "New System Creation")
    public static void createNewSystem() throws InterruptedException {
//        loginIntoZGlueApplication();

        logStep("Verify new system is created successfully");

        sysName = chipSystem + GenericFunctions.generateRandomNum(5);

//        MainCall.navBarPage.selectDeveloperRole();
        MainCall.navBarPage.selectNewSystemIcon();

        MainCall.systemPage.enterSystemName(sysName);

        MainCall.commonLocators.selectSave();
        WebDriverWaits.waitUntilLoaderDisapears();

        MainCall.navBarPage.verifySystemNameTitle(sysName);
    }

    @Test(description = "Create New System & its Verification")
    public static void verifyNewSystem() throws InterruptedException {
        createNewSystem();

        MainCall.navBarPage.selectAppLogo();
        WebDriverWaits.waitUntilLoaderDisapears();

        MainCall.systemPage.searchAndSelectSystem(sysName);
    }

    @Test(description = "Import System")
    public static void importSystem() throws InterruptedException, AWTException {
//        loginIntoZGlueApplication();
        MainCall.navBarPage.selectAdminRole();

        logStep("Verify system is imported successfully");

        importedSystem = "Imported-System_" + GenericFunctions.generateRandomNum(5);

        MainCall.navBarPage.selectNewSystemIcon();

        MainCall.systemPage.enterSystemName(importedSystem);
        MainCall.systemPage.selectImportSystem();
        MainCall.commonLocators.fileSelectionForMac("/System.zip");
        MainCall.commonLocators.selectSave();
        WebDriverWaits.waitUntilLoaderDisapears();

        MainCall.navBarPage.verifySystemNameTitle(importedSystem);
    }

    @Test(description = "Delete System")
    public static void deleteSystems() throws InterruptedException {
        createNewSystem();

        logStep("Verify system is deleted successfully");

        MainCall.navBarPage.selectSystemName();
        MainCall.systemPage.selectFromDropDown("Delete ZiP");
        MainCall.commonLocators.selectYes();

        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.systemPage.verifySystemDeleted(sysName);
    }

    @Test(description = "Save As System")
    public static void saveAsSystem() throws InterruptedException {
        logStep("Verify \"Save As\" system creates new system successfully");

//        loginIntoZGlueApplication();
//        MainCall.navBarPage.selectDeveloperRole();

        MainCall.systemPage.searchAndSelectSystem(chipSystem);

//        WebDriverWaits.waitUntilElementIsClickable(MainCall.navBarPage.systemName());
        MainCall.navBarPage.verifySystemNameTitle(sysName);

        MainCall.systemPage.saveAsTestSystem(sysName);
//        MainCall.navBarPage.verifySystemNameTitle(sysName+saveAsName);
    }

}
