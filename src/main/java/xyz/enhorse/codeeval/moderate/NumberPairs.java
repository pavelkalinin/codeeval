package xyz.enhorse.codeeval.moderate;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * https://www.codeeval.com/open_challenges/34/
 */
public class NumberPairs {
    private static final String FILE_NAME = TestData.path+"numberpairs.txt";

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        StringBuilder current = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            String[] input = line.trim().split(";");
            int[] numbers = stringToArray(input[0]);
            int sum = Integer.parseInt(input[1]);
            current.setLength(0);
            int first = 0;
            int last = numbers.length - 1;
            while (first < last) {
                int s = numbers[first] + numbers[last];
                if (s == sum) {
                    current.append(numbers[first]).append(',').append(numbers[last]).append(';');
                    first++;
                    last--;
                } else {
                    if (s < sum) {
                        first++;
                    } else {
                        last--;
                    }
                }
            }
            if (current.length() > 0) {
                current.setLength(current.length() - 1);
            } else {
                current.append("NULL");
            }
            result.append(current).append('\n');
        }
        System.out.print(result);
        buffer.close();
    }

    private static int[] stringToArray(String string) {
        StringTokenizer token = new StringTokenizer(string, ",", false);
        int[] result = new int[token.countTokens()];
        int i = 0;
        while (token.hasMoreTokens()) {
            result[i++] = Integer.parseInt(token.nextToken());
        }
        return result;
    }
}
