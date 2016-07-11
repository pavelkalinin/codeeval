package xyz.enhorse.codeeval.moderate;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/228/
 */

public class ToPIorNotToPI {
    private static final String FILE_NAME = TestData.path + "topiornottopi.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        String pi = piBySpigot(5000);

        while ((line = buffer.readLine()) != null) {
            int position = Integer.parseInt(line);
            result.append(pi.charAt(position - 1)).append('\n');
        }

        buffer.close();
        System.out.print(result);

    }

    private static String piBySpigot(final int n) {
        StringBuilder pi = new StringBuilder(n);
        int boxes = n * 10 / 3;
        int reminders[] = new int[boxes];

        for (int i = 0; i < boxes; i++) {
            reminders[i] = 2;
        }
        int heldDigits = 0;
        for (int i = 0; i < n; i++) {
            int carriedOver = 0;
            int sum = 0;
            for (int j = boxes - 1; j >= 0; j--) {
                reminders[j] *= 10;
                sum = reminders[j] + carriedOver;
                int quotient = sum / (j * 2 + 1);
                reminders[j] = sum % (j * 2 + 1);
                carriedOver = quotient * j;
            }
            reminders[0] = sum % 10;

            int q = sum / 10;	// new digit of Pi

            if (q == 9) {
                heldDigits++;
            } else if (q == 10) {
                q = 0;
                for (int k = 1; k <= heldDigits; k++) {
                    int replaced = Integer.parseInt(pi.substring(i - k, i - k + 1));
                    if (replaced == 9) {
                        replaced = 0;
                    } else {
                        replaced++;
                    }
                    pi.deleteCharAt(i - k);
                    pi.insert(i - k, replaced);
                }
                heldDigits = 1;
            } else {
                heldDigits = 1;
            }
            pi.append(q);
        }
        return pi.toString();
    }
}