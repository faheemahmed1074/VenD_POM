package Testcases;

import Config.configProperties;
import General.*;
import org.testng.annotations.Test;

import java.util.List;

import static Config.configProperties.chipSystem;
import static Config.configProperties.systemName;
import static Testcases.loginTests.loginIntoZGlueApplication;

public class chipletTests extends baseTest {

    static configProperties configProps = new configProperties();
    String[] marginValues = configProps.marginConfigs();
    public static String sysName = "";
    public static int zoomA;
    public static int zoomB;

//    @Test
    public void OmniChipTest() throws InterruptedException {
        logStep("Verify Omnichip");

//        loginTests.loginIntoZGlueApplication();

        MainCall.loginPage.selectSkipButton();

        MainCall.systemPage.selectSystemByName(chipSystem.toString());

        WebDriverFactory.getDriver().navigate().refresh();
        WebDriverWaits.waitUntilLoaderDisapears();

        MainCall.chipletPage.fillMarginValuesAndSave(marginValues);

//        NRF52832 Chiplet
        MainCall.chipletPage.addChiplet("coordinates", "NRF52832", 2900, 800, "180");
//        MainCall.chipletPage.removeChiplet();

//        BQ25120A Chiplet
        MainCall.chipletPage.addChiplet("coordinates", "BQ25120A", 1100, 5200, "0");
//        MainCall.chipletPage.removeChiplet();

//        MAX86140 Chiplet
        MainCall.chipletPage.addChiplet("coordinates", "MAX86140", 3450, 5450, "90");
//        MainCall.chipletPage.removeChiplet();

//        MC3672 Chiplet
        MainCall.chipletPage.addChiplet("coordinates", "MC3672", 550, 3050, "90");
//        MainCall.chipletPage.removeChiplet();

//        TMP108 Chiplet
        MainCall.chipletPage.addChiplet("coordinates", "TMP108", 1950, 3250, "90");
//        MainCall.chipletPage.removeChiplet();

//        BMM150 Chiplet
        MainCall.chipletPage.addChiplet("coordinates", "BMM150", 3599, 3399, "0");
//        MainCall.chipletPage.removeChiplet();

//        SIT1552 Chiplet
        MainCall.chipletPage.addChiplet("coordinates", "SIT1552", 355, 1150, "0");
//        MainCall.chipletPage.removeChiplet();

        MainCall.commonLocators.selectNextButton();
    }

    @Test
    public static void placement() throws InterruptedException {
        MainCall.systemPage.selectDefaultSystem();
//        createNewSystem();

        logStep("Verify chiplet placements");

        MainCall.chipletPage.removeAllChiplets();
//        SIT1552 Chiplet
//        MainCall.chipletPage.addChiplet("dragdrop", "SIT1552", 955, 5050, "0");
        MainCall.chipletPage.addChiplet("coordinates", "SIT1552", 955, 5050, "0");

//        MAX86140 Chiplet
        MainCall.chipletPage.addChiplet("coordinates", "MAX86140", 1850, 1850, "270");

    }

    // Physical -- Placement Tests

    @Test
    public static void moveChipletByDragAndDropPanAndFitFunctionalityChecks() throws InterruptedException
    {
//        loginTests.loginIntoZGlueApplication();

        sysName = systemName + GenericFunctions.generateRandomNum(5);

//   Change to dev role
//        MainCall.navBarPage.selectDeveloperRole();
        MainCall.navBarPage.selectNewSystemIcon();

//   Creating a new system
        MainCall.systemPage.enterSystemName(sysName);
        MainCall.commonLocators.selectSave();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.navBarPage.verifySystemNameTitle(sysName);

//   Adding a new chiplet in the system created
        MainCall.chipletPage.addChiplet("coordinates", "SIT1552", envGlobals.xCord , envGlobals.yCord, "0");

//   Drag and drop the newly added chiplet on board
        MainCall.chipletPage.dragAndDropChiplet();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.chipletPage.checkXYValuesAfterDragDrop();
        WebDriverWaits.sleep(2000);

//   Pan Functionality, moves the whole board (Asserts by getting transform value before and after)
        envGlobals.boardValueBefore = MainCall.chipletPage.getBoardTransformValue() ;
        logStep("PanBefore"+" "+ envGlobals.boardValueBefore);
        MainCall.chipletPage.panFunctionality();
        envGlobals.boardValueAfter = MainCall.chipletPage.getBoardTransformValue() ;
        logStep("PanAfter"+" "+ envGlobals.boardValueAfter);
        MainCall.chipletPage.assertBoardTransformValueAfterPan(envGlobals.boardValueBefore,envGlobals.boardValueAfter);
        WebDriverWaits.sleep(2000);

//   Fit Functionality (Asserts by getting transform LastTransformValue of Pan and by getting transform value after pan)
        MainCall.chipletPage.fitFunctionality();
        String value = MainCall.chipletPage.getBoardTransformValue();
        logStep("Fit"+"  "+ value);
        MainCall.chipletPage.assertBoardTransformValueAfterFit(envGlobals.boardValueAfter,value);

        WebDriverWaits.sleep(2000);

    }

    @Test
    public void verifyZoomInAndZoomOutFunctionality()
    {
//        loginTests.loginIntoZGlueApplication();

        sysName = systemName + GenericFunctions.generateRandomNum(5);

//   Change to dev role
//        MainCall.navBarPage.selectDeveloperRole();
        MainCall.navBarPage.selectNewSystemIcon();

//   Creating a new system
        MainCall.systemPage.enterSystemName(sysName);
        MainCall.commonLocators.selectSave();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.navBarPage.verifySystemNameTitle(sysName);

//   Check zoomIn Functionality

        zoomB = Integer.parseInt(MainCall.chipletPage.zoomText());
        MainCall.chipletPage.zoomOut(1);
        zoomA = Integer.parseInt(MainCall.chipletPage.zoomText());
        MainCall.chipletPage.assertZoomIn(zoomB,zoomA);
        WebDriverWaits.sleep(2000);

//   Check zoomOut Functionality

        zoomB = Integer.parseInt(MainCall.chipletPage.zoomText());
        MainCall.chipletPage.zoomIn(1);
        zoomA = Integer.parseInt(MainCall.chipletPage.zoomText());
        MainCall.chipletPage.assertZoomOut(zoomB,zoomA);
        WebDriverWaits.sleep(2000);

    }


    @Test
    public void verifyLockSystem() throws InterruptedException
    {
//        loginTests.loginIntoZGlueApplication();

        sysName = systemName + GenericFunctions.generateRandomNum(5);

//        MainCall.navBarPage.selectDeveloperRole();
        MainCall.navBarPage.selectNewSystemIcon();

        MainCall.systemPage.enterSystemName(sysName);
        MainCall.commonLocators.selectSave();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.navBarPage.verifySystemNameTitle(sysName);

        MainCall.chipletPage.addChiplet("coordinates", "SIT1552", envGlobals.xCord , envGlobals.yCord, "0");

        MainCall.navBarPage.selectAdminRole();


        MainCall.chipletPage.clickSystemDropDown();
        MainCall.chipletPage.clickLockSystem();
        WebDriverWaits.waitUntilLoaderDisapears();

        MainCall.chipletPage.dragAndDropChiplet();
        MainCall.chipletPage.assertXYCordinates();
    }

    @Test
    public void verifySaveAsFeature() throws InterruptedException
    {
//        loginTests.loginIntoZGlueApplication();

        sysName = systemName + GenericFunctions.generateRandomNum(5);
        String sysEditName = systemName + GenericFunctions.generateRandomNum(3);

//        MainCall.navBarPage.selectDeveloperRole();
        MainCall.navBarPage.selectNewSystemIcon();

        MainCall.systemPage.enterSystemName(sysName);
        MainCall.commonLocators.selectSave();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.navBarPage.verifySystemNameTitle(sysName);

        MainCall.chipletPage.addChiplet("coordinates", "SIT1552", envGlobals.xCord , envGlobals.yCord, "0");

        MainCall.navBarPage.selectAdminRole();


        MainCall.chipletPage.clickSystemDropDown();
        MainCall.genericFunctions.clickSystemDropdwnButton("Save As");

        MainCall.chipletPage.changeSystemName(sysEditName);
        MainCall.commonLocators.selectSave();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.genericFunctions.clickDashboard();
        MainCall.chipletPage.searchSystem(sysEditName);
        MainCall.chipletPage.assertSystemName(sysEditName);
        WebDriverWaits.sleep(5000);
    }

    @Test
    public void verifyChipDetails() throws InterruptedException
    {
//        loginTests.loginIntoZGlueApplication();

        sysName = systemName + GenericFunctions.generateRandomNum(5);

//        MainCall.navBarPage.selectDeveloperRole();
        MainCall.navBarPage.selectNewSystemIcon();

        MainCall.systemPage.enterSystemName(sysName);
        MainCall.commonLocators.selectSave();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.navBarPage.verifySystemNameTitle(sysName);

        MainCall.chipletPage.addChiplet("coordinates", "SIT1552", envGlobals.xCord , envGlobals.yCord, "0");
        MainCall.chipletPage.clickMainBoard();

        MainCall.chipletPage.verifyChipletData();

    }

    //Need to apply better assertions
    @Test
    public void verifySnapToGridFunctionality() throws InterruptedException
    {
//        loginTests.loginIntoZGlueApplication();

        sysName = systemName + GenericFunctions.generateRandomNum(5);

//        MainCall.navBarPage.selectDeveloperRole();
        MainCall.navBarPage.selectNewSystemIcon();

        MainCall.systemPage.enterSystemName(sysName);
        MainCall.commonLocators.selectSave();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.navBarPage.verifySystemNameTitle(sysName);

        MainCall.chipletPage.addChiplet("coordinates", "SIT1552", envGlobals.xCord , envGlobals.yCord, "0");
        MainCall.navBarPage.selectAdminRole();
        MainCall.chipletPage.dragAndDropChiplet();
        WebDriverWaits.waitUntilLoaderDisapears();


//        MainCall.navBarPage.selectSettingsIcon();
        WebDriverWaits.sleep(2000);

        MainCall.chipletPage.clickAbstractView();
        List<Integer> rectCountBefore = MainCall.chipletPage.getRectCount();
        MainCall.chipletPage.clickPhysicalView();
        MainCall.chipletPage.clickSnapChipToGrid();
        MainCall.chipletPage.changeRotationHandleData(envGlobals.xCordEdited, envGlobals.yCordEdited);
        WebDriverWaits.waitUntilLoaderDisapears();
        WebDriverWaits.sleep(2000);
        MainCall.chipletPage.clickAbstractView();
        List<Integer> rectCountAfter = MainCall.chipletPage.getRectCount();
        MainCall.chipletPage.assertRectCount(rectCountBefore,rectCountAfter);

    }


    @Test
    public void dragAndDrop() throws InterruptedException
    {
//        loginTests.loginIntoZGlueApplication();

        sysName = systemName + GenericFunctions.generateRandomNum(5);

//        MainCall.navBarPage.selectDeveloperRole();
        MainCall.navBarPage.selectNewSystemIcon();

        MainCall.systemPage.enterSystemName(sysName);
        MainCall.commonLocators.selectSave();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.navBarPage.verifySystemNameTitle(sysName);


        MainCall.chipletPage.addChiplet("dragdrop", "SIT1552", 2155, 2850, "0");
        WebDriverWaits.waitUntilLoaderDisapears();
    }

    @Test
    public void manualDragAndDrop() throws InterruptedException {

//        loginTests.loginIntoZGlueApplication();

        sysName = systemName + GenericFunctions.generateRandomNum(5);

//        MainCall.navBarPage.selectDeveloperRole();
        MainCall.navBarPage.selectNewSystemIcon();

        MainCall.systemPage.enterSystemName(sysName);
        MainCall.commonLocators.selectSave();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.navBarPage.verifySystemNameTitle(sysName);


        MainCall.chipletPage.addChiplet("coordinates", "SIT1552", 955, 5050, "0");
        WebDriverWaits.waitUntilLoaderDisapears();
    }

    @Test
    public void rotateChiplet() throws InterruptedException
    {
//        loginTests.loginIntoZGlueApplication();

        sysName = systemName + GenericFunctions.generateRandomNum(5);

//        MainCall.navBarPage.selectDeveloperRole();
        MainCall.navBarPage.selectNewSystemIcon();

        MainCall.systemPage.enterSystemName(sysName);
        MainCall.commonLocators.selectSave();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.navBarPage.verifySystemNameTitle(sysName);


        MainCall.chipletPage.addChiplet("coordinates", "SIT1552", 955, 5050, "0");
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.chipletPage.updateRotationDegree();
        WebDriverWaits.waitUntilLoaderDisapears();
    }

    @Test
    public void removeChiplet() throws InterruptedException
    {
//        loginTests.loginIntoZGlueApplication();

        sysName = systemName + GenericFunctions.generateRandomNum(5);

//        MainCall.navBarPage.selectDeveloperRole();
        MainCall.navBarPage.selectNewSystemIcon();

        MainCall.systemPage.enterSystemName(sysName);
        MainCall.commonLocators.selectSave();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.navBarPage.verifySystemNameTitle(sysName);


        MainCall.chipletPage.addChiplet("coordinates", "SIT1552", 955, 5050, "0");
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.chipletPage.removeAllChiplets();
        WebDriverWaits.waitUntilLoaderDisapears();
    }

    @Test
    public void editChipletViewDetails() throws InterruptedException
    {

        sysName = systemName + GenericFunctions.generateRandomNum(5);

//        MainCall.navBarPage.selectDeveloperRole();
        MainCall.navBarPage.selectNewSystemIcon();

        MainCall.systemPage.enterSystemName(sysName);
        MainCall.commonLocators.selectSave();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.navBarPage.verifySystemNameTitle(sysName);


        MainCall.chipletPage.addChiplet("coordinates", "SIT1552", 955, 5050, "0");
        WebDriverWaits.waitUntilLoaderDisapears();



        MainCall.chipletPage.updateRotationDegree();
        MainCall.chipletPage.changeRotationHandleData(envGlobals.xCordEdited, envGlobals.yCordEdited);
        MainCall.chipletPage.assertRotationHandleData(GenericFunctions.stringToInt(envGlobals.xCordEdited),GenericFunctions.stringToInt(envGlobals.yCordEdited));

        WebDriverWaits.waitUntilLoaderDisapears();
    }

    @Test
    public void enforcePlacementRule() throws InterruptedException
    {
//        loginTests.loginIntoZGlueApplication();

        sysName = systemName + GenericFunctions.generateRandomNum(5);

//        MainCall.navBarPage.selectDeveloperRole();
        MainCall.navBarPage.selectNewSystemIcon();

        MainCall.systemPage.enterSystemName(sysName);
        MainCall.commonLocators.selectSave();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.navBarPage.verifySystemNameTitle(sysName);


        MainCall.chipletPage.addChiplet("coordinates", "SIT1552", envGlobals.xCord, envGlobals.yCord, "0");
        WebDriverWaits.waitUntilLoaderDisapears();

        MainCall.chipletPage.addChiplet("coordinates","SIT1552",2150,1245,"90");
        WebDriverWaits.waitUntilLoaderDisapears();

        MainCall.chipletPage.dragChipOverChip();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.chipletPage.assertChipOverChip();

        MainCall.chipletPage.clickSpacingRule();
        MainCall.chipletPage.dragChipOverChip();
//        MainCall.commonLocators.verifyErrorNotif();

        WebDriverWaits.sleep(8000);

    }

}

