package io.github.devictor8.question3;

public class Runner extends Thread {
    private final Team team;
    private final String name;
    private final int barrierNumber;

    public Runner(Team team, String name, int barrier) {
        this.team = team;
        this.name = name;
        this.barrierNumber = barrier;
    }

    @Override
    public void run() {
        team.reachPoint(this);
        for (int i = 0; i < this.barrierNumber; i++) {
            try {
                Thread.sleep((long) (1000 + Math.random() * 4000));
                team.reachPoint(this);
            } catch (InterruptedException ignored) {}
        }
    }

    public String getRunnerName() {
        return this.name;
    }
}
