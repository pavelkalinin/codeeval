package xyz.enhorse.codeeval.moderate;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/172/
 */
public class CardNumberValidation {

    private static final String FILE_NAME = TestData.PATH + "CardNumberValidation.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;

        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            line = line.replace(" ", "");
            boolean t = false;
            int sum = 0;
            for (int i = line.length() - 1; i >= 0; i--) {
                int current = line.charAt(i) - 0x30;
                sum += t ? (current * 2) / 10 + (current * 2) % 10 : current;
                t = !t;
            }
            result.append(sum % 10 == 0 ? 1 : 0).append('\n');
        }

        System.out.print(result);
        buffer.close();
    }
}
