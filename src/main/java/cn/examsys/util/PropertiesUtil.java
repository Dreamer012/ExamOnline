package cn.examsys.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesUtil {

    /**
     * 根据key获取value
     *
     * @param key key
     * @return String key
     */
    public static String getValue(String key) {
        Properties prop = new Properties();
        InputStream in = PropertiesUtil.class.getResourceAsStream("/examsys.properties");
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (String) prop.get(key);
    }
}
