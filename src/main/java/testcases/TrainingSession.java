package testcases;

import general.*;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class TrainingSession extends BaseTest {

    @Test(description = "225371")
    public static void AlertWindow() throws InterruptedException {
        MainCall.genericFunctions.driverStart("https://www.seleniumeasy.com/test/bootstrap-modal-demo.html");
        MainCall.trainingSessionPage.openMultipleModalAlert();
        MainCall.genericFunctions.PercyCapture("Alert Window");
    }

    @Test(description = "225371")
    public static void Slider() throws InterruptedException
    {
        MainCall.genericFunctions.driverStart("https://www.seleniumeasy.com/test/drag-drop-range-sliders-demo.html");
        MainCall.webDriverWaits.sleep(5000);
        MainCall.trainingSessionPage.slideThirdRangeSlider();
        MainCall.trainingSessionPage.verifySuccessMessage();
        MainCall.genericFunctions.PercyCapture("Slider");
    }

    @Test(description = "225371")
    public static void JavaScriptAlert() throws InterruptedException
    {
        MainCall.genericFunctions.driverStart("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        MainCall.trainingSessionPage.EnterTextInAlertBox();
        MainCall.genericFunctions.PercyCapture("JavaScriptAlert");
    }
    @Test(description = "225371")
    public static void InputForm() throws InterruptedException
    {
        MainCall.genericFunctions.driverStart("https://www.seleniumeasy.com/test/input-form-demo.html");
        MainCall.trainingSessionPage.fillForm();
        MainCall.genericFunctions.PercyCapture("InputForm");
    }
}