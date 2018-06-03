package org.zwx.cryptogram.digest;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

public class Base64Test {

    public static void main(String[] args) throws IOException {
        BASE64Encoder encoder = new BASE64Encoder();
        String bytes = encoder.encode("hello".getBytes());
        System.out.println(bytes);

        BASE64Decoder decoder = new BASE64Decoder();
        byte[] bytes1 = decoder.decodeBuffer(bytes);
        System.out.println(new String(bytes1));
    }
}
