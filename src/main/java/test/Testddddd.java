package test;

/*
居伟伟
给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

示例1:输入: pattern = "abba", str = "dog cat cat dog"
输出: true


示例 2:输入:pattern = "abba", str = "dog cat cat fish"
输出: false


示例 3:输入: pattern = "aaaa", str = "dog cat cat dog"
输出: false


示例 4:输入: pattern = "abba", str = "dog dog dog dog"
输出: false
11:16
居伟伟
pattern：abbabb
str：  abbacc
11:24
居伟伟
abbba。 dog cat cat cat fish

 */
public class Testddddd {

    //abbabb
    public static void main(String[] args) {
        String pattern1 = "abba";
        String pattern2 = "abba";
        String pattern3 = "aaaa";
        String pattern4 = "abbba";
        String str1 = "dog cat cat dog";
        String str2 = "dog cat cat fish";
        String str3 = "dog cat cat dog";
        String str4 = " dog cat cat cat fish";
//        System.out.println(test(pattern1, str1));
//        System.out.println(test(pattern2, str2));
//        System.out.println(test(pattern3, str3));
        System.out.println(test(pattern4, str4));
    }

    public static boolean test(String pattern, String str) {
        String[] strList = str.split(" ");
        int len = strList.length;

        if (len != pattern.length()){
            return false;
        }

        for (int i = 0;i < len-1;i++) {
            for (int j = i+1;j < len;j++) {
                if (pattern.charAt(i) == pattern.charAt(j) ) {
                    if (!strList[i].equals(strList[j])){
                        return false;
                    }
                } else {
                    if (strList[i].equals(strList[j])){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
