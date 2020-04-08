package Objects;

import General.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static Config.configProperties.chipSystem;
import static utils.LogHelper.logStep;

public class chipletPage {

    public chipletPage() {}

    //Chiplet Page Functions

    public static By byChiplet = By.className("chiplet");
    public static By byChipletList = By.id("chiplet-list");
    public static By byMainBoard = By.id("mainboard");
    public static By byRotationHandle = By.id("rotationHandle");
    public static By byX = By.id("xCoord");
    public static By byY = By.id("yCoord");
    public static By byRemoveChip = By.id("removeChip");
    public static By bySearchChiplets = By.id("chiplet-search");

    public static By bySensor = By.cssSelector(".toggle-exp button[class*='jss']");
    public static By bySensor0 = By.cssSelector("li[data-degree='0']");
    public static By bySensor90 = By.cssSelector("li[data-degree='90']");
    public static By bySensor180 = By.cssSelector("li[data-degree='180']");
    public static By bySensor270 = By.cssSelector("li[data-degree='270']");

    public static By byNext = By.name("next");
    public static By byPrevious = By.name("prev");
    public static By bySubmitDesign = By.className("btn-submit");

    // TOOLS
    public static By byEnforceSpacingRules = By.cssSelector("input[value='enabled_margin']");
    public static By bySnapToGrid = By.cssSelector("input[value='shouldSnap']");
    public static By byOptimalPlacement = By.cssSelector("input[value='rdl_mask']");
    public static By byContainers = By.className("box-design-tool");
    public static By byShowAirwires = By.cssSelector("input[value='enabled_airwire']");

    // SPACING RULES
    public static By byChipToChip = By.id("c2c");
    public static By byTopOverHang = By.id("topoverhang");
    public static By byBottomOverHang = By.id("bottomoverhang");
    public static By byLeftOverHang = By.id("leftoverhang");
    public static By byRightOverHang = By.id("rightoverhang");
    public static By bySave = By.className("btn-save");

    public static By byDiv = By.tagName("div");
    public static By byTSpan = By.tagName("tspan");
    public static By byUl = By.tagName("ul");
    public static By byLi = By.tagName("li");
    public static By byButton = By.tagName("button");
    public static By byP = By.tagName("p");
    public static By bySpan = By.tagName("span");

    public static By byChipHeading = By.className("heading-left");

    public static String expandedChip = "div[class*='MuiExpansionPanel-expanded']";
//    public static String expandedChip = "div[class*='toggle-exp']";
    public static By byExpandedChip = By.cssSelector(expandedChip);

    public static By byMenuLevel = By.cssSelector("div[class*='menu-lv']");
    public static By byDegree = By.className("form-input");
    public static By byDegreeList = By.cssSelector("ul[role='listbox']");
    public static By byXCoordinateField = By.name("x");
    public static By byYCoordinateField = By.name("y");
    public static By byCollapseContainer = By.className("collapse-container");
    public static By byTickButton = By.className("text-center");
    public static By byPolygonIcon = By.tagName("polygon");
    public static By by0Degree = By.cssSelector("li[data-value='0']");
    public static By by90Degree = By.cssSelector("li[data-value='90']");
    public static By by180Degree = By.cssSelector("li[data-value='180']");
    public static By by270Degree = By.cssSelector("li[data-value='270']");
    public static By byDegreeTexts = By.tagName("text");
    public static String[] degreeValues = {"0","90","180"};
    public final static String[] chipletData = {"SIT1552","U1","SITIME","4","X-955, Y-5050, ROT-0°","H-1540, W-840, Z-600"};


    public static By byChipsOnBoard = By.className("react-draggable");
    public static By byZoomControls = By.className("zoom-controls");

    // Placement Locators
    public static By byPan = By.id("pan");
    public static By bymainContainer = By.className("main-container");
    public static By byG = By.tagName("g");
    public static By byRightContainer = By.className("app-right-container");
    public static By byFit = By.id("btn-fit");
    public static By bySystemButtonDropDown = By.id("system-button");
    public static By byLockSystemBtn = By.className("list-action");

    public static By byformControl = By.className("form-group");
    public static By bySearchField = By.id("input-with-icon-textfield");
    public static By bySystemName = By.className("primary-heading");
    public static By byToolTip = By.className("tool-tip-mar");
    public static By bychipData = By.className("text-light");
    //Snap-toGrid Locators
    public static By byAbstractView = By.id("subview-1");
    public static By byPhysicalView = By.id("subview-2");
    public static By byRect = By.tagName("rect");
    public static By bySwitchButton = By.className("btn-switch");
    public static By byDrag = By.className("react-draggable");




    public void updateRotationDegree(){
        Actions action = new Actions(WebDriverFactory.getDriver());
        WebElement rotate = WebDriverFactory.getDriver().findElement(byRotationHandle);
        for (int i =0; i <= degreeValues.length -1 ; i++)
        {
            action.click(rotate).build().perform();
            WebElement degree = WebDriverFactory.getDriver().findElements(byTSpan).get(i);
            String deg = degree.getText().split("°")[0];
            Assert.assertTrue(Arrays.asList(degreeValues).contains(deg));
            degree.click();
            WebDriverWaits.waitUntilLoaderDisapears();
        }

    }

    public void selectDegree(String degree){
        logStep("User selects degree " + degree);

        WebElement degreeDropDown = WebDriverFactory.getDriver().findElement(byChipletList).findElement(byDegree);

        WebDriverWaits.sleep250();
        degreeDropDown.click();
        WebDriverWaits.sleep250();

        switch(degree){
            case "0":
                WebDriverFactory.getDriver().findElement(by0Degree).click();
                break;
            case "90":
                WebDriverFactory.getDriver().findElement(by90Degree).click();
                break;
            case "180":
                WebDriverFactory.getDriver().findElement(by180Degree).click();
                break;
            case "270":
                WebDriverFactory.getDriver().findElement(by270Degree).click();
                break;
        }
    }

    public void zoomIn(int no){
        for (int i=0 ; i<no ; i++)
            WebDriverFactory.getDriver().findElement(byZoomControls).findElements(byButton).get(0).click();
    }

    public void zoomOut(int no){
        for (int i=0 ; i<no ; i++)
            WebDriverFactory.getDriver().findElement(byZoomControls).findElements(byButton).get(1).click();
    }

    public String zoomText()
    {
        WebElement zoomValue = WebDriverFactory.getDriver().findElement(byZoomControls).findElement(bySpan);
        String text = zoomValue.getText();
        String splitText = text.split("%")[0];

        return splitText;
    }

    public void assertZoomIn(int zoomB, int zoomA)
    {

        System.out.println(zoomB +""+ zoomA);
        Assert.assertTrue(zoomB == zoomA - 10 );
    }

    public void assertZoomOut(int zoomB, int zoomA)
    {
        System.out.println(zoomB+""+zoomA);
        Assert.assertTrue(zoomB == zoomA + 10);
    }

    public WebElement searchChiplets(){
        return WebDriverFactory.getDriver().findElement(bySearchChiplets);
    }

    public void searchChiplets(String chiplet){
        logStep("User searches chiplet");

        checkMenuLevel = false;
        WebElement searchChiplets = WebDriverFactory.getDriver().findElement(bySearchChiplets);

        MainCall.commonLocators.clearField(searchChiplets());
        searchChiplets().sendKeys(chiplet);
    }

    public void clickEnforceSpacingRules(){
        WebDriverFactory.getDriver().findElement(byEnforceSpacingRules).click();
    }

    public void clickSnapToGrid(){
        WebDriverFactory.getDriver().findElement(bySnapToGrid).click();
    }

    public void clickOptimalPlacement(){
        WebDriverFactory.getDriver().findElement(byOptimalPlacement).click();
//        MainCall.commonLocators.verifySuccessNotif();
    }

    public void clickShowAirwires(){
        WebDriverFactory.getDriver().findElement(byShowAirwires).click();
    }

    public void clickTickButton(){
        List<WebElement> listCollapseContainer = WebDriverFactory.getDriver().findElements(byCollapseContainer);

        for (int i=0 ; i<listCollapseContainer.size() ; i++) {
            if (listCollapseContainer.get(i).getAttribute("aria-hidden") == null) {
                listCollapseContainer.get(i).findElement(byTickButton).click();
                break;
            }
        }
    }

    public void inputChipToChipValue(String c2c){
        WebElement chipToChip = WebDriverFactory.getDriver().findElement(byChipToChip);

        MainCall.commonLocators.clearField(chipToChip);
        chipToChip.sendKeys(c2c);
    }

    public void inputTopOverHangValue(String toh){
        WebElement topOverHang = WebDriverFactory.getDriver().findElement(byTopOverHang);

        MainCall.commonLocators.clearField(topOverHang);
        topOverHang.sendKeys(toh);
    }

    public void inputBottomOverHangValue(String boh){
        WebElement bottomOverHang = WebDriverFactory.getDriver().findElement(byBottomOverHang);

        MainCall.commonLocators.clearField(bottomOverHang);
        bottomOverHang.sendKeys(boh);
    }

    public void inputLeftOverHangValue(String loh){
        WebElement leftOverHang = WebDriverFactory.getDriver().findElement(byLeftOverHang);

        MainCall.commonLocators.clearField(leftOverHang);
        leftOverHang.sendKeys(loh);
    }

    public void inputRightOverHangValue(String roh){
        WebElement rightOverHang = WebDriverFactory.getDriver().findElement(byRightOverHang);

        MainCall.commonLocators.clearField(rightOverHang);
        rightOverHang.sendKeys(roh);
    }

    public WebElement selectPolygonIcon(int no){
        return WebDriverFactory.getDriver().findElement(byChipletList).findElements(byPolygonIcon).get(no);
    }

    public void selectSaveButton(){
        WebDriverFactory.getDriver().findElement(bySave).click();
//        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.commonLocators.verifySuccessNotif();
    }

    public void clickRotationalHandler(){
        JavascriptExecutor js = (JavascriptExecutor)WebDriverFactory.getDriver();
        int size = WebDriverFactory.getDriver().findElements(byRotationHandle).size() - 1;

        js.executeScript(
                "document.querySelectorAll(\"[id=rotationHandle]\")[" + size + "].dispatchEvent(new MouseEvent(\"click\", {\n" +
                "bubbles: true,\n" +
                "cancelable: true,\n" +
                "view: window\n" +
                "}));");
    }

    public void dragAndDropChiplet(String degree) throws InterruptedException {
        logStep("User drags and drops chiplet onto Physical  board");

        GenericFunctions.mouseHover(bySensor);
        WebDriverWaits.sleep250();

        switch(degree){
            case "0":
                WebDriverFactory.getDriver().findElement(bySensor0).click();
                break;
            case "90":
                WebDriverFactory.getDriver().findElement(bySensor90).click();
                break;
            case "180":
                WebDriverFactory.getDriver().findElement(bySensor180).click();
                break;
            case "270":
                WebDriverFactory.getDriver().findElement(bySensor270).click();
                break;
        }

        WebDriverWaits.sleep250();
        WebElement mainBorad = WebDriverFactory.getDriver().findElement(byMainBoard);
        mainBorad.click();

        WebElement dragChiplet = WebDriverFactory.getDriver().findElement(byChipsOnBoard);

        int x = dragChiplet.getLocation().getX();
        int y = dragChiplet.getLocation().getY();

//          Dragged and dropped through coordinates (Method 1)
//        action.dragAndDropBy(dragChiplet, ).build().perform();

        //Dragged and dropped (Method 2)
//        action.clickAndHold(from).moveToElement(to).release(to).build().perform();

        WebDriverWaits.waitUntilLoaderDisapears();
    }

    public void clickRotationHandle_Y(int yCoord) throws InterruptedException {
        //change Y coordinate
        WebDriverFactory.getDriver().findElement(byChipletList).findElements(byPolygonIcon).get(0).click();
        WebDriverFactory.getDriver().findElements(byYCoordinateField).get(0).sendKeys(Integer.toString(yCoord));
        clickTickButton();
        WebDriverWaits.waitUntilLoaderDisapears();

        WebDriverFactory.getDriver().findElement(byRotationHandle).click();

//        WebDriverFactory.getDriver().findElement(byY).clear();
//        WebDriverFactory.getDriver().findElement(byY).sendKeys(yCoord + "");
//        action.sendKeys(Keys.ENTER).build().perform();
        WebDriverWaits.waitUntilLoaderDisapears();

        WebDriverFactory.getDriver().findElement(byRotationHandle).click();
        String check = WebDriverFactory.getDriver().findElement(byY).getAttribute("value");
        Assert.assertTrue(GenericFunctions.stringToInt(check) == yCoord);
    }

    public void addChiplet(int xCoord, int yCoord, String deg) throws InterruptedException {
        logStep("User adds chiplet to Physical board");

        if (checkMenuLevel == true)
            checkMenuLevel();

        selectDegree(deg);

        WebElement x = WebDriverFactory.getDriver().findElement(byChipletList).findElement(byXCoordinateField);
//        WebElement x = WebDriverFactory.getDriver().findElement(byChipletList).findElement(byExpandedChip).findElement(byXCoordinateField);
        WebElement y = WebDriverFactory.getDriver().findElement(byChipletList).findElement(byYCoordinateField);
//        WebElement y = WebDriverFactory.getDriver().findElement(byChipletList).findElement(byExpandedChip).findElement(byYCoordinateField);

        //add X coordinate
        MainCall.commonLocators.clearField(x);
        x.sendKeys(Integer.toString(xCoord));
        //add Y coordinate
        MainCall.commonLocators.clearField(y);
        y.sendKeys(Integer.toString(yCoord));

        WebDriverWaits.sleep500();
        clickTickButton();
        WebDriverWaits.waitUntilLoaderDisapears();
    }



    public void verifyDragandDrop(String deg) {
        clickRotationalHandler();
        Assert.assertTrue(Arrays.asList(degreeValues).contains(deg));
        clickRotationalHandler();
    }

    public void changeRotationHandleData(String X, String Y) throws InterruptedException {


        clickRotationalHandler();
        WebElement checkX = WebDriverFactory.getDriver().findElement(byX);
        checkX.clear();
        checkX.sendKeys(X);
        WebElement checkY = WebDriverFactory.getDriver().findElement(byY);
        checkY.clear();
        checkY.sendKeys(Y);
        Actions actions = new Actions(WebDriverFactory.getDriver());
        actions.sendKeys(Keys.ENTER).build().perform();
        WebDriverWaits.waitUntilLoaderDisapears();
    }

    public void assertRotationHandleData(int xCoord, int yCoord) throws InterruptedException {
        logStep("Verify chiplet is added on correct coordinates");

        clickRotationalHandler();
        String checkX = WebDriverFactory.getDriver().findElement(byX).getAttribute("value");
        Assert.assertTrue(GenericFunctions.stringToInt(checkX) == xCoord);
        String checkY = WebDriverFactory.getDriver().findElement(byY).getAttribute("value");
        Assert.assertTrue(GenericFunctions.stringToInt(checkY) == yCoord);
        clickRotationalHandler();
    }


    public void clickChipHeading(String chipHeading) throws InterruptedException {
        logStep("User selects " + chipHeading + " chiplet from hierarchy");

        List<WebElement> list = WebDriverFactory.getDriver().findElements(byChipHeading);

        for (int i=0 ; i<list.size() ; i++) {
            if (list.get(i).findElement(byP).getText().equals(chipHeading)) {
                list.get(i).findElement(byP).click();
            }
        }
//        WebDriverWaits.sleep250();
    }

    public void removeAllChiplets(){
//        MainCall.navBarPage.verifySystemNameTitle(chipSystem);

        logStep("User removes all chiplets");

        int removeCount = WebDriverFactory.getDriver().findElements(byRemoveChip).size();

        if (removeCount > 0) {
            for (int i=0; i<removeCount ; i++) {
                WebDriverFactory.getDriver().findElement(byRemoveChip).click();
                WebDriverWaits.waitUntilLoaderDisapears();
            }
        }
        int removeCountAfter = WebDriverFactory.getDriver().findElements(byRemoveChip).size();
        Assert.assertTrue(removeCountAfter == 0);
    }

    public void removeAnyChiplet(int chipIndex){

        logStep("User remove {chipIndex} chiplet");

        int removeCount = WebDriverFactory.getDriver().findElements(byRemoveChip).size();
        WebDriverFactory.getDriver().findElements(byRemoveChip).get(chipIndex).click();
        int removeCountAfter = WebDriverFactory.getDriver().findElements(byRemoveChip).size();

        Assert.assertTrue(removeCount == removeCountAfter + 1);
    }

    public void getCirclesLocation(String[] actualXCoordinates, String[] actualYCoordinates) {
        int x=0;
        int y=0;

        List<WebElement> circles = WebDriverFactory.getDriver().findElement(By.className("react-draggable-dragged")).findElements(By.tagName("circle"));
        int circlesCount = circles.size();

        String[] xCoordinates = new String[circlesCount/2];
        String[] yCoordinates = new String[circlesCount/2];

        for (int i = 0; i<circlesCount; i=i+2) {
            xCoordinates[x] = circles.get(i).getAttribute("cx");
            yCoordinates[y] = circles.get(i).getAttribute("cy");
            x++;
            y++;
        }

        //print x and y
        System.out.println("\nX COORDINATES: \n");
        for (int i=0; i<xCoordinates.length; i++) {
            Assert.assertTrue(actualXCoordinates[i].equals(xCoordinates[i]));
        }

        System.out.println("\nY COORDINATES: \n");
        for (int i=0; i<yCoordinates.length; i++) {
            Assert.assertTrue(actualYCoordinates[i].equals(yCoordinates[i]));
        }

    }

    public static boolean checkMenuLevel = true;

    public void addChiplet(String condition, String chip, int x, int y, String deg) throws InterruptedException {
        searchChiplets(chip);
        clickChipHeading(chip);

        condition = condition.toLowerCase();
        switch(condition){
            case "dragdrop":
                dragAndDropChiplet(deg);
                verifyDragandDrop(deg);
                break;
            case "coordinates":
                addChiplet(x, y, deg);
                assertRotationHandleData(x, y);
                break;
        }

        WebDriverWaits.waitUntilLoaderDisapears();

        MainCall.commonLocators.clearField(searchChiplets());
        WebDriverWaits.waitUntilLoaderDisapears();

        checkMenuLevel = true;
    }

    public void fillMarginValuesAndSave(String[] margin){
        inputChipToChipValue(margin[0]);
        inputTopOverHangValue(margin[1]);
        inputBottomOverHangValue(margin[2]);
        inputLeftOverHangValue(margin[3]);
        inputRightOverHangValue(margin[4]);
        selectSaveButton();
    }

    public static String className = "";
    public static int menuLvl = 0;

    public void checkMenuLevel(){
        expandedChip = "";
        List<WebElement> menuLevelList = WebDriverFactory.getDriver().findElements(byMenuLevel);

        for (int i=0; i<menuLevelList.size() ; i++) {
            className = menuLevelList.get(i).getAttribute("class").toString();

            className = className.substring(className.length()-1);

            if (menuLvl < GenericFunctions.stringToInt(className))
                 menuLvl = GenericFunctions.stringToInt(className);
        }

        for (int i=0; i<menuLvl ; i++) {
            expandedChip += " div[class*='MuiExpansionPanel-expanded']";
//            expandedChip += " div[class*='toggle-exp']";
        }

        byExpandedChip = By.cssSelector(expandedChip);
    }

    public void openAllContainers(){
        List<WebElement> allContainers = WebDriverFactory.getDriver().findElements(byContainers);

        for (int i=0 ; i<allContainers.size() ; i++) {
            WebElement box = allContainers.get(i).findElements(byDiv).get(0);

            if(box.getAttribute("aria-expanded").equals("false"))
                box.click();
        }
    }

    //Placement

    public void dragAndDropChiplet()
    {
        WebElement from = WebDriverFactory.getDriver().findElement(byRotationHandle);
        WebElement to = WebDriverFactory.getDriver().findElement(byMainBoard);

        Actions action = new Actions(WebDriverFactory.getDriver());
//        action.dragAndDropBy(from,envGlobals.xCordAfter,envGlobals.yCordAfter);
        action.dragAndDrop(from,to).build().perform();
        WebDriverWaits.waitUntilLoaderDisapears();

    }


    public void checkXYValuesAfterDragDrop()
    {
        WebDriverFactory.getDriver().findElement(byRotationHandle).click();
        String xCord = WebDriverFactory.getDriver().findElement(byX).getAttribute("value");
        System.out.println(xCord);
        String yCord = WebDriverFactory.getDriver().findElement(byY).getAttribute("value");
        System.out.println(yCord);

        Assert.assertNotEquals(xCord, envGlobals.xCord,"Element has not moved");
        Assert.assertNotEquals(yCord,envGlobals.yCord,"Element has not moved");

        Assert.assertTrue("Element has not moved", xCord.equals(Integer.toString(envGlobals.xCordAfter)));
        Assert.assertTrue("Element has not moved", yCord.equals(Integer.toString(envGlobals.yCordAfter)));
    }

    public void assertXYCordinates()
    {
        WebDriverFactory.getDriver().findElement(byRotationHandle).click();
        String xCord = WebDriverFactory.getDriver().findElement(byX).getAttribute("value");
        System.out.println(xCord);
        String yCord = WebDriverFactory.getDriver().findElement(byY).getAttribute("value");
        System.out.println(yCord);

        Assert.assertEquals(xCord,envGlobals.xCord,"Element has moved");
        Assert.assertEquals(yCord,envGlobals.yCord,"Element has moved");
    }



    public String getBoardTransformValue()
    {
        String value = WebDriverFactory.getDriver().findElement(bymainContainer).findElement(byG).getAttribute("transform");
        return value;
    }

    public void panFunctionality()
    {
        WebDriverFactory.getDriver().findElement(byPan).click();
        WebElement from = WebDriverFactory.getDriver().findElement(byMainBoard);
        WebElement to = WebDriverFactory.getDriver().findElement(bymainContainer);

        Actions action = new Actions(WebDriverFactory.getDriver());
        action.dragAndDrop(from,to).build().perform();

        WebDriverWaits.waitUntilLoaderDisapears();


    }

    public void assertBoardTransformValueAfterPan(String valueBefore, String valueAfter)
    {
        Assert.assertNotEquals(valueBefore,valueAfter,"Element not moved");
    }

    public void fitFunctionality()
    {
        WebDriverFactory.getDriver().findElement(byFit).click();

    }
    public void assertBoardTransformValueAfterFit(String valueAfter, String fitValue)
    {
        Assert.assertNotEquals(valueAfter,fitValue);

    }

    public void clickSystemDropDown()
    {
        WebDriverFactory.getDriver().findElement(bySystemButtonDropDown).click();
    }

    public void changeSystemName(String sysName)
    {
        WebElement systemField = WebDriverFactory.getDriver().findElement(byformControl).findElement(commonLocators.byInput);
        systemField.clear();
        systemField.sendKeys(sysName);
    }

    public void searchSystem(String sysName)
    {
        WebElement searchField = WebDriverFactory.getDriver().findElement(bySearchField);
        searchField.sendKeys(sysName);
    }

    public void assertSystemName(String editSysName)
    {
        String systemName = WebDriverFactory.getDriver().findElement(bySystemName).getText();
        if(systemName.contains(editSysName))
        {
            System.out.println(systemName);

        }
    }

    public void clickMainBoard()
    {
        WebDriverFactory.getDriver().findElement(byMainBoard).click();
    }


    public List<WebElement> ChipletDataList()
    {
        return WebDriverFactory.getDriver().findElement(byToolTip).findElements(byLi);
    }

    public void verifyChipletData()
    {
//        ArrayList<String> str = new ArrayList<String>();
        List<WebElement> ele = ChipletDataList();
        for (WebElement element : ele)
        {
            String text = element.findElement(bychipData).getText();

            if (!text.trim().isEmpty())
            {
                Assert.assertTrue(Arrays.asList(chipletData).contains(text));
                System.out.println(text);
            }
        }

    }

    public void clickAbstractView()
    {
        WebDriverFactory.getDriver().findElement(byAbstractView).click();
        WebDriverWaits.sleep(1000);
    }

    public List<WebElement> Rectangles()
    {
//        WebDriverFactory.getDriver().findElement(By.className("react-draggable")).findElements(By.tagName("g")).get(1).findElements(By.tagName("rect"))
        return WebDriverFactory.getDriver().findElement(byChipsOnBoard).findElements(byG);
    }

    public List<Integer> getRectCount()
    {

        ArrayList<Integer> count = new ArrayList();
        List<WebElement> gTags = Rectangles();
        for (int i = 1; i < gTags.size(); i++)
        {
//             rect = gTags.get(i).findElements(byRect).size();

            count.add(gTags.get(i).findElements(byRect).size());


        }
        return count;

    }

    public void clickSnapChipToGrid()
    {
        WebDriverFactory.getDriver().findElements(bySwitchButton).get(1).findElement(commonLocators.byInput).click();
        WebDriverWaits.sleep(1000);
    }

    public void clickSpacingRule()
    {
        WebDriverFactory.getDriver().findElements(bySwitchButton).get(0).findElement(commonLocators.byInput).click();
    }

    public void clickLockSystem()
    {
        WebDriverFactory.getDriver().findElement(byLockSystemBtn).findElement(commonLocators.byInput).click();
    }

    public void clickPhysicalView()
    {
        WebDriverFactory.getDriver().findElement(byPhysicalView).click();
        WebDriverWaits.sleep(1000);
    }

    public void assertRectCount(List<Integer> rectCountBefore, List<Integer> rectCountAfter)
    {
        int rectCountB = rectCountBefore.get(1);
        int rectCountA = rectCountAfter.get(1);
        int diff = Math.abs(rectCountA-rectCountB);
        Assert.assertTrue(rectCountB == rectCountA - diff);

    }


    public void dragChipOverChip()
    {
        List<WebElement> chiplets = WebDriverFactory.getDriver().findElements(byChiplet);
        List<WebElement> rotationHandles = WebDriverFactory.getDriver().findElements(byRotationHandle);

        WebElement from = rotationHandles.get(0);
        WebElement to = rotationHandles.get(1);

        Actions action = new Actions(WebDriverFactory.getDriver());
//        action.dragAndDropBy(from,2150,1245).build().perform();
        action.dragAndDrop(from,to).build().perform();
        WebDriverWaits.waitUntilLoaderDisapears();

    }

    public void assertChipOverChip()
    {
        WebElement rotationTriangle = WebDriverFactory.getDriver().findElements(byRotationHandle).get(0);
        rotationTriangle.click();

        String checkX = WebDriverFactory.getDriver().findElement(byX).getAttribute("value");
        Assert.assertTrue(GenericFunctions.stringToInt(checkX) == envGlobals.xCordAfterOverlap);

        String checkY = WebDriverFactory.getDriver().findElement(byY).getAttribute("value");
        Assert.assertTrue(GenericFunctions.stringToInt(checkY) == envGlobals.yCordAfterOverlap);

        WebElement checkXCord = WebDriverFactory.getDriver().findElement(byX);
        checkXCord.clear();
        checkXCord.sendKeys("955");

        WebElement checkYCord = WebDriverFactory.getDriver().findElement(byY);
        checkYCord.clear();
        checkYCord.sendKeys("5050");

        Actions actions = new Actions(WebDriverFactory.getDriver());
        actions.sendKeys(Keys.ENTER).build().perform();
        WebDriverWaits.waitUntilLoaderDisapears();

    }

    public void editXYCordsWithESREnable()
    {
        WebElement rotationTriangle = WebDriverFactory.getDriver().findElements(byRotationHandle).get(0);
        rotationTriangle.click();

        WebElement checkXCord = WebDriverFactory.getDriver().findElement(byX);
        checkXCord.clear();
        checkXCord.sendKeys("2150");

        WebElement checkYCord = WebDriverFactory.getDriver().findElement(byY);
        checkYCord.clear();
        checkYCord.sendKeys("1245");

        Actions actions = new Actions(WebDriverFactory.getDriver());
        actions.sendKeys(Keys.ENTER).build().perform();
        WebDriverWaits.waitUntilLoaderDisapears();
    }

}
