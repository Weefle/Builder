package org.anhcraft.spaciouslib.scheduler;

public class TimerTask extends TaskScheduler {
    private long period;
    private long delay;
    private long duration;
    private long endTime;
    private long current;

    /**
     * Creates a timer scheduler
     * @param runnable the runnable for executing
     * @param delay the delay time (in milliseconds)
     * @param period the period time (in milliseconds)
     */
    public TimerTask(Runnable runnable, long delay, long period) {
        super(runnable);
        this.period = period;
        this.delay = delay;
        this.duration = -1;
        this.current = 0;
    }

    /**
     * Creates a timer scheduler
     * @param runnable the runnable for executing
     * @param delay the delay time (in seconds) before the first execution time
     * @param period the period time (in seconds) between execution times
     * @param duration the living-duration of this task (in seconds)
     */
    public TimerTask(Runnable runnable, long delay, long period, long duration) {
        super(runnable);
        this.period = period;
        this.delay = delay;
        this.duration = duration < 0 ? 0 : duration;
        this.current = 0;
    }

    @Override
    public void run() {
        endTime = System.currentTimeMillis() + duration;
        this.thread = new Thread(() -> {
            try {
                Thread.sleep(delay);
                while(true) {
                    if(stopped || (duration != -1 && endTime <= System.currentTimeMillis())){
                        thread.interrupt();
                        break;
                    }
                    current++;
                    runnable.run();
                    Thread.sleep(period);
                }
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });
        this.thread.start();
    }

    public long getCurrent() {
        return current;
    }
}
