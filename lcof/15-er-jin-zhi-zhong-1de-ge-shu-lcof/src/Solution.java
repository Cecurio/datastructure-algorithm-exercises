/**
 * @author shanxiaokai
 * @date 2021/3/19 18:08
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        for(int i=0; i<32; i++) {
            int t = n & (1 << i);
            if(t != 0) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int a = 0b00000000000000000000000000001011;
        System.out.println(sol.hammingWeight(a));
    }
}
