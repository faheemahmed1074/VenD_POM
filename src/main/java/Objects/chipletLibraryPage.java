package Objects;

import General.MainCall;
import General.WebDriverFactory;
import General.WebDriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.File;

import static utils.LogHelper.logStep;

public class chipletLibraryPage {
    public static By byChipletLibraryButton = By.id("chiplet-library-button");
    public static By byChipletSearchField = By.className("jss276");
    public static By byChipletibraryHeading = By.className("app-header-heading");
    public static By byChipletHeaderButtons = By.className("add-chiplet-btn");
    String chipletLibraryHeading = "Chiplet Library";


    //Add New Chiplet Form
    public static By byMPN = By.id("mpn");
    public static By byNumOfIOs = By.id("num_balls");
    public static By byXaxis = By.id("x_dim");
    public static By byYaxis = By.id("y_dim");
    public static By byZaxis = By.id("z_dim");
    public static By byCompany = By.id("company");
    public static By byDescription = By.id("description");
    public static By byURL = By.id("url");


    //Add New IO against Chiplet
    public static By byPlusIcon = By.className("add-chipletIO-btn");
    public static By byPnum = By.id("pnum");
    public static By byPname = By.id("pname");
    public static By bySigt = By.id("sigt");
    public static By byIoMech = By.id("io_mech");
    public static By byDiameter = By.id("diameter");
    public static By byXPos = By.id("x_pos");
    public static By byYPos = By.id("y_pos");
    public static By byAddButton = By.className("btn-blue");




    //Low level Functions


    public void addChipletAxisValue(String axisValue)
    {
        WebElement xAxis = WebDriverFactory.getDriver().findElement(byXaxis);
        xAxis.clear();
        xAxis.sendKeys(axisValue);

        WebElement yAxis = WebDriverFactory.getDriver().findElement(byYaxis);
        yAxis.clear();
        yAxis.sendKeys(axisValue);

        WebElement zAxis = WebDriverFactory.getDriver().findElement(byZaxis);
        zAxis.clear();
        zAxis.sendKeys(axisValue);

    }

    public void scrollDown()
    {
        WebElement element = WebDriverFactory.getDriver().findElement(byPlusIcon);
        ((JavascriptExecutor) WebDriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true)", element);

    }
    public void clickAddNewIoIcon()
    {
        WebDriverFactory.getDriver().findElement(byPlusIcon).click();
    }



    public void addNewIOData()
    {
        WebDriverFactory.getDriver().findElement(byPnum).sendKeys("A1");
        WebDriverFactory.getDriver().findElement(byPname).sendKeys("VDD");
        WebDriverFactory.getDriver().findElement(bySigt).sendKeys("V");
        WebDriverFactory.getDriver().findElement(byIoMech).sendKeys("BALL");
    }

    public void addNewIoPositionValues(String integerValue)
    {
        WebDriverFactory.getDriver().findElement(byDiameter).sendKeys(integerValue);
        WebDriverFactory.getDriver().findElement(byXPos).sendKeys(integerValue);
        WebDriverFactory.getDriver().findElement(byYPos).sendKeys(integerValue);
    }

    public void editChipletData(String company, String desc, String url)
    {
        WebElement Company = WebDriverFactory.getDriver().findElement(byCompany);
        Company.clear();
        Company.sendKeys(company);

        WebElement Description = WebDriverFactory.getDriver().findElement(byDescription);
        Description.clear();
        Description.sendKeys(desc);

        WebElement URL = WebDriverFactory.getDriver().findElement(byURL);
        URL.clear();
        URL.sendKeys(url);
    }

    public void clickAddButton() {
        logStep("User clicks on Add Button");

        WebDriverFactory.getDriver().findElement(byAddButton).click();
        WebDriverWaits.waitUntilLoaderDisapears();
    }

    public void clickSaveButton()
    {
        WebDriverFactory.getDriver().findElement(byAddButton).click();
        WebDriverWaits.waitUntilLoaderDisapears();
    }

    public int getPagination()
    {
        String text =  WebDriverFactory.getDriver().findElement(commonLocators.byFooter).findElement(commonLocators.byTr).findElement(commonLocators.byTd).findElement(commonLocators.bySpan).getText();
        String splitText = text.split(" ")[0];
        return Integer.parseInt(splitText.split("-")[1]);

    }

    public int getTotalChipletsCount()
    {
        String text =  WebDriverFactory.getDriver().findElement(commonLocators.byFooter).findElement(commonLocators.byTr).findElement(commonLocators.byTd).findElement(commonLocators.bySpan).getText();
        return Integer.parseInt(text.split(" ")[2]);

    }





    // High Level Functions
    public void clickChipletLibraryBtn()
    {
        logStep("User clicks on chiplet library button");

        WebDriverFactory.getDriver().findElement(byChipletLibraryButton).click();
        WebDriverWaits.waitUntilLoaderDisapears();
//        String heading = WebDriverFactory.getDriver().findElement(byChipletibraryHeading).getText();
//        Assert.assertEquals(heading, chipletLibraryHeading);
//        WebDriverWaits.waitUntilLoaderDisapears();

    }

    public void addNewChiplet(String MPN, String axisValue) {
        logStep("User enter details for chip");

        WebDriverFactory.getDriver().findElement(byMPN).sendKeys(MPN);
        WebDriverFactory.getDriver().findElement(byNumOfIOs).clear();
        WebDriverFactory.getDriver().findElement(byNumOfIOs).sendKeys("1");
        addChipletAxisValue(axisValue);


    }

    public void addNewIO(String integerValue)
    {
        logStep("User enter IO details");
        WebDriverWaits.sleep1000();
//        scrollDown();
        clickAddNewIoIcon();
        addNewIOData();
        addNewIoPositionValues(integerValue);
    }


    public void searchChipletLibrary(String chipData) {
        logStep("User searches chiplet");

        WebElement searchField = WebDriverFactory.getDriver().findElement(byChipletSearchField);
        Actions actions = new Actions(WebDriverFactory.getDriver());
        WebDriverWaits.sleep1000();
        actions.moveToElement(searchField);
        actions.click();
        actions.sendKeys(chipData).build().perform();
        WebDriverWaits.waitUntilLoaderDisapears();

    }


    public void editSearchedChiplet(String axisValue,String company, String desc, String url)
    {
        editChipletData(company,desc,url);
        addChipletAxisValue(axisValue);
        clickAddButton();
        WebDriverWaits.waitUntilLoaderDisapears();

    }



//    public int countFilesInDownloads() {
//
//        File folder = new File(System.getProperty("user.dir") + "\\Downloads");
//        File[] listOfFiles = folder.listFiles();
//        return listOfFiles.length;
//    }

    public int checkDownloadFileName()
    {
    File folder = new File(System.getProperty("user.dir") + "\\Downloads");
    File[] listOfFiles = folder.listFiles();
    int count = 0;

    for (File listOfFile : listOfFiles)
    {
        if (listOfFile.isFile())
        {
            String fileName = listOfFile.getName();
            System.out.println("File" + fileName);
            if (fileName.contains(".zef"))
            {
                count++;
            }
        }


    }
    return count;
    }

    //Assert Functions

    public void assertEditedChipletData(String URL)
    {
        String dataSheetURL = WebDriverFactory.getDriver().findElement(byDescription).getText();
        Assert.assertEquals(URL,dataSheetURL,"Chiplet not edited");
    }

    public void assertFileDownload(int countBeforeDownload, int countAfterDownload)
    {
        Assert.assertTrue(countAfterDownload == countBeforeDownload + 1, "Downloaded document is not found");
    }


    public void assertTotalCountAfterDelete(int totalChipletsCountBefore, int totalChipletscountAfter)
    {
        System.out.println(totalChipletsCountBefore + " " +totalChipletscountAfter);
        Assert.assertTrue(totalChipletscountAfter == totalChipletsCountBefore - 1, "Chiplet not deleted");
    }

    public void assertTotalCountAfterAdd(int totalChipletsCountBefore, int totalChipletscountAfter)
    {
        System.out.println(totalChipletsCountBefore+"  " + totalChipletscountAfter);
        Assert.assertTrue(totalChipletscountAfter == totalChipletsCountBefore + 1, "Chiplet not added");
    }


//    public void assertPaginationCount(int PaginationBefore, int PaginationAfter)
//    {
//        Assert.assertTrue(PaginationAfter == PaginationBefore + 10 , "Pagination not working correct");
//    }

}