package org.zwx.cryptogram.synmatic;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static javax.crypto.Cipher.*;

public class SynmaticTest {





    public static String generateBase64Key(String alogricName, int bitNum) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(alogricName);

        keyGenerator.init(bitNum);

        SecretKey key = keyGenerator.generateKey();
        byte[] bytes = key.getEncoded();
        return byte2Base64(bytes);
    }

    private static String byte2Base64(byte[] bytes) {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(bytes);
    }

    private static byte[] base64ToByte(String encryptedStr) throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        return decoder.decodeBuffer(encryptedStr);
    }

    private static byte[] encrypt(String alograthicName, byte[] source, SecretKey key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = getInstance(alograthicName);
        cipher.init(ENCRYPT_MODE, key);
        return cipher.doFinal(source);
    }

    private static byte[] decrypt(String alograthicName, byte[] source, SecretKey key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(alograthicName);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(source);
    }

    private static SecretKey loadSecretKey(String base64Str, String alogrithName) throws IOException {
        byte[] bytes = base64ToByte(base64Str);
        SecretKey key = new SecretKeySpec(bytes, alogrithName);
        return key;
    }
}
