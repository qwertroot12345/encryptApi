package org.example.cipherFactory.blockCipher;

import org.apache.commons.lang3.StringUtils;
import org.example.cipherBean;
import org.example.cipherFactory.abstructCipherFactory;
import org.example.encEnum.cipherSettingEnum;
import org.example.utils.cipherFullmodenameBuilder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.SecureRandom;

public abstract class abstructBlockCipherFactory extends abstructCipherFactory {
    protected String passwd, iv;
    protected byte[] b_passwd, b_iv;
    protected boolean needIV;


    public abstructBlockCipherFactory(cipherBean config) throws Exception {
        super(config);
    }

    public void init(cipherBean config) throws Exception {
        super.init(config);
        getCipName();
        getEncBit();
        if (config.getWorkmode() != cipherSettingEnum.cipherWorkmode.ECB) {
            if (!StringUtils.isEmpty(config.getIv())) {
                b_iv = iv.getBytes(StandardCharsets.UTF_8);
            } else {
                throw new Exception("no valid IV");
            }
        }
        if (StringUtils.isEmpty(config.getPassword())) {
            throw new Exception("no valid password");
        }
        passwd = config.getPassword();
        b_passwd = passwd.getBytes(StandardCharsets.UTF_8);
        cipstr = new cipherFullmodenameBuilder(config).getcCipherStr();
    }

    @Override
    public Cipher[] getCipPair() throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance(cipname);
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        sr.setSeed(b_passwd);
        kg.init(encbit, sr);
        Key skey = kg.generateKey();
        inner_enc = Cipher.getInstance(cipstr);
        inner_dec = Cipher.getInstance(cipstr);
        if (needIV) {
            b_iv = iv.getBytes(StandardCharsets.UTF_8);
            IvParameterSpec ivs = new IvParameterSpec(b_iv);
            inner_enc.init(Cipher.ENCRYPT_MODE, skey, ivs);
            inner_dec.init(Cipher.DECRYPT_MODE, skey, ivs);
        } else {
            inner_enc.init(Cipher.ENCRYPT_MODE, skey);
            inner_dec.init(Cipher.DECRYPT_MODE, skey);
        }
        return new Cipher[]{inner_enc, inner_dec};
    }

}
