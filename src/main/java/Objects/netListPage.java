package Objects;

import General.WebDriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.LogHelper.logStep;

public class netListPage {
    public netListPage(){}

    //netList Page Functions
    public static By byAppCFooter = By.className("app-c-footer");
    public static By byAppFooter = By.className("app-c-footer");
    public static By byFooterCenter = By.className("btn-footer-center");
    public static By byNetlistArrow = By.className("arrow-up-small");

    public static By bySearchField = By.cssSelector("[placeholder='Search']");

    public static By byTable = By.tagName("table");
    public static By byThead = By.tagName("thead");
    public static By byTbody = By.tagName("tbody");
    public static By byTr = By.tagName("tr");
    public static By byTd = By.tagName("td");
    public static By byTh = By.tagName("th");

    public static By byDiv = By.tagName("div");
    public static By byInput = By.tagName("input");
    public static By bySpan = By.tagName("span");
    public static By byFooter = By.tagName("footer");

    public void openNetlist() {
        logStep("User opens Netlist on footer");
        WebDriverFactory.getDriver().findElement(byAppCFooter).findElement(byFooterCenter).findElement(byNetlistArrow).click();
    }

    public void closeNetlist() {
        logStep("User closes Netlist on footer");
        WebDriverFactory.getDriver().findElement(byAppFooter).findElement(byFooterCenter).findElement(byNetlistArrow).click();
    }

    public void search(String input) {
        logStep("User enters into search field");
        WebDriverFactory.getDriver().findElement(bySearchField).sendKeys(input);
    }

    public void verifyNetList(String searched, String heading){
        int head = 0;
        WebElement tHead = WebDriverFactory.getDriver().findElement(byFooter).findElement(byThead);
        List<WebElement> th = tHead.findElements(byTh);

        for (int i=0 ; i<th.size() ; i++) {
            if (th.get(i).findElement(bySpan).getText().equals(heading)){
                head = i;
                break;
            }
        }

        WebElement tBody = WebDriverFactory.getDriver().findElement(byFooter).findElement(byTbody);
        List<WebElement> tBodyH = tBody.findElements(byTh);
        List<WebElement> tr = tBody.findElements(byTr);

        if (heading.equalsIgnoreCase("mpn")){
            Assert.assertTrue(tBodyH.get(head).getText().equals(heading));
        }

        for (int i=0 ; i<tr.size() ; i++) {
            WebElement td = tBody.findElements(byTr).get(i).findElements(byTd).get(head);

            Assert.assertTrue(td.getText().equals(heading));
        }
    }
}
