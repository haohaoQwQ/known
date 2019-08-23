package util;

/**
 * @author 刘梦昊 2019/7/22 22:58
 */
public class GetFileName {
    public static String getName(String heard) {
        String[] split = heard.split(";");
        String[] split1 = split[2].split("=");
        String s = split1[1].replaceAll("\"", "");
        return s;
    }
}
