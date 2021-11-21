package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * x【c，a，b，f，h】y【a，a，r，j，f，f】，输出数组x，x中删除在y中重复1次以上的，并最后排序。leetcode有一道中等难度的题类似。算法有什么性能问题？
 * 1.暴力解法，先排序，再循环查找相同
 */
public class CommonPerfix {
    public static void main(String[] args) {
        String[] x = {"c", "b", "a", "f", "h"};
        String[] y = {"a", "a", "r", "j", "f", "f"};
        System.out.println(commonPerfix1(x, y));
    }

    public static List<String> commonPerfix1(String[] x, String[] y) {
        Arrays.sort(x);
        Arrays.sort(y);
        int lenX = x.length;
        int lenY = y.length;

        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));

        HashMap<String,Integer> newMap = new HashMap<String,Integer>();
        for (String yStr: y) {
            if (newMap.containsKey(yStr)) {
                newMap.replace(yStr, newMap.get(yStr) + 1);
            } else {
                newMap.put(yStr, 1);
            }
        }

        ArrayList<String> newList = new ArrayList<String>();
        for (String xStr: x) {
            if (newMap.containsKey(xStr) && newMap.get(xStr) > 1){
                continue;
            } else{
                newList.add(xStr);
            }
        }

        return newList;
    }
}
