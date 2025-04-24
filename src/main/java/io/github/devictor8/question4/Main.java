package io.github.devictor8.question4;

public class Main {
    public static void main(String[] args) {
        Fork fork1 = new Fork();
        Fork fork2 = new Fork();
        Fork fork3 = new Fork();
        Fork fork4 = new Fork();
        Fork fork5 = new Fork();

        new Philosopher("Gabriel, the Thinker", fork1, fork2, 1).start();
        new Philosopher("Hugo Calderano", fork2, fork3, 2).start();
        new Philosopher("Bruna Takahashi", fork3, fork4, 3).start();
        new Philosopher("Max Emilian Verstappen", fork4, fork5, 4).start();
        new Philosopher("Flavio Caça Rato", fork5, fork1, 5).start();
    }
}
