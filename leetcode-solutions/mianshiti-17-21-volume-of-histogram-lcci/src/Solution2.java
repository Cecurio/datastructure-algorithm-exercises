/**
 * @author shanxiaokai
 * @date 2021/4/2 19:59
 */
public class Solution2 {

    /**
     * 动态规划的解法
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        // leftMax[i]表示 [0,i] 位置的height最大的值
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0 ; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            int t = Math.min(leftMax[i - 1], rightMax[i + 1]) - height[i];
            if (t > 0) res += t;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Solution2 sol = new Solution2();
        System.out.println(sol.trap(nums));
    }
}
