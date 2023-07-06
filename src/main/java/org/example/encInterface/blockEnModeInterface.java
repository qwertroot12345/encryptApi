package org.example.encInterface;

import org.example.utils.cipherFullmodenameBuilder;

public interface blockEnModeInterface extends enModeInterface{
    interface ECB_Mode{
        cipherFullmodenameBuilder get_PCKS5();
        cipherFullmodenameBuilder get_PCKS7();
        cipherFullmodenameBuilder get_NONE();
        cipherFullmodenameBuilder get_ZEROBYTE();
        cipherFullmodenameBuilder getTBC();
    }
    interface CBC_Mode{
        cipherFullmodenameBuilder get_PCKS5();
        cipherFullmodenameBuilder get_PCKS7();
        cipherFullmodenameBuilder get_NONE();
        cipherFullmodenameBuilder get_ZEROBYTE();
        cipherFullmodenameBuilder getTBC();
    }
    interface GCM_Mode{
        cipherFullmodenameBuilder get_PCKS5();
        cipherFullmodenameBuilder get_PCKS7();
        cipherFullmodenameBuilder get_NONE();
        cipherFullmodenameBuilder get_ZEROBYTE();
        cipherFullmodenameBuilder getTBC();
    }
    interface OFB_Mode{
        cipherFullmodenameBuilder get_PCKS5();
        cipherFullmodenameBuilder get_PCKS7();
        cipherFullmodenameBuilder get_NONE();
        cipherFullmodenameBuilder get_ZEROBYTE();
        cipherFullmodenameBuilder getTBC();
    }
    interface CFB_Mode{
        cipherFullmodenameBuilder get_PCKS5();
        cipherFullmodenameBuilder get_PCKS7();
        cipherFullmodenameBuilder get_NONE();
        cipherFullmodenameBuilder get_ZEROBYTE();
        cipherFullmodenameBuilder getTBC();
    }
    interface SIC_Mode{
        cipherFullmodenameBuilder get_PCKS5();
        cipherFullmodenameBuilder get_PCKS7();
        cipherFullmodenameBuilder get_NONE();
        cipherFullmodenameBuilder get_ZEROBYTE();
        cipherFullmodenameBuilder getTBC();
    }
    interface CTR_Mode{
        cipherFullmodenameBuilder get_PCKS5();
        cipherFullmodenameBuilder get_PCKS7();
        cipherFullmodenameBuilder get_NONE();
        cipherFullmodenameBuilder get_ZEROBYTE();
        cipherFullmodenameBuilder getTBC();
    }
    interface CCB_Mode{
        cipherFullmodenameBuilder get_PCKS5();
        cipherFullmodenameBuilder get_PCKS7();
        cipherFullmodenameBuilder get_NONE();
        cipherFullmodenameBuilder get_ZEROBYTE();
        cipherFullmodenameBuilder getTBC();
    }
}
