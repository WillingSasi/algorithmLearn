package string;

/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * 方法1，2原理一样，都是通过s+s，掐头去尾，再用java String内置方法，判断是否包含s
 * 方法3. 两层循环暴力破解
 * 方法4. KMP算法
 */
public class DuplicateStr {

    public static void main(String[] args) {
        System.out.println(DuplicateStr1("ababab"));
        System.out.println(DuplicateStr2("ababab"));
    }

    public static boolean DuplicateStr1(String s) {
       String str = s + s;
       return str.substring(1,str.length()-1).contains(s);
    }

    public static boolean DuplicateStr2(String s) {
        String str = s + s;
        return str.indexOf(s, 1) != s.length();
    }
}
