package org.example.utils;

import org.example.encEnum.cipherName;
import org.example.encEnum.cipherSettingEnum;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class assKeypairGen {

    public static KeyPair generateKeyPair(cipherName name,cipherSettingEnum.cipherBit bit) throws NoSuchAlgorithmException {
        switch (name){
            case RSA -> {
                return RSA_generateKeyPair(bit);
            }
//            case DSA -> {
//
//            }
//            case EDDSA -> {
//
//            }
//            case DH -> {
//
//            }
            default -> {
                return RSA_generateKeyPair(bit);
            }
        }
    }

    public static KeyPair RSA_generateKeyPair(cipherSettingEnum.cipherBit bit) throws NoSuchAlgorithmException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        switch (bit) {
            case BITS_1024 -> kpg.initialize(1024);
            case BITS_2048 -> kpg.initialize(2048);
            case BITS_3072 -> kpg.initialize(3072);
            case BITS_4096 -> kpg.initialize(4096);
            case BITS_8192 -> kpg.initialize(8192);
            default -> kpg.initialize(1024);
        }
        return kpg.genKeyPair();
    }
}
