package util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncrypt {
    public static void main(String[] args) {
        String password = "123";
        System.out.println("password: " + password);
        System.out.println("password encriptado:" + passwordEncrypt(password));
    }

    private static String passwordEncrypt(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
