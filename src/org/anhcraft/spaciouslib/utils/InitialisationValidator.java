package org.anhcraft.spaciouslib.utils;

/**
 * A simple validation checker for initialisation processes
 */
public class InitialisationValidator {
    private boolean initialized;
    private final Object lock = new Object();

    /**
     * Create a new instance of the validator
     */
    public InitialisationValidator(){
        this.initialized = false;
    }

    /**
     * Every time the process is being initialized calls this method to validate.<br>
     * This method can only be called one time. Later, this will throw an exception
     */
    public void validate() throws Exception {
        synchronized(lock) {
            if(initialized) {
                throw new Exception("The destination has already initialized");
            }
            initialized = true;
        }
    }
}
