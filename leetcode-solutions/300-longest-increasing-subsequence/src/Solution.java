import java.util.Arrays;

/**
 * @author shanxiaokai
 * @date 2021/3/22 10:15
 */
public class Solution {
    private int[] nums;
    private int[] tab;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        this.tab = new int[n];
        int max = -1;
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, fun(i));
        }
        return max;
        //int res2 = fun(n-2);
        //int res3 = fun(n-3);
        //System.out.println(res2);
        //System.out.println("res3 = "+res3);
    }

    private int fun(int n) {
        //System.out.println(String.format("enter fun(%d)", n));
        if (this.tab[n] != 0) return this.tab[n];
        int a = 1;
        // 查看[0,1,2,...,n-1]处的元素是否小于n处的元素，如果小于
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[n]) {
                a = Math.max(a, fun(i) + 1);
            }
        }
        //System.out.println(String.format("end fun(%d)", n));
        this.tab[n] = a;
        return a;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        int[] nums = {10,9,2,5,3,7,101,18};
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(sol.lengthOfLIS(nums));
        System.out.println(Arrays.toString(sol.nums));
        System.out.println(Arrays.toString(sol.tab));
    }
}
