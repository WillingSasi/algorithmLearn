package array;

/**
 * 来源：度小满测开
 * 牛客NC19 Easy
 *
 * 给定一个长度为 n 的数组 arr ，返回其中任意连续子数组的最大累加和
 * 输入：[1, -2, 3, 5, -2, 6, -1] 输出：12 说明：[3,6]范围内的子数组之和最大，3+5-2+6=12
 */
public class MaxAccumulationSum {

    public static void main(String[] args) {
        int[] array = {1, -2, 3, 5, -2, 6, -1};
        int[] array1 = {1,-2,3,10,-4,7,2,-5};
        System.out.println(maxAccumulationSum1(array));
        System.out.println(maxAccumulationSum1(array1));
        System.out.println(maxAccumulationSum2(array));
        System.out.println(maxAccumulationSum2(array1));
    }

    /**
     * 解法1：贪心算法，依次相加对比，只取累加正区间的值
     * @param array
     * @return
     */
    public static int maxAccumulationSum1(int[] array) {
        if (array.length == 1) {
            return array[0];
        }

        int sum = 0;
        int max = array[0];

        for (int i : array) {
            sum += i;

            if (sum > max) {
                max = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }

    /**
     * 解法2：用动态规划dp【】数组记录当前最大和，遍历完数组后最后一个就是最大和
     * @param array
     * @return
     */
    public static int maxAccumulationSum2(int[] array) {
        if (array.length == 1) {
            return array[0];
        }

        int[] dp = new int[array.length];
        dp[0] = array[0];
        int temp =Integer.MIN_VALUE;

        for (int i = 1;i < array.length;i++) {
            dp[i] = Math.max(array[i], dp[i-1] + array[i]);
            temp = Math.max(temp, dp[i]);

        }
        return temp;
    }
}
