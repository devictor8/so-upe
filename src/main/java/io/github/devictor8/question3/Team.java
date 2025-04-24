package io.github.devictor8.question3;

public class Team {
    private int membersInPoint;
    private final String name;
    private boolean teamReady = false;
    private int barriersReached = 0;

    public Team(String name) {
        this.name = name;
        this.membersInPoint = 0;
    }

    public synchronized void reachPoint(Runner runner) {
        System.out.println(this.name + ": " + runner.getRunnerName() + " chegou ao ponto");
        membersInPoint++;
        try {
            if (membersInPoint == 3) {
                if (!this.teamReady) {
                    this.teamReady = true;
                    System.out.println(this.name + ": todos os integrantes chegaram na lagarda. INICIANDO!");
                } else {
                    this.barriersReached++;
                    if (this.barriersReached == 4) {
                        System.out.println(this.name + ": terminou a corrida!");
                    } else {
                        System.out.println(this.name + ": Todos chegaram! Indo ao proximo ponto.");
                    }
                }
                this.membersInPoint = 0;
                this.notifyAll();
                return;
            }

            this.wait();
        } catch (InterruptedException ignored) {}
    }
}
