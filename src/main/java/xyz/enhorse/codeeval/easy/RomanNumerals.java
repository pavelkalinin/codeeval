package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/106/
 */

public class RomanNumerals {
    private static final String FILE_NAME = TestData.path + "romannumerals.txt";
    private static final int BUFFER_SIZE = 1024;
    private static final String[] ROMAN = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] ARABIC = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public static void main(String[] args) throws IOException {
        File inputFile = new File(args.length > 0 ? args[0] : FILE_NAME);
        FileInputStream buffer = new FileInputStream(inputFile);
        byte[] input = new byte[BUFFER_SIZE];
        int inputLength;

        StringBuilder result = new StringBuilder();
        StringBuilder current = new StringBuilder();
        int number;

        while ((inputLength = buffer.read(input)) != -1) {
            if (inputLength < BUFFER_SIZE && input[inputLength - 1] != '\n') {
                input[inputLength++] = '\n';
            }
            for (int i = 0; i < inputLength; i++) {
                switch (input[i]) {
                    case '\r': {
                        continue;
                    }
                    case '\n': {
                        number = Integer.parseInt(current.toString());
                        current.setLength(0);
                        convertToRoman(number, current);
                        result.append(current).append('\n');
                        current.setLength(0);
                        break;
                    }
                    default: {
                        current.append((char) input[i]);
                    }
                }
            }
        }
        System.out.print(result);
        buffer.close();
    }

    private static void convertToRoman(int number, StringBuilder result) {
        int i = 0;
        while (number > 0) {
            while (ARABIC[i] <= number) {
                result.append(ROMAN[i]);
                number -= ARABIC[i];
            }
            i++;
        }
    }
}
