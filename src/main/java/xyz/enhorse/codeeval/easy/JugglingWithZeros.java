package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/149/
 */

public class JugglingWithZeros {

    private static final String FILE_NAME = TestData.PATH + "jugglingwithzeros.txt";

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        StringBuilder decodedNumber = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            String[] words = line.split(" ");
            for (int i = 0; i < words.length; i = i + 2) {
                decodedNumber.append(decode(words[i], words[i + 1]));
            }
            result.append(Long.parseLong(decodedNumber.toString(), 2)).append('\n');
            decodedNumber.setLength(0);
        }
        System.out.print(result);
        buffer.close();
    }

    private static String decode(String flag, String value) {
        StringBuilder result = new StringBuilder();
        char symbol = getSymbol(flag);
        for (int i = 0; i < value.length(); i++) {
            result.append(symbol);
        }
        return result.toString();
    }

    private static char getSymbol(String flag) {
        return flag.length() > 1 ? '1' : '0';
    }
}
