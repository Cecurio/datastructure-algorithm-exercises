import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author shanxiaokai
 * @date 2021/3/22 17:49
 */
public class MaxHeapUsage {
    // maxHeap
    // 自定义比较器：当compare函数中第一个参数（这里是较大的元素）需要排在前面时，返回一个负数；反之返回一个正数。
    static class MaxComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer num1, Integer num2) {
            return num1 >= num2 ? -1 : 1;
        }
    }

    public static void main(String[] args) {
        // 初始化PriorityQueue的时候new一个自定义比较器的对象
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new MaxComparator());
        maxHeap.offer(5);
        maxHeap.offer(3);
        maxHeap.offer(4);
        maxHeap.offer(1);
        maxHeap.offer(2);

        while(!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }
    }

}
