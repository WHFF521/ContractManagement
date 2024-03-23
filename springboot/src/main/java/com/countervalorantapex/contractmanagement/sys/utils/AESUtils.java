package com.countervalorantapex.contractmanagement.sys.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESUtils {
    private static final String AES_ALGORITHM = "AES";

    private static String secretKey = "5F69A2BCD874E961";

    private static String getSecretKey(){
        return secretKey;
    }

    public static String encrypt(String password) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(getSecretKey().getBytes(), AES_ALGORITHM);
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encryptedBytes = cipher.doFinal(password.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedPassword) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(getSecretKey().getBytes(), AES_ALGORITHM);
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedPassword);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }
}

//import javax.crypto.Cipher;
//        import javax.crypto.spec.SecretKeySpec;
//        import java.nio.charset.StandardCharsets;
//        import java.util.Base64;
//
//public class AESUtils {
//    private static final String AES_ALGORITHM = "AES";
//
//    public static String encrypt(String password, String secretKey) throws Exception {
//        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), AES_ALGORITHM);
//        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
//        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
//        byte[] encryptedBytes = cipher.doFinal(password.getBytes(StandardCharsets.UTF_8));
//        return Base64.getEncoder().encodeToString(encryptedBytes);
//    }
//
//    public static String decrypt(String encryptedPassword, String secretKey) throws Exception {
//        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), AES_ALGORITHM);
//        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
//        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
//        byte[] decodedBytes = Base64.getDecoder().decode(encryptedPassword);
//        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
//        return new String(decryptedBytes, StandardCharsets.UTF_8);
//    }
//}

