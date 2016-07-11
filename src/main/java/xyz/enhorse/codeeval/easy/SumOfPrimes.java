package xyz.enhorse.codeeval.easy;

/**
 * https://www.codeeval.com/open_challenges/4/
 */

public class SumOfPrimes {
    public static void main (String[] args) {
        int i = 1;
        int n = 2;
        long result = 2;
        while (i < 1000) {
            if (millerRabinPass(2, n) && (n <= 7 || millerRabinPass(7, n)) && (n <= 61 || millerRabinPass(61, n))) {
                result += n;
                i++;
            }
            n++;
        }
        System.out.println(result);
    }

    private static int modularExponent(int base, int power, int modulus) {
        long result = 1;
        for (int i = 31; i >= 0; i--) {
            result = (result * result) % modulus;
            if ((power & (1 << i)) != 0) {
                result = (result * base) % modulus;
            }
        }
        return (int)result;
    }

    private static boolean millerRabinPass(int a, int n) {
        int d = n - 1;
        int s = Integer.numberOfTrailingZeros(d);
        d >>= s;
        int a_to_power = modularExponent(a, d, n);
        if (a_to_power == 1) return true;
        for (int i = 0; i < s - 1; i++) {
            if (a_to_power == n - 1) return true;
            a_to_power = modularExponent(a_to_power, 2, n);
        }
        return a_to_power == n - 1;
    }
}
