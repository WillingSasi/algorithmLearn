package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {6,1,3,4,10,9,8, 1, 2,3};

        int len  = nums.length;
        int index = 0;

        for (int j = 0; j< len-1;j++) {
            for (int i = 0;i < len-1-i;i++) {
                if (nums[i] > nums[i+1]) {
                    index = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = index;

                    System.out.println(Arrays.toString(nums));
                }
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
