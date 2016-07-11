package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.codeeval.com/open_challenges/124/
 */

public class RoadTrip {
    private static final String FILE_NAME =  TestData.path + "roadtrip.txt";
    private static final Pattern PATTERN = Pattern.compile("-?\\d+");

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        List<Integer> distances = new ArrayList<>();
        while ((line = buffer.readLine()) != null) {
            Matcher matcher = PATTERN.matcher(line);
            while (matcher.find()) {
                distances.add(Integer.parseInt(matcher.group()));
            }
            Collections.sort(distances);
            int way = 0;
            for(int distance : distances) {
                result.append(distance - way).append(',');
                way = distance;
            }
            result.deleteCharAt(result.length() - 1);
            result.append('\n');
            distances.clear();
        }
        System.out.print(result);
        buffer.close();
    }
}