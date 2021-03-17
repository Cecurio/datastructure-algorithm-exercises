import java.util.Arrays;

/**
 * @author shanxiaokai
 * @date 2021/3/16 9:36
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int lr = 0, lc = 0, rr = n - 1, rc = n - 1;
        int value = 1;
        while (lr <= rr && lc <= rc) {
            if (lr == rr) {
                // 只有一行
                while (lc <= rc) {
                    res[lr][lc] = value++;
                    lc++;
                }
            } else if (lc == rc) {
                // 只有一列
                while (lr <= rr) {
                    res[lr][lc] = value++;
                    lr++;
                }
            } else {
                // 行列都大于1
                int curR = lr;
                int curC = lc;
                while (curC < rc) {
                    res[lr][curC] = value++;
                    curC++;
                }
                while (curR < rr) {
                    res[curR][rc] = value++;
                    curR++;
                }
                while (curC > lc) {
                    res[rr][curC] = value++;
                    curC--;
                }
                while (curR > lr) {
                    res[curR][lc] = value++;
                    curR--;
                }
            }


            lr++;
            lc++;
            rr--;
            rc--;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] res=sol.generateMatrix(1);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}