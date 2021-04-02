import java.util.Arrays;

/**
 * @author shanxiaokai
 * @date 2021/3/20 0:57
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int g_i = 0;
        int s_i = 0;
        int res = 0;
        while (g_i < g.length && s_i < s.length) {
            if(g[g_i] <= s[s_i]) {
                g_i++;
                s_i++;
                res++;
            } else {
                s_i++;
            }
        }
        return res;
    }
}
