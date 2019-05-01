package org.anhcraft.spaciouslib.utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;

public enum PublicKeyEncryption {
    RSA;

    private KeyPairGenerator gen;
    private Cipher cipher;

    PublicKeyEncryption(){
        try {
            gen = KeyPairGenerator.getInstance(this.name());
            cipher = Cipher.getInstance(this.name());
        } catch(NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    public KeyPair genKeyPair(int keysize){
        gen.initialize(keysize);
        return gen.genKeyPair();
    }

    public byte[] encode(PublicKey publicKey, byte[] data){
        try {
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            return cipher.doFinal(data);
        } catch(InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] decode(PrivateKey privateKey, byte[] data){
        try {
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            return cipher.doFinal(data);
        } catch(InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }
}
