package org.example.cipherFactory.blockCipher;

import org.example.cipherBean;
import org.example.encEnum.cipherSettingEnum;

public class AEScipherFactory extends abstructBlockCipherFactory {
    public AEScipherFactory(cipherBean config) throws Exception {
        super(config);
    }


    @Override
    public void init(cipherBean config) throws Exception {
        super.init(config);
    }

    @Override
    protected boolean checkis_cipvalid(cipherSettingEnum.cipherWorkmode workmode,
                                       cipherSettingEnum.padType pad) {
        return workmode != cipherSettingEnum.cipherWorkmode.GCM
                || pad == cipherSettingEnum.padType.NONE;
    }


}
