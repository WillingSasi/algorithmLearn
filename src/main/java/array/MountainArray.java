package array;

import java.util.Arrays;

/**
 * 一个山峰型数组（先单调增后单调减），对数组去重排序并输出，比如 输入[1,3,5,6,4,3,2,1]，去重并排序后输出[1,2,3,4,5,6]，要求时间复杂度O(n)，空间复杂度O(1)
 * 1.插入法，从后依次取值往前判断插入位置，相同跳过，可插入时所有元素依次后移一位
 */
public class MountainArray {
    public static void main(String[] args) {
        int[] a = {1,3,5,6,4,3,2,1};
        System.out.println(Arrays.toString(mountainArray1(a)));
    }

    /**
     * 1.插入法，从后依次取值往前判断插入位置，相同跳过，可插入时所有元素依次后移一位
     * 事实上，此题还有很多场景未考虑到，比如[1,3,5,6,4,3,2,-1]，[1,3,3,6,4,3,2,1]如果有特殊情况还得判断处理，再次不做研究
     * @param a
     * @return
     */
    public static int[] mountainArray1(int[] a) {
        int len = a.length;

        int left = 0;
        int right = len - 1;
        int temp = 0;

        while (left < right) {
            if (a[right] == a[left]) {
                right--;
            } else if (a[right] > a[left] && a[right] < a[left + 1]) {
                temp = a[right];
                for  (int j = right;j > left + 1;j--) {
                    a[j] = a[j - 1];
                }
                a[left + 1] = temp;

                left++;
            }else {
                left++;
            }
        }

        int[] newA = new int[right + 1];
        for (int i =  0;i < right + 1;i++) {
            newA[i] = a[i];
        }

        return newA;
    }
}
