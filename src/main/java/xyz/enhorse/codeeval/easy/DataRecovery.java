package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/140/
 */

public class DataRecovery {

    private static final String FILE_NAME = TestData.PATH + "datarecovery.txt";

    public static void main (String[] args) throws IOException {
        File inputFile = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(inputFile));
        String line;
        StringBuilder result = new StringBuilder();
        int length, missedIndex;
        while ((line = buffer.readLine()) != null) {
            String[] parts = line.split(";");
            String[] words = parts[0].split(" ");
            String[] order = parts[1].split(" ");
            length = words.length;
            missedIndex = (length * (length + 1) / 2) - 1;
            String[] sentence = new String[length];
            for (int i = 0; i < length - 1; i++) {
                int index = Integer.parseInt(order[i]);
                sentence[index - 1] = words[i];
                missedIndex -= index;
            }
            sentence[missedIndex] = words[length - 1];
            for (String word : sentence) {
                result.append(word).append(" ");
            }
            result.delete(result.length() - 1, result.length()).append('\n');
        }
        System.out.print(result);
        buffer.close();
    }
}
