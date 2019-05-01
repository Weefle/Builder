package org.anhcraft.spaciouslib.net.socket;

import org.anhcraft.spaciouslib.builders.ArrayBuilder;

import java.io.*;

public abstract class SocketStream {
    private BufferedInputStream input;
    private BufferedOutputStream output;
    private SocketStreamMode mode = SocketStreamMode.FIXED_LENGTH;

    void assignInput(InputStream input){
        if(this.input != null){
            return;
        }
        this.input = new BufferedInputStream(input);
    }

    void assignOutput(OutputStream output){
        if(this.output != null){
            return;
        }
        this.output = new BufferedOutputStream(output);
    }

    byte[] receiveData() throws IOException {
        ArrayBuilder builder = new ArrayBuilder(byte.class);
        int b;
        switch(mode){
            case FULLY:
                while((b = input.read()) != -1){
                    builder.append((byte) b);
                }
                break;
            case NOT_NULL:
                while((b = input.read()) > 0){
                    builder.append((byte) b);
                }
                break;
            case AVAILABLE:
                do{
                    builder.append((byte) input.read());
                } while(input.available() > 0);
                break;
            case PER_LINE:
                while((b = input.read()) != -1 && b != '\n'){
                    builder.append((byte) b);
                }
                break;
            case FIXED_LENGTH:
                int length = input.read();
                for(int i = 0; i < length && (b = input.read()) != -1; i++){
                    builder.append((byte) b);
                }
                break;
        }
        return (byte[]) builder.build();
    }

    public void sendData(byte[] data) throws IOException {
        switch(mode){
            case FULLY:
            case AVAILABLE:
            case NOT_NULL:
                output.write(data);
                break;
            case PER_LINE:
                output.write(data);
                if(data[data.length-1] != '\n'){
                    output.write('\n');
                }
                break;
            case FIXED_LENGTH:
                output.write(data.length);
                output.write(data);
                break;
        }
        output.flush();
    }

    public void onReceived(byte[] data){
    }

    public SocketStreamMode getMode() {
        return mode;
    }

    public void setMode(SocketStreamMode mode) {
        this.mode = mode;
    }
}
