package org.anhcraft.spaciouslib.builders;

import org.anhcraft.spaciouslib.utils.IOUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HTTPConnectionBuilder {
    private URL url;
    private String method = "GET";
    private HashMap<String, String> properties = new HashMap<>();
    private BufferedInputStream input;
    private BufferedOutputStream output;
    private boolean doOutput = false;

    /**
     * Create a new instance of HTTPConnectionBuilder
     * @param url the url
     */
    public HTTPConnectionBuilder(String url) {
        try {
            this.url = new URL(url);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create a new instance of HTTPConnectionBuilder
     * @param url the url object
     */
    public HTTPConnectionBuilder(URL url) {
        this.url = url;
    }

    /**
     * Set the method of connection
     * @param method method (e.g: get, post, etc)
     * @return this object
     */
    public HTTPConnectionBuilder setMethod(String method){
        this.method = method;
        return this;
    }

    /**
     * Overrides the given property
     * @param name property name
     * @param value property value
     * @return this object
     */
    public HTTPConnectionBuilder setProperty(String name, String value){
        properties.put(name, value);
        return this;
    }

    /**
     * Enables the output
     * @return this object
     */
    public HTTPConnectionBuilder doOutput(){
        this.doOutput = true;
        return this;
    }

    /**
     * Build and connect to the url
     * @return this object
     */
    public HTTPConnectionBuilder build(){
        try {
            HttpURLConnection url = (HttpURLConnection) this.url.openConnection();
            url.setRequestMethod(method);
            for(Map.Entry<String, String> entry : properties.entrySet()) {
                url.setRequestProperty(entry.getKey(), entry.getValue());
            }
            if(doOutput) {
                url.setDoOutput(true);
                output = new BufferedOutputStream(url.getOutputStream());
            }
            input = new BufferedInputStream(url.getInputStream());
        } catch(IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * Write the given data into the output.<br>
     * This method only works after use the method {@link HTTPConnectionBuilder#build()}
     * @param data data
     * @return this object
     */
    public HTTPConnectionBuilder writeOutput(byte data){
        if(output != null) {
            try {
                this.output.write(data);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    /**
     * Write the given data into the output.<br>
     * This method only works after use the method {@link HTTPConnectionBuilder#build()}
     * @param data data
     * @return this object
     */
    public HTTPConnectionBuilder writeOutput(byte[] data){
        if(output != null) {
            try {
                for(byte b : data) {
                    this.output.write(b);
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    /**
     * Read the input and returns as an array of bytes
     * @return data
     */
    public byte[] readInput(){
        return IOUtils.toByteArray(input);
    }

    /**
     * Get the input stream
     * @return input stream
     */
    public BufferedInputStream getInput(){
        return input;
    }
}
