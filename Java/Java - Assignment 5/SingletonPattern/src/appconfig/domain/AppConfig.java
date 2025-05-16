package appconfig.domain;

public class AppConfig {
    private static AppConfig instance;
    private String configName;

    private AppConfig() {
        configName = "DefaultConfig";
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }
}
