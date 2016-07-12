package xyz.enhorse.codeeval.moderate;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

/**
 * https://www.codeeval.com/open_challenges/68/
 */
public class ValidParentheses {

    private static final String FILE_NAME = TestData.PATH + "ValidParentheses.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        Stack<Character> sequence = new Stack<>();
        boolean current;
        char ch;
        while ((line = buffer.readLine()) != null) {
            current = line.length() > 1;
            for (int i = 0; i < line.length(); i++) {
                ch = line.charAt(i);
                if (isOpening(ch)) {
                    sequence.push(ch);
                } else {
                    if (sequence.empty() || (sequence.peek() != getOpening(ch))) {
                        current = false;
                        break;
                    } else {
                        sequence.pop();
                    }
                }
            }
            result.append(current && sequence.empty() ? "True\n" : "False\n");
            sequence.clear();
        }
        System.out.print(result);
        buffer.close();
    }

    static boolean isOpening(char ch) {
        return (ch == '(') || (ch == '{') || (ch == '[');
    }

    static char getOpening(char closing) {
        switch (closing) {
            case ')': {
                return '(';
            }
            case '}': {
                return '{';
            }
            case ']': {
                return '[';
            }
            default: {
                throw new IllegalArgumentException("Illegal Parentheses!");
            }
        }
    }
}
