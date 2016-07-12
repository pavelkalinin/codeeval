package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://www.codeeval.com/open_challenges/222/
 */
public class BlackCard {

    private static final String FILE_NAME = TestData.PATH + "blackcard.txt";

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();

        while ((line = buffer.readLine()) != null) {
            String[] input = line.split(" \\| ");
            result.append(findWinner(input[0].split(" "), Integer.parseInt(input[1]) - 1)).append('\n');
        }
        System.out.println(result.toString());
    }

    public static String findWinner(String[] pirates, int outPerson) {
        List<String> people = new LinkedList<>(Arrays.asList(pirates));
        while (people.size() > 1) {
            int current = outPerson % people.size();
            people.remove(current);
        }
        return people.get(0);
    }
}
