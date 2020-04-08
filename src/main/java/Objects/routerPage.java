package Objects;

import General.*;
import PreReq.TestPage;
import dbConnection.dbConn;
import org.openqa.selenium.By;

import java.sql.SQLException;

import static utils.LogHelper.logStep;

public class routerPage {
    public routerPage(){}

    //Router Page Functions

    public static By byRouterIcon = By.id("system-routing-btn");

    public void selectRouterButton(){
        logStep("User clicks on Router button");
        WebDriverFactory.getDriver().findElement(byRouterIcon).click();
    }

    public void route(){
        MainCall.navBarPage.selectOptimize();
        WebDriverWaits.waitUntilLoaderDisapears();

        MainCall.routerPage.selectRouterButton();
        WebDriverWaits.waitUntilLoaderDisapears();

        MainCall.commonLocators.verifySuccessNotif();

    }

}
