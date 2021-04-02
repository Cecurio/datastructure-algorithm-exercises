import java.util.Deque;
import java.util.LinkedList;

/**
 * @author shanxiaokai
 * @date 2021/4/2 22:25
 */
public class Solution4 {

    /**
     * 单调栈的解法
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        // 栈存放的是 height数组的下标
        Deque<Integer> st = new LinkedList<>();
        st.push(0);
        int sum = 0;
        for (int i = 1; i < height.length; i++) {
            // while(height[i] > height[st.peek()) 不断往左找 ， 适合 [5,4,3,2,1,7] 这样的用例
            while (!st.isEmpty() && height[i] > height[st.peek()]) {
                int mid = st.pop();
                // 弹出栈顶的元素，必须检验栈中是否有元素
                if (!st.isEmpty()) {
                    int h = Math.min(height[st.peek()], height[i]) - height[mid];
                    int w = i - st.peek() - 1;
                    sum += h * w;
                }
            }
            // 经过while循环 , 要么栈空了， 要么 height[i] <= height[st.peek()]
            // 所以要把此时的下标 入栈
            st.push(i);
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] nums = {5,5,1,6};
        Solution4 sol = new Solution4();
        System.out.println(sol.trap(nums));
        System.out.println(sol.trap(new int[]{5,4,1,6}));
    }
}
