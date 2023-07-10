package org.example;

import lombok.Data;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

@Data
public class assKeyPair<Pub extends PublicKey, Pri extends PrivateKey> {

    private KeyPair kp;
    private PublicKey pub;
    private PrivateKey pri;
}
