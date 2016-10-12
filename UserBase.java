/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authentication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author macbook
 */
public class UserBase {
    private static Map<String, UserData> userBase;
    private static final String fileName = "UserBase";
    
    public static void loadUserBase() throws IOException {
        if(Files.notExists(Paths.get(fileName))) {
            Files.createFile(Paths.get(fileName));
            userBase = new HashMap<String, UserData>();
        } else {
            List<String> content = Files.readAllLines(Paths.get(fileName));
            userBase = new HashMap<String, UserData>();
            for (String line : content) {
                String[] s = line.split(";");
                userBase.put(s[0], new UserData(s[1], s[2]));
            }
        }
    }

     public static boolean addNewUser(String login, String password) throws NoSuchAlgorithmException {
        if (userBase.containsKey(login) == true) {
            return false;
        } else {
            String salt = getNewSolt();
            userBase.put(login, new UserData(sha256(password + salt), salt));
            String newUser = login + ";" + sha256(password + salt) + ";" + salt + "\n";
            System.out.println(newUser);
            try {
                Files.write(Paths.get(fileName), newUser.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
    }
     
     public static String getNewSolt(){
        Random ran = new SecureRandom();
        return Integer.toString(ran.nextInt(100));
    }
    
    public static String sha256(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
    
    public static boolean checkLoginAndPass( String login, String pass) throws NoSuchAlgorithmException{
        if(userBase.containsKey(login)){
            String solt = userBase.get(login).getSalt();
            String passHash = userBase.get(login).getPasswordHash();
            if(passHash.equals(sha256(pass+solt))){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    public static boolean singIn(String login, String pass) throws NoSuchAlgorithmException{
        return checkLoginAndPass(login, pass);
        }
   
}
