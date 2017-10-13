package cn.bestick.examsys.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 2016/4/8
 * Time: 21:54
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
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
