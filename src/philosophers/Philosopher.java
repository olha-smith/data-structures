package philosophers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Philosopher implements Runnable{
    private static final int TIME_TO_SLEEP = 1000;
    private Fork leftFork;
    private Fork rightFork;

    enum Actions {
        THINKING, EATING, TAKING_LEFT_FORK, TAKING_RIGHT_FORK, PUTTING_LEFT_FORK, PUTTING_RIGHT_FORK
    }

    public Philosopher (Fork leftFork, Fork rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void think() throws InterruptedException {
        doAction(Actions.THINKING, true);
    }
    private boolean takeLeftFork() throws InterruptedException {
        if (leftFork.get()) {
            doAction(Actions.TAKING_LEFT_FORK, false);
            return true;
        }
        return false;
    }
    private boolean takeRightFork() throws InterruptedException {
        if (rightFork.get()) {
            doAction(Actions.TAKING_RIGHT_FORK, false);
            return true;
        }
        return false;
    }
    private void eat() throws InterruptedException {
        doAction(Actions.EATING, true);
    }
    private void putRightFork() throws InterruptedException {
        doAction(Actions.PUTTING_RIGHT_FORK, false);
        rightFork.release();
    }
    private void putLeftFork() throws InterruptedException {
        doAction(Actions.PUTTING_LEFT_FORK, false);
        leftFork.release();
    }

    private void doAction(Actions action, boolean isTimeConsuming) throws InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SSS");

        System.out.println("[" + sdf.format(new Date(System.currentTimeMillis())) + "] "
                + Thread.currentThread().getName() + " " + action);
        if (isTimeConsuming) {
            Thread.sleep(TIME_TO_SLEEP);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                think();
                if (takeLeftFork()) {
                    if (takeRightFork()) {
                        eat();
                        putRightFork();
                    }
                    putLeftFork();
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception thrown!");
            }
        }
    }

}
