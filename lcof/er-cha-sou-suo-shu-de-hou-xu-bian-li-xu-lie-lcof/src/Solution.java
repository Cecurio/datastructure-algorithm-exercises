/**
 * @author shanxiaokai
 * @date 2021/3/19 12:09
 */
public class Solution {

    //[1,3,2,6,5]
    private int[] postorder;

    public boolean verifyPostorder(int[] postorder) {
        this.postorder = postorder;
        return fun(0, postorder.length - 1);
    }

    private boolean fun(int left, int right) {
        System.out.println(String.format("fun(%d, %d)", left, right));
        // 此处一定得是 >=
        if (left >= right) return true;

        int root = postorder[right];
        int idx = 0;
        for (idx = left; postorder[idx] < root; idx++) {
        }

        // [idx, right-1]
        for (int i = idx; i < right; i++) {
            if (postorder[i] < root) return false;
        }

        // 左边的子树
        // [left,idx-1]
        return fun(left, idx - 1) && fun(idx, right - 1);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        //System.out.println(sol.verifyPostorder(new int[]{1, 3, 2, 6, 5}));
        //System.out.println(sol.verifyPostorder(new int[]{1, 6, 3, 2, 5}));
        System.out.println(sol.verifyPostorder(new int[]{1, 2, 5, 10, 6, 9, 4, 3}));
    }
}
