package org.anhcraft.spaciouslib.net.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public abstract class SocketClient extends SocketStream implements SocketController {
    private Socket socket;
    private String host;
    private int port;

    public SocketClient(String host, int port){
        this.host = host;
        this.port = port;
        socket = new Socket();
    }

    public SocketClient(Socket socket){
        this.socket = socket;
    }

    @Override
    public void start() {
        try {
            if(!socket.isConnected()) {
                socket.connect(new InetSocketAddress(host, port));
            }
            assignInput(socket.getInputStream());
            assignOutput(socket.getOutputStream());
            onReady();
            while(!socket.isInputShutdown()){
                onReceived(receiveData());
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void shutdown() {
        try {
            socket.shutdownInput();
            socket.shutdownOutput();
            socket.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public InetAddress getAddress(){
        return socket.getInetAddress();
    }

    @Override
    public void sendData(byte[] data) throws IOException {
        if(socket.isOutputShutdown()){
            return;
        }
        super.sendData(data);
    }
}
