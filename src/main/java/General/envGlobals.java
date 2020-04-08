package General;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.List;

import static Config.configProperties.Url;

public class envGlobals {

    public static RequestSpecification requestSpecification;
    public static Response response;

    public static String referer = Url;
    public static String contentType = "application/json";
    public static String auth = "JWT eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyZW1haWwiOiJqYW1lc0B6Z2x1ZS5jb20iLCJ1c2VySWQiOiI1YTY4M2YyM2JkYjMxMTAwMTRhOTFlMDEiLCJhY2NvdW50X2lkIjoxLCJhY2NvdW50X25hbWUiOiJ6R2x1ZSIsInR5cGUiOiJhZG1pbiIsInJvbGVzIjpbImFkbWluIiwiaW50ZXJuYWwiLCJkZXZlbG9wZXIiLCJidXNpbmVzcyIsIm1hbnVmYWN0dXJlciIsInN1cHBsaWVyIiwidmVuZG9yIl0sImdyb3VwcyI6W3siaWQiOjEsIm5hbWUiOiJ6R2x1ZSIsImFjY291bnRfaWQiOjF9LHsiaWQiOjksIm5hbWUiOiJqYW1lcyIsImFjY291bnRfaWQiOjY3Nn0seyJpZCI6MTIsIm5hbWUiOiJ0ZXN0MSIsImFjY291bnRfaWQiOjF9LHsiaWQiOjEzLCJuYW1lIjoidGVzdDIiLCJhY2NvdW50X2lkIjoxfSx7ImlkIjoxNCwibmFtZSI6ImZyaWVuZHMiLCJhY2NvdW50X2lkIjoxfSx7ImlkIjoxNSwibmFtZSI6IndlIiwiYWNjb3VudF9pZCI6MX1dLCJpYXQiOjE1Njc1NzcxNDEsImV4cCI6MTU2NzY2MzU0MX0.WU6uJMXmDZAoJuLnoxeBZC_70OCKnWgZug4FPw0GHxk";

    public static int systemSelection = 0;
    public static String gitDirectory = "/Users/vd-maaz/canvas";

    public static String firstName = "";
    public static String lastName = "";
    public static String email = "";
    public static String password = "";
    public static String companyField = "";

    public static List<String> sysNames = new ArrayList<>();
    public static List<Integer> randList = new ArrayList<>();
    public static List<Integer> sysId = new ArrayList<>();

    public static String sys1019 = "1019";
    public static String sys1019Name = "OMNICHIP_MPW_LGA_V2" + sys1019 + "_";
    public static String sys1328 = "1328";
    public static String sys1328Name = "OMNICHIP_MPW_LGA_V2" + sys1328 + "_";
    public static String sys674 = "674";
    public static String sys674Name = "Cypress-Design_ZIP1" + sys674 + "_";

    public static String sys896 = "896";
    public static String sys896Name = "736 - Cypress_ZiP2" + sys896 + "_";
    public static String sys898 = "898";
    public static String sys898Name = "600 - PISON_HAVANA_V1" + sys898 + "_";
    public static String sys899 = "899";
    public static String sys899Name = "525 - OMNICHIP_V1_fix" + sys899 + "_";
    public static String sys900 = "900";
    public static String sys900Name = "674 - Cypress-Design_ZIP1" + sys900 + "_";

    public static String requstBody = "";

    public static String mpn = "";
    public static String downloadFileName = "chiplets.zef";
    public static String mechFilePath = System.getProperty("user.dir") + "\\Files\\TS4231_mech - Copy.zef";
    public static String ioFilePath = System.getProperty("user.dir") + "\\Files\\MAX31875R0TZS+T_io.zef";
    public static String downloadFilesPath = System.getProperty("user.dir")+ "\\Downloads";

    public static String MPN = GenericFunctions.generateAlphaNumeric("Automation",3);
    public static String axisValue = GenericFunctions.generateRandomNum(3);
    public static String integerValue = GenericFunctions.generateRandomNum(3);
    public static String company = GenericFunctions.generateRandomString(5);
    public static String description = GenericFunctions.generateRandomString(10);
    public static String URL = "https://www.sitime.com/datasheet/SiT1552";

    public static int xCord = 955;
    public static int yCord = 5050;
    public static int xCordAfter = 2255;
    public static int yCordAfter = 2750;

    public static int xCordAfterOverlap = 2655;
    public static int yCordAfterOverlap = 1750;


    public static String xCordEdited = "2845";
    public static String yCordEdited = "1150";

    public static String boardValueBefore;
    public static String boardValueAfter;

    public static String type = "";
    public static String option = "";
    public static String newNetName = "";
    public static String resistorNetName = "";
    public static String chiplet = "";
    public static String chipletTarget = "";
    public static String pinCircle = "";
    public static String pinCircleTarget = "";
    public static List<String> bondpadList = new ArrayList<>();
    public static String levelShifter = "";
    public static String rowMux = "";
    public static String colMux = "";
    public static String spare = "";

    public static int gpioPortHeading = 0;
    public static int pinLevelHeading = 0;
    public static int functionHeading = 0;
    public static int configHeading = 0;
    public static int pNameHeading = 0;
}
