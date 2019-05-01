package org.anhcraft.spaciouslib.net.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SocketServer implements SocketController {
    private ServerSocket socket;
    private String host;
    private int port;
    private final ExecutorService pool = Executors.newCachedThreadPool();
    private final Map<SocketClient, Future<?>> clients = Collections.synchronizedMap(new HashMap<>());

    public SocketServer(String host, int port){
        this.host = host;
        this.port = port;
        try {
            socket = new ServerSocket();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start() {
        try {
            socket.bind(new InetSocketAddress(host, port));
            onReady();
            while(!socket.isClosed()) {
                synchronized(clients) {
                    try {
                        SocketClient client = new SocketClient(socket.accept()) {
                            @Override
                            public void onReceived(byte[] data) {
                                SocketServer.this.onReceived(this, data);
                            }

                            @Override
                            public void shutdown() {
                                super.shutdown();
                                synchronized(clients) {
                                    clients.get(this).cancel(true);
                                    clients.remove(this);
                                }
                            }

                            @Override
                            public void onReady() {
                                onConnected(this);
                            }
                        };
                        clients.put(client, pool.submit(client::start));
                    } catch(IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void shutdown() {
        pool.shutdownNow();
        synchronized(clients) {
            clients.keySet().forEach(SocketClient::shutdown);
        }
        try {
            socket.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public InetAddress getAddress(){
        return socket.getInetAddress();
    }

    public void onConnected(SocketClient client){
    }

    public void onReceived(SocketClient client, byte[] data){
    }

    public List<SocketClient> getClients(){
        return new ArrayList<>(clients.keySet());
    }
}
