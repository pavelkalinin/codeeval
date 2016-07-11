package xyz.enhorse.codeeval.moderate;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/12/
 */
public class FirstNonRepeatedCharacter {
    private static final String FILE_NAME = TestData.path + "FirstNonRepeatedCharacter.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        char ch;
        while ((line = buffer.readLine()) != null) {
            ch = line.charAt(0);
            for (int i = 0; i < line.length(); i++) {
                ch = line.charAt(i);
                if ((line.indexOf(ch) == i) && (line.lastIndexOf(ch) == i)) {
                    break;
                }
            }
            result.append(ch).append('\n');
        }
        System.out.print(result);
        buffer.close();
    }
}
