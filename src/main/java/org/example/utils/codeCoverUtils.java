package org.example.utils;

import org.apache.commons.codec.binary.BinaryCodec;
import org.bouncycastle.util.encoders.Base32;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.Hex;
import org.example.encEnum.encodeTypeEnum;

import java.nio.charset.StandardCharsets;

public class codeCoverUtils {

    public static String toText(byte[] input, encodeTypeEnum type) {
        String output;
        switch (type) {
            case HEX -> output = Hex.toHexString(input);
            case BASE64 -> output = Base64.toBase64String(input);
            case BASE32 -> output = Base32.toBase32String(input);
            case BYTE -> output = new String(input);
            default -> output = BinaryCodec.toAsciiString(input);
        }
        return output;
    }

    public static byte[] toBinary(String input, encodeTypeEnum type) {
        byte[] output;
        switch (type) {
            case HEX -> output = Hex.decode(input);
            case BASE64 -> output = Base64.decode(input);
            case BASE32 -> output = Base32.decode(input);
            case BYTE -> output = input.getBytes(StandardCharsets.UTF_8);
            default -> output = BinaryCodec.fromAscii(input.getBytes());
        }
        return output;
    }

}
