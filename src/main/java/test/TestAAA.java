package test;

import java.util.ArrayList;
import java.util.HashMap;

public class TestAAA {

    /**
     * 统计一篇英文文章每个单词的出现频率，并返回出现频率最高的前3个单词及其出现次数(字典形式)
     * "A small sample of texts from Project Gutenberg appears in the NLTK corpus collection However small of from in of the However"
     * @param args
     */
    public static void main(String[] args) {
        String ss = "A small sample of texts from Project Gutenberg appears in the NLTK corpus collection However small of from in of the However";
        String[] sList = ss.split(" ");
        int len = sList.length;
        HashMap<String, Integer> hm = new HashMap<>();

        for (String s : sList) {
            if (hm.get(s) != null) {
                hm.put(s, hm.get(s)+1);
            } else {
                hm.put(s, 1);
            }
        }

        String[] al = new String[len + 1];
        for (String s : sList) {
            al[hm.get(s)] = s;
        }

        int count = 0;
        for (int i = len;i >= 0;i--) {
            if (al[i] != null && count < 3) {
                count++;
                System.out.println(al[i] + i);
            }
        }

    }
}
