package top.hoyouly.playwithalgorithms.leetcode;

/**
 *
 */
public class Leetcode_7 {
    public static void main(String[] args) {
        int x = -2147483412;
        System.out.printf(x + "  reverse   " + reverse(x));
    }

    public static int reverse(int x) {
        int sum = 0;
        while (x != 0) {
            if (sum > Integer.MAX_VALUE / 10 || sum < Integer.MIN_VALUE / 10) {
                return 0;
            }
            sum = sum * 10 + x % 10;
            x = x / 10;
        }
        return sum;
    }

    public static int reverse1(int x) {
        long sum = 0;
        boolean isPlus = x > 0;

        long i = Math.abs(x);
        while (i > 0) {
            sum = sum * 10 + i % 10;
            if (sum > Integer.MAX_VALUE) {
                sum = 0;
                break;
            }
            i = i / 10;
        }
        return (int) (isPlus ? sum : sum * -1);
    }

}
