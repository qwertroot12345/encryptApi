package org.example.utils;

import org.example.cipherBean;
import org.example.encEnum.cipherSettingEnum;

public class cipherFullmodenameBuilder {

    private String cipname, cipmode, cippad;

    private StringBuilder fullname;

    private cipherSettingEnum.cipherNameEnum e_cipname;
    private cipherSettingEnum.cipherWorkmode e_cipmode;
    private cipherSettingEnum.padType e_cippad;

    public cipherFullmodenameBuilder(cipherBean config) {
        e_cipmode = config.getWorkmode();
        e_cipname = config.getCipher();
        e_cippad = config.getPadType();
    }

    public cipherFullmodenameBuilder() {
    }

    public cipherFullmodenameBuilder setE_cipname(cipherSettingEnum.cipherNameEnum e_cipname) {
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
            if (e_cipname == null) {
                System.out.println("加密器名称为空");
            }
            if (e_cippad == null) {
                System.out.println("加密器填充为空");
            }
            if (e_cipmode == null) {
                System.out.println("加密器工作模式为空");
            }
        } else {
            fullname = new StringBuilder();
            cipname = cipherSettingEnum.cipherNameEnum.toSt(e_cipname);
            cipmode = cipherSettingEnum.cipherWorkmode.toSt(e_cipmode);
            cippad = cipherSettingEnum.padType.toSt(e_cippad);
            fullname.append(cipname)
                    .append("/")
                    .append(cipmode)
                    .append("/")
                    .append(cippad);
        }
        return fullname.toString();
    }
}
