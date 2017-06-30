package No09_ETL.com.ws.config;

import No09_ETL.com.ws.commone.Constant;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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

    public static String[] getETLFIELDS() {

        return getStr(Constant.FIELDS_AFTER_ETL).split(";");
    }


}
