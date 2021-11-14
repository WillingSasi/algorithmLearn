package array;

import java.util.Arrays;

/**
 * 有序数组，查找目标target是否存在：
 * 1.无重复有序数组，查找存在
 * 2.有重复有序数组，查找首次出现index
 * 3.有重复有序数组，查找返回区间【】，否则返回【-1，-1】
 */
public class ArrayFindTarget {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,9};
        int target = 4;

        System.out.println(Arrays.toString(arrayFindTarget3(nums, target)));
    }

    /**
     * 3.有重复有序数组，查找返回区间【】，否则返回【-1，-1】
     * 要求：时间复杂度logN，也就是说不能用循环或者双指针遍历，得用二分法
     * @param nums
     * @param target
     * @return int[]
     */
    public static int[] arrayFindTarget3(int[] nums, int target) {
        int[] newNums = {-1, -1};
        if (nums == null || nums.length == 0) {
            return newNums;
        }

        int len = nums.length;
        int left = 0;
        int right = len -1;

        while (left < right) {
            int mid = (right + left)/2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (nums[left] != target) {
            return newNums;
        }  else {
            newNums[0] = left;

            while (nums[left] == target) {
                left++;
            }

            newNums[1] = left - 1;
        }

        return newNums;
    }
}
