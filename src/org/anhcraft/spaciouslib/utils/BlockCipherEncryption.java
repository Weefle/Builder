package org.anhcraft.spaciouslib.utils;

import javax.crypto.*;
import java.security.*;

public enum BlockCipherEncryption {
    AES,
    DES;

    private KeyGenerator gen;
    private Cipher cipher;

    BlockCipherEncryption(){
        try {
            gen = KeyGenerator.getInstance(this.name());
            cipher = Cipher.getInstance(this.name());
        } catch(NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    public SecretKey genKey(int keysize){
        gen.init(keysize);
        return gen.generateKey();
    }

    public byte[] encode(SecretKey secretKey, byte[] data){
        try {
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(data);
        } catch(InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] decode(SecretKey secretKey, byte[] data){
        try {
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return cipher.doFinal(data);
        } catch(InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }
}

