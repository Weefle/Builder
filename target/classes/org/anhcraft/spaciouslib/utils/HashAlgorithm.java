package org.anhcraft.spaciouslib.utils;

public enum HashAlgorithm {
    MD2("MD2"),
    MD5("MD5"),
    SHA_1("SHA-1"),
    SHA_256("SHA-256"),
    SHA_384("SHA-384"),
    SHA_512("SHA-512");

    private String id;

    HashAlgorithm(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
