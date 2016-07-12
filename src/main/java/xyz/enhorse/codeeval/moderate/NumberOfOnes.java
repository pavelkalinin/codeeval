package xyz.enhorse.codeeval.moderate;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/16/
 */
public class NumberOfOnes {

    private static final String FILE_NAME = TestData.PATH + "NumberOfOnes.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        int n, counter;
        while ((line = buffer.readLine()) != null) {
            n = Integer.parseInt(line);
            counter = 0;
            do {
                counter += (n & 1);
                n /= 2;
            } while (n != 0);
            result.append(counter).append('\n');
        }
        System.out.print(result);
        buffer.close();
    }
}