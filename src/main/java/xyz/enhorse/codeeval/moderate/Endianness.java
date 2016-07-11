package xyz.enhorse.codeeval.moderate;

/**
 * https://www.codeeval.com/open_challenges/15/
 */
public class Endianness {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        if (((b << 16) | a) == 65536) {
            System.out.println("LittleEndian");
        } else {
            System.out.println("BigEndian");
        }
    }
}