package org.anhcraft.spaciouslib.net.socket;

/**
 * Kinds of reading and writing mode for socket
 */
public enum SocketStreamMode {
    /**
     * The output reads until the input is closed.
     */
    FULLY,
    /**
     * The output reads until it receives a null character.
     */
    NOT_NULL,
    /**
     * The output reads until the input is blocked or unavailable.
     */
    AVAILABLE,
    /**
     * The input sends an array of bytes which is ending with a newline character.<br>
     * If the character is missing, it will be appended to the end of the array automatically.<br>
     * This kind is recommended for interacting with texts.
     */
    PER_LINE,
    /**
     * The input sends an array of bytes and also a bit more information about the size of that data.<br>
     * This kind is recommended for interacting with raw bytes such as sending files or packets.
     */
    FIXED_LENGTH
}
