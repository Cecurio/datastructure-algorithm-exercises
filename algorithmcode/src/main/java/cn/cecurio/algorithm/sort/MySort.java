package cn.cecurio.algorithm.sort;

public class MySort {
    // 升序
    // 直接插入排序，最坏的情况是 待排序列是递减序列
    public static void insertSort(int[] data) {

        for (int i = 1; i < data.length; i++) {
            for (int j = i; j > 0; j--) {
                if (data[j] >= data[j - 1]) {
                    break;
                }

                int t = data[j];
                data[j] = data[j - 1];
                data[j - 1] = t;

            }
        }
    }

    // 交换排序 之 冒泡排序
    // 升序 ， 如果把 data[0] ... data[n-1] 看成一摞从上至下排列的盘子的话， 下面这种方式是大的盘子往下降
    public static void bubbleSort(int[] data) {
        int len = data.length;

        for (int i = 0; i <= len - 2; ++i) {
            for (int j = 0; j <= len - 2 - i; ++j) {
                if (data[j] > data[j + 1]) {
                    int t = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = t;
                }
            }
        }
    }

    // 升序 ， 最小的往前去，第一趟确定最小的 ， 这才是 往上冒泡
    public static void bubbleSort2(int[] data) {
        int len = data.length;

        for (int i = 0; i <= len - 2; ++i) {
            for (int j = len - 1; j >= 1 + i; --j) {
                if (data[j] < data[j - 1]) {
                    int t = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = t;
                }
            }
        }
    }

}
