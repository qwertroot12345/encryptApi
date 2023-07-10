import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.example.encInterface.cipherFun;
import org.example.utils.cipherFullmodenameBuilder;
import org.junit.Before;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.ArrayList;

import static org.example.encEnum.cipherNameEnum.AES;
import static org.example.encEnum.cipherSettingEnum.cipherWorkmode.*;
import static org.example.encEnum.cipherSettingEnum.padType.*;

public final class encModeTest {

    cipherFullmodenameBuilder namebuilder;

    String password = "password";
    String iv_str = cipherFun.zero_vi;
    String paintext = "text";

    @Before
    public void init() {
        Security.addProvider(new BouncyCastleProvider());
        namebuilder = new cipherFullmodenameBuilder();
    }

    public boolean check_is_encvalid(Cipher enc, Cipher dec) throws IllegalBlockSizeException, BadPaddingException {


        return dec.doFinal(enc.doFinal(paintext.getBytes(StandardCharsets.UTF_8))) == paintext.getBytes(StandardCharsets.UTF_8);
    }

    @Test
    public void aesTest() throws Exception {
        ArrayList<String> aesmodes = new ArrayList<>();

        //ECB
        {
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(ECB).setE_cippad(PCKS5).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(ECB).setE_cippad(PCKS7).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(ECB).setE_cippad(ZEROBYTE).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(ECB).setE_cippad(NONE).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(ECB).setE_cippad(TBC).getcCipherStr());
        }
        //CBC
        {
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(CBC).setE_cippad(PCKS5).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(CBC).setE_cippad(PCKS7).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(CBC).setE_cippad(ZEROBYTE).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(CBC).setE_cippad(NONE).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(CBC).setE_cippad(TBC).getcCipherStr());
        }
        //OFB
        {
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(OFB).setE_cippad(PCKS5).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(OFB).setE_cippad(PCKS7).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(OFB).setE_cippad(ZEROBYTE).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(OFB).setE_cippad(NONE).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(OFB).setE_cippad(TBC).getcCipherStr());
        }
        //GCM
        {
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(GCM).setE_cippad(PCKS5).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(GCM).setE_cippad(PCKS7).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(GCM).setE_cippad(ZEROBYTE).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(GCM).setE_cippad(NONE).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(GCM).setE_cippad(TBC).getcCipherStr());
        }
        //CFB
        {
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(CFB).setE_cippad(PCKS5).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(CFB).setE_cippad(PCKS7).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(CFB).setE_cippad(ZEROBYTE).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(CFB).setE_cippad(NONE).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(CFB).setE_cippad(TBC).getcCipherStr());
        }
        //CTR
        {
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(CTR).setE_cippad(PCKS5).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(CTR).setE_cippad(PCKS7).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(CTR).setE_cippad(ZEROBYTE).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(CTR).setE_cippad(NONE).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(CTR).setE_cippad(TBC).getcCipherStr());
        }
        //CCM
        {
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(CCM).setE_cippad(PCKS5).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(CCM).setE_cippad(PCKS7).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(CCM).setE_cippad(ZEROBYTE).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(CCM).setE_cippad(NONE).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(CCM).setE_cippad(TBC).getcCipherStr());
        }
        //SIC
        {
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(SIC).setE_cippad(PCKS5).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(SIC).setE_cippad(PCKS7).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(SIC).setE_cippad(ZEROBYTE).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(SIC).setE_cippad(NONE).getcCipherStr());
            aesmodes.add(namebuilder.setE_cipname(AES).setE_cipmode(SIC).setE_cippad(TBC).getcCipherStr());
        }

        Cipher[] enc = new Cipher[aesmodes.size()];
        Cipher[] dec = new Cipher[aesmodes.size()];

        //不带iv
        for (int i = 0; i < 5; i++) {
            System.out.print(aesmodes.get(i));
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            // kg.init(128);//要生成多少位，只需要修改这里即可128, 192或256
            //SecureRandom是生成安全随机数序列，password.getBytes()是种子，只要种子相同，序列就一样，所以生成的秘钥就一样。
            kg.init(256, new SecureRandom(password.getBytes()));
            try {
                enc[i] = Cipher.getInstance(aesmodes.get(i));
                dec[i] = Cipher.getInstance(aesmodes.get(i));
                enc[i].init(Cipher.ENCRYPT_MODE, new SecretKeySpec(kg.generateKey().getEncoded(), "AES"));
                dec[i].init(Cipher.DECRYPT_MODE, new SecretKeySpec(kg.generateKey().getEncoded(), "AES"));
            } catch (NoSuchAlgorithmException e) {
                System.out.println("----------------------------X");
                continue;
            }
            System.out.println("  √");
        }
        //带iv
        for (int i = 5; i < aesmodes.size(); i++) {
            System.out.print(aesmodes.get(i));
            IvParameterSpec iv = new IvParameterSpec(iv_str.getBytes(StandardCharsets.UTF_8));
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            SecretKeySpec aes_skey = new SecretKeySpec(kg.generateKey().getEncoded(), "AES");

            // kg.init(128);//要生成多少位，只需要修改这里即可128, 192或256
            //SecureRandom是生成安全随机数序列，password.getBytes()是种子，只要种子相同，序列就一样，所以生成的秘钥就一样。
            kg.init(256, new SecureRandom(password.getBytes()));
            try {
                enc[i] = Cipher.getInstance(aesmodes.get(i));
                dec[i] = Cipher.getInstance(aesmodes.get(i));
                enc[i].init(Cipher.ENCRYPT_MODE, aes_skey, iv);
                dec[i].init(Cipher.DECRYPT_MODE, aes_skey, iv);
            } catch (NoSuchAlgorithmException e) {
                System.out.println("        x");
                continue;
            }
            System.out.println("  √");
        }

        /*
                AES/ECB/PKCS5Padding  √
                AES/ECB/PKCS7Padding  √
                AES/ECB/ZeroBytePadding  √
                AES/ECB/NoPadding  √
                AES/ECB/TBCPadding  √
                AES/CBC/PKCS5Padding  √
                AES/CBC/PKCS7Padding  √
                AES/CBC/ZeroBytePadding  √
                AES/CBC/NoPadding  √
                AES/CBC/TBCPadding  √
                AES/OFB/PKCS5Padding  √
                AES/OFB/PKCS7Padding  √
                AES/OFB/ZeroBytePadding  √
                AES/OFB/NoPadding  √
                AES/OFB/TBCPadding  √
          --->  AES/GCM/PKCS5Padding  x
          --->  AES/GCM/PKCS7Padding  x
          --->  AES/GCM/ZeroBytePadding  x
                AES/GCM/NoPadding  √
          --->  AES/GCM/TBCPadding  x
                AES/CFB/PKCS5Padding  √
                AES/CFB/PKCS7Padding  √
                AES/CFB/ZeroBytePadding  √
                AES/CFB/NoPadding  √
                AES/CFB/TBCPadding  √
                AES/CTR/PKCS5Padding  √
                AES/CTR/PKCS7Padding  √
                AES/CTR/ZeroBytePadding  √
                AES/CTR/NoPadding  √
                AES/CTR/TBCPadding  √
                AES/CTR/PKCS5Padding  √
                AES/CTR/PKCS7Padding  √
                AES/CTR/ZeroBytePadding  √
                AES/CTR/NoPadding  √
                AES/CTR/TBCPadding  √
                AES/SIC/PKCS5Padding  √
                AES/SIC/PKCS7Padding  √
                AES/SIC/ZeroBytePadding  √
                AES/SIC/NoPadding  √
                AES/SIC/TBCPadding  √
        */

    }
}
