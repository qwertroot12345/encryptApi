import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;
import org.example.cipherBean;
import org.example.cipherFactory.blockCipher.AEScipherFactory;
import org.example.encEnum.cipherSettingEnum;
import org.example.encEnum.encodeTypeEnum;
import org.example.utils.codeCoverUtils;
import org.junit.Test;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.Security;

public class aesTest {
    @Test
    public void aesTest1() throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        cipherBean config = new cipherBean(
                "0000",
//                "0000000000000000",
                cipherSettingEnum.cipherNameEnum.AES,
                cipherSettingEnum.cipherBit.BITS_256,
//                cipherSettingEnum.cipherWorkmode.ECB,
                cipherSettingEnum.padType.PCKS5);

        AEScipherFactory factory = new AEScipherFactory(config);
        Cipher enc = factory.getEncCip();
        Cipher dec = factory.getDecCip();
        String text = "0000000000000000000000000000";
        String enced = codeCoverUtils.toText(enc.doFinal(text.getBytes(StandardCharsets.UTF_8)), encodeTypeEnum.BASE64);
        String deced = codeCoverUtils.toText(dec.doFinal(Base64.decode(enced)), encodeTypeEnum.BYTE);
        System.out.println(deced);
    }
}
