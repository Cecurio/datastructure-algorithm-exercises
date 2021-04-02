import org.omg.PortableInterceptor.INACTIVE;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shanxiaokai
 * @date 2021/3/31 23:28
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            go(triangle, n - 1, i, dp);

        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(dp[n - 1][i], res);
        }
        return res;


    }

    private int go(List<List<Integer>> triangle, int i,
                   int j, int[][] dp) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (i == 0) return dp[i][j] = triangle.get(i).get(j);

        if (j == 0) return dp[i][j] = triangle.get(i).get(j) + go(triangle, i - 1, 0, dp);

        if (j == i) return dp[i][j] = triangle.get(i).get(j) + go(triangle, i - 1, i - 1, dp);

        return dp[i][j] = triangle.get(i).get(j) + Math.min(go(triangle, i - 1, j - 1, dp), go(triangle, i - 1, j, dp));

    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        Solution sol = new Solution();
        System.out.println(sol.minimumTotal(triangle));

    }


}
