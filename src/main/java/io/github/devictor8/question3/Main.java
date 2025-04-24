package io.github.devictor8.question3;

public class Main {
    public static void main(String[] args) {
        int barrierNumber = 4;

        Team teamA = new Team("time A");
        Team teamB = new Team("Time B");

        new Runner(teamA, "Vitu", barrierNumber).start();
        new Runner(teamA, "Keisy", barrierNumber).start();
        new Runner(teamA, "Camila", barrierNumber).start();
        new Runner(teamB, "Vó de Everton", barrierNumber).start();
        new Runner(teamB, "K´io", barrierNumber).start();
        new Runner(teamB, "João Grandão", barrierNumber).start();
    }
}
