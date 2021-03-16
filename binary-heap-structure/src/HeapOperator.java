import java.util.Arrays;

/**
 * 二叉堆的操作
 * 二叉堆是实现堆排序和优先队列的基础
 * <p>
 * 二叉堆本质上是一种完全二叉树
 * <p>
 * 最大堆的堆顶是整个堆中的最大元素
 * 最小堆的堆顶是整个堆中的最小元素
 */
public class HeapOperator {
    /**
     * 向上调整尾部元素
     *
     * @param array
     */
    public static void upAdjust(int[] array) {
        int n = array.length;
        int childIndex = n - 1;
        int parentIndex = (childIndex - 1) / 2;
        while (childIndex > 0) {
            if (array[childIndex] < array[parentIndex]) {
                swap(array, parentIndex, childIndex);
            }
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
    }

    public static void upAdjustOpt(int[] array) {
        int n = array.length;
        int childIndex = n - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = array[childIndex];
        while (childIndex > 0 && temp < array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            //System.out.println(Arrays.toString(array));
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    /**
     * @param array
     * @param parentIndex
     * @param length      二叉堆对应的数组的长度
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        //System.out.println(Arrays.toString(array));
        int moveIndex = parentIndex;
        int temp = array[moveIndex];
        int minIndex = 0;
        int leftChildIndex = 2 * moveIndex + 1;

        int rightChildIndex = 2 * moveIndex + 2;
        if (leftChildIndex >= length) return;
        if (rightChildIndex >= length) {
            minIndex = leftChildIndex;
        } else {
            minIndex = array[leftChildIndex] < array[rightChildIndex] ? leftChildIndex : rightChildIndex;
        }

        while (minIndex < length && temp > array[minIndex]) {
            array[moveIndex] = array[minIndex];

            moveIndex = minIndex;

            leftChildIndex = 2 * moveIndex + 1;
            if (leftChildIndex >= length) {
                break;
            }
            rightChildIndex = 2 * moveIndex + 2;
            if (rightChildIndex >= length) {
                minIndex = leftChildIndex;
            } else {
                minIndex = array[leftChildIndex] < array[rightChildIndex] ? leftChildIndex : rightChildIndex;
            }
        }
        array[moveIndex] = temp;
    }

    public static void downAdjustOpt(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        // 左孩子节点
        int childIndex = (2 * parentIndex + 1);
        // 首先要判断有没有左孩子节点
        while (childIndex < length) {
            // 如果有右孩子节点，并且比左孩子节点小，则右孩子节点与根节点交换
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }

            if (temp <= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            // 父索引 往下移动
            parentIndex = childIndex;
            // 然后也要更新
            childIndex = (2 * parentIndex + 1);
        }
        // 最后把一开始要下沉的值(暂存在temp中了)放在合适的位置
        array[parentIndex] = temp;
    }


    /**
     * 建堆，从最后一个 非叶子结点 开始，依次下沉
     * @param array
     */
    public static void buildHeap(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjustOpt(array, i, array.length);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        //upAdjustOpt(array);

        array = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6, 11};

        //downAdjust(array, 3, array.length - 1);
        System.out.println(Arrays.toString(array));
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }
}
