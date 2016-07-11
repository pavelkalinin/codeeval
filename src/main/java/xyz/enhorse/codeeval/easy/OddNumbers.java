package xyz.enhorse.codeeval.easy;

/**
 * https://www.codeeval.com/open_challenges/25/
 */

public class OddNumbers {
    private static final int MAX_NUMBER = 99;

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= MAX_NUMBER; i++) {
            if (i % 2 == 1) {
                result.append(i).append('\n');
            }
        }
        System.out.print(result);
    }
}
