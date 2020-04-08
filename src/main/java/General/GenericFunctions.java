package General;

import Objects.chipletLibraryPage;
import Objects.commonLocators;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static Config.configProperties.systems;
import static General.WebDriverFactory.action;
import static org.apache.commons.lang3.StringUtils.substringAfter;


public class GenericFunctions {

    public static By byButton = By.tagName("button");
    public static By byInput = By.tagName("input");
    //    int rowCount = WebDriverFactory.getDriver().findElements(commonLocators.byTr).size() - 1;
    int countB ;
    int totalCountB ;
    int countA;
    int totalCountA ;

    public static String generateRandomNum(int length)
    {
        String RawRandomNumber = RandomStringUtils.randomNumeric(length);
        return RawRandomNumber;
    }

    public static List<Integer> generateRandomNumSystem(int length, int sysCount)
    {
        List<Integer> RawRandomNumber = new ArrayList<>();
        for (int i=0 ; i<sysCount ; i++) {
            RawRandomNumber.add(Integer.valueOf(RandomStringUtils.randomNumeric(length)));
        }
        return RawRandomNumber;
    }

    public static String generateAlphaNumeric(String s, int length)
    {
        String RawRandomNumber = RandomStringUtils.randomNumeric(length);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s);
        stringBuilder.append(RawRandomNumber);
        return stringBuilder.toString();
    }

    public static String RandomPhoneNumber(String RawRandomNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("+92300");
        stringBuilder.append(RawRandomNumber);
        return stringBuilder.toString();
    }

    public static String generateRandomString(int length) {
        String name = RandomStringUtils.randomAlphabetic(length);
        String first_letter = name.substring(0, 1).toUpperCase();
        String other_letters = name.substring(1).toLowerCase();
        String finalname = first_letter + other_letters;
        return finalname;
    }

    public static String generateEmail(String finalname)
    {
        return finalname + "@vd.com";
    }

    public static void clearFieldWithJS(By locator, String input) {
        JavascriptExecutor js = (JavascriptExecutor)WebDriverFactory.getDriver();
        String element = substringAfter(locator.toString(), ": ");

        js.executeScript("document.getElementById('" + element + "').value = '" + input + "'");
    }

    public static void mouseHover(By by){
//        action = new Actions(WebDriverFactory.getDriver());
        action.moveToElement(WebDriverFactory.getDriver().findElement(by))
                .perform();
    }

    public static int stringToInt(String number) {
        int result = Integer.parseInt(number);
        return result;
    }

    public void clickElementByText(String text) throws InterruptedException {
        WebDriverFactory.getDriver().findElement(By.xpath("//*[contains(text(), '" + text + "')]")).click();
        Thread.sleep(1000);
    }

    public List<WebElement> getHeaderButtons() {
        return WebDriverFactory.getDriver().findElements(commonLocators.byChipletLibHeaderButtons);
    }

    public void clickChipletLibraryHeaderBtn(String btnName) {


        List<WebElement> HeaderMenuButtons = getHeaderButtons();
        for (WebElement HeaderMenuButton : HeaderMenuButtons) {
            if (HeaderMenuButton.getText().trim().equals(btnName)) {
                Actions actions = new Actions(WebDriverFactory.getDriver());
                actions.click(HeaderMenuButton).build().perform();
//                HeaderMenuButton.click();
                break;
            }

        }
        WebDriverWaits.waitUntilLoaderDisapears();

    }

    public void clickDashboard()
    {
        WebDriverFactory.getDriver().findElement(commonLocators.bylogo).click();
        WebDriverWaits.waitUntilLoaderDisapears();
    }

    public List<WebElement> getChipletLibButtons() {
        return WebDriverFactory.getDriver().findElements(commonLocators.byChipletLibraryButton);
    }

    public void clickChipletLibButtons(String btnName) {

        List<WebElement> chipletButtons = getChipletLibButtons();
        for (WebElement chipletButton : chipletButtons) {
            if (chipletButton.getText().trim().equals(btnName)) {
                chipletButton.click();
                break;
            }

        }
        WebDriverWaits.waitUntilLoaderDisapears();

    }



    public int getColumnsName(String columnName)
    {
        int i = 0;
        List<WebElement> elements11 = WebDriverFactory.getDriver().findElement(commonLocators.byThead).
                findElements(commonLocators.byTr).get(1).findElements(commonLocators.byTh);

        for (WebElement element: elements11) {
            if (element.getText().trim().equals(columnName))
            {
                break;
            }
            i++;
        }
        return i;
    }

    public List<WebElement> getRowsOfTable() {
        return WebDriverFactory.getDriver().findElement(commonLocators.byTable).findElements(commonLocators.byTr);

    }

    public void clickOnColumnOfTable(String itemName) {
        List<WebElement> Rows = getRowsOfTable();
        for (int i = 0; i <= Rows.size(); i++) {
            List<WebElement> Columns = WebDriverFactory.getDriver().findElements(commonLocators.byTd);
            for (WebElement Column : Columns)
                if (Column.getText().trim().equals(itemName)) {
                    Actions actions = new Actions(WebDriverFactory.getDriver());
                    actions.click(Column).build().perform();
                    break;
                }
        }
        WebDriverWaits.waitUntilLoaderDisapears();
        //        int columnName1 = getColumnsName(columnName);
//        WebElement tbody = WebDriverFactory.getDriver().findElement(commonLocators.byTable);

//        for (int i=0 ; i<Rows.size() ; i++) {
//            WebElement data = tbody.findElements(commonLocators.byTr).get(i).findElements(commonLocators.byTd).get(columnName1);
//            String name = data.getText();
//            if(name.equals(itemName))
//                data.click();
//        }
    }

    public void scrollUp() {
        WebElement element = WebDriverFactory.getDriver().findElement(chipletLibraryPage.byChipletibraryHeading);
        ((JavascriptExecutor) WebDriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true)", element);

    }






    //Fetch Footer Buttons

    public List<WebElement> footer() {
        WebElement footer = WebDriverFactory.getDriver().findElement(commonLocators.byFooter).findElement(commonLocators.byTr).findElement(commonLocators.byTd);
        return footer.findElement(commonLocators.byDiv).findElements(commonLocators.byButton);

    }


    // Verify Buttons Functionality
    public void verifyPaginationInFooter()
    {
        List<WebElement> footerElements = footer();
        for (WebElement FooterElement : footerElements)
        {
            if (FooterElement.getAttribute("tabindex").contains("0"))
            {
                countB = MainCall.chipletLibraryPage.getPagination();
                totalCountB = MainCall.chipletLibraryPage.getTotalChipletsCount();

                Actions actions = new Actions(WebDriverFactory.getDriver());
                actions.click(FooterElement).build().perform();

                countA = MainCall.chipletLibraryPage.getPagination();
                totalCountA =MainCall.chipletLibraryPage.getTotalChipletsCount();

                switch (FooterElement.getAttribute("aria-label").toString())
                {
                    case "Next Page":
                        System.out.println("SuccessNP");
                        Assert.assertTrue(countA == countB + 10);
                        break;

                    case "Last Page":
                        System.out.println("SuccessLP");
                        Assert.assertTrue(totalCountA == totalCountB);
                        break;

                }

            }
            else if (FooterElement.getAttribute("tabindex").contains("-1"))
            {

                WebDriverFactory.getDriver().findElement(commonLocators.byFooter).
                        findElement(commonLocators.byTr).
                        findElement(commonLocators.byTd).
                        findElement(commonLocators.byDiv).
                        findElements(commonLocators.byButton).get(2).click();

                countB = MainCall.chipletLibraryPage.getPagination();

                Actions actions = new Actions(WebDriverFactory.getDriver());
                actions.click(FooterElement).build().perform();

                countA = MainCall.chipletLibraryPage.getPagination();


                switch (FooterElement.getAttribute("aria-label").toString())
                {
                    case "First Page":
                        System.out.println("SuccessFP");
                        Assert.assertTrue(countB - 10 == countA);
                        break;

                    case "Previous Page":
                        System.out.println("SuccessPP");

                        Assert.assertTrue(countB - 10 == countA);
                        break;

                }

            }

        }
        WebDriverWaits.waitUntilLoaderDisapears();

    }

    //Assert Buttons being enabled/disabled by default
    public void assertPaginationButtons()
    {
        List<WebElement> PaginationButtons = footer();
        for (WebElement PaginationButton : PaginationButtons)
        {
            if (PaginationButton.getAttribute("tabindex").contains("-1"))
            {
                System.out.println("Condition Verify for Disabled Buttons");
                Assert.assertFalse(PaginationButton.isEnabled());
            }

            else if(PaginationButton.getAttribute("tabindex").contains("0"))
            {
                System.out.println("Condition Verify for Enabled Buttons");

                Assert.assertTrue(PaginationButton.isEnabled());
            }

        }
        WebDriverWaits.waitUntilLoaderDisapears();
    }


    public List<WebElement> chipletBlueClassButtons() {
        return WebDriverFactory.getDriver().findElements(chipletLibraryPage.byAddButton);
    }

    public void clickBlueClassButtons(String btnName) {

        List<WebElement> BlueClassButtons = chipletBlueClassButtons();
        for (WebElement BlueClassButton : BlueClassButtons) {
            if (BlueClassButton.getText().trim().equals(btnName)) {
                Actions actions =new Actions(WebDriverFactory.getDriver());
                actions.click(BlueClassButton).build().perform();
                MainCall.commonLocators.verifyNotif();
//                BlueClassButton.click();
                break;
            }

        }
//        WebDriverWaits.waitUntilLoaderDisapears();

    }



    public List<WebElement> getSystemDropDownButtons() {
        return WebDriverFactory.getDriver().findElements(commonLocators.byDropdwnButtons);
    }

    public void clickSystemDropdwnButton(String btnName) {

        List<WebElement> SystemDropDownButtons = getSystemDropDownButtons();
        for (WebElement SystemDropDownButton : SystemDropDownButtons) {
//            WebDriverFactory.getDriver().findElement(byInput);
            System.out.println(SystemDropDownButton.getText());
            if (SystemDropDownButton.getText().trim().equals(btnName)) {

                Actions action = new Actions(WebDriverFactory.getDriver());
                action.click(SystemDropDownButton).build().perform();
                break;
            }

        }
        WebDriverWaits.waitUntilLoaderDisapears();

    }

}