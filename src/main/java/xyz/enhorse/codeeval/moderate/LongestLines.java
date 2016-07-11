package xyz.enhorse.codeeval.moderate;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * https://www.codeeval.com/open_challenges/2/
 */
public class LongestLines {
    private static final String FILE_NAME = TestData.path + "longestlines.txt";

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        List<String> list = new ArrayList<>();
        int numberLinesForOutput = Integer.parseInt(buffer.readLine());
        String line;
        while ((line = buffer.readLine()) != null) {
            list.add(line);
        }
        Collections.sort(list, new StringComparator());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numberLinesForOutput; i++) {
            result.append(list.get(i)).append('\n');
        }
        System.out.print(result);
    }

    static class StringComparator implements Comparator<String>
    {
        public int compare(String s1, String s2)
        {
            return s2.length() - s1.length();
        }
    }
}
