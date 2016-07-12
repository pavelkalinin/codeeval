package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.File;

/**
 * https://www.codeeval.com/open_challenges/26/
 */

public class FileSize {

    public static final String FILE_NAME = TestData.PATH + "filesize.txt";

    public static void main(String[] args) {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        System.out.println(file.length());
    }
}
