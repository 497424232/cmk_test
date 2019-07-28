package cmk.suanfa.sort;

import java.util.Random;

/**
 *
 * 快速排序
 * @auther changmk
 * @date 2019/7/28 下午5:58
 */
public class quickSort {
    public static void main(String[] args) {

        int[] array = new int[]{5,4,8,3,67,22,7,1};

        qucikSortMethod(array, 0, array.length - 1);

        for (int i : array) {
            System.out.println(i);
        }
        System.out.println(array);

        int [] arrays = new int[1000000];
        Random random = new Random();
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = random.nextInt();
        }

        long stattime = System.currentTimeMillis();
        qucikSortMethod(arrays, 0 , arrays.length -1);
        long enttime = System.currentTimeMillis();

        System.out.println(enttime - stattime);

    }

    /**
     * 快速排序方法
     * 选择基数后，先从右往左比对，再从左往右比对
     * @param array     数组
     * @param left      左边开始
     * @param right     结束位置
     */
    public static void qucikSortMethod(int[] array, int left, int right) {
        if (left > right) {
            return;
        }

        int i = left;
        int j = right;
        int base = array[left];

        while (i != j) {//todo 注意是i和j

            //j 从右往左检索，如果碰到比基数小的就停下
            //如果碰见比基数大的则继续检索
            while (array[j] >= base && i < j) {//todo 注意增加i<j这个条件
                j--;    //j从右往左移动
            }
            //i 从左往右检索
            while (array[i] <= base && i < j) {
                i++;    //i 从左往右移动
            }
            //走到这里交换 i和j 的位置
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        //while 条件不成立后，走到了这里
        //交换基数和ij相遇处的数字
        array[left] = array[i];
        array[i] = base;

        //基数在这里归位了，左边的都比基数小，右边的都比基数大
        //继续排序左边的
        qucikSortMethod(array, left, i -1);
        //继续排序右边的
        qucikSortMethod(array, j + 1, right);
    }
}
