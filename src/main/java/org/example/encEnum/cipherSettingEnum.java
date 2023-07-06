package org.example.encEnum;

public enum cipherSettingEnum {

    ;

    String listAll = """
                        
                        
            """;

    public enum padType {
        ZEROBYTE, PCKS7, PCKS5, NONE, TBC,
        OAEP_SHA1_MGF1, OAEP_SHA256_MGF1
    }

    public enum cipherType {
        BLOCK_ENCRYPT, STREAM_ENCRYPT, ASSM_ENCRYPT
    }

    public enum cipherWorkmode {
        ECB, CBC, GCM, OFB,
        //GCM 是流加密，所以对应的填充模式为 NoPadding
        CFB, SIC, CTR, CCM
    }

    public enum cipherBit {
        BITS_56,
        BITS_128, BITS_192, BITS_256,
        BITS_448, BITS_512, BITS_768,
        BITS_1024, BITS_2048, BITS_3072,
        BITS_4096, BITS_8192
    }

}
