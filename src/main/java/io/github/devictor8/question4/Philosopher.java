package io.github.devictor8.question4;

public class Philosopher extends Thread {
    private final String name;
    private final Fork rightFork;
    private final Fork leftFork;
    private final int id;

    public Philosopher(String name, Fork rightFork, Fork leftFork, int id) {
        this.name = name;
        this.rightFork = rightFork;
        this.leftFork = leftFork;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Filósofo " + name + " está pensando.");
                Thread.sleep((long) (1000 + Math.random() * 2000));
                synchronized (this.id % 2 == 0 ? rightFork : leftFork) {
                    synchronized (this.id % 2 == 0 ? leftFork : rightFork) {
                        System.out.println("Filósofo " + name + " está comendo!");
                        Thread.sleep((long) (1000 + Math.random() * 2000));
                    }
                }
            } catch (InterruptedException ignored) {}
        }
    }
}