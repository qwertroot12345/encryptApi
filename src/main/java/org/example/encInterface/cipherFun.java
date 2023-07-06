package org.example.encInterface;


import org.example.encEnum.encodeTypeEnum;
import org.example.utils.codeCoverUtils;
import org.example.utils.compressUtils;

public interface cipherFun {

    String zero_vi = "0000000000000000";

    boolean get_is_compress();

    byte[] encrypt(String text);

    default String encryptToOtherType(String text, encodeTypeEnum type) {
        byte[] encrypted_raw = encrypt(text);
        String output;
        if (get_is_compress()) {
            encrypted_raw = compressUtils.binaryCompress(encrypted_raw);
        }
        output = codeCoverUtils.toText(encrypted_raw, type);
        return output;
    }

    byte[] decrypt(byte[] input);

    default String decryptFromOtherType(String input, encodeTypeEnum type) {
        byte[] encrypted_raw = codeCoverUtils.toBinary(input, type);
        if (get_is_compress()) {
            encrypted_raw = compressUtils.binaryDecompress(encrypted_raw);
        }
        byte[] plain_raw = decrypt(encrypted_raw);
        return new String(plain_raw);
    }

    enum encryptType {
        BYTE, HEX, BASE32, BASE64
    }

    enum codeCoverMode {
        ASCII_TO_BINARY,
        BINARY_TO_ASCII
    }

}
