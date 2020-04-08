package PreReq;

import General.GenericFunctions;
import General.envGlobals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Config.configProperties.systems;

public class TestBase {
    public TestBase(){}

    private static int sysCount = systems;

    public static void setup() throws SQLException {
        envGlobals.randList = GenericFunctions.generateRandomNumSystem(5, sysCount);
        String name = "";

        TestPage.getSystems();

        data();

        for (int i=0 ; i<sysCount ; i++) {
            name = "AutoSystem" + i;
            envGlobals.sysNames.add(name + "_" + envGlobals.randList.get(i));

            TestPage.saveAsSystems(name, envGlobals.sysNames.get(i), envGlobals.sysId.get(i));
        }
    }

    public static void dataCreation() throws SQLException {
        envGlobals.sys1019Name += Integer.parseInt(GenericFunctions.generateRandomNum(5));
        envGlobals.sys1328Name += Integer.parseInt(GenericFunctions.generateRandomNum(5));
        envGlobals.sys674Name += Integer.parseInt(GenericFunctions.generateRandomNum(5));

        TestPage.saveAsSystems("OMNICHIP_MPW_LGA_V2", envGlobals.sys1019Name, Integer.parseInt(envGlobals.sys1019));
        TestPage.saveAsSystems("Cypress_Oakland_V1_Programmable_OA_wLS", envGlobals.sys1328Name, Integer.parseInt(envGlobals.sys1328));
        TestPage.saveAsSystems("Cypress-Design_ZIP1", envGlobals.sys674Name, Integer.parseInt(envGlobals.sys674));
    }

    public static void data(){
        String name = "";
        int systemsSize = envGlobals.response.body().path("systems.size()");

        for (int i=0 ; i<systemsSize ; i++) {
            name = envGlobals.response.body().path("systems[" + i + "].name");

            for (int j=0 ; j<sysCount ; j++) {
                if (name.equals("AutoSystem" + j)){
                    envGlobals.sysId.add(envGlobals.response.body().path("systems["+ i +"].id"));
                    break;
                }
            }
        }
    }
}
