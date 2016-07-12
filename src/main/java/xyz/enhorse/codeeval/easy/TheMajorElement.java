package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/132/
 */

public class TheMajorElement {

    private static final String FILE_NAME = TestData.PATH + "majorelement.txt";
    private static final int BUFFER_SIZE = 1024;
    private static final String NONE = "None";

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        FileInputStream buffer = new FileInputStream(file);
        byte[] input = new byte[BUFFER_SIZE];
        int inputLength;
        StringBuilder result = new StringBuilder();
        StringBuilder current = new StringBuilder();
        int[] quantities = new int[100];
        int index = -1, length = -1;
        while ((inputLength = buffer.read(input)) != -1) {
            if (inputLength < BUFFER_SIZE) {
                input[inputLength++] = '\n';
            }
            for (int i = 0; i < inputLength; i++) {
                switch (input[i]) {
                    case'\r': {
                        continue;
                    }
                    case ',':
                    case '\n': {
                        if (current.length() == 0) {
                            continue;
                        }
                        quantities[(current.length() == 1)
                                ? current.charAt(0) - 0x30
                                : (current.charAt(0) - 0x30) * 10 + (current.charAt(1) - 0x30)]++;
                        length++;
                        current.setLength(0);
                        if (input[i] == ',') {
                            break;
                        }
                        int max = -1;
                        for (int j = 0; j < quantities.length; j++) {
                            if (max < quantities[j]) {
                                max = quantities[j];
                                index = j;
                            }
                            quantities[j] = 0;
                        }
                        result.append(max > length / 2 ? index : NONE).append('\n');
                        length = -1;
                        index = -1;
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