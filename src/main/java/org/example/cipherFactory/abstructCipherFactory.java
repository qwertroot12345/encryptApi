package org.example.cipherFactory;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.example.cipherBean;
import org.example.encEnum.cipherNameEnum;
import org.example.encEnum.cipherSettingEnum;

import javax.crypto.Cipher;
import java.security.Security;

public abstract class abstructCipherFactory {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    protected cipherBean config;

    protected String cipstr, cipname;

    protected int encbit;

    protected Cipher inner_enc, inner_dec;

    public abstructCipherFactory(cipherBean config) throws Exception {
        init(config);
    }

    public void init(cipherBean config) throws Exception {
        this.config = config;
    }

    public abstract Cipher[] getCipPair() throws Exception;

    public Cipher getEncCip() throws Exception {
        getCipPair();
        return inner_enc;
    }

    public Cipher getDecCip() throws Exception {
        getCipPair();
        return inner_dec;
    }

    protected void getCipName() {//生成kg
        cipname = cipherNameEnum.toSt(config.getCipher());
    }

    protected void getEncBit() {//生成skey和kp
        encbit = cipherSettingEnum.cipherBit.toInt(config.getBit());
    }

    //检查加密器设定是否合法（在具体加密器实现）
    protected abstract boolean checkis_cipvalid(cipherSettingEnum.cipherWorkmode workmode,
                                                cipherSettingEnum.padType pad);
}
