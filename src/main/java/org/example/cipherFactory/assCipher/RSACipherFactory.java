package org.example.cipherFactory.assCipher;

import org.example.assKeyPair;
import org.example.cipherBean;
import org.example.encEnum.cipherSettingEnum;

import javax.crypto.Cipher;
import java.security.PrivateKey;
import java.security.PublicKey;

public class RSACipherFactory extends absAssCipherFactory {
    public RSACipherFactory(cipherBean config) throws Exception {
        super(config);
    }

    @Override
    public Cipher[] getCipPair() {
        return new Cipher[]{};
    }

    @Override
    protected boolean checkis_cipvalid(cipherSettingEnum.cipherWorkmode workmode, cipherSettingEnum.padType pad) {
        return false;
    }

    @Override
    public assKeyPair<PublicKey, PrivateKey> generateKeyPair(cipherSettingEnum.cipherBit bit) {
        return null;
    }
}
