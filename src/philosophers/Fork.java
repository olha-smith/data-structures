package philosophers;

import java.util.concurrent.Semaphore;

public class Fork {
    Semaphore inUse = new Semaphore(1);

    public boolean get() throws InterruptedException {
        return inUse.tryAcquire();
    }

    public boolean isAvailable() {
        return inUse.availablePermits() != 0;
    }

    public void release() {
        inUse.release();
    }
}
