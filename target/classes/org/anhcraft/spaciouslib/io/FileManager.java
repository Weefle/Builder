package org.anhcraft.spaciouslib.io;

import org.anhcraft.spaciouslib.utils.ExceptionThrower;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * A class helps you to manage files
 */
public class FileManager {
    private File file;

    /**
     * Creates a new FileManager instance
     * @param file a file
     */
    public FileManager(File file){
        ExceptionThrower.ifNull(file, new Exception("File must not null"));
        this.file = file;
        if(this.file.exists() && !this.file.isFile()){
            try {
                throw new Exception("The file object doesn't represents for a file");
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Creates a new FileManager instance
     * @param path the path of a file
     */
    public FileManager(String path){
        ExceptionThrower.ifNull(path, new Exception("File path must not null"));
        this.file = new File(path);
        if(this.file.exists() && !this.file.isFile()){
            try {
                throw new Exception("The file object doesn't represents for a file");
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Creates this file if it doesn't exist
     * @return this object
     */
    public FileManager create(){
        if(!this.file.exists()){
            try {
                this.file.createNewFile();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    /**
     * Deletes this file if it exists
     * @return this object
     */
    public FileManager delete(){
        if(this.file.exists()) {
            this.file.delete();
        }
        return this;
    }

    /**
     * Initializes this file, creates and writes if it doesn't exist.
     * @param content an array of bytes (binary content)
     * @return this object
     */
    public FileManager initFile(byte[] content)
            throws IOException{
        if (!this.file.exists()) {
            return create().write(content);
        }
        return this;
    }

    /**
     * Writes the given content to this file
     * @param content an array of bytes (binary content)
     * @param append if true the content will be appended at the end of the file
     * @return this object
     */
    public FileManager write(byte[] content, boolean append) throws IOException {
        if(this.file.exists()) {
            FileOutputStream stream = new FileOutputStream(this.file, append);
            stream.write(content);
            stream.flush();
            stream.close();
        }
        return this;
    }

    /**
     * Overwrites this file with the given content
     * @param content an array of bytes (binary content)
     * @return this object
     */
    public FileManager write(byte[] content) throws IOException {
        return write(content, false);
    }

    /**
     * Writes the given content to this file
     * @param content a string
     * @param append if true the content will be appended at the end of the file
     * @return this object
     */
    public FileManager write(String content, boolean append) throws IOException {
        return write(content.getBytes(StandardCharsets.UTF_8), append);
    }

    /**
     * Overwrites this file with the given content
     * @param content a string
     * @return this object
     */
    public FileManager write(String content) throws IOException {
        return write(content, false);
    }

    /**
     * Reads this file
     * @return the content as an array of bytes
     */
    public byte[] read() throws IOException {
        byte[] content = new byte[(int) this.file.length()];
        FileInputStream stream = new FileInputStream(this.file);
        stream.read(content);
        stream.close();
        return content;
    }

    /**
     * Reads this file
     * @return the content as a string
     */
    public String readAsString() throws IOException {
        return new String(read());
    }

    /**
     * Copies the data of this file into another file or copy this file to another directory
     * @param output another file or directory
     */
    public void copy(File output) throws IOException {
        if(output.isDirectory()) {
            new DirectoryManager(output).mkdirs();
            new FileManager(new File(output, file.getName())).create().write(read());
        } else {
            new FileManager(output).create().write(read());
        }
    }

    /**
     * Copies the data of this file into another file or copy this file to another directory
     * @param output another file or directory
     * @param override override the existing file or not
     */
    public void copy(File output, boolean override) throws IOException {
        if(output.isDirectory()) {
            new DirectoryManager(output).mkdirs();
            File f = new File(output, file.getName());
            if(!f.exists() || override) {
                new FileManager(f).create().write(read());
            }
        } else {
            if(!output.exists() || override) {
                new FileManager(output).create().write(read());
            }
        }
    }
}
