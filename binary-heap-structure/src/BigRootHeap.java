import java.util.Arrays;

/**
 * @author shanxiaokai
 * @date 2021/3/15 21:32
 */
public class BigRootHeap {


    public static void upAdjust(int[] array) {
        int n = array.length;
        int childIndex = n - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = array[childIndex];
        while (childIndex > 0 && temp > array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            //System.out.println(Arrays.toString(array));
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    public static void downAdjust(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        // 左孩子节点
        int childIndex = (2 * parentIndex + 1);
        // 首先要判断有没有左孩子节点
        while (childIndex < length) {
            // 如果有右孩子节点，并且比左孩子节点小，则右孩子节点与根节点交换
            if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }

            if (array[childIndex] < temp) {
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
     *
     * @param array
     */
    public static void buildHeap(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
    }

    public static void heapSort(int[] array) {
        buildHeap(array);
        int lastIndex = array.length - 1;
        while (lastIndex > 0) {
            swap(array, 0, lastIndex);
            downAdjust(array, 0, lastIndex);
            lastIndex--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{10, 8, 9, 7, 5, 4, 6, 3, 2};
        heapSort(array);
        System.out.println(Arrays.toString(array));

    }
}
