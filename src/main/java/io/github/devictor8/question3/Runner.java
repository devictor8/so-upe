package io.github.devictor8.question3;

public class Runner extends Thread {
    private Team team;

    public Runner(Team team) {
        this.team =
    }

    @Override
    public void run() {
        for (;;) {
            this.reachPoint = false;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {}
            this.reachPoint = true;
        }
    }
}
