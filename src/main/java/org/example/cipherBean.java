package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.apache.commons.io.FileUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.example.encEnum.*;
import org.example.utils.assKeypairGen;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;


@Data
public class cipherBean {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    //加密类型（块/流/公钥）
    cipherSettingEnum.cipherType type;
    //加密算法
    private cipherName cipher;
    //加密位数
    private cipherSettingEnum.cipherBit bit;
    //加密模式
    private cipherSettingEnum.cipherWorkmode workmode;
    //填充模式
    private cipherSettingEnum.padType padType;
    //密码（对称加密）和初始化向量
    private String password, iv;
    //公钥（非对称加密）
    private PublicKey pubkey;
    //私钥（非对称加密）
    private PrivateKey prikey;
    //私钥是否加密(AES-256-ECB)
    private boolean prikeyEncrypted;
    //加密内容是否压缩
    private boolean is_compress;

    //对称加密（不带iv）
    public cipherBean(String passwd,
                      cipherName cipher,
                      cipherSettingEnum.cipherBit bit,
                      cipherSettingEnum.padType padType){
        setPassword(passwd);
        setCipher(cipher);
        setBit(bit);
        setWorkmode(cipherSettingEnum.cipherWorkmode.ECB);
        setPadType(padType);
    }

    //对称加密（带iv）
    public cipherBean(String passwd,
                      String iv,
                      cipherName cipher,
                      cipherSettingEnum.cipherBit bit,
                      cipherSettingEnum.cipherWorkmode workmode,
                      cipherSettingEnum.padType padType){
        setType(cipherSettingEnum.cipherType.BLOCK_ENCRYPT);
        setPassword(passwd);
        setIv(iv);
        setCipher(cipher);
        setBit(bit);
        setWorkmode(workmode);
        setPadType(padType);
    }

    //公钥加密（带密钥对，极少）
    public cipherBean(PublicKey pubkey,
                      PrivateKey prikey,
                      cipherName cipher,
                      cipherSettingEnum.cipherWorkmode workmode,
                      cipherSettingEnum.padType padType){
        setType(cipherSettingEnum.cipherType.ASSM_ENCRYPT);
        setPubkey(pubkey);
        setPrikey(prikey);
        setCipher(cipher);
        setWorkmode(workmode);
        setPadType(padType);
    }

    //公钥加密（生成密钥）
    public cipherBean(cipherName cipher,
                      cipherSettingEnum.cipherBit bit,
                      cipherSettingEnum.cipherWorkmode workmode,
                      cipherSettingEnum.padType padType) throws NoSuchAlgorithmException {
        setType(cipherSettingEnum.cipherType.ASSM_ENCRYPT);
        setCipher(cipher);
        KeyPair kp=assKeypairGen.generateKeyPair(cipher, bit);
        System.out.println(kp.getPublic());
        System.out.println(kp.getPrivate());
        setPrikey(kp.getPrivate());
        setPubkey(kp.getPublic());
        setWorkmode(workmode);
        setPadType(padType);
    }
    public void backup_to_json_config() {
        ObjectMapper jsonmaper = new ObjectMapper();
        try {
            String json_str = jsonmaper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
            FileUtils.writeByteArrayToFile(new File("./cipher_config.json"), json_str.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
