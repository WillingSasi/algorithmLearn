package array;

import java.util.Arrays;

/**
 * 来源：度小满测开
 *
 * 牛客原题 NC22 合并两个有序的数组 Easy
 * 输入：[4,5,6],[1,2,3] 返回值：[1,2,3,4,5,6]
 * 说明：A数组为[4,5,6]，B数组为[1,2,3]，后台程序会预先将A扩容为[4,5,6,0,0,0]，B还是为[1,2,3]，m=3，n=3，
 * 传入到函数merge里面，然后请同学完成merge函数，将B的数据合并A里面，最后后台程序输出A数组
 */
public class TwoSortArrayMerge {

    public static void main(String[] args) {
        int[] A = {4,5,6};
        int[] B = {1,2,3};

        int[] A1 = {1,5,6};
        int[] B1 = {1,2,3};

//        twoSortArrayMerge1(A, 3, B, 3);
        twoSortArrayMerge2(A, 3, B, 3);
//        twoSortArrayMerge3(A, 3, B, 3);
    }

    /**
     * 解法1：投机取巧，用内置函数sort
     */
    public static void twoSortArrayMerge1(int A[], int m, int B[], int n) {
        A = expansionArray(A, m+n);

        for (int i = m;i < m+n;i++) {
            A[i] = B[i - m];
        }

        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
    }

    /**
     * 解法2：三指针插入法，分别从m-1，m-1，m+n-1三个位置，倒序对比插入A，不涉及多元素位移
     * ！错误思考！：双指针插入法，从B不断取数从头插入A，直到A[m-1]（大错特错）其中设计元素位移，复杂度太大，实现逻辑也复杂
     */
    public static void twoSortArrayMerge2(int A[], int m, int B[], int n) {
        A = expansionArray(A, m+n);

        int index = m + n -1;
        int i = m - 1;
        int j = n - 1;

        while (i >= 0 && j >= 0) {
            A[index--] = A[i] >= B[j] ? A[i--] : B[j--];
        }

        if (j >= 0) {
            System.arraycopy(B, 0, A, 0, j+1);
        }

        System.out.println(Arrays.toString(A));
    }

    /**
     * 解法3：新建数组C，AB依次比较后插入C，最后C赋值到A
     */
    public static void twoSortArrayMerge3(int A[], int m, int B[], int n) {
        A = expansionArray(A, m + n);
        int[] C = new int[m + n];

        int i = 0;
        int j = 0;
        int index = 0;
        while (i < m && j < n) {
            C[index++] = A[i] <= B[j] ? A[i++] : B[j++];
        }

        if (i == m) {
            System.arraycopy(B, j, C, index, n-j);
        }else {
            System.arraycopy(A, i, C, index, m-i);
        }

        System.arraycopy(C, 0, A, 0, m+n);
        System.out.println(Arrays.toString(A));
    }

    /**
     * 数组扩容的三种方法
     * 1.new新数组再for循环插值
     * 2.Arrays.copyOf，其实该函数内部也是用3实现的
     * 3.System.arraycopy
     * 注：基本类型默认填充值是各类型的0，引用内容默认填充值是null
     * @param A
     * @param expansionSize
     * @return int[]
     */
    public static int[] expansionArray(int[] A, int expansionSize){
        //方法1
        int[] newA = new int[expansionSize];
        for (int i = 0;i < expansionSize - A.length;i++) {
            newA[i] = A[i];
        }
        System.out.println("扩容方法1" + Arrays.toString(newA));

        //方法2
        int[] newB = Arrays.copyOf(A, expansionSize);
        System.out.println("扩容方法2" + Arrays.toString(newB));

        //方法3
        int[] newC = new int[expansionSize];
        System.arraycopy(A, 0, newC, 0,expansionSize - A.length);
        System.out.println("扩容方法3" + Arrays.toString(newC));

        return newA;
    }
}
