import java.util.Arrays;
import java.util.HashMap;

/**
 * @author shanxiaokai
 * @date 2021/3/17 11:26
 */
public class Solution2 {

    HashMap<Integer, Integer> map = new HashMap<>();
    int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursive(postorder.length - 1, 0, inorder.length - 1);
    }

    TreeNode recursive(int post_root_idx, int in_left_idx, int in_right_idx) {
        System.out.println(String.format("recursive(%d,%d,%d)", post_root_idx, in_left_idx, in_right_idx));
        if (in_left_idx == in_right_idx) return new TreeNode(this.postorder[post_root_idx]);
        if (in_left_idx > in_right_idx) return null;

        int rootValue = this.postorder[post_root_idx];

        TreeNode root = new TreeNode(rootValue);

        int idx = map.get(rootValue);

        root.left = recursive(post_root_idx- in_right_idx + idx -1, in_left_idx, idx - 1);
        root.right = recursive(post_root_idx - 1, idx + 1, in_right_idx);

        return root;
    }


    public static void main(String[] args) {
        test1();

    }

    static void test1() {
        int[] inorder = {9, 3, 15, 20};
        int[] postorder = {9, 15,  20, 3};
        Solution2 sol = new Solution2();
        TreeNode root = sol.buildTree(inorder, postorder);
        System.out.println("done");
    }
}
