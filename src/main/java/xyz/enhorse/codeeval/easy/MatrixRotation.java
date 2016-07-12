package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/178/
 */

public class MatrixRotation {

    private static final String FILE_NAME = TestData.PATH + "matrixrotation.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            char[] elements = new char[line.length() / 2 + 1];
            for (int i = 0; i < line.length(); i += 2 ) {
                elements[i / 2] = line.charAt(i);
            }
            int n = (int) Math.sqrt(elements.length);
            for (int i = n; i > 0; i--) {
                for (int j = 0; j < n; j++) {
                    result.append(elements[(n - j) * n - i]).append(' ');
                }
            }
            result.deleteCharAt(result.length() - 1).append('\n');
        }
        System.out.print(result);
        buffer.close();
    }
}
