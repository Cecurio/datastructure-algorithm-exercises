import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 使用堆解决topk问题
 * @author shanxiaokai
 * @date 2021/3/22 18:04
 */
public class Solution3 {

    class MaxComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer num1, Integer num2) {
            return  num1 >= num2 ? -1 : 1;
        }
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0 || arr == null || arr.length == 0) {
            return new int[]{};
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new MaxComparator());
        for (Integer num : arr) {
            if(maxHeap.size() < k) {
                maxHeap.offer(num);
            } else if(num < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(num);
            }
        }
        int[] res = new int[k];
        int idx = 0;
        for (Integer i : maxHeap) {
            res[idx++] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,2,0,5};
        Solution3 sol = new Solution3();
        System.out.println(Arrays.toString(sol.getLeastNumbers(nums, 0)));
    }
}
