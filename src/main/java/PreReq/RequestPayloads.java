package PreReq;

import General.GenericFunctions;
import General.envGlobals;
import dbConnection.dbConn;

import java.sql.SQLException;

import static Config.configProperties.UserName;

public class RequestPayloads {
    public RequestPayloads(){}

    public static String saveAsSystem(String name, String randName, int systemId) throws SQLException {
        String zcadSystemId = dbConn.getSystemIds(name).get(0);
        String archId = dbConn.getSystemIds(name).get(1);
        String archTileId = dbConn.getSystemIds(name).get(2);

        envGlobals.requstBody =
                "{\n" +
                        "    \"name\": \"" + randName + "\",\n" +
                        "    \"architecture\": {\n" +
                        "        \"id\": "  + archTileId + ",\n" +
                        "        \"arch_id\": "  + archId + ",\n" +
                        "        \"rows\": 64,\n" +
                        "        \"columns\": 44\n" +
                        "    },\n" +
                        "    \"user\": \"" + UserName + "\",\n" +
                        "    \"systemId\": " + systemId + ",\n" +
                        "    \"zcad_system_id\": " + zcadSystemId + ",\n" +
                        "    \"ult\": \"\",\n" +
                        "    \"is_sub_system\": false,\n" +
                        "    \"account_id\": 1\n" +
                        "}";

        return envGlobals.requstBody;
    }
}
