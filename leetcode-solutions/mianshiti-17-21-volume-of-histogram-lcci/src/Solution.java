/**
 * @author shanxiaokai
 * @date 2021/4/2 19:59
 */
public class Solution {
    /**
     * 暴力解法
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for (int i = 1; i < n - 1; i++) {
            int left = i - 1;
            int right = i + 1;
            int lMax = -1;
            int rMax = -1;
            while (left >= 0) {
                lMax = Math.max(lMax, height[left]);
                left--;
            }
            while (right <= n - 1) {
                rMax = Math.max(rMax, height[right]);
                right++;
            }
            leftMax[i] = lMax;
            rightMax[i] = rMax;
        }
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            int t = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (t > 0) res += t;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Solution sol = new Solution();
        System.out.println(sol.trap(nums));
    }
}
