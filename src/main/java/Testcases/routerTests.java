package Testcases;

import General.*;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static Testcases.loginTests.loginIntoZGlueApplication;
import static Testcases.schematicTests.*;
import static Testcases.systemTests.createNewSystem;

public class routerTests extends baseTest {

    @Test
    public static void routing() throws InterruptedException {
        logStep("User routes system");

        MainCall.navBarPage.selectOptimize();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.commonLocators.verifySuccessNotif();

        MainCall.routerPage.selectRouterButton();
        WebDriverWaits.waitUntilLoaderDisapears();

        MainCall.commonLocators.verifySuccessNotif();
    }

    @Test
    public static void routeTestSystem1019() throws InterruptedException, SQLException {
//        loginIntoZGlueApplication();

        MainCall.systemPage.selectSystemByName(envGlobals.sys1019Name);

        logStep("User routes system");

        MainCall.routerPage.route();
    }

    @Test
    public static void routeTestSystem1328() throws InterruptedException, SQLException {
//        loginIntoZGlueApplication();

        MainCall.systemPage.selectSystemByName(envGlobals.sys1328Name);

        logStep("User routes system");

        MainCall.routerPage.route();
    }

    @Test
    public static void routeTestSystem674() throws InterruptedException, SQLException {
//        loginIntoZGlueApplication();

        MainCall.systemPage.selectSystemByName(envGlobals.sys674Name);

        logStep("User routes system");

        MainCall.routerPage.route();
    }

    @Test
    public void smartFabric() throws InterruptedException {
        createNewSystem();

        logStep("Smart Fabric");

        MainCall.chipletPage.addChiplet("coordinates", "SIT1552", 3555, 5550, "0");
        MainCall.chipletPage.addChiplet("coordinates", "MAX86140", 2250, 250, "270");

        schematicSelection();

        /* -----------------------------------------------  'BONDPAD'  ----------------------------------------------- */
        logStep("/* ------------------------------------------------------------------------------------------------------------------------------------- */");
        logStep("BONDPAD");

        envGlobals.chiplet = "U23";
        envGlobals.pinCircle = "LED2_DRV";
        envGlobals.newNetName = "net_1";
        envGlobals.type = "Programmable";
        envGlobals.option = "Analog";

        envGlobals.bondpadList.add("Tio_rm_l_7 / 15");
        envGlobals.bondpadList.add("Tio_col_25 / 33");

        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.commonLocators.escape();

        MainCall.schematicPage.selectBonpad();
        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.commonLocators.escape();

        MainCall.schematicPage.selectBondpadConfigs(envGlobals.bondpadList);
        MainCall.commonLocators.selectSave();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.commonLocators.verifySuccessNotif();

        /* -----------------------------------------------  'SMART FABRIC CONTROL'  ----------------------------------------------- */
        logStep("/* ------------------------------------------------------------------------------------------------------------------------------------- */");
        logStep("SMART FABRIC CONTROL");

        envGlobals.chiplet = "U1";
        envGlobals.pinCircle = "CLK_OUT";
        envGlobals.newNetName = "SMC_1";
        envGlobals.chipletTarget = "S1";
        envGlobals.pinCircleTarget = "FAULT_INT";
        envGlobals.type = "Programmable";
        envGlobals.option = "Analog";

        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget, "single", true);
        MainCall.commonLocators.escape();

        /* -----------------------------------------------  'INTERFACE'  ----------------------------------------------- */
        logStep("/* ------------------------------------------------------------------------------------------------------------------------------------- */");
        logStep("INTERFACE");

        envGlobals.chiplet = "U23";
        envGlobals.pinCircle = "CSB";
        envGlobals.newNetName = "INT_1";
        envGlobals.chipletTarget = "S2";
        envGlobals.pinCircleTarget = "ZIP_CS";
        envGlobals.type = "Programmable";
        envGlobals.option = "Analog";

        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget, "single", true);
        MainCall.commonLocators.escape();

        /* -----------------------------------------------  'POWER SUPPLY'  ----------------------------------------------- */
        logStep("/* ------------------------------------------------------------------------------------------------------------------------------------- */");
        logStep("POWER SUPPLY");

        envGlobals.chiplet = "U23";
        envGlobals.pinCircle = "VDD_ANA";
        envGlobals.newNetName = "VDD_1";
        envGlobals.chipletTarget = "S4";
        envGlobals.pinCircleTarget = "LDO1";
        envGlobals.type = "Programmable";
        envGlobals.option = "Power";

        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget, "single", true);
        MainCall.commonLocators.escape();

        envGlobals.chiplet = "S4";

        // POWER SUPPLY
        MainCall.schematicPage.selectChiplet(envGlobals.chiplet);
        MainCall.schematicPage.powerSupplyConfigs(1, false, true, "3.0", true);
        MainCall.commonLocators.selectSet();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.commonLocators.selectCross();
        MainCall.commonLocators.verifySuccessNotif();

        routing();
    }

        @Test
    public void otg() throws InterruptedException {
        createNewSystem();

        logStep("OTG");

        MainCall.chipletPage.addChiplet("coordinates", "MAX86140", 2250, 250, "270");

        schematicSelection();

        envGlobals.chiplet = "U23";
        envGlobals.pinCircle = "LED2_DRV";
        envGlobals.newNetName = "netA3";
//        envGlobals.chipletTarget = "U1";
        envGlobals.pinCircleTarget = "PD_GND";
        envGlobals.type = "Programmable";
        envGlobals.option = "Analog";

        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.schematicPage.inputOtg(0, 42);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircleTarget, "single", true);
        MainCall.commonLocators.escape();

        routing();
    }

    @Test
    public void changeTypeDeleteBondpad() throws InterruptedException {
        createNewSystem();

        String chiplet1 = "TMP108AIYFFT";
        String chiplet2 = "SIT1552";
        logStep("Change Type / Delete / Bondpad");

        MainCall.chipletPage.addChiplet("coordinates", chiplet1, 650, 5550, "0");
        MainCall.chipletPage.addChiplet("coordinates", chiplet2, 3555, 5550, "0");

/* -----------------------------------------------  'ANAS'  ----------------------------------------------- */
        logStep("/* ------------------------------------------------------------------------------------------------------------------------------------- */");
        logStep("ANAS");

        schematicSelection();

        envGlobals.type = "Programmable";
        envGlobals.option = "Analog";
        envGlobals.newNetName = "net1";
        envGlobals.resistorNetName = "";
        envGlobals.chiplet = "U9";
        envGlobals.pinCircle = "SDA";
        envGlobals.chipletTarget = "U1";
        envGlobals.pinCircleTarget = "VDD";

        envGlobals.bondpadList.add("Tio_rm_l_7 / 15");
        envGlobals.bondpadList.add("Tio_col_25 / 33");

        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget, "single", true);
        MainCall.commonLocators.verifySuccessNotif();
        MainCall.commonLocators.escape();

        MainCall.schematicPage.selectBonpad();
        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget, "single", false);
        MainCall.commonLocators.escape();

        MainCall.schematicPage.selectBondpadConfigs(envGlobals.bondpadList);
        MainCall.commonLocators.selectSave();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.commonLocators.verifySuccessNotif();

        routing();

/* -----------------------------------------------  'DIGS'  ----------------------------------------------- */
        logStep("/* ------------------------------------------------------------------------------------------------------------------------------------- */");
        logStep("DIGS");

        schematicSelection();
        MainCall.schematicPage.removeBondpads();

        envGlobals.option = "Digital";
        envGlobals.bondpadList.add("Padio_l_4 / 44");

        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget, "double", false);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.schematicPage.selectDriver();
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.commonLocators.escape();

        MainCall.schematicPage.selectBonpad();
        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget, "single", false);
        MainCall.commonLocators.escape();

        MainCall.schematicPage.selectBondpadConfigs(envGlobals.bondpadList);
        MainCall.schematicPage.selectDriver();
        MainCall.commonLocators.selectSave();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.commonLocators.verifySuccessNotif();

        routing();

/* -----------------------------------------------  'P'  ----------------------------------------------- */
        logStep("/* ------------------------------------------------------------------------------------------------------------------------------------- */");
        logStep("P");

        schematicSelection();
        MainCall.schematicPage.removeBondpads();

        envGlobals.option = "Power";

        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget, "double", false);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.commonLocators.escape();

        MainCall.schematicPage.selectBonpad();
        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget, "single", false);
        MainCall.commonLocators.escape();

//        routing();

/* -----------------------------------------------  'RDLS-ANAS'  ----------------------------------------------- */
        logStep("/* ------------------------------------------------------------------------------------------------------------------------------------- */");
        logStep("RDLS-ANAS");

        schematicSelection();
        MainCall.schematicPage.removeBondpads();

        envGlobals.type = "Metal Programmable";
        envGlobals.option = "Analog";
        envGlobals.bondpadList.add("Spare_b_5");

        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget, "double", false);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.commonLocators.escape();

        MainCall.schematicPage.selectBonpad();
        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget,"single", false);
        MainCall.commonLocators.escape();

        MainCall.schematicPage.selectBondpadConfigs(envGlobals.bondpadList);
        MainCall.commonLocators.selectSave();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.commonLocators.verifySuccessNotif();

        routing();

/* -----------------------------------------------  'RDLS-DIGS'  ----------------------------------------------- */
        logStep("/* ------------------------------------------------------------------------------------------------------------------------------------- */");
        logStep("RDLS-DIGS");

        schematicSelection();
        MainCall.schematicPage.removeBondpads();

        envGlobals.option = "Digital";

        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget, "double", false);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.schematicPage.selectDriver();
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.commonLocators.escape();

        MainCall.schematicPage.selectBonpad();
        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget,"single", false);
        MainCall.commonLocators.escape();

        MainCall.schematicPage.selectBondpadConfigs(envGlobals.bondpadList);
        MainCall.schematicPage.selectDriver();
        MainCall.commonLocators.selectSave();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.commonLocators.verifySuccessNotif();

        routing();

/* -----------------------------------------------  'RDLP'  ----------------------------------------------- */
        logStep("/* ------------------------------------------------------------------------------------------------------------------------------------- */");
        logStep("RDLP");

        schematicSelection();
        MainCall.schematicPage.removeBondpads();

        envGlobals.option = "Power";

        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget, "double", false);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.commonLocators.escape();

        MainCall.schematicPage.selectBonpad();
        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget,"single", false);
        MainCall.commonLocators.escape();

//        routing();

/* -----------------------------------------------  'RDLSX'  ----------------------------------------------- */
        logStep("/* ------------------------------------------------------------------------------------------------------------------------------------- */");
        logStep("RDLSX");

        schematicSelection();
        MainCall.schematicPage.removeBondpads();

        envGlobals.type = "Metal Only";
        envGlobals.option = "Signal";

        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget, "double", false);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.commonLocators.escape();

        MainCall.schematicPage.selectBonpad();
        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget,"single", false);
        MainCall.commonLocators.escape();

        MainCall.schematicPage.selectBondpadConfigs(envGlobals.bondpadList);
        MainCall.commonLocators.selectSave();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.commonLocators.verifySuccessNotif();

        routing();

/* -----------------------------------------------  'RDLPX'  ----------------------------------------------- */
        logStep("/* ------------------------------------------------------------------------------------------------------------------------------------- */");
        logStep("RDLPX");

        schematicSelection();
        MainCall.schematicPage.removeBondpads();

        envGlobals.type = "Metal Only";
        envGlobals.option = "Power";

        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget, "double", false);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.commonLocators.escape();

        MainCall.schematicPage.selectBonpad();
        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget,"single", false);
        MainCall.commonLocators.escape();

        MainCall.schematicPage.selectBondpadConfigs(envGlobals.bondpadList);
        MainCall.commonLocators.selectSave();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.commonLocators.verifySuccessNotif();

        routing();
    }


}
