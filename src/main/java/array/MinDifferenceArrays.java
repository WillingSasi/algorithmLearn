package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * 1.三次循环查找，时间复杂度有点高
 * 2.一次循环，循环最小值元素反复更新到ArrayList，时间复杂度N
 */
public class MinDifferenceArrays {

    public static void main(String[] args) {
        int[] a = {188,9,-189,-112,165,4,-141,179,-154,258,53,71,201,204,121,215,259,-22,34,-213,-88,-192,118,-221,130,-86,209};
        System.out.println(minimumAbsDifference1(a));
        System.out.println(minimumAbsDifference2(a));
    }

    /**
     * 1.三次循环查找，时间复杂度有点高
     * @param arr
     * @return
     */
    public static List<List<Integer>> minimumAbsDifference1(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        List<List<Integer>> newList = new ArrayList<List<Integer>>();
        int[] dp = new int[len];

        for (int i = 1;i < len;i++) {
            dp[i] = arr[i] - arr[i - 1];
        }

        int min = dp[1];
        for (int j = 1;j < len;j++) {
            min = Math.min(dp[j], min);
        }

        for (int j = 1;j < len;j++) {
            if (min == dp[j]) {
                List<Integer> li = new ArrayList<Integer>();
                li.add(arr[j-1]);
                li.add(arr[j]);
                newList.add(li);
            }
        }

        return newList;
    }

    /**
     * 2.一次循环，循环最小值元素反复更新到ArrayList，时间复杂度N
     * @param arr
     * @return
     */
    public static List<List<Integer>> minimumAbsDifference2(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        List<List<Integer>> newList = new ArrayList<List<Integer>>();
        int min = Integer.MAX_VALUE;

        for (int i = 1;i < len;i++)  {
            if ((arr[i] - arr[i-1]) < min) {
                min =  arr[i] - arr[i-1];
                newList = new ArrayList<List<Integer>>();

                List<Integer> li = new ArrayList<Integer>();
                li.add(arr[i-1]);
                li.add(arr[i]);
                newList.add(li);
            } else if ((arr[i] - arr[i-1]) == min) {
                List<Integer> li = new ArrayList<Integer>();
                li.add(arr[i-1]);
                li.add(arr[i]);
                newList.add(li);
            }
        }

        return newList;
    }
}
