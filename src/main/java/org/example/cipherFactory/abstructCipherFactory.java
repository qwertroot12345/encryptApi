package org.example.cipherFactory;

import org.apache.commons.lang3.tuple.Pair;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.example.cipherBean;
import org.example.encInterface.cipherFun;
import org.example.utils.cipherFullmodenameBuilder;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public abstract class abstructCipherFactory {

    protected cipherBean config;

    protected String cipstr,cipname;

    protected Cipher inner_enc,inner_dec;

    public abstructCipherFactory (cipherBean config) throws Exception {
        init(config);
        cipherFullmodenameBuilder cipstrbuilder=new cipherFullmodenameBuilder(config);
        cipstr = cipstrbuilder.getcCipherStr();
        Cipher cipher=Cipher.getInstance(cipstr, BouncyCastleProvider.PROVIDER_NAME);
    }

    public void init(cipherBean config) throws Exception{
        this.config=config;
    };

    public abstract Cipher[] getCipPair() throws Exception;

    public Cipher getEncCip() throws Exception {
        return getCipPair()[0];
    }

    public Cipher getDecCip() throws Exception {
        return getCipPair()[1];
    }
    protected abstract void getCipName();

    protected abstract void getEncBit();
}