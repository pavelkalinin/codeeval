package xyz.enhorse.codeeval.moderate;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/71/
 */
public class ReverseGroups {
    private static final String FILE_NAME = TestData.path + "reversegroups.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            String[] parts = line.split(";");
            int number = Integer.parseInt(parts[1]);
            int[] array = reverse(parseArray(parts[0]), number);
            result.append(arrayToString(array)).append('\n');
        }
        System.out.print(result);
    }

    private static int[] parseArray(final String string) {
        String[] array = string.split(",");
        int[] result = new int[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(array[i]);
        }
        return result;
    }

    private static String arrayToString(final int[] array) {
        StringBuilder result = new StringBuilder();
        for (int i : array) {
            result.append(i).append(',');
        }
        trimLastSymbol(result);
        return result.toString();
    }

    private static int[] reverse(int[] array, int number) {
        for (int i = 0; i + number - 1 < array.length; i += number) {
            for (int j = 0; j < number / 2; j++) {
                int firstIndex = i + j;
                int secondIndex = i + number - j - 1;

                int tmp = array[firstIndex];
                array[firstIndex] = array[secondIndex];
                array[secondIndex] = tmp;
            }
        }
        return array;
    }

    private static void trimLastSymbol(StringBuilder sb) {
        if ((sb != null) && (sb.length() > 0)) {
            sb.setLength(sb.length() - 1);
        }
    }
}
