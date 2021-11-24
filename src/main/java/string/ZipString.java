package string;

/**
 * 来源：高德地图服务端测开
 *
 * 问题1：通过键盘输入一串小写字母(a~z)组成的字符串。请编写一个字符串压缩程序，将字符串中连续出席的重复字母和重复字符串进行压缩，并输出压缩后的
 * 字符串。如果是字符串片段重复, 则用括号扩起来, 如果是字符重复, 则不用括号括起来.
 * 举例:
 * abcbc -> a2(bc), abbbbbb->a6b, abbbcbbbcbbbc->a3(3bc)
 * 要求实现函数：
 * void stringZip(const char *pInputStr, long lInputLen, char *pOutputStr);
 * 【输入】 pInputStr：  输入字符串 lInputLen：  输入字符串长度
 * 【输出】 pOutputStr： 输出字符串，空间已经开辟好，与输入字符串等长；
 * 【注意】只需要完成该函数功能算法，中间不需要有任何IO的输入输出
 *
 * 问题2：现输入一个字符串，对字符串进行压缩，如：如字符串"abcdabcd"由于无连续重复字符，
 * 压缩后的字符串还是"abcdabcd"，字符串"xxxrryyyyyyz"压缩后就成为"3x2r6yz"。
 *
 * 问题3：字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）
 * leetcode 面试题01.06 Easy
 */
public class ZipString {

    public static void main(String[] args) {
        System.out.println(zipString1("aabcccccaafghjbbbbbbbbbbbbbbbbbbbbbbbbbbbbbuyyy"));
        System.out.println(zipString2("aabcccccaafghjbbbbbbbbbbbbbbbbbbbbbbbbbbbbbuyyy"));
    }

    /**
     * 问题1：通过键盘输入一串小写字母(a~z)组成的字符串。请编写一个字符串压缩程序，将字符串中连续出席的重复字母和重复字符串进行压缩，并输出压缩后
     * 的字符串。如果是字符串片段重复, 则用括号扩起来, 如果是字符重复, 则不用括号括起来.
     * 思路1：abbbcbbbcbbbc->a3bc3bc3bc->a3(3bc)  有点思路就是多次循环，先判断单字符，再判断2字符，再判断3字符，最大到长度的一半
     *
     * 难度较大，暂未做出
     * @param str
     * @return
     */
    public static String zipString1(String str) {
        return str;
    }

    /**
     * 问题2：现输入一个字符串，对字符串进行压缩，如：如字符串"abcdabcd"由于无连续重复字符，
     * 解法1：双指针加临时空间存储，依次遍历查找相同字符，校验完存储StringBuffer，最后再单独判断最后一位字符异同
     * @param str
     * @return
     */
    public static String zipString2(String str) {
        int len = str.length();
        StringBuffer newS = new StringBuffer();
        int left = 0;
        int index = 1;
        //int right  = len - 1;

        while (left + index < len){
            if (str.charAt(left) == str.charAt(left + index)) {
                index++;
            } else {
                newS.append(index-1 == 0 ? "": index);
                newS.append(str.charAt(left));

                left = left + index;
                index = 1;
            }
        }

        newS.append(index != 1 ? index : "");
        newS.append(str.charAt(len-1));

        return newS.toString();
    }

    /**
     * leetcode 面试题01.06 Easy
     * @param S
     * @return
     */
    public static String zipString3(String S) {
        int len = S.length();
        int index = 1;
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < len;i++) {
            if (i+1 < len && S.charAt(i) == S.charAt(i+1)) {
                index++;
            } else {
                sb.append(S.charAt(i)).append(index);
                index = 1;
            }
        }

        return sb.toString().length() >= len ? S : sb.toString();
    }
}
