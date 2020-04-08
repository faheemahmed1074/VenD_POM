package PreReq;

import General.envGlobals;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static javax.swing.text.DefaultStyledDocument.ElementSpec.ContentType;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.core.IsNot.not;

public class TestPage {
    public TestPage(){}

//    **********************************************    API Calls   **********************************************

    public static Response saveAsSystems(String name, String randName, int systemId) throws SQLException {
        envGlobals.response =
                given()
                        .headers("Authorization", envGlobals.auth, "Content-Type", envGlobals.contentType, "referer", envGlobals.referer)
                        .body(RequestPayloads.saveAsSystem(name, randName, systemId))
//                        .log().all()
                .when()
                        .post("/save-as-system")
                .then()
//                        .log().all()
                        .assertThat().statusCode(200)
                        .body("system", hasKey("id"))
                .extract()
                        .response();

        return envGlobals.response;
    }

    public static Response getSystems() {
        envGlobals.response =
                given()
                        .headers("Authorization", envGlobals.auth, "referer", envGlobals.referer)
//                        .log().all()
                .when()
                        .get("/app/systems")
                .then()
//                        .log().all()
                        .assertThat().statusCode(200).and()
                .extract()
                        .response();

        return envGlobals.response;
    }


}
