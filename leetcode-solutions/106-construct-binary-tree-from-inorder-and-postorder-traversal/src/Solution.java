import java.util.Arrays;

/**
 * @author shanxiaokai
 * @date 2021/3/17 11:26
 */
public class Solution {
    int count=0;

    /**
     * 时间复杂度：O(N), 但是额外创建新数组的时间复杂度应该是O(nlogn)
     * 空间复杂度：O(nlogn)
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        System.out.println(count++);
        System.out.println(Arrays.toString(inorder));
        System.out.println(Arrays.toString(postorder));
        if (postorder == null || inorder == null) return null;
        if (postorder.length != inorder.length) return null;
        if (postorder.length == 0) return null;
        int left = 0;
        int right = inorder.length - 1;
        // 只有一个元素
        if (left == right) return new TreeNode(inorder[0]);

        int rootValue = postorder[right];
        int idx = getIndex(inorder, rootValue);
        TreeNode root = new TreeNode(rootValue);
        TreeNode leftNode = buildTree(Arrays.copyOfRange(inorder, 0, idx),
                Arrays.copyOfRange(postorder, 0, idx));
        TreeNode rightNode = buildTree(Arrays.copyOfRange(inorder, idx + 1, right + 1),
                Arrays.copyOfRange(postorder, idx, right));
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    int getIndex(int[] arr, int v) {
        for (int i = 0; i < arr.length; i++) {
            if (v == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        test1();

    }

    static void test1() {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        Solution sol = new Solution();
        TreeNode root = sol.buildTree(inorder, postorder);
        System.out.println("done");
    }
}
