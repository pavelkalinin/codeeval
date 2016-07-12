package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.codeeval.com/open_challenges/116/
 */

public class MorseCode {

    private static final String FILE_NAME = TestData.PATH + "morsecode.txt";
    private static final Map<String, Character> TABLE = new HashMap<String, Character>(34) {
        {
            put(".-",'A');
            put("-...",'B');
            put("-.-.",'C');
            put("-..",'D');
            put(".",'E');
            put("..-.",'F');
            put("--.",'G');
            put("....",'H');
            put("..",'I');
            put(".---",'J');
            put("-.-",'K');
            put(".-..",'L');
            put("--",'M');
            put("-.",'N');
            put("---",'O');
            put(".--.",'P');
            put("--.-",'Q');
            put(".-.",'R');
            put("...",'S');
            put("-",'T');
            put("..-",'U');
            put("...-",'V');
            put(".--",'W');
            put("-..-",'X');
            put("-.--",'Y');
            put("--..",'Z');
            put("-----",'0');
            put(".----",'1');
            put("..---",'2');
            put("...--",'3');
            put("....-",'4');
            put(".....",'5');
            put("-....",'6');
            put("--...",'7');
            put("---..",'8');
            put("----.",'9');
        }
    };
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        FileInputStream buffer = new FileInputStream(file);
        byte[] input = new byte[BUFFER_SIZE];
        int inputLength;
        StringBuilder code = new StringBuilder();
        boolean space = false;
        StringBuilder result = new StringBuilder();
        while ((inputLength = buffer.read(input)) != -1) {
            if (inputLength < BUFFER_SIZE && input[inputLength - 1] != '\n') {
                input[inputLength++] = '\n';
            }
            for (int i = 0; i < inputLength; i++) {
                if (input[i] == '\n') {
                    result.append(TABLE.get(code.toString()));
                    code.setLength(0);
                    result.append('\n');
                } else {
                    if (input[i] == ' ') {
                        if (!space) {
                            result.append(TABLE.get(code.toString()));
                            code.setLength(0);
                            space = true;
                        } else {
                            result.append(' ');
                            space = false;
                        }
                    } else {
                        code.append((char) input[i]);
                        space = false;
                    }
                }
            }
        }
        System.out.print(result);
        buffer.close();
    }
}

