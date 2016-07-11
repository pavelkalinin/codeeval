package xyz.enhorse.codeeval.easy;

/**
 * https://www.codeeval.com/open_challenges/23/
 */

public class MultiplicationTables {
    public static void main (String[] args) {
        printMultiplicationTable(12);
    }

    private static void printMultiplicationTable(int number) {
        String formatting = "%" + (String.valueOf(number * number).length() + 1) + "d";
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number; j++) {
                System.out.printf(formatting, i * j);
            }
            System.out.println();
        }
    }
}