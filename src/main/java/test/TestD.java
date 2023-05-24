package test;

import java.util.ArrayList;
import java.util.Arrays;

//无序整数数组，三个数相加为0，打印所有情况组 [1, -1, 0, 2, 1, -3]
public class TestD {

    public static void main(String[] args) {
        int[] nums = {1, -1, 0, 2, 1, -3};
        int len = nums.length;

        ArrayList ay = new ArrayList();
        Arrays.sort(nums);

        for (int i = 0; i < len-2;i++) {
            if (nums[i] > 0) {
                return;
            } else {
                for (int j = i+1;j < len - 1;j++) {
                    int temp = 0 - nums[i] - nums[j];
                    for (int index = j+1;index < len;index++) {
                        if (nums[index] == temp) {
                            System.out.println(nums[i]+" "+ nums[j]+" "+ nums[index]);
                        }
                    }
                }
            }
        }
    }
}
