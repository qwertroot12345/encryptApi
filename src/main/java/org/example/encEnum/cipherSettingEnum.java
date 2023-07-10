package org.example.encEnum;

public enum cipherSettingEnum {

    ;

    public enum padType {
        ZEROBYTE, PCKS7, PCKS5, NONE, TBC,
        OAEP_SHA1_MGF1, OAEP_SHA256_MGF1;

        public static String toSt(padType pad) {
            String cippad;
            switch (pad) {
                case PCKS5 -> cippad = "PKCS5Padding";
                case TBC -> cippad = "TBCPadding";
                case NONE -> cippad = "NoPadding";
                case PCKS7 -> cippad = "PKCS7Padding";
                case ZEROBYTE -> cippad = "ZeroBytePadding";
                case OAEP_SHA1_MGF1 -> cippad = "OAEPWithSHA-1AndMGF1Padding";
                case OAEP_SHA256_MGF1 -> cippad = "OAEPWithSHA-256AndMGF1Padding";
                default -> cippad = "";
            }
            return cippad;
        }
    }

    public enum cipherType {
        BLOCK_ENCRYPT, STREAM_ENCRYPT, ASSM_ENCRYPT
    }

    public enum cipherWorkmode {
        ECB, CBC, GCM, OFB,
        //GCM 是流加密，所以对应的填充模式为 NoPadding
        CFB, SIC, CTR, CCM;

        public static String toSt(cipherWorkmode workmode) {
            String wm;
            switch (workmode) {
                case ECB -> wm = "ECB";
                case SIC -> wm = "SIC";
                case OFB -> wm = "OFB";
                case GCM -> wm = "GCM";
                case CTR -> wm = "CTR";
                case CFB -> wm = "CFB";
                case CBC -> wm = "CBC";
                case CCM -> wm = "CCM";
                default -> wm = "";
            }
            return wm;
        }
    }

    public enum cipherBit {
        BITS_56,
        BITS_128, BITS_192, BITS_256,
        BITS_448, BITS_512, BITS_768,
        BITS_1024, BITS_2048, BITS_3072,
        BITS_4096, BITS_8192;

        public static int toInt(cipherBit bit) {
            int encbit;
            switch (bit) {
                case BITS_56 -> encbit = 56;
                case BITS_128 -> encbit = 128;
                case BITS_192 -> encbit = 192;
                case BITS_256 -> encbit = 256;
                case BITS_448 -> encbit = 448;
                case BITS_512 -> encbit = 512;
                case BITS_768 -> encbit = 768;
                case BITS_1024 -> encbit = 1024;
                case BITS_2048 -> encbit = 2048;
                case BITS_3072 -> encbit = 3072;
                case BITS_4096 -> encbit = 4096;
                case BITS_8192 -> encbit = 8192;
                default -> encbit = 0;
            }
            return encbit;
        }
    }


}
