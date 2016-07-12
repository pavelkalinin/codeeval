package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/82/
 */

public class ArmstrongNumbers {

    private static final String FILE_NAME = TestData.PATH + "armstrongnumbers.txt";
    private static final String YES = "True\n";
    private static final String NO = "False\n";

    public static void main (String[] args) throws IOException {
        File inputFile = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(inputFile));
        String line;
        StringBuilder result = new StringBuilder();
        int number, length, sum;
        while ((line = buffer.readLine()) != null) {
            number = Integer.parseInt(line);
            length = line.length();
            sum = 0;
            for (int i = 0; i < length; i++) {
                sum += Math.pow(Character.digit(line.charAt(i), 10), length);
            }
            result.append(sum == number ? YES : NO);
        }
        System.out.print(result);
        buffer.close();
    }
}
