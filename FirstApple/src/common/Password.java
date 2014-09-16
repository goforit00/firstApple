package common;

import java.security.MessageDigest;

public class Password {
    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "a", "b", "c", "d", "e", "f"   };
    private final static String MD5="MD5";

    public static String generateMD5Password(String password) {
        if (StringUtil.isBlank(password)) {
            return null;
        }

        return encodeByMD5(password);
    }

    public static boolean checkPassword(String inputPassword, String MD5Password) {
        if ( StringUtil.isBlank(inputPassword) || StringUtil.isBlank(MD5Password)) {
            return false;
        }
        if (StringUtil.equals(MD5Password,encodeByMD5(inputPassword))) {
            return true;
        } else {
            return false;
        }
    }

    private static String encodeByMD5(String password) {
        if (StringUtil.isBlank(password)) {
            return null;
        }

        try {
            MessageDigest md = MessageDigest.getInstance(MD5);
            byte[] results = md.digest(password.getBytes());
            
            String MD5password = byteArrayToHexString(results);
            return MD5password.toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            result.append(byteToHexString(b[i]));
        }
        return result.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

}
