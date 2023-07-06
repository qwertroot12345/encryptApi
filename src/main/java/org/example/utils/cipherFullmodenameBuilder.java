package org.example.utils;

import org.example.cipherBean;
import org.example.encEnum.cipherName;
import org.example.encEnum.cipherSettingEnum;

public class cipherFullmodenameBuilder {

    private String cipname, cipmode, cippad;

    private StringBuilder fullname;

    private cipherName e_cipname;
    private cipherSettingEnum.cipherWorkmode e_cipmode;
    private cipherSettingEnum.padType e_cippad;

    public cipherFullmodenameBuilder(cipherBean config) {
        e_cipmode = config.getWorkmode();
        e_cipname = config.getCipher();
        e_cippad = config.getPadType();
    }

    public cipherFullmodenameBuilder(cipherName e_cipname,
                                     cipherSettingEnum.cipherWorkmode e_cipmode,
                                     cipherSettingEnum.padType e_cippad) {
        this.e_cipname = e_cipname;
        this.e_cipmode = e_cipmode;
        this.e_cippad = e_cippad;
    }

    public cipherFullmodenameBuilder() {
    }

    public cipherFullmodenameBuilder setE_cipname(cipherName e_cipname) {
        this.e_cipname = e_cipname;
        return this;
    }

    public cipherFullmodenameBuilder setE_cipmode(cipherSettingEnum.cipherWorkmode e_cipmode) {
        this.e_cipmode = e_cipmode;
        return this;
    }

    public cipherFullmodenameBuilder setE_cippad(cipherSettingEnum.padType e_cippad) {
        this.e_cippad = e_cippad;
        return this;
    }

    public String getcCipherStr() throws Exception {
        if (e_cipname == null || e_cippad == null || e_cipmode == null) {
            throw new Exception("can't be null config.");
        } else {
            fullname = new StringBuilder();
            switch (e_cipname) {
                case AES -> cipname = "AES";
                case DES -> cipname = "DES";
            }
            switch (e_cipmode) {
                case CBC -> cipmode = "CBC";
                case CFB -> cipmode = "CFB";
                case CTR -> cipmode = "CTR";
                case ECB -> cipmode = "ECB";
                case GCM -> cipmode = "GCM";
                case OFB -> cipmode = "OFB";
                case SIC -> cipmode = "SIC";
            }
            switch (e_cippad) {
                case PCKS5 -> cippad = "PKCS5Padding";
                case TBC -> cippad = "TBCPadding";
                case NONE -> cippad = "NoPadding";
                case PCKS7 -> cippad = "PKCS7Padding";
                case ZEROBYTE -> cippad = "ZeroBytePadding";
                case OAEP_SHA1_MGF1 -> cippad = "OAEPWithSHA-1AndMGF1Padding";
                case OAEP_SHA256_MGF1 -> cippad = "OAEPWithSHA-256AndMGF1Padding";
            }
            fullname.append(cipname)
                    .append("/")
                    .append(cipmode)
                    .append("/")
                    .append(cippad);
        }
        return fullname.toString();
    }
}
