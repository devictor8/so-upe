package io.github.devictor8.question2;

public class Main {
    private static final int T = 1000;
    private static final String password = "1.234.567.890";
    public static void main(String[] args) {
        final double range = Math.ceil((double) 9999999999L / T);

        for (int i = 0; i < T; i++) {
            final int index = i;
            new Thread(() -> {
                double init = range * index;
                double end = init + range;

                for (double j = init; j < end; j++) {
                    String test_pass = String.format("%.0f", j);
                    if (test_pass.equals(password)) {
                        System.out.println("senha encontrada: " + test_pass);
                        System.out.println("Thread: " + index);
                        return;
                    }
                }
            }).start();
        }
    }
}
