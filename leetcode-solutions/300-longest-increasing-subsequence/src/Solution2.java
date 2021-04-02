import java.util.Arrays;

/**
 * @author shanxiaokai
 * @date 2021/3/22 11:28
 */
public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxans = -1;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            // 首先一个元素本身就是一个长度为1的子序列
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {

                    // 此处状态转移
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }


    public static void main(String[] args) {
        Solution2 sol = new Solution2();
//        int[] nums = {10,9,2,5,3,7,101,18};
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(sol.lengthOfLIS(nums));

    }
}
