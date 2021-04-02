import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author shanxiaokai
 * @date 2021/3/22 17:39
 */
public class Solution2 {

    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            minHeap.offer(arr[i]);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();

    }
}
