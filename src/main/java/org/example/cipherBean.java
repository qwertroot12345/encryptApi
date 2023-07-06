package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.apache.commons.io.FileUtils;
import org.example.encEnum.cipherName;
import org.example.encEnum.cipherSettingEnum;

import javax.crypto.Cipher;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.security.PublicKey;

@Data
public class cipherBean {
    //加密算法
    private  cipherName cipher;
    //加密位数
    private  cipherSettingEnum.cipherBit bit;
    //加密模式
    private  cipherSettingEnum.cipherWorkmode workmode;
    //填充模式
    private  cipherSettingEnum.padType padType;
    //密码（对称加密）和初始化向量
    private  String password, iv;
    //公钥（非对称加密）
    private  PublicKey pubkey;
    //私钥（非对称加密）
    private  PrivateKey prikey;
    //内部加密器
    private  Cipher innerCipher;
    //私钥是否加密(AES-256-ECB)
    private  boolean prikeyEncrypted;
    //加密内容是否压缩
    private boolean is_compress;

    public cipherBean() {

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
