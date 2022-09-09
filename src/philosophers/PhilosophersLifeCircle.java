package philosophers;

public class PhilosophersLifeCircle {
    static final int PHILOSOPHERS_AMOUNT = 5;
    static final String[] PHILOSOPHERS_NAME = {"Socrates", "Diogenes", "Plato", "Aristotle", "Pythagoras"};

    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[PHILOSOPHERS_AMOUNT];
        Fork[] forks = new Fork[PHILOSOPHERS_AMOUNT];
        Thread[] threads = new Thread[PHILOSOPHERS_AMOUNT];

        for (int i = 0; i < PHILOSOPHERS_AMOUNT; i++) {
            forks[i] = new Fork();
        }

        for (int i = 0; i < PHILOSOPHERS_AMOUNT; i++) {
            if (i == PHILOSOPHERS_AMOUNT - 1) {
                philosophers[i] = new Philosopher(forks[i], forks[0]);
                break;
            }
            philosophers[i] = new Philosopher(forks[i], forks[i + 1]);
        }

        for (int i = 0; i < PHILOSOPHERS_AMOUNT; i++) {
            threads[i] = new Thread(philosophers[i], PHILOSOPHERS_NAME[i]);
            threads[i].start();
        }
    }
}
