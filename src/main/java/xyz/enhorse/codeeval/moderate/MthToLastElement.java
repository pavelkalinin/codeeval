package xyz.enhorse.codeeval.moderate;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/10/
 */
public class MthToLastElement {

    private static final String FILE_NAME = TestData.PATH + "mthtolastelement.txt";

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            String[] input = line.trim().split(" ");
            int index = Integer.parseInt(input[input.length - 1]);
            if (index < input.length) {
                result.append(input[input.length - 1 - index].charAt(0)).append('\n');
            }
        }
        System.out.print(result);
        buffer.close();
    }
}
