package ec.edu.espe.controller;

public class AccountController {

    public static String encryptPassword(String password) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char newChar = (char) ((c - base + 2) % 26 + base);
                encrypted.append(newChar);
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    public static boolean checkPassword(String inputPassword, String storedPassword) {
        String inputPasswordEncrypted = encryptPassword(inputPassword);
        if (inputPasswordEncrypted.equals(storedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}
