package test;

import common.Password;

public class PasswordTest {
    public static void main(String argv[]) {
        String pass="123456";
        String md5pass=Password.generateMD5Password(pass);
        System.err.println(md5pass);

        String pass2="6666";
        if(Password.checkPassword(pass2, md5pass) ==true)
        {
            System.err.println("password same");
        }
        else {
            System.err.println("password error");
        }
    }
}
