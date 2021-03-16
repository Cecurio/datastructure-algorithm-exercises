import java.util.Arrays;

/**
 * @author shanxiaokai
 * @date 2021/3/15 23:15
 */
public class PriorityQueue {
    // 用数组存储数据结构
    private int[] array;

    // 队列的当前总长度
    private int size;

    // 构造函数
    public PriorityQueue() {
        this.array = new int[3];
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 入队
    public void enQueue(int elem) {
        if (size >= array.length) resize();
        this.array[size++] = elem;
        // 一个元素，根本没必要把元素上升
        if (size > 1) upAdjust();
    }

    // 出队
    public int deQueue() {
        if (size == 0) throw new RuntimeException("the queue is empty!");
        int res = this.array[0];
        this.array[0] = this.array[--size];
        downAdjust();
        return res;
    }

    // 扩容函数
    private void resize() {
        int newSize = 2 * this.array.length;

//        int[] newArray = new int[newSize];
//        for (int i = 0; i < this.size; i++) {
//            newArray[i] = this.array[i];
//        }
//        this.array = newArray;
        // 上面的代码换成这个更高效，调用系统的底层实现
        this.array = Arrays.copyOf(this.array, newSize);
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private void upAdjust() {
        int childIndex = this.size - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = this.array[childIndex];
        while (childIndex > 0 && temp > this.array[parentIndex]) {
            this.array[childIndex] = this.array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        this.array[childIndex] = temp;
    }

    private void downAdjust() {
        int parentIndex = 0;
        int temp = this.array[parentIndex];
        // 左孩子节点
        int childIndex = 1;
        // 首先要判断有没有左孩子节点
        while (childIndex < this.size) {
            // 如果有右孩子节点，并且比左孩子节点小，则右孩子节点与根节点交换
            if (childIndex + 1 < this.size && this.array[childIndex + 1] > this.array[childIndex]) {
                childIndex++;
            }

            if (this.array[childIndex] < temp) {
                break;
            }
            this.array[parentIndex] = this.array[childIndex];
            // 父索引 往下移动
            parentIndex = childIndex;
            // 然后也要更新
            childIndex = (2 * parentIndex + 1);
        }
        // 最后把一开始要下沉的值(暂存在temp中了)放在合适的位置
        this.array[parentIndex] = temp;
    }


    public static void main(String[] args) {
        PriorityQueue q = new PriorityQueue();
        q.enQueue(5);
        q.enQueue(36);
        q.enQueue(8);
        q.enQueue(11);
        q.enQueue(17);
        while (!q.isEmpty()){
            System.out.println(q.deQueue());
        }
    }
}
