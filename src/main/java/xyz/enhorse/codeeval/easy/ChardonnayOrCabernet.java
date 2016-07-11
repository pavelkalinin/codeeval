package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/211/
 */
public class ChardonnayOrCabernet {
    private static final String FILE_NAME = TestData.path + "chardonnayorcabernet.txt";

    private static final int MAX_REMEMBERED_LETTERS = 5;
    private static final String NOT_FOUND = "False";

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        StringBuilder current = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            String[] list = line.replace("| ", "").split(" ");
            String letters = list[list.length - 1];
            for (int i = 0; i < (list.length - 1); i++) {
                Letters.setContent(letters);
                for (int j = 0; j < list[i].length(); j++) {
                    if (Letters.removeLetter(list[i].charAt(j)) == 0) {
                        current.append(list[i]).append(" ");
                        break;
                    }
                }
            }
            result.append((current.length() != 0) ? current : NOT_FOUND).append('\n');
            current.setLength(0);
        }
        System.out.print(result);
        buffer.close();
    }

    private static class Letters {
        private static final char[] content = new char[MAX_REMEMBERED_LETTERS];
        private static int length;

        private static void setContent(final String value) {
            length = value.length();
            for (int i = 0; i < length; i++) {
                content[i] = value.charAt(i);
            }
        }

        private static int removeLetter(char letter) {
            for (int i = 0; i < length; i++) {
                if (content[i] == letter) {
                    if (i != (length - 1)) {
                        content[i] = content[length - 1];
                    }
                    length--;
                    break;
                }
            }
            return length;
        }
    }
}
