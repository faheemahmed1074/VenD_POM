package Config;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource.Classpath;

@Classpath({"ApplicationConfig.properties"})
public class ApplicationConfigReader {
    @Property("username")
    private String UserName;

    @Property("password")
    private String Password;

    @Property("Environment")
    private String Environment;

    @Property("Device")
    private String Device;

    @Property("headless")
    private String headless;

    @Property("Browser")
    private String Browser;

     @Property("baseURI")
    private String baseURI;

     @Property("url")
    private String url;

    @Property("isEnableReporting")
    private String isEnableReporting;

    @Property("isEnableRecording")
    private String isEnableRecording;

    @Property("chipSystem")
    private String chipSystem;

    @Property("chipToChip")
    private String chipToChip;

    @Property("topOverhang")
    private String topOverhang;

    @Property("bottomOverhang")
    private String bottomOverhang;

    @Property("leftOverhang")
    private String leftOverhang;

    @Property("rightOverhang")
    private String rightOverhang;

    @Property("systemName")
    private String systemName;

    @Property("systems")
    private String systems;

/*############################ --- Environment --- ############################*/

    @Property("dbAutoName")
    private String dbAutoName = "";

    @Property("dbName")
    private String dbName = "";

    @Property("dbUrl")
    private String dbUrl = "";

    @Property("dbUsername")
    private String dbUsername = "";

    @Property("dbPassword")
    private String dbPassword = "";


    public ApplicationConfigReader() {
        PropertyLoader.newInstance().populate(this);
    }

    public String getUserName() {
        return this.UserName;
    }

    public String getPassword() {
        return this.Password;
    }

    public String getEnvironment() {
        return this.Environment;
    }

    public String getDevice() {
        return this.Device;
    }

    public String getHeadless() {
        return this.headless;
    }

    public String getBrowser() {
        return this.Browser;
    }

    public String getBaseURI() {
        return this.baseURI;
    }
    public String getUrl() {
        return this.url;
    }

    public String getIsEnableReporting() { return this.isEnableReporting; }
    public String getIsEnableRecording() { return this.isEnableRecording; }

    public String getChipSystem() { return this.chipSystem; }

    public String getSystemName() { return this.systemName; }

    public String getChipToChip() { return this.chipToChip; }

    public String getTopOverhang() { return this.topOverhang; }
    public String getBottomOverhang() { return this.bottomOverhang; }
    public String getLeftOverhang() { return this.leftOverhang; }
    public String getRightOverhang() { return this.rightOverhang; }

    public String getSystems() { return this.systems; }

    public String getDbAutoName() {
        return dbAutoName;
    }
    public String getDbName() {
        return dbName;
    }
    public String getDbUrl() {
        return dbUrl;
    }
    public String getDbUsername() { return dbUsername; }
    public String getDbPassword() { return dbPassword; }


}
