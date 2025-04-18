package io.github.devictor8.question1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    private static final String filePath = "src/main/java/io/github/devictor8/question1/trava.txt";
    private static final int N = 2;
    private static final int T = 3;

    private static final HashMap<String, Integer> wordsCount = new HashMap<>();
    private static final ArrayList<String> rows = new ArrayList<>();
    private static final ArrayList<Thread> threads = new ArrayList<>();

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        getRows();
        createThreads();

        for (Thread t : threads) {
            t.start();
        }

        System.out.println("Número de threads: " + threads.size());
        System.out.println("As " + N + " palavras que mais apareceram:");
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordsCount.entrySet());
        sortedWords.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (int i = 0; i < N; i++) {
            System.out.println(sortedWords.get(i).getKey() + " -> " + sortedWords.get(i).getValue() + " vezes");
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Tempo total: " + (endTime - startTime)/1000.0 + " segundos");
    }

    public static void getRows() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                rows.add(line.toLowerCase());
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }


    public static void createThreads() {
        for (int i = 0; i < T; i++) {
            int finalI = i;
            threads.add(new Thread(() -> {
                for(int row = finalI; row < rows.size(); row += T) {
                    String[] words = rows.get(row).split(" ");
                    for (String word : words) {
                        synchronized (wordsCount) {
                            wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1);
                        }
                    }
                }
            }));
        }
    }
}
