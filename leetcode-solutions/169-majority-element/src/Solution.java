public class Solution {
    public int majorityElement(int[] nums) {
        int res = nums[0], cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cnt == 0) res = nums[i];
            if (res == nums[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {2, 2, 1, 1, 1, 2, 2, 2};
        System.out.println(sol.majorityElement(nums));
    }
}