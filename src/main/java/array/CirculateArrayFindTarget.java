package array;

/**
 * 循环数组，找出可插入目标值target的下标index
 * 1.直接查找，做好几个规则的多重判断，时间复杂度N
 * 2.先扩展移动，或者反转数组，形成无循环排序数组，然后二分查找，最后计算index，时间复杂度logN？
 */
public class CirculateArrayFindTarget {
    public static void main(String[] args) {
        int[] nums = {4,6,8,10,0,2};
        int target = 5;

        System.out.println(circulateArrayFindTarget2(nums, target));
    }

    /**
     * 1.直接查找，做好几个规则的多重判断，时间复杂度N
     * @param nums
     * @param target
     * @return
     */
    public static int circulateArrayFindTarget1(int[] nums, int target) {
        int len = nums.length;

        for (int i = 0;i < len -1;i++) {
            if (nums[i] <= target && target <= nums[i+1]) {
                return i + 1;
            }

            if (nums[i] > nums[i+1] ) {
                if ((target >= nums[i] && target >= nums[i+1]) || (target <= nums[i] && target <= nums[i+1]))
                return i + 1;
            }
        }

        if (nums[len - 1] <= target && target <= nums[0]) {
            return 0;
        }

        return -1;
    }

    /**
     * 2.先扩展移动，或者反转数组，形成无循环排序数组，然后二分查找，最后计算index，时间复杂度NlogN, logN？
     * 关键在于反转或移动消除循环，最后还得计算反转后的index
     * @param nums
     * @param target
     * @return
     */
    public static int circulateArrayFindTarget2(int[] nums, int target) {
        int len = nums.length;
        int index  = 0;
        int left = 0;
        int right = len - 1;

        for (int i = 0;i < len;i++) {
            if(nums[i] > nums[i+1]) {
                index = i;
                break;
            }
        }

        revNums(nums, left, index);
        revNums(nums, index+1, right);

        while (left < right) {
            int mid = (left + right)/2;

            if (nums[mid] > target){
                left = mid;
            } else {
                right = mid;
            }
        }

        if (left < index) {
            return index - left;
        } else {
            return index + (right -left);
        }
    }

    public static int[] revNums(int[] a, int first, int last) {
        for (int i = first;i <= (last+first)/2;i++) {
            int flag = a[i];
            a[i] = a[last -i];
            a[last -i] = flag;
        }
        return a;
    }
}