package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/152/
 */

public class AgeDistribution {

    private static final String FILE_NAME = TestData.PATH + "agedistribution.txt";
    private static final int BUFFER_SIZE = 1024;
    private static final String[] AGES = new String[]{
            "This program is for humans\n",
            "Still in Mama's arms\n",
            "Preschool Maniac\n",
            "Elementary school\n",
            "Middle school\n",
            "High school\n",
            "College\n",
            "Working for the man\n",
            "The Golden Years\n"
    };

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        FileInputStream buffer = new FileInputStream(file);
        byte[] input = new byte[BUFFER_SIZE];
        int inputLength;
        StringBuilder result = new StringBuilder();
        StringBuilder current = new StringBuilder();
        while ((inputLength = buffer.read(input)) != -1) {
            if (inputLength < BUFFER_SIZE && input[inputLength - 1] != '\n') {
                input[inputLength++] = '\n';
            }
            for (int i = 0; i < inputLength; i++) {
                switch (input[i]) {
                    case '\r': {
                        continue;
                    }
                    case '\n': {
                        if (current.length() == 0) {
                            continue;
                        }
                        result.append(getAge(Integer.parseInt(current.toString())));
                        current.setLength(0);
                        break;
                    }
                    default: {
                        current.append((char) input[i]);
                    }
                }

            }
        }
        System.out.print(result);
        buffer.close();
    }

    private static String getAge(final int value) {
        if (value < 0 || value > 100) {
            return AGES[0];
        }
        if (value < 3) {
            return AGES[1];
        } else {
            if (value < 5) {
                return AGES[2];
            } else {
                if (value < 12) {
                    return AGES[3];
                } else {
                    if (value < 15) {
                        return AGES[4];
                    } else {
                        if (value < 19) {
                            return AGES[5];
                        } else {
                            if (value < 23) {
                                return AGES[6];
                            } else {
                                if (value < 66) {
                                    return AGES[7];
                                }
                            }
                        }
                    }
                }
            }
        }
        return AGES[8];
    }
}
