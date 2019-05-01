package org.anhcraft.spaciouslib.net.socket;

import java.net.InetAddress;

public interface SocketController {
    InetAddress getAddress();
    default void start(){
    }
    default void shutdown(){
    }
    default void onReady(){
    }
}
