package string;

import java.util.HashMap;

public class FirstDisplayChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }

    public static char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        if (len == 0) {
            return ' ';
        } else if (len == 1) {
            return chars[0];
        }

        HashMap<Character, Integer> mp = new HashMap<Character, Integer>();

        for (char c : chars) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        for (char c : chars) {
            if (mp.get(c) == 1) {
                return c;
            }
        }

        return ' ';
    }
}
