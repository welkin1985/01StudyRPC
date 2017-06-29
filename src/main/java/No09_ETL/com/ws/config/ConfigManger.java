package No09_ETL.com.ws.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 *
 */
public class ConfigManger {
    private static Properties prop = new Properties();

    static {
        try {
            InputStream in = ConfigManger.class.getClassLoader().getResourceAsStream("Config.properties");
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getStr(String key) {
        return prop.getProperty(key);
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(getStr(key));
    }

    public static Set<String> getTargetFields(String regex) {
        Set<String> keySet = prop.stringPropertyNames();
        Set<String> target = new HashSet<>();
        for (String s : keySet) {
            if (s.matches(regex)) {
                target.add(s.substring(s.lastIndexOf("=") + 1));
            }
        }

        return target;
    }
}
