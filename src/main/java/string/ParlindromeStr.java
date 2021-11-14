package string;

import java.io.InputStream;
import java.util.Scanner;

/**
 * 回文字符串问题，包含两个问题：
 * 1. 字符串是否回文？
 * 2. 字符串中是否包含回文子串？
 */
public class ParlindromeStr {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        Scanner scanner = new Scanner(inputStream);
        String testStr = scanner.next();
        isContainParlindromeStr1(testStr);
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
    public static void isContainParlindromeStr(String testStr) {
        if (testStr == null || testStr.length() < 2) {
            System.out.println(false);
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

        System.out.println(flag);
    }

    /**
     * 2. 字符串中是否包含回文子串？
     * 思路1：两层for循环，从每个字符开始向两边遍历，时间复杂度n^2, 凑够某种意义上能比上种方法快一点，如果只判断true false的话，
     * 只要判断有最小单元比如aa，aba这种类型就返回true
     * @param testStr
     */
    public static void isContainParlindromeStr1(String testStr) {
        boolean flag = false;
        if (testStr == null || testStr.length() < 2) {
            System.out.println(flag);
        }

        int len = testStr.length();

        for (int i = 1;i < len-1;i++) {
            while (testStr.charAt(i-1) == testStr.charAt(i)
                    || testStr.charAt(i) == testStr.charAt(i+1)
                    || testStr.charAt(i-1) == testStr.charAt(i+1)) {
                flag = true;
                break;
            }
        }

        System.out.println(flag);
    }
}
