package xyz.enhorse.codeeval.moderate;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * https://www.codeeval.com/open_challenges/75/
 */
public class FlaviousJosephus {

    private static final String FILE_NAME = TestData.PATH + "FlaviousJosephus.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        int n, m;
        while ((line = buffer.readLine()) != null) {
            n = Integer.parseInt(line.substring(0, line.indexOf(",")));
            m = Integer.parseInt(line.substring(line.lastIndexOf(",") + 1, line.length()));
            getExecutedQueue(result, n, m);
        }
        System.out.print(result);
        buffer.close();
    }

    private static void getExecutedQueue(StringBuilder result, final int n, final int m) {
        ArrayList<Integer> queue = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }
        int pointer = 0;
        while (queue.size() > 1) {
            pointer = (pointer + m - 1) % queue.size();
            result.append(queue.get(pointer)).append(' ');
            queue.remove(pointer);
        }
        result.append(queue.get(0)).append('\n');
    }
}