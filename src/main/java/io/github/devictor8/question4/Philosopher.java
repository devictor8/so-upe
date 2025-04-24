package io.github.devictor8.question4;

public class Philosopher extends Thread {
    private final String name;
    private final Fork rightFork;
    private final Fork leftFork;

    public Philosopher(String name, Fork rightFork, Fork leftFork) {
        this.name = name;
        this.rightFork = rightFork;
        this.leftFork = leftFork;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Filósofo " + name + " está pensando.");
                Thread.sleep((long) (1000 + Math.random() * 2000));
                synchronized (rightFork) {
                    synchronized (leftFork) {
                        System.out.println("Filósofo " + name + " está comendo!");
                        Thread.sleep((long) (1000 + Math.random() * 2000));
                    }
                }
            } catch (InterruptedException ignored) {}
        }
    }
}