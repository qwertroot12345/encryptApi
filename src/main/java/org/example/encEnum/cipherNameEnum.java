package org.example.encEnum;

public enum cipherNameEnum {

    //Block
    AES, DES, DESEDE,

    //STEAM
    RC4,

    //ASSY
    RSA, DH, EDDSA, DSA,
    ECDSA, GOST, ECGOST, ELGAMAL, GM,
    DSTU4145;

    public static String toSt(cipherNameEnum cipnameen) {
        String cipname;
        switch (cipnameen) {
            case DES -> cipname = "DES";
            case AES -> cipname = "AES";
            //...........
            default -> cipname = "";
        }
        return cipname;
    }

}
