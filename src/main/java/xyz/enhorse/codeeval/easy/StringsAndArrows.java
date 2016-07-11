package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * https://www.codeeval.com/open_challenges/203/
 */
public class StringsAndArrows {
    private static final String FILE_NAME =  TestData.path + "stringsandarrows.txt";

    private static final char[] LEFT_ARROW = new char[] {'>', '>', '-', '-', '>'};
    private static final char[] RIGHT_ARROW = new char[] {'<', '-', '-', '<', '<'};

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        char[] sample = new char[LEFT_ARROW.length];
        while ((line = buffer.readLine()) != null) {
            int counter = 0;
            char[] input = line.toCharArray();
            for (int i = 0; i < input.length - 4; i++) {
                if (input[i] != '-') {
                    System.arraycopy(input, i, sample, 0, LEFT_ARROW.length);
                    if (Arrays.equals(sample, LEFT_ARROW) || Arrays.equals(sample, RIGHT_ARROW)) {
                        counter++;
                    }
                }
            }
            result.append(counter).append('\n');
        }
        System.out.print(result);
        buffer.close();
    }
}
