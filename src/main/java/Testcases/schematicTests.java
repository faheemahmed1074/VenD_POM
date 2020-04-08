package Testcases;

import General.MainCall;
import General.WebDriverWaits;
import General.baseTest;
import General.envGlobals;
import org.testng.annotations.Test;

import java.awt.*;

import static Config.configProperties.chipSystem;
import static Testcases.loginTests.loginIntoZGlueApplication;
import static Testcases.routerTests.routing;
import static Testcases.systemTests.importSystem;

public class schematicTests extends baseTest {

    public static void schematicSelection() throws InterruptedException {
//        MainCall.systemPage.selectDefaultSystem();
//        try {
//            importSystem();
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }

        logStep("User is in Schematic View");

//        MainCall.chipletPage.removeAllChiplets();
        MainCall.navBarPage.selectBuild();
        MainCall.schematicPage.selectSchematic();
        MainCall.commonLocators.verifyRightContainer();
//        MainCall.schematicPage.removeAllResistors();
//        MainCall.schematicPage.removeAllNetNames();
    }

    public static void func(int sysNumber) throws InterruptedException {
//        loginIntoZGlueApplication();
        MainCall.systemPage.searchAndSelectSystem(envGlobals.sysNames.get(sysNumber));
        envGlobals.systemSelection++;
        schematicSelection();
    }

    // POWER SUPPLY CONNECTIONS
    @Test
    public static void powerSupplyConnections() throws InterruptedException {
        func(envGlobals.systemSelection);
//        loginIntoZGlueApplication();
//        MainCall.systemPage.searchAndSelectSystem("AutoSystem0_31071");
//        schematicSelection();

        // LDO1
        logStep("User connects pin-to-pin with LDO1");

        // POWER SUPPLY CONNECTION WITH CHIPLETS
        envGlobals.chiplet = "U23";
        envGlobals.pinCircle = "VDD_ANA";
        envGlobals.newNetName= "net1";
        envGlobals.type = "Programmable";
        envGlobals.option = "Analog";

        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.commonLocators.escape();

        // APPLY RESISTOR ON NET
        MainCall.schematicPage.selectResistorToolTip("10000");
        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single",  true);
        MainCall.commonLocators.escape();

        envGlobals.chiplet = "S3";
        envGlobals.pinCircle = "LDO1";
        envGlobals.newNetName= "VDD_1";

        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectResistorPin(1, "single");
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.commonLocators.verifySuccessNotif();
        MainCall.commonLocators.escape();


        // LDO2
        logStep("User connects pin-to-pin with LDO2");

        // POWER SUPPLY CONNECTION WITH CHIPLETS
        envGlobals.chiplet = "U1";
        envGlobals.pinCircle = "CLK_OUT";
        envGlobals.newNetName= "net2";
        envGlobals.type = "Programmable";
        envGlobals.option = "Analog";

        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.commonLocators.escape();

        // APPLY RESISTOR ON NET
        MainCall.schematicPage.selectResistorToolTip("10000");
        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single",  true);
        MainCall.commonLocators.escape();

        envGlobals.chiplet = "S3";
        envGlobals.pinCircle = "LDO2";
        envGlobals.newNetName= "VDD_2";

        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectResistorPin(1, "single");
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.commonLocators.verifySuccessNotif();
        MainCall.commonLocators.escape();


        //GND
        logStep("User connects pin-to-pin with GND");

        // POWER SUPPLY CONNECTION WITH CHIPLETS
        envGlobals.chiplet = "U23";
        envGlobals.pinCircle = "GND_ANA";
        envGlobals.newNetName= "net3";
        envGlobals.type = "Programmable";
        envGlobals.option = "Analog";

        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.commonLocators.escape();

        // APPLY RESISTOR ON NET
        MainCall.schematicPage.selectResistorToolTip("10000");
        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single",  true);
        MainCall.commonLocators.escape();

        envGlobals.chiplet = "S3";
        envGlobals.pinCircle = "GND";
        envGlobals.newNetName= "GND_1";

        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectResistorPin(1, "single");
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.commonLocators.verifySuccessNotif();
        MainCall.commonLocators.escape();

        routing();
    }

    // GPIO EXPANDER CONNECTIONS
    @Test
    public static void gpioExpanderConnection() throws InterruptedException {
        func(envGlobals.systemSelection);
//        loginIntoZGlueApplication();
//        MainCall.systemPage.searchAndSelectSystem("AutoSystem2_27632");
//        schematicSelection();

        logStep("User connects pin-to-pin with GPIO Expander");

        logStep("/* ------------------------------------------------------------------------------------------------------------------------------------- */");
        logStep("GPIO EXPANDER");
        logStep("User connects pin-to-pin with GPIO Expander");
        // GPIO EXPANDER CONNECTION WITH CHIPLETS
        envGlobals.chiplet = "S4";
        envGlobals.pinCircle = "GPIO0";
        envGlobals.newNetName= "GPIO_0";
        envGlobals.chipletTarget = "U23";
        envGlobals.pinCircleTarget = "GPIO1";
        envGlobals.type = "Programmable";
        envGlobals.option = "Analog";

        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget, "single", true);
        MainCall.commonLocators.escape();

        // GPIO EXPANDER
        MainCall.schematicPage.selectChiplet(envGlobals.chiplet);
        MainCall.schematicPage.gpioConfig(1, 0, 1, true);
        MainCall.commonLocators.selectSet();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.commonLocators.selectCross();
        MainCall.commonLocators.verifySuccessNotif();

        routing();
    }

    // LEVEL SHIFTER CONNECTIONS
    @Test
    public static void levelShifterConnections() throws InterruptedException {
        func(envGlobals.systemSelection);
//        loginIntoZGlueApplication();
//        MainCall.systemPage.searchAndSelectSystem("AutoSystem2_27632");
//        schematicSelection();

        logStep("LEVEL SHIFTERS");
        logStep("User connects pin-to-pin with Level Shifters");

        envGlobals.chiplet = "S3";
        envGlobals.pinCircle = "LDO1";
        envGlobals.newNetName= "VDD_1";
        envGlobals.chipletTarget = "S6";
        envGlobals.pinCircleTarget = "V_A";

        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget, "single", true);
        MainCall.commonLocators.escape();

        envGlobals.chiplet = "S3";
        envGlobals.pinCircle = "LDO2";
        envGlobals.newNetName= "VDD_2";
        envGlobals.chipletTarget = "S6";
        envGlobals.pinCircleTarget = "V_B";

        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget, "single", true);
        MainCall.commonLocators.escape();

        envGlobals.chiplet = "U23";
        envGlobals.pinCircle = "GND_DIG";
        envGlobals.newNetName= "net_1";
        envGlobals.chipletTarget = "S6";
        envGlobals.pinCircleTarget = "A1";
        envGlobals.type = "Metal Programmable";
        envGlobals.option = "Analog";

        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget, "single", true);
        MainCall.commonLocators.escape();

        envGlobals.chiplet = "U1";
        envGlobals.pinCircle = "CLK_OUT";
        envGlobals.newNetName= "net_2";
        envGlobals.chipletTarget = "S6";
        envGlobals.pinCircleTarget = "B1";
        envGlobals.type = "Programmable";
        envGlobals.option = "Analog";

        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget,"single", true);
        MainCall.commonLocators.escape();

        envGlobals.levelShifter = "A1 <> B1";
        envGlobals.spare = "Spare_lt_l_4";

        // LEVEL SHIFTER
        MainCall.schematicPage.selectChiplet(envGlobals.chipletTarget);
        MainCall.schematicPage.levelShifterConfig(envGlobals.chipletTarget, 1, envGlobals.levelShifter, envGlobals.spare);
        MainCall.commonLocators.selectSet();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.commonLocators.selectCross();
        MainCall.commonLocators.verifySuccessNotif();

        routing();
    }

    // RESISTOR CONNECTIONS
    @Test
    public static void resistorsConnections() throws InterruptedException {
        func(envGlobals.systemSelection);
//        loginIntoZGlueApplication();
//        MainCall.systemPage.searchAndSelectSystem("AutoSystem6_64023");
//        schematicSelection();

        logStep("User connects resistors with other chiplets");

        logStep("RESISTORS");
        logStep("PULL-UP RESISTORS");
        // PULLUP RESISTOR
        envGlobals.chiplet = "U23";
        envGlobals.pinCircle = "GND_DIG";
        envGlobals.newNetName= "VDD_1";
        envGlobals.chipletTarget = "S3";
        envGlobals.pinCircleTarget = "LDO1";
        envGlobals.resistorNetName = "VDD_1";
        envGlobals.type = "Programmable";
        envGlobals.option = "Analog";

        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget,"single", false);
        MainCall.schematicPage.updateNetname(envGlobals.resistorNetName);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.resistorNetName);
        MainCall.commonLocators.escape();
        MainCall.schematicPage.selectResistorToolTip("10000");
        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single",  false);
        MainCall.commonLocators.escape();
        MainCall.schematicPage.selectResistorPin(1, "double");
        MainCall.schematicPage.updateNetname(envGlobals.resistorNetName);
//        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.resistorNetName);


        logStep("PULL-DOWN RESISTORS");
        // PULLDOWN RESISTOR
        envGlobals.chiplet = "U1";
        envGlobals.pinCircle = "CLK_OUT";
//        envGlobals.newNetName= "GND_1";
        envGlobals.chipletTarget = "S3";
        envGlobals.pinCircleTarget = "GND";
        envGlobals.resistorNetName = "GND_1";
        envGlobals.type = "Programmable";
        envGlobals.option = "Analog";

        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget,"single", false);
        MainCall.schematicPage.updateNetname(envGlobals.resistorNetName);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.resistorNetName);
        MainCall.commonLocators.escape();
        MainCall.schematicPage.selectResistorToolTip("10000");
        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.commonLocators.escape();
        MainCall.schematicPage.selectResistorPin(0, "double");
        MainCall.schematicPage.updateNetname(envGlobals.resistorNetName);
//        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.resistorNetName);


        logStep("PULL SERIES RESISTORS");
        // PULL SERIES
        envGlobals.chiplet = "U23";
        envGlobals.pinCircle = "VREF";
        envGlobals.newNetName= "net_3";
        envGlobals.chipletTarget = "U1";
        envGlobals.pinCircleTarget = "VDD";
        envGlobals.resistorNetName = "resis3";
        envGlobals.type = "Programmable";
        envGlobals.option = "Analog";

        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget,"single", false);
        MainCall.schematicPage.updateNetname(envGlobals.resistorNetName);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.resistorNetName);
        MainCall.commonLocators.escape();
        MainCall.schematicPage.selectResistorToolTip("10000");
        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.commonLocators.escape();
        MainCall.schematicPage.selectResistorPin(0, "double");
        MainCall.schematicPage.updateNetname(envGlobals.resistorNetName);
//        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.resistorNetName);

        routing();
    }

    // BONDPAD SCHEMATIC
    @Test
    public void bondPadConnection() throws InterruptedException {
        func(envGlobals.systemSelection);

        logStep("BONDPAD");
        logStep("User connects bondpads with other chiplets");

        envGlobals.chiplet = "U23";
        envGlobals.pinCircle = "VDD_DIG";
//        envGlobals.newNetName= "BondPad-1";
//        envGlobals.chipletTarget = "GND";
//        envGlobals.pinCircleTarget = "GND";
//        envGlobals.type = "Programmable";
//        envGlobals.option = "Analog";
        envGlobals.bondpadList.add("Tio_rm_l_7 / 15");
        envGlobals.bondpadList.add("tio_col_25 / 33");

        MainCall.schematicPage.selectBonpad();
        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.commonLocators.escape();

        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "double", false);
//        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
//        MainCall.schematicPage.selectTioCol("Tio_col_16");
        MainCall.commonLocators.selectNetnameSave();
//        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
//        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget);
        MainCall.commonLocators.escape();
        MainCall.schematicPage.selectBondpadConfigs(envGlobals.bondpadList);
        MainCall.commonLocators.selectSave();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.commonLocators.verifySuccessNotif();

        routing();
    }

/* ------------------------------------------------------------------------------------------------------------------------------------- */

    // END-TO-END SCHEMATIC
    @Test
    public void endToEndSchematic() throws InterruptedException {
        func(envGlobals.systemSelection);

/* -----------------------------------------------  POWER SUPPLY  ----------------------------------------------- */

        logStep("/* ------------------------------------------------------------------------------------------------------------------------------------- */");
        logStep("POWER SUPPLY");
        logStep("User connects pin-to-pin with Power Supply");
        // POWER SUPPLY CONNECTION WITH CHIPLETS
        envGlobals.chiplet = "S3";
        envGlobals.pinCircle = "LDO1";
        envGlobals.newNetName= "VDD_1";
        envGlobals.chipletTarget = "U1";
        envGlobals.pinCircleTarget = "GND";

        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget,"single", true);
        MainCall.commonLocators.escape();

        envGlobals.chiplet = "U23";
        envGlobals.pinCircle = "GND_ANA";
        envGlobals.newNetName= "VDD_2";
        envGlobals.chipletTarget = "S3";
        envGlobals.pinCircleTarget = "LDO2";

        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget,"single", true);
        MainCall.commonLocators.escape();

/* -----------------------------------------------  GPIO EXPANDER  ----------------------------------------------- */

        logStep("/* ------------------------------------------------------------------------------------------------------------------------------------- */");
        logStep("GPIO EXPANDER");
        logStep("User connects pin-to-pin with GPIO Expander");
        // GPIO EXPANDER CONNECTION WITH CHIPLETS
        envGlobals.chiplet = "S4";
        envGlobals.pinCircle = "GPIO0";
        envGlobals.newNetName= "GPIO_0";
        envGlobals.chipletTarget = "U23";
        envGlobals.pinCircleTarget = "GPIO1";
        envGlobals.type = "Programmable";
        envGlobals.option = "Analog";
        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget,"single", true);
        MainCall.commonLocators.escape();

/* -----------------------------------------------  LEVEL SHIFTER  ----------------------------------------------- */

        logStep("/* ------------------------------------------------------------------------------------------------------------------------------------- */");
        logStep("LEVEL SHIFTERS");
        logStep("User connects pin-to-pin with Level Shifters");
        // LEVEL SHIFTER CONNECTION WITH CHIPLETS
        envGlobals.chiplet = "S6";
        envGlobals.pinCircle = "V_A";
        envGlobals.newNetName= "VDD_1";
//        envGlobals.chipletTarget = "S3";
//        envGlobals.pinCircleTarget = "LDO1";

        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.commonLocators.escape();

        envGlobals.chiplet = "S3";
        envGlobals.pinCircle = "LDO3";
        envGlobals.newNetName= "VDD_3";
        envGlobals.chipletTarget = "S6";
        envGlobals.pinCircleTarget = "V_B";
        envGlobals.type = "Programmable";
        envGlobals.option = "Analog";

        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget,"single", true);
        MainCall.commonLocators.escape();

        // LEVEL SHIFTER A1 & B1
        envGlobals.chiplet = "S6";
        envGlobals.pinCircle = "A1";
        envGlobals.newNetName= "net_1";
        envGlobals.chipletTarget = "U23";
        envGlobals.pinCircleTarget = "GND_DIG";
        envGlobals.type = "Programmable";
        envGlobals.option = "Analog";

        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget,"single", true);
        MainCall.commonLocators.escape();

        envGlobals.chiplet = "S6";
        envGlobals.pinCircle = "B1";
        envGlobals.newNetName= "net_2";
        envGlobals.chipletTarget = "U1";
        envGlobals.pinCircleTarget = "CLK_OUT";
        envGlobals.type = "Programmable";
        envGlobals.option = "Analog";

        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget,"single", true);
        MainCall.commonLocators.escape();

/* -----------------------------------------------  RESISTORS  ----------------------------------------------- */

        logStep("/* ------------------------------------------------------------------------------------------------------------------------------------- */");
        logStep("RESISTORS");
        logStep("PULL-UP RESISTORS");
        // PULLUP RESISTOR
        envGlobals.chiplet = "U23";
        envGlobals.pinCircle = "GND_DIG";
        envGlobals.newNetName= "VDD_1";
//        envGlobals.chipletTarget = "S3";
//        envGlobals.pinCircleTarget = "LDO1";
        envGlobals.type = "Programmable";
        envGlobals.option = "Analog";

        MainCall.schematicPage.selectResistorToolTip("10000");
        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.commonLocators.escape();
        MainCall.schematicPage.selectResistorPin(1, "double");
        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
//        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
//        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget, "single", true);
//        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
//        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
//        MainCall.commonLocators.selectNetnameSave();
        MainCall.commonLocators.escape();

        logStep("PULL-DOWN RESISTORS");
        // PULLDOWN RESISTOR
        envGlobals.chiplet = "U1";
        envGlobals.pinCircle = "CLK_OUT";
        envGlobals.newNetName= "GND_1";
        envGlobals.chipletTarget = "S3";
        envGlobals.pinCircleTarget = "GND";
        envGlobals.type = "Programmable";
        envGlobals.option = "Analog";

        MainCall.schematicPage.selectResistorToolTip("10000");
        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.commonLocators.escape();
        MainCall.schematicPage.selectResistorPin(1, "double");
        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
//        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget,"single", true);
        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.commonLocators.escape();

        logStep("PULL SERIES RESISTORS");
        // PULL SERIES
        envGlobals.chiplet = "U1";
        envGlobals.pinCircle = "VDD";
        envGlobals.newNetName= "net_3";
        envGlobals.chipletTarget = "U23";
        envGlobals.pinCircleTarget = "VREF";
        envGlobals.resistorNetName = "resis";
        envGlobals.type = "Programmable";
        envGlobals.option = "Analog";

        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget,"single", true);
        MainCall.commonLocators.escape();
        MainCall.schematicPage.selectResistorToolTip("10000");
        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget,"single", false);
        MainCall.commonLocators.escape();
        MainCall.schematicPage.selectResistorPin(1, "double");
        MainCall.schematicPage.updateNetname(envGlobals.resistorNetName);
//        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
        MainCall.commonLocators.selectNetnameSave();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.schematicPage.verifyNewNetname(envGlobals.resistorNetName);

/* -----------------------------------------------  BONDPAD  ----------------------------------------------- */

//        logStep("/* ------------------------------------------------------------------------------------------------------------------------------------- */");
//        logStep("BONDPAD");
//        logStep("User connects bondpads with other chiplets");
//        envGlobals.chiplet = "U23";
//        envGlobals.pinCircle = "VDD_DIG";
////        envGlobals.newNetName= "BondPad-1";
////        envGlobals.chipletTarget = "GND";
////        envGlobals.pinCircleTarget = "GND";
////        envGlobals.type = "Programmable";
////        envGlobals.option = "Analog";
//        MainCall.schematicPage.selectBonpad();
//        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "single", false);
//        MainCall.commonLocators.escape();
//
//        MainCall.schematicPage.selectPinCircle(envGlobals.chiplet, envGlobals.pinCircle, "double", false);
////        MainCall.schematicPage.updateNetname(envGlobals.newNetName);
//        MainCall.schematicPage.selectType(envGlobals.type, envGlobals.option);
////        MainCall.schematicPage.selectTioCol("Tio_col_16");
//        MainCall.commonLocators.selectNetnameSave();
////        MainCall.schematicPage.verifyNewNetname(envGlobals.newNetName);
////        MainCall.schematicPage.selectPinCircle(envGlobals.chipletTarget, envGlobals.pinCircleTarget,"single", true);
//        MainCall.commonLocators.escape();
//        MainCall.schematicPage.selectBondpadConfigs("Tio_rm_l_7");
//        MainCall.commonLocators.selectSave();
//        WebDriverWaits.waitUntilLoaderDisapears();
//        MainCall.commonLocators.verifySuccessNotif();

        routing();
    }


}
