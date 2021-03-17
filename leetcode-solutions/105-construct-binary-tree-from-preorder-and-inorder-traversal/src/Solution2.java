import java.util.HashMap;

/**
 * @author shanxiaokai
 * @date 2021/3/17 13:04
 */
public class Solution2 {

    HashMap<Integer, Integer> map = new HashMap<>();
    int[] preorder;

    /**
     * 时间复杂度为 O(N)
     * 空间复杂度为 O(N)
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursive(0, 0, inorder.length - 1);
    }

    /**
     * @param pre_root_idx 前序遍历的根节点的索引
     * @param in_left_idx  中序遍历左边界的索引
     * @param in_right_idx 中序遍历右边界的索引
     * @return
     */
    TreeNode recursive(int pre_root_idx, int in_left_idx, int in_right_idx) {
        System.out.println(String.format("recursive(%d,%d,%d)", pre_root_idx, in_left_idx, in_right_idx));
        if (in_left_idx == in_right_idx) return new TreeNode(this.preorder[pre_root_idx]);
        if (in_left_idx > in_right_idx) return null;

        int rootValue = this.preorder[pre_root_idx];

        TreeNode root = new TreeNode(rootValue);

        int idx = map.get(rootValue);

        root.left = recursive(pre_root_idx + 1, in_left_idx, idx - 1);
        // root.right = recursive(idx + 1, idx + 1, in_right_idx);
        // 与上面的一条语句等价 ✖ 上面的是错误写法，下面的才是对的
        root.right = recursive(idx - in_left_idx + 1 + pre_root_idx, idx + 1, in_right_idx);

        return root;
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int[] preorder = {3, 9, 20, 15};
        int[] inorder = {9, 3, 15, 20};
        TreeNode root = sol.buildTree(preorder, inorder);

    }

    // 错误的用例：
    // 输入：
    //[1,2,3]
    //[2,3,1]
    //输出：
    //[1,2,null,null,2]
    //预期结果：
    //[1,2,null,null,3]
}
