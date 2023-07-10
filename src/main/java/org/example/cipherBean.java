package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.apache.commons.io.FileUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.example.encEnum.cipherNameEnum;
import org.example.encEnum.cipherSettingEnum;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.HashMap;
import java.util.Map;


@Data
public class cipherBean {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    //加密类型（块/流/公钥）
    cipherSettingEnum.cipherType type;
    //加密算法
    private cipherNameEnum cipher;
    //加密位数
    private cipherSettingEnum.cipherBit bit;
    //加密模式
    private cipherSettingEnum.cipherWorkmode workmode;
    //填充模式
    private cipherSettingEnum.padType padType;
    //密码（对称加密）和初始化向量
    private String password, iv;
    //密钥对
    private KeyPair kp;
    //公钥（非对称加密）
    private PublicKey pubkey;
    //私钥（非对称加密）
    private PrivateKey prikey;
    //私钥是否加密(AES-256-ECB)
    private boolean prikeyEncrypted;

    //对称加密（不带iv）
    public cipherBean(String passwd,
                      cipherNameEnum cipher,
                      cipherSettingEnum.cipherBit bit,
                      cipherSettingEnum.padType padType) {
        setPassword(passwd);
        setCipher(cipher);
        setBit(bit);
        setWorkmode(cipherSettingEnum.cipherWorkmode.ECB);
        setPadType(padType);
    }

    //对称加密（带iv）
    public cipherBean(String passwd,
                      String iv,
                      cipherNameEnum cipher,
                      cipherSettingEnum.cipherBit bit,
                      cipherSettingEnum.cipherWorkmode workmode,
                      cipherSettingEnum.padType padType) {
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
                      cipherNameEnum cipher,
                      cipherSettingEnum.cipherWorkmode workmode,
                      cipherSettingEnum.padType padType) {
        setType(cipherSettingEnum.cipherType.ASSM_ENCRYPT);
        setPubkey(pubkey);
        setPrikey(prikey);
        setCipher(cipher);
        setWorkmode(workmode);
        setPadType(padType);
    }

    //公钥加密（生成密钥）
    public cipherBean(cipherNameEnum cipher,
                      cipherSettingEnum.cipherBit bit,
                      cipherSettingEnum.cipherWorkmode workmode,
                      cipherSettingEnum.padType padType) throws Exception {
        setType(cipherSettingEnum.cipherType.ASSM_ENCRYPT);
        setCipher(cipher);
        KeyPair kp = generateKeyPair(cipher, bit);
        setPrikey(kp.getPrivate());
        setPubkey(kp.getPublic());
        System.out.println("pub:" + pubkey);
        System.out.println("pri:" + prikey);
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

    public void output_pk(KeyPair kp) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = new HashMap<>();
        map.put("cipher", cipherNameEnum.toSt(cipher));
        map.put("pubkey", kp.getPublic().toString());
        map.put("prikey", kp.getPrivate().toString());
        String jsonStr = objectMapper.writeValueAsString(map);
        System.out.println("===================================================\n");
        System.out.println(jsonStr);
        System.out.println("===================================================\n");
        System.out.println("密钥对写入当前文件夹下");
        FileUtils.writeByteArrayToFile(new File("./keypair.json"),
                jsonStr.getBytes(StandardCharsets.UTF_8));
    }

    public KeyPair generateKeyPair(cipherNameEnum name, cipherSettingEnum.cipherBit bit)
            throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance(cipherNameEnum.toSt(name));
        kpg.initialize(cipherSettingEnum.cipherBit.toInt(bit));
        kp = kpg.generateKeyPair();
        return kp;
    }
}
