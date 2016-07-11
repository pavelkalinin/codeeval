package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/166/
 */

public class DeltaTime {
    private static final String FILE_NAME = TestData.path + "deltatime.txt";

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            result.append(calcDelta(line.trim())).append('\n');
        }
        System.out.print(result);
        buffer.close();
    }

    private static String calcDelta(String line) {
        String[] timePair = line.split(" ");
        return fromSeconds(Math.abs((inSeconds(timePair[0]) - inSeconds(timePair[1]))));
    }

    private static long inSeconds(String time) {
        String[] parts = time.split(":");
        int hours = Integer.valueOf(parts[0]);
        int minutes = Integer.valueOf(parts[1]);
        int seconds = Integer.valueOf(parts[2]);
        return seconds + (hours * 60 + minutes) * 60;
    }

    private static String fromSeconds(long time) {
        long seconds = time % 60;
        long minutes = ((time - seconds) / 60) % 60;
        long hours = (((time - seconds) / 60) - minutes) / 60;
        return addLeadingZero(String.valueOf(hours)) + ':'
                + addLeadingZero(String.valueOf(minutes))
                + ':' + addLeadingZero(String.valueOf(seconds));
    }

    private static String addLeadingZero(String value) {
        return value.length() > 1 ? value : '0' + value;
    }
}
