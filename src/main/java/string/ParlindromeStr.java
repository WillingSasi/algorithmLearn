package string;

import java.io.InputStream;
import java.util.Scanner;

/**
 * 回文字符串问题，包含3个问题：
 * 1. 字符串是否回文？
 * 2. 字符串中是否包含回文子串？
 * 3. 最长回文子串, 暴力循环法，动态规划？
 */
public class ParlindromeStr {

    public static void main(String[] args) {
//        InputStream inputStream = System.in;
//        Scanner scanner = new Scanner(inputStream);
//        String testStr = scanner.next();
        String testStr = "ababc";
//        System.out.println(maxParlindromeStr(testStr));
//        System.out.println(getLongestPalindrome(testStr));
        System.out.println(getLongestPalindromeStr(testStr));
    }

    /**
     * 1. 字符串是否回文？
     * 思路：双指针从两头单步判断
     * @param testStr
     */
    public static void isOrNotParlindromeStr(String testStr) {
        if (testStr == null || testStr.length() < 2) {
            System.out.println(false);
        }

        int len = testStr.length();
        boolean flag = true;
        for (int i = 0;i < len/2;i++) {
            if (testStr.charAt(i) != testStr.charAt(len - 1 -i)) {
                flag = false;
                break;
            }
        }

        System.out.println(flag);
    }

    /**
     * 2. 字符串中是否包含回文子串？
     * 思路1：两层for循环，从两边开始往中间找，时间复杂度n^2,暴力枚举判断
     * @param testStr
     */
    public static boolean isContainParlindromeStr(String testStr) {
        if (testStr == null || testStr.length() < 2) {
            return false;
        }

        int len = testStr.length();
        boolean flag = false;

        for (int i = 0; i < len-2;i++) {
            for (int j = len-1;j > i;j--) {
                int m = i;
                int n = j;
                while (testStr.charAt(m) == testStr.charAt(n) && m < n) {
                    if (n == m+1 || n == m+2) {
                        flag = true;
                        break;
                    }
                    m++;
                    n--;
                }
            }
        }

        return flag;
    }

    /**
     * 3. 最长回文子串, 暴力循环法，基于isContainParlindromeStr方法
     * @param testStr
     */
    public static int maxParlindromeStr(String testStr) {
        int maxParlindrome = 0;
        if (testStr == null || testStr.length() < 2) {
            return maxParlindrome;
        }

        int len = testStr.length();
        for (int i = 0;i < len-1;i++) {
            for (int j = len-1;j > i;j--){
                int m = i;
                int n = j;
                int count = 0;

                while (testStr.charAt(m) == testStr.charAt(n) && m < n) {
                    count++;
                    if (m + 1 == n || m +2 == n) {
                        maxParlindrome = Math.max(maxParlindrome, count*2 + (n-m-1));
                        break;
                    }
                    m++;
                    n--;
                }
            }
        }

        return maxParlindrome;
    }

    public static int getLongestPalindrome(String A) {
        // write code here
        int maxParlindrome = 0;
        int n = A.length();
        if (n < 2) {
            return maxParlindrome;
        }

        for (int i = 0;i < n-1;i++) {
            for (int j = n-1;j > i;j--){
                int x = i;
                int y = j;
                int count = 0;

                while (A.charAt(x) == A.charAt(y) && x < y) {
                    count++;
                    if (x + 1 == y || x + 2 == y) {
                        System.out.println(count*2 + (x-y-1));
                        maxParlindrome = Math.max(maxParlindrome, count*2 + (y-x-1));
                        break;
                    }
                    x++;
                    y--;
                }
            }
        }

        return maxParlindrome;
    }

    public static String getLongestPalindromeStr(String s) {
        int len = s.length();
        String newS = s;
        int max = Integer.MIN_VALUE;

        for (int i = 0;i < len-1;i++) {
            int left = i;
            for (int j = len-1;j > left;j--) {
                int right = j;
                while (s.charAt(right) == s.charAt(left) && left < right) {
                    left++;
                    right--;
                }

                if (left == right || left + 1 == right) {
                    max = Math.max(max, j - i);
                    if (max == j - i) {
                        newS = s.substring(i, j);
                    }
                }
            }
        }

        return newS;
    }
}
