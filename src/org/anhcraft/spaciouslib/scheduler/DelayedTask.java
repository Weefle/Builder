package org.anhcraft.spaciouslib.scheduler;

public class DelayedTask extends TaskScheduler {
    private long delay;

    /**
     * Creates a delayed scheduler
     * @param runnable the runnable for executing
     * @param delay the delay time (in milliseconds)
     */
    public DelayedTask(Runnable runnable, long delay) {
        super(runnable);
        this.delay = delay;
    }

    @Override
    public void run() {
        this.thread = new Thread(() -> {
            try {
                Thread.sleep(delay);
                if(!stopped){
                    runnable.run();
                    stopped = true;
                }
                thread.interrupt();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });
        this.thread.start();
    }
}
