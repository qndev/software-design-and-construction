/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hust.soict.logic;
import org.jasypt.util.password.StrongPasswordEncryptor;
/**
 * Class encrypt password and compare password user input with password in database.
 * @author quangnd
 */
public class PasswordUtils {

    private static StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();

    /**
     * Encrypts (digests) a password.
     *
     * @param data - the password to be encrypted.
     * @return
     */
    public static String encryptPassword(String data) {

        String result = passwordEncryptor.encryptPassword(data);

        return result;
    }

    /**
     * Checks an unencrypted (plain) password against an encrypted one (a
     * digest) to see if they match.
     *
     * @param getPasswordTextField
     * @param encryptedPassword
     * @return true if passwords match, false if not.
     */
    public static boolean checkPassword(String getPasswordTextField, String encryptedPassword) {

        return passwordEncryptor.checkPassword(getPasswordTextField, encryptedPassword);
    }
}
