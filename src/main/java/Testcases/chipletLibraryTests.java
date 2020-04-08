package Testcases;

import General.*;

import org.testng.annotations.Test;

import java.awt.*;


public class chipletLibraryTests extends baseTest
{

    @Test
    public void addNewChiplet()
    {
        logStep("Add New Chiplet Scenario");

//        loginTests.loginIntoZGlueApplication();
        MainCall.chipletLibraryPage.clickChipletLibraryBtn();
        int TotalCountBeforeAdd = MainCall.chipletLibraryPage.getTotalChipletsCount();

        MainCall.genericFunctions.clickChipletLibraryHeaderBtn("Add New Chiplet");
        MainCall.chipletLibraryPage.addNewChiplet(envGlobals.MPN,envGlobals.axisValue);
        MainCall.chipletLibraryPage.scrollDown();

        MainCall.chipletLibraryPage.addNewIO(envGlobals.integerValue);
        MainCall.genericFunctions.clickBlueClassButtons("Add");

        MainCall.commonLocators.verifyNotif();
        MainCall.commonLocators.assertAddChipletMessageToast();

        int TotalCountAfterAdd = MainCall.chipletLibraryPage.getTotalChipletsCount();
        MainCall.chipletLibraryPage.assertTotalCountAfterAdd(TotalCountBeforeAdd,TotalCountAfterAdd);

    }

    @Test
    public void uploadMechanicalCsvIOFile() throws AWTException {
        logStep("Uploading Mechanical CSV");

//        loginTests.loginIntoZGlueApplication();
        MainCall.chipletLibraryPage.clickChipletLibraryBtn();
        int totalCountBefore = MainCall.chipletLibraryPage.getTotalChipletsCount();

        MainCall.genericFunctions.clickChipletLibraryHeaderBtn("Add New Chiplet");
        MainCall.genericFunctions.clickChipletLibButtons("Upload Mechanical File");
        MainCall.commonLocators.uploadFileWithRobot(envGlobals.mechFilePath);
        WebDriverWaits.waitUntilLoaderDisapears();

        MainCall.genericFunctions.clickChipletLibButtons("Upload IO File");
        MainCall.commonLocators.uploadFileWithRobot(envGlobals.ioFilePath);
        WebDriverWaits.waitUntilLoaderDisapears();

        MainCall.chipletLibraryPage.clickAddButton();

        int totalCountAfter = MainCall.chipletLibraryPage.getTotalChipletsCount();
        MainCall.chipletLibraryPage.assertTotalCountAfterAdd(totalCountBefore,totalCountAfter);
        WebDriverWaits.waitUntilLoaderDisapears();
    }

//    @Test
//    public void uploadIoFile() throws AWTException
//    {
//        logStep("Uploading IO File");
//
//        loginTests.loginIntoZGlueApplication();
//        MainCall.chipletLibraryPage.clickChipletLibraryBtn();
//        MainCall.genericFunctions.clickChipletLibraryHeaderBtn("Add New Chiplet");
//        MainCall.genericFunctions.clickChipletLibButtons("Upload IO File");
//        MainCall.commonLocators.uploadFileWithRobot(envGlobals.ioFilePath);
//        WebDriverWaits.waitUntilLoaderDisapears();
//        MainCall.chipletLibraryPage.clickAddButton();
//        WebDriverWaits.waitUntilLoaderDisapears();
//    }

    @Test
    //Add assertions(Not needed)
    public void searchChiplets()
    {
        logStep("Search for any Chiplet");
//        loginTests.loginIntoZGlueApplication();
        MainCall.chipletLibraryPage.clickChipletLibraryBtn();
        MainCall.chipletLibraryPage.searchChipletLibrary("BOOST");
        MainCall.genericFunctions.clickOnColumnOfTable("BOOST");

    }

    @Test
    //Add Assertions
    public void editChiplets()
    {
        logStep("Edit any Chiplet");
//        loginTests.loginIntoZGlueApplication();
        MainCall.chipletLibraryPage.clickChipletLibraryBtn();
        MainCall.chipletLibraryPage.searchChipletLibrary("Smart Fabric Control");
        MainCall.genericFunctions.clickOnColumnOfTable("Smart Fabric Control");
        MainCall.genericFunctions.clickChipletLibButtons("Edit Chiplet");
        MainCall.chipletLibraryPage.editSearchedChiplet(envGlobals.axisValue,envGlobals.companyField,envGlobals.description,envGlobals.URL);
        MainCall.genericFunctions.clickBlueClassButtons("Save");
//        MainCall.commonLocators.verifyNotif();


    }

    //Chiplet name to be dynamic
    @Test
    public void deleteChiplets()
    {
        logStep("Delete any Chiplet");
//        loginTests.loginIntoZGlueApplication();
        MainCall.chipletLibraryPage.clickChipletLibraryBtn();
        int totalCountBefore = MainCall.chipletLibraryPage.getTotalChipletsCount();
        MainCall.chipletLibraryPage.searchChipletLibrary("Automation811");
        MainCall.genericFunctions.clickOnColumnOfTable("Automation811");
        MainCall.genericFunctions.clickChipletLibButtons("Delete Chiplet");
        MainCall.commonLocators.selectSave();
        WebDriverWaits.waitUntilLoaderDisapears();
        int totalCountAfter = MainCall.chipletLibraryPage.getTotalChipletsCount();
        MainCall.chipletLibraryPage.assertTotalCountAfterDelete(totalCountBefore,totalCountAfter);

    }

    @Test
    public void downloadChiplets()
    {
//        loginTests.loginIntoZGlueApplication();
        MainCall.chipletLibraryPage.clickChipletLibraryBtn();

        int countBeforeDownload = MainCall.chipletLibraryPage.checkDownloadFileName();
        MainCall.genericFunctions.clickChipletLibraryHeaderBtn("Download");

        WebDriverWaits.waitUntilLoaderDisapears();

        int countAfterDownload = MainCall.chipletLibraryPage.checkDownloadFileName();
        MainCall.chipletLibraryPage.assertFileDownload(countBeforeDownload, countAfterDownload);

    }

    @Test
    public void verifyPagination()
    {
//        loginTests.loginIntoZGlueApplication();
        MainCall.chipletLibraryPage.clickChipletLibraryBtn();
        MainCall.genericFunctions.assertPaginationButtons();
        MainCall.genericFunctions.verifyPaginationInFooter();
    }

} 