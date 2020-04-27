package General;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.List;

import static Config.configProperties.Url;

public class envGlobals {

    public static RequestSpecification requestSpecification;
    public static Response response;
    public static String requestBody = "";

    public static String firstName = "";
    public static String lastName = "";
    public static String email = "";
    public static String password = "";
    public static String company = "";
}
