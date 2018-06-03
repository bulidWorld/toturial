package org.zwx.cryptogram.digest;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5SHA1Test {

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        digest("MD5", "hello");

    }


    public static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static void digest(String algrothName, String msg) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algrothName);

        byte[] bytes = digest.digest(msg.getBytes("UTF-8"));

        System.out.println(bytes.length);
        System.out.println(bytesToHexString(bytes).toUpperCase());
    }
}
