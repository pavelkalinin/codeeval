package xyz.enhorse.codeeval.moderate;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 * https://www.codeeval.com/open_challenges/13/
 */
public class RemoveCharacters {
    private static final String FILE_NAME = TestData.path + "removecharacters.txt";

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            String[] parts = line.split(",");
            parts[1] = parts[1].trim();
            for (int i = 0; i < parts[1].length(); i++) {
                char ch = parts[1].charAt(i);
                result.append(parts[0].replace(String.valueOf(ch), "")).append('\n');
            }
        }
        System.out.print(result);
    }
}
