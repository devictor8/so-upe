package io.github.devictor8.question2;


public class Main {
    private static final int T = 20;
    private static final String password = "1020217890";
    static volatile boolean found = false;
    public static void main(String[] args) {
        final long range = (long) Math.pow(10, 10) / T;

        for (int i = 0; i < T; i++) {
            final int index = i;
            new Thread(() -> {
                long init = range * index;
                long end = init + range;

                for (long j = init; j < end; j++) {
                    if (found) return;

                    String test_pass = String.format("%010d", j);
                    if (test_pass.equals(password)) {
                        System.out.println("senha encontrada: " + test_pass);
                        System.out.println("Thread: " + index);
                        found = true;
                        return;
                    }
                }
            }).start();
        }
    }
}
