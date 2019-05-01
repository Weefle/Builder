package net.jrbudda.builder;

import org.bukkit.Bukkit;

public enum GameVersion {
    v1_8_R1(0),
    v1_8_R2(1),
    v1_8_R3(2),
    v1_9_R1(3),
    v1_9_R2(4),
    v1_10_R1(5),
    v1_11_R1(6),
    v1_12_R1(7),
    v1_13_R1(8),
    v1_13_R2(9);

    private static final GameVersion version = GameVersion.valueOf(Bukkit.getServer().getClass().getPackage()
            .getName().replace(".",  ",").split(",")[3]);

    private int id;

    GameVersion(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    /**
     * Gets current Minecraft version of this server
     */
    public static GameVersion getVersion(){
        return version;
    }

    public static boolean is1_8Above(){
        return GameVersion.v1_8_R1.getId() <= getVersion().getId();
    }

    public static boolean is1_9Above(){
        return GameVersion.v1_9_R1.getId() <= getVersion().getId();
    }

    public static boolean is1_10Above(){
        return GameVersion.v1_10_R1.getId() <= getVersion().getId();
    }

    public static boolean is1_11Above(){
        return GameVersion.v1_11_R1.getId() <= getVersion().getId();
    }

    public static boolean is1_12Above(){
        return GameVersion.v1_12_R1.getId() <= getVersion().getId();
    }

    public static boolean is1_13Above(){
        return GameVersion.v1_13_R1.getId() <= getVersion().getId();
    }
}