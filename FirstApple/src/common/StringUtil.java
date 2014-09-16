package common;

/**
 * 
 * @author junqing.fjq
 * @version $Id: StringUtil.java, v 0.1 2014年9月2日 下午5:39:37 junqing.fjq Exp $
 */
public class StringUtil {

    public static final String EMPTY_STRING = "";

    public static boolean isEmpty(String str) {

        return ((str == null) || str.length() == 0);
    }

    public static boolean isBlank(String str) {
        int length = 0;
        if ((str == null) || ((length = str.length()) == 0))
            return true;
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i)))
                return false;
        }
        return true;
    }

    public static boolean equals(String str1, String str2) {
        if (str1 == null) {
            return null == str2;
        }
        return str1.equals(str2);
    }

}
