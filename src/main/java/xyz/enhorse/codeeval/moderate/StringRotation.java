package xyz.enhorse.codeeval.moderate;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/76/
 */
public class StringRotation {
    private static final String FILE_NAME = TestData.path + "stringrotation.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            boolean current = false;
            String[] words = line.split(",");
            if (words[0].length() == words[1].length()) {
                char[] word = words[0].toCharArray();
                for (int i = 0; i < word.length - 1; i++) {
                    if (words[1].equals(rotate(word))) {
                        current = true;
                        break;
                    }
                }
            }
            result.append(current ? "True" : "False").append('\n');
        }
        System.out.print(result);
        buffer.close();
    }

    private static String rotate(char[] array) {
        reverse(array, 0, array.length - 1);
        reverse(array, 0, array.length - 2);
        return String.valueOf(array);
    }

    public static void reverse(char[] array, int left, int right) {
        if (array.length > 1) {
            while (left < right) {
                char temp = array[left];
                array[left++] = array[right];
                array[right--] = temp;
            }
        }
    }
}
