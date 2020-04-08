package Objects;

import General.MainCall;
import General.WebDriverFactory;
import General.WebDriverWaits;
import General.envGlobals;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import static General.WebDriverFactory.action;
import static General.WebDriverFactory.robot;
import static utils.LogHelper.logStep;

public class schematicPage {
    public schematicPage(){}

    //Schematic Page Functions

    public static By bySchematic = By.id("subview-7");
    public static By byResistorToolTip = By.id("peripheral-resistor");
    public static By byResistorValue = By.id("resistorTooltip");

    public static By byBonpadToolTip = By.id("peripheral-bidirectional");
    public static By byBonpad = By.className("joint-type-bidirectional");
    public static By byMenuBonpadId = By.id("menu-bondpad_id");
    public static By byBonpadConfig = By.className("bondpad-config");

    public static By byResistor = By.className("joint-type-resistor");
    public static By byResistorLine = By.className("resistor");
    public static By byResistorCircle = By.className("joint-port-body");

    public static By bySchematicView = By.id("schematicView");
    public static By byVLine = By.className("v-line");
    public static By bySelectionSpace = By.className("selection-space");
    public static By byLabel = By.className("label");
    public static By byPortLabel = By.className("port-label");
    public static By byPortTag = By.className("port-tag");
    public static By byPortBodyLine = By.className("port-body-line");
    public static By byPortBody = By.className("port-body");

    public static By byNetName = By.name("netname");
    public static By byTypeDropDown = By.className("dropdown-btn");
    public static By byOtgRow = By.name("otg_m_row");
    public static By byOtgCol = By.name("otg_m_col");
    public static By byMenu = By.cssSelector("ul[role='menu']");
    public static By byMenuItems = By.cssSelector("div[role='button']");
    public static By byMenuItemsList = By.className("dropdown-list");
    public static By byFormControl = By.className("form-control");
    public static By byFormInput = By.className("form-input");

    public static By byLevelShifterDropDown = By.className("level-shifter-dropdowns");

    public static By byDiv = By.tagName("div");
    public static By bySpan = By.tagName("span");
    public static By byInput = By.tagName("input");
    public static By byCircle = By.tagName("circle");
    public static By byButton = By.tagName("button");
    public static By byLi = By.tagName("li");
//    ul[role='listbox'] li

    public static By byTable = By.tagName("table");
    public static By byTBody = By.tagName("tbody");
    public static By byTHead = By.tagName("thead");
    public static By byTh = By.tagName("th");
    public static By byTr = By.tagName("tr");
    public static By byTd = By.tagName("td");

    public static By byPrompt = By.className("modal-content-body");
    public static By byH2 = By.tagName("H2");
    public static By byDropDown = By.cssSelector("ul[role='listbox']");
    public static By byDriverCheckbox = By.cssSelector("input[type='checkbox']");

    public void selectSchematic(){
        logStep("User clicks on Schematic");
        WebDriverFactory.getDriver().findElement(bySchematic).click();

        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.chipletPage.openAllContainers();
    }

    public void selectBonpad(){
        logStep("User clicks on Bonpad");
        WebDriverFactory.getDriver().findElement(byBonpadToolTip).click();
    }

    public void selectDriver(){
        logStep("User clicks on Driver checkbox");
        WebDriverFactory.getDriver().findElement(byPrompt).findElement(byDriverCheckbox).click();
    }

    public void selectResistorToolTip(String value){
        logStep("User clicks on Resistor and inputs value also");

        WebDriverFactory.getDriver().findElement(byResistorToolTip).click();
        WebDriverFactory.getDriver().findElement(byResistorValue).findElement(byInput).clear();
        WebDriverFactory.getDriver().findElement(byResistorValue).findElement(byInput).sendKeys(value);
    }

    public WebElement vLinePinCircle(String pin){
        return WebDriverFactory.getDriver().findElement(By.xpath("//*[./text()='" + pin + "']/../preceding-sibling::*[@magnet=\"passive\"]"));
    }

    public static String vLineText = "";

    public void selectPinCircle(String chip, String pinCircle, String condition, boolean check){
        logStep("User clicks on pin " + pinCircle + " circle");

        WebElement chiplet = WebDriverFactory.getDriver().findElement(By.xpath("//*[./text()='" + chip + "']/../parent::*[@class=\"rotatable\"]"));

        List<WebElement> portLabel = chiplet.findElements(byPortLabel);
        List<WebElement> portBody = chiplet.findElements(byPortBody);

        for (int i = 0; i<portLabel.size() ; i++) {
            vLineText = portLabel.get(i).findElement(byVLine).getText();

            if (vLineText.equals(pinCircle)) {
                WebDriverWaits.sleep500();
                if (condition.equalsIgnoreCase("double"))
                    action.doubleClick(portBody.get(i)).click().build().perform();
                else
                    action.moveToElement(portBody.get(i)).click().build().perform();
                break;
            }
        }

        WebDriverWaits.waitUntilLoaderDisapears();
        if(check)
            MainCall.commonLocators.verifySuccessNotif();
    }

    public void selectPinName(String pinCircle, String pinName){
        logStep("User clicks on pin " + pinName + " twice");

        List<WebElement> portTag = WebDriverFactory.getDriver().findElements(byPortTag);
        WebElement vLineElement = null;

        for (int i = 0; i<portTag.size() ; i++) {
            vLineElement = portTag.get(i).findElement(byVLine);
            vLineText = vLineElement.getText();

            if (vLineText.equals(pinName)) {
                action.doubleClick(vLineElement).perform();
                break;
            }
        }

        MainCall.commonLocators.checkPromptOpen(pinCircle);
    }

    public void updateNetname(String newNetname){
        logStep("User updates netname to " + newNetname);

        WebDriverWaits.sleep500();
//        WebDriverWaits.visibilityOf(WebDriverFactory.getDriver().findElement(byNetName));
//        WebElement netName = WebDriverFactory.getDriver().findElement(byNetName);

        MainCall.commonLocators.clearField(WebDriverFactory.getDriver().findElement(byNetName));
        WebDriverFactory.getDriver().findElement(byNetName).sendKeys(newNetname);
    }

    public void verifyNewNetname(String newNetname){
        logStep("Verify new netname " + newNetname);

        List<WebElement> portTag = WebDriverFactory.getDriver().findElements(byPortTag);

        for (int i=0 ; i<portTag.size() ; i++) {
//            vLineText = portTag.get(i).findElement(byVLine).getText();
            vLineText = portTag.get(i).getText();

            if (vLineText.equals(newNetname)) {
                Assert.assertTrue(vLineText.equals(newNetname));
                break;
            }
        }
    }

    public void selectResistorPin(int index, String condition){
        logStep("User selects pin " + index + " of Resistor");

        List<WebElement> resistorList = WebDriverFactory.getDriver().findElements(byResistor);
        List<WebElement> unattachedResistorList = new ArrayList<WebElement>();
        int resistorsCount = resistorList.size();

        for (int i=0 ; i<resistorsCount ; i++){
            List<WebElement> portTag = resistorList.get(i).findElements(byResistorCircle);

            if (portTag.get(0).getAttribute("port-tag") == null && portTag.get(1).getAttribute("port-tag") == null)
                unattachedResistorList.add(resistorList.get(i));
        }

        int unattachedResistorCount = unattachedResistorList.size();

        for (int i=0 ; i<unattachedResistorCount ; i++) {
//            if (unattachedResistorCount < 1){
//                action.doubleClick(unattachedResistorList.get(0).findElements(byResistorCircle).get(index)).perform();
////                unattachedResistorList.get(0).findElements(byResistorCircle).get(index).click();
//                MainCall.commonLocators.checkPromptOpen("Resistor");
//            }
//            else {
            if (condition.equalsIgnoreCase("double")){
                action.doubleClick(unattachedResistorList.get(i).findElements(byResistorCircle).get(index)).perform();
                MainCall.commonLocators.checkPromptOpen("Resistor");
            }
            else {
                action.moveToElement(unattachedResistorList.get(i).findElements(byResistorCircle).get(index)).click().build().perform();
//                MainCall.commonLocators.verifySuccessNotif();
            }
//                unattachedResistorList.get(i).findElements(byResistorCircle).get(index).click();
            break;
//            }
        }
    }

    public void selectType(String type, String option){
        logStep("User selects menu type " + type + " and option " + option);

//        if (WebDriverFactory.getDriver().findElement(byTypeDropDown).findElement(bySpan).findElement(byDiv).findElement(byDiv).getText().equals("Unassigned")){
            WebDriverFactory.getDriver().findElement(byTypeDropDown).click();
            WebDriverWaits.sleep500();

            WebElement menu = WebDriverFactory.getDriver().findElement(byMenu);
            List<WebElement> menuItems = menu.findElements(byMenuItems);

            for (int i=0 ; i<menuItems.size() ; i++) {
                String menuItemsText = menuItems.get(i).findElement(byDiv).findElement(bySpan).getText();

                if (menuItemsText.equals(type)) {
                    menuItems.get(i).click();

                WebDriverWaits.sleep500();
                List<WebElement> menuItemsList = menu.findElement(byMenuItemsList).findElements(byLi);

                    for (int j=0; j<menuItemsList.size() ; j++) {
                        String menuItemsListText = menuItemsList.get(j).findElement(byDiv).getText();

                        if (menuItemsListText.equals(option))
                            menuItemsList.get(j).click();
                    }

                    WebDriverWaits.sleep1000();
                    break;
                }
            }
//        }
    }

    public void inputOtg(int row, int col){
        WebDriverFactory.getDriver().findElement(byOtgRow).sendKeys(String.valueOf(row));
        WebDriverFactory.getDriver().findElement(byOtgCol).sendKeys(String.valueOf(col));
    }

    public void selectChiplet(String chip){
        logStep("User selects " + chip + " chiplet");
        WebDriverFactory.getDriver().findElement(By.xpath("//*[./text()='" + chip + "']/../preceding-sibling::*[@class=\"body\"]")).click();
        WebDriverWaits.visibilityOf(MainCall.commonLocators.promptTitle().findElement(byH2));
    }

    public void verifyPromptTitle(String title){
        String text = MainCall.commonLocators.promptTitle().findElement(byH2).getText();
        Assert.assertTrue(text.equals(title));
    }

    public void powerSupplyConfigs(int rowNum, boolean byPassMode, boolean currentLimit, String voltOutput, boolean config){
        verifyPromptTitle("LDO Config");

        logStep("Power Supply configs updated");

        WebElement row = WebDriverFactory.getDriver().findElement(byPrompt).findElement(byTable).findElement(byTBody).findElements(byTr).get(rowNum-1);
        WebDriverWaits.visibilityOf(MainCall.commonLocators.promptTitle());

        // BYPASS MODE
        row.findElements(byTd).get(0).click();
        WebDriverWaits.sleep250();
        if (!byPassMode)
            WebDriverFactory.getDriver().findElement(byDropDown).findElements(byLi).get(0).click();
        else
            WebDriverFactory.getDriver().findElement(byDropDown).findElements(byLi).get(1).click();
        WebDriverWaits.sleep250();

        // CURRENT LIMIT
        row.findElements(byTd).get(1).click();
        WebDriverWaits.sleep250();
        if (!currentLimit)
            WebDriverFactory.getDriver().findElement(byDropDown).findElements(byLi).get(0).click();
        else
            WebDriverFactory.getDriver().findElement(byDropDown).findElements(byLi).get(1).click();
        WebDriverWaits.sleep250();

        // VOLTAGE OUTPUT
        row.findElements(byTd).get(2).click();
        WebDriverWaits.sleep250();
        List<WebElement> voltList = WebDriverFactory.getDriver().findElement(byDropDown).findElements(byLi);
        for (int i=0 ; i<voltList.size() ; i++) {
            if (voltList.get(i).getText().contains(voltOutput))
                voltList.get(i).click();
        }
        WebDriverWaits.sleep250();

        // CONFIGURE
        if (config)
            row.findElements(byTd).get(3).findElement(byInput).click();
        WebDriverWaits.sleep250();
    }

    public void headingList(){
        List<WebElement> headings = WebDriverFactory.getDriver().findElement(byPrompt).findElement(byTable).findElement(byTHead).findElements(byTh);

        for (int i=0 ; i<headings.size() ; i++) {
            if (headings.get(i).getText().equalsIgnoreCase("GPIO Port"))
                envGlobals.gpioPortHeading = i-1;
            else if (headings.get(i).getText().equalsIgnoreCase("Pin Level"))
                envGlobals.pinLevelHeading = i-1;
            else if (headings.get(i).getText().equalsIgnoreCase("Function"))
                envGlobals.functionHeading = i-1;
            else if (headings.get(i).getText().equalsIgnoreCase("Configure"))
                envGlobals.configHeading = i-1;
            else if (headings.get(i).getText().equalsIgnoreCase("Pname"))
                envGlobals.pNameHeading = i-1;
        }
    }

    public void gpioConfig(int rowNum, int pinLevel, int function, boolean config){
        verifyPromptTitle("GPIO Config");

        logStep("GPIO configs updated");

        WebElement row = WebDriverFactory.getDriver().findElement(byPrompt).findElement(byTable).findElement(byTBody).findElements(byTr).get(rowNum-1);
        WebDriverWaits.visibilityOf(MainCall.commonLocators.promptTitle());
        headingList();

        // PIN LEVEL
        row.findElements(byTd).get(envGlobals.pinLevelHeading).click();
        WebDriverFactory.getDriver().findElement(byDropDown).findElements(byLi).get(pinLevel).click();
        WebDriverWaits.sleep250();

        // FUNCTION
        row.findElements(byTd).get(envGlobals.functionHeading).click();
        WebDriverFactory.getDriver().findElement(byDropDown).findElements(byLi).get(function).click();
        WebDriverWaits.sleep250();

        // CONFIGURE
        if (config)
            row.findElements(byTd).get(envGlobals.configHeading).findElement(byInput).click();
        WebDriverWaits.sleep250();
    }

    public void levelShifterConfig(String chip, int row, String type, String config){
        verifyPromptTitle("Level Shifter " + chip);

        logStep("Level Shifter configs");

        int dropDown1 = (row * 2) - 2;
        int dropDown2 = (row * 2) - 1;

        WebElement dropDowns = WebDriverFactory.getDriver().findElement(byLevelShifterDropDown);
        WebElement firstDropDown = dropDowns.findElements(byFormInput).get(dropDown1);
        WebElement bondpadConfig = dropDowns.findElements(byFormInput).get(dropDown2);

        firstDropDown.click();
        WebDriverWaits.sleep500();

        WebElement menu = WebDriverFactory.getDriver().findElement(byDropDown);
        List<WebElement> menuItems = menu.findElements(byLi);

        // first dropdown selection respective to same string
        for (int i=0 ; i<menuItems.size() ; i++) {
            String menuItemsText = menuItems.get(i).getText();

            if (menuItemsText.equals(type)){
                menuItems.get(i).click();
                WebDriverWaits.sleep500();
                break;
            }
        }

        bondpadConfig.click();
        WebDriverWaits.sleep500();

        menu = WebDriverFactory.getDriver().findElement(byDropDown);
        menuItems = menu.findElements(byLi);

        for (int i=0 ; i<menuItems.size() ; i++) {
            String menuItemsText = menuItems.get(i).findElement(byDiv).findElement(bySpan).getText();

            if (menuItemsText.equals(config)){
                menuItems.get(i).click();
                WebDriverWaits.sleep500();
                break;
            }
        }
    }

    public void removeAllNetNames(){
        logStep("User removes all netNames");

//        action = new Actions(WebDriverFactory.getDriver());
        List<WebElement> portTag = WebDriverFactory.getDriver().findElements(byPortTag);
        int removeCount = portTag.size();

        if (removeCount > 0) {
            for (int i=removeCount-1 ; i>=0 ; i--) {
                action.moveToElement(vLinePinCircle(WebDriverFactory.getDriver().findElements(byPortTag).get(0).getText())).click().build().perform();
                MainCall.commonLocators.delete();

                WebDriverWaits.waitUntilLoaderDisapears();
//                MainCall.commonLocators.verifySuccessNotif("Pin saved");
            }
        }
    }


    public void removeAllResistors(){
        logStep("User removes all resistors");

//        action = new Actions(WebDriverFactory.getDriver());
        List<WebElement> resistorLines = WebDriverFactory.getDriver().findElements(byResistorLine);
        int removeCount = resistorLines.size();

        if (removeCount > 0) {
            for (int i=removeCount-1 ; i>=0 ; i--) {
                action.moveToElement(resistorLines.get(i)).click().build().perform();
                MainCall.commonLocators.delete();

                WebDriverWaits.waitUntilLoaderDisapears();
                MainCall.commonLocators.verifySuccessNotif();
            }
        }
    }

    public void selectTioCol(String tio){
        logStep("User selects " + tio);

        WebElement colDropDown = WebDriverFactory.getDriver().findElement(byPrompt).findElements(byFormControl).get(1).findElement(byDiv);
        colDropDown.click();
        WebDriverWaits.sleep250();

        List<WebElement> tioList = WebDriverFactory.getDriver().findElement(byDropDown).findElements(byLi);
        int count = tioList.size();

        for (int i=0 ; i<count ; i++) {
            if(tioList.get(i).findElement(byDiv).findElement(bySpan).getText().equals(tio)) {
                tioList.get(i).click();
                WebDriverWaits.sleep500();
                break;
            }
        }

        Assert.assertTrue(colDropDown.getText().equals(tio.toLowerCase()));
    }

    public void removeBondpads(){
        List<WebElement> bondpad = WebDriverFactory.getDriver().findElements(byBonpad);
        int bondpadCount = bondpad.size();

        if (bondpadCount>0) {
            for (WebElement aBondpad : bondpad) {
                aBondpad.click();
                robot.keyPress(KeyEvent.VK_DELETE);
                robot.keyRelease(KeyEvent.VK_DELETE);
//                aBondpad.sendKeys(Keys.BACK_SPACE);
                WebDriverWaits.waitUntilLoaderDisapears();
            }
        }
    }

    public void selectBondpadConfigs(List<String> list){
        logStep("User double clicks on BONDPAD and selects Bondpad Configuration");

        List<WebElement> bondpad = WebDriverFactory.getDriver().findElements(byBonpad);
        int bondpadCount = bondpad.size();
        WebElement bondpadDropDown = null;
        List<WebElement> tioList;
        int count;

        if (bondpadCount > 0){
            for (int i=0 ; i<bondpadCount ; i--) {
                action.doubleClick(bondpad.get(i)).perform();

                WebDriverWaits.sleep1000();

                bondpadDropDown = WebDriverFactory.getDriver().findElement(byBonpadConfig).findElement(byFormControl).findElement(byDiv);

                bondpadDropDown.click();
                WebDriverWaits.sleep500();

                tioList = WebDriverFactory.getDriver().findElement(byDropDown).findElements(byLi);
                count = tioList.size();

                for (int j=0 ; j<count ; j++) {
                    String configText = tioList.get(j).findElement(byDiv).findElement(bySpan).getText();

                    for (int k=0 ; k<list.size() ; k++) {
                        if (configText.equalsIgnoreCase(list.get(k))) {
                            tioList.get(j).click();
                        }
                    }
                }
                action.moveToElement(MainCall.commonLocators.rightContainer()).click().build().perform();
                WebDriverWaits.sleep500();
                break;
            }
        }
    }

}
