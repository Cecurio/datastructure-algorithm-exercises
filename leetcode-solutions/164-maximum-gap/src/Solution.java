import java.util.Arrays;

public class Solution {

    public int maximumGap(int[] nums) {

        // 处理类似[1]这种输入
        if (nums.length <= 1) return 0;
        int n = nums.length;

        int max = -1, min = Integer.MAX_VALUE;
        // 找出序列的最小值 最大值
        for (int i = 0; i < n; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }
        // 处理[1,1,1,1]这样的元素全相等输入
        if (max - min == 0) return 0;

        // 作了此判断，下面的处理针对数组元素个数大于三的
        if(nums.length == 2) return max - min;


        // n个元素，要有n-1个桶
        int[] bucketMin = new int[n - 1];
        int[] bucketMax = new int[n - 1];
        Arrays.fill(bucketMax, -1);
        Arrays.fill(bucketMin, Integer.MAX_VALUE);

        bucketMin[0] = min;
        bucketMax[0] = min;
        bucketMax[n-2] = max;
        bucketMin[n-2] = max;


        // 求出平均间距
        int interval = (int) Math.ceil((double) (max - min) / (n - 1));
        // 把元素放入桶中
        for (int i = 0; i < nums.length; i++) {
            int ID = (nums[i] - min) / interval;
            // max min已经放入桶中，故此处不放入桶中
            if(nums[i] == min || nums[i] == max)    continue;
            bucketMax[ID] = Math.max(bucketMax[ID], nums[i]);
            bucketMin[ID] = Math.min(bucketMin[ID], nums[i]);
        }

        int maxGap = 0;
        int previousMax = bucketMax[0];
        // 对n-1个桶进行处理
        for (int i = 1; i < n - 1; i++) {
            // 说明是空桶
            if (bucketMax[i] == -1) continue;
            // 后边桶的最小值 减去 前边桶的最大值，得到可能的最大间距
            maxGap = Math.max(bucketMin[i] - previousMax, maxGap);
            previousMax = bucketMax[i];
        }

        //1, 100000
        //maxGap = Math.max(maxGap, max - previousMax);
        return maxGap;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        int[] nums = {3, 6, 9, 1};
//        int[] nums = {100000, 1};
//        int[] nums = {100, 3, 1};
        int[] nums = {100,3,2,1};
        System.out.println(sol.maximumGap(nums));
    }
}
