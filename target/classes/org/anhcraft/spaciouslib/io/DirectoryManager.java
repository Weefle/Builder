package org.anhcraft.spaciouslib.io;

import org.anhcraft.spaciouslib.utils.ExceptionThrower;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

/**
 * A class helps you to manage directories
 */
public class DirectoryManager {
    private File directory;

    /**
     * Creates a new DirectoryManager instance
     * @param directory a directory
     */
    public DirectoryManager(File directory){
        ExceptionThrower.ifNull(directory, new Exception("Directory must not null"));
        this.directory = directory;
        if(this.directory.exists() && !this.directory.isDirectory()){
            try {
                throw new Exception("The file object doesn't represents for a directory");
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Creates a new DirectoryManager instance
     * @param path the path of a directory
     */
    public DirectoryManager(String path){
        ExceptionThrower.ifNull(path, new Exception("Directory path must not null"));
        this.directory = new File(path);
        if(this.directory.exists() && !this.directory.isDirectory()){
            try {
                throw new Exception("The file object doesn't represents for a directory");
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Creates this directory if it doesn't exist
     * @return this object
     */
    public DirectoryManager mkdir(){
        if(!this.directory.exists()){
            this.directory.mkdir();
        }
        return this;
    }

    /**
     * Creates this directory and its parent directories if them don't exist
     * @return this object
     */
    public DirectoryManager mkdirs(){
        if(!this.directory.exists()){
            this.directory.mkdirs();
        }
        return this;
    }

    /**
     * Deletes this directory and its child directories if it exists.<br>
     * That will also affect all files of them
     * @return this object
     */
    public DirectoryManager delete(){
        if(this.directory.exists()){
            this.directory.delete();
        }
        return this;
    }

    /**
     * Copies this directory and its child directories into another directory.<br>
     * @param output an output directory
     * @return this object
     */
    public DirectoryManager copy(File output) throws IOException {
        ExceptionThrower.ifTrue(output.exists() && !output.isDirectory(), new Exception("The output file object doesn't represents for a directory"));
        new DirectoryManager(output).mkdir();
        handleCopy(this.directory, output, pathname -> true, true);
        return this;
    }

    /**
     * Copies this directory and its child directories into another directory.<br>
     * @param output an output directory
     * @param filter a file filter
     * @return this object
     */
    public DirectoryManager copy(File output, FileFilter filter) throws IOException {
        ExceptionThrower.ifTrue(output.exists() && !output.isDirectory(), new Exception("The output file object doesn't represents for a directory"));
        new DirectoryManager(output).mkdir();
        handleCopy(this.directory, output, filter, true);
        return this;
    }

    /**
     * Copies this directory and its child directories into another directory.<br>
     * @param output an output directory
     * @param override override existing files or not
     * @return this object
     */
    public DirectoryManager copy(File output, boolean override) throws IOException {
        ExceptionThrower.ifTrue(output.exists() && !output.isDirectory(), new Exception("The output file object doesn't represents for a directory"));
        new DirectoryManager(output).mkdir();
        handleCopy(this.directory, output, pathname -> true, override);
        return this;
    }

    /**
     * Copies this directory and its child directories into another directory.<br>
     * @param output an output directory
     * @param filter a file filter
     * @param override override existing files or not
     * @return this object
     */
    public DirectoryManager copy(File output, FileFilter filter, boolean override) throws IOException {
        ExceptionThrower.ifTrue(output.exists() && !output.isDirectory(), new Exception("The output file object doesn't represents for a directory"));
        new DirectoryManager(output).mkdir();
        handleCopy(this.directory, output, filter, override);
        return this;
    }

    private static void handleCopy(File directory, File output, FileFilter filter, boolean override) throws IOException {
        for(File f : directory.listFiles(filter)){
            File out = new File(output, f.getName());
            if(f.isFile()){
                new FileManager(f).copy(out, override);
            }
            else if(f.isDirectory()){
                new DirectoryManager(out).mkdir();
                handleCopy(f, out, filter, override);
            }
        }
    }

    /**
     * Clean all files and directories inside this directory
     * @return this object
     */
    public DirectoryManager clean(){
        for(File file : this.directory.listFiles()){
            file.delete();
        }
        return this;
    }
}
