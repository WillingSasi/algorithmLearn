package test;

import java.util.HashMap;

public class TestDDD {
    public static void main(String[] args) {
        String s = "rtyuiCVHJGHjkhjdahAAAA";

        int len = s.length();
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

        for (int i = 0;i < len;i++) {
            if (hm.get(s.charAt(i)) == null) {
                hm.put(s.charAt(i), 1);
            } else {
                hm.put(s.charAt(i), hm.get(s.charAt(i))+1);
            }
        }
//        hm.forEach( BiCo？.get('A') + );
    }

}
