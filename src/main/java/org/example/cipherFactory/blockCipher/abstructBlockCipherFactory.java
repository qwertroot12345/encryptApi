package org.example.cipherFactory.blockCipher;

import org.apache.commons.lang3.StringUtils;
import org.example.cipherBean;
import org.example.cipherFactory.abstructCipherFactory;
import org.example.encEnum.cipherSettingEnum;
import org.example.utils.cipherFullmodenameBuilder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.SecureRandom;

public abstract class abstructBlockCipherFactory extends abstructCipherFactory {
    protected String passwd, iv;
    protected byte[] b_passwd, b_iv;
    protected int encbit;
    protected boolean needIV;


    public abstructBlockCipherFactory(cipherBean config) throws Exception {
        super(config);
    }

    public void init(cipherBean config) throws Exception {
        super.init(config);
        getCipName();
        is_needIV();
        if (needIV && StringUtils.isEmpty(config.getIv())) {
            throw new Exception("no valid IV");
        }
        passwd = config.getPassword();
        if (StringUtils.isEmpty(config.getPassword())) {
            throw new Exception("no valid password");
        }
        b_passwd = passwd.getBytes(StandardCharsets.UTF_8);
        getEncBit();
        cipstr = new cipherFullmodenameBuilder(config).getcCipherStr();
    }

    @Override
    public Cipher[] getCipPair() throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance(cipname);
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        sr.setSeed(b_passwd);
        kg.init(encbit,sr);
        Key aes_skey=kg.generateKey();
        Cipher enc, dec;
        enc = Cipher.getInstance(cipstr);
        dec = Cipher.getInstance(cipstr);

        if (needIV) {
            b_iv = iv.getBytes(StandardCharsets.UTF_8);
            IvParameterSpec ivs = new IvParameterSpec(b_iv);
            enc.init(Cipher.ENCRYPT_MODE, aes_skey, ivs);
            dec.init(Cipher.DECRYPT_MODE, aes_skey, ivs);
        } else {
            enc.init(Cipher.ENCRYPT_MODE, aes_skey);
            dec.init(Cipher.DECRYPT_MODE, aes_skey);
        }
        return new Cipher[]{enc, dec};
    }

    @Override
    protected void getCipName() {
        switch (config.getCipher()) {
            case DES -> cipname = "DES";
            case AES -> cipname = "AES";
            //...........
            default -> cipname = "AES";
        }
    }

    private void is_needIV() {
        needIV = config.getWorkmode() == cipherSettingEnum.cipherWorkmode.CBC;
    }

    @Override
    protected void getEncBit() {
        switch (config.getBit()) {
            case BITS_56 -> encbit = 56;
            case BITS_128 -> encbit = 128;
            case BITS_192 -> encbit = 192;
            case BITS_256 -> encbit = 256;
            case BITS_448 -> encbit = 448;
            case BITS_512 -> encbit = 512;
        }
    }

}
