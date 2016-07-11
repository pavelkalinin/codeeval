package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.codeeval.com/open_challenges/19/
 */

public class BitPositions {
    private static final String FILE_NAME = TestData.path + "bitpositions.txt";
    private static final int BUFFER_SIZE = 1024;
    private static final Pattern NUMBER_PATTERN = Pattern.compile("(\\d+),(\\d+),(\\d+)");

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        FileInputStream buffer = new FileInputStream(file);
        byte[] input = new byte[BUFFER_SIZE];
        int inputLength;
        StringBuilder result = new StringBuilder();
        Matcher matcher;
        int number;
        StringBuilder current = new StringBuilder();
        while ((inputLength = buffer.read(input)) != -1) {
            if (inputLength < BUFFER_SIZE && input[inputLength - 1] != '\n') {
                input[inputLength++] = '\n';
            }
            for (int i = 0; i < inputLength; i++) {
                switch (input[i]) {
                    case'\r': {
                        continue;
                    }
                    case '\n': {
                        if (current.length() == 0) {
                            continue;
                        }
                        matcher = NUMBER_PATTERN.matcher(current);
                        //noinspection ResultOfMethodCallIgnored
                        matcher.find();
                        number = Integer.parseInt(matcher.group(1));
                        result.append(Integer.lowestOneBit(number >> (Integer.parseInt(matcher.group(2)) - 1))
                                == Integer.lowestOneBit(number >> (Integer.parseInt(matcher.group(3)) - 1))).append('\n');
                        current.setLength(0);
                        break;
                    }
                    default: {
                        current.append((char)input[i]);
                    }
                }

            }
        }
        System.out.print(result);
        buffer.close();
    }
}