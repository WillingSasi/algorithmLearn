package array;

import java.util.Arrays;

/**
 * 来源：字节跳动移动端测开2面
 *
 * 数组每K个元素反转 [1、2、3、4、5、6、7、8]
 * K = 3  [3、2、1、6、5、4、8、7]
 */
public class ReverseArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        reverseArray1(nums);
    }

    /**
     * 假设k=3写死
     * @return
     */
    public static int[] reverseArray1(int[] nums) {
        int k =3;

        int len = nums.length;
        int i = len/3;

        for (int j = 1; j <= i;j++) {
            int temp = nums[j * k - 1];
            nums[j * k - 1] = nums[j * k - 3];
            nums[j * k - 3] = temp;
        }

        if (len%3 == 2) {
            int temp = nums[len - 1];
            nums[len - 1] = nums[len - 2];
            nums[len - 2] = temp;
        }

        System.out.println(Arrays.toString(nums));

        return nums;
    }

    /**
     * 假设 0 < k <= nums.lengh.
     * 解法1：
     * @return
     */
//    public static int[] reverseArray1(int[] nums, int k) {
}
