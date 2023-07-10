package org.example.cipherFactory.assCipher;

import org.example.assKeyPair;
import org.example.cipherBean;
import org.example.cipherFactory.abstructCipherFactory;
import org.example.encEnum.cipherSettingEnum;

import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public abstract class abstructAssCipherFactory extends abstructCipherFactory {

    public static int MAX_ENC_BYTE_SIZE = 256, MAX_DEC_BYTE_SIZE = 256;

    public abstructAssCipherFactory(cipherBean config) throws Exception {
        super(config);
    }

    public abstract assKeyPair<PublicKey, PrivateKey> generateKeyPair(cipherSettingEnum.cipherBit bit)
            throws NoSuchAlgorithmException;

}

