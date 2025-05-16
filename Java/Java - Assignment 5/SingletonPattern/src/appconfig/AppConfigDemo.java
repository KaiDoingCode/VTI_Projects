package appconfig;

import appconfig.domain.AppConfig;

public class AppConfigDemo {
    public static void run() {
        AppConfig config1 = AppConfig.getInstance();
        config1.setConfigName("MyApp");

        AppConfig config2 = AppConfig.getInstance();
        System.out.println("Config name: " + config2.getConfigName()); // Should print "MyApp"
    }
}
