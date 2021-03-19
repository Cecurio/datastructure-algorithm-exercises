import java.util.HashMap;

/**
 * @author shanxiaokai
 * @date 2021/3/19 14:08
 */
public class Solution {
    HashMap<Integer, Integer> map = new HashMap();

    public int climbStairs(int n) {
        return fun(n);
    }

    int fun(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(map.containsKey(n)) return map.get(n);
        int res =  fun(n - 1) + fun(n - 2);
        map.put(n, res);
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.climbStairs(3));
    }
}
