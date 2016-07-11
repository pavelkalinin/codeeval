package xyz.enhorse.codeeval.moderate;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.BitSet;

/**
 * https://www.codeeval.com/open_challenges/37/
 */

public class Pangrams {
    private static final String FILE_NAME = TestData.path + "pangrams.txt";
    private static final int ALPHABET_SIZE = 26;

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        BitSet letters = new BitSet(ALPHABET_SIZE);
        StringBuilder result = new StringBuilder();
        char current;
        int last;
        while ((line = buffer.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                current = Character.toLowerCase(line.charAt(i));
                if (current >= 'a' && current <= 'z') {
                    letters.set(current - 0x61, true);
                    if (letters.cardinality() == ALPHABET_SIZE) {
                        break;
                    }
                }
            }
            last = letters.previousClearBit(ALPHABET_SIZE - 1);
            if (last < 0) {
                result.append("NULL");
            }
            for (int i = 0; i <=last; i++) {
                if (!letters.get(i)) {
                    result.append((char) (i + 0x61));
                }
            }
            result.append('\n');
            letters.clear();
        }
        System.out.print(result);
        buffer.close();
    }
}
