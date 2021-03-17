

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

import java.util.Arrays;

/**
 * @author shanxiaokai
 * @date 2021/3/16 16:31
 */
public class SolutionDebug {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        System.out.println(Arrays.toString(preorder));
        System.out.println(Arrays.toString(inorder));

        int root = preorder[0];
        int idx = getIndex(inorder, root);
        System.out.println(String.format("在中序序列中，根节点的位置：%d", idx));
        System.out.println(String.format("根节点的左子树的左边界下标：%d，右边界下标：%d", 0, idx - 1));
        System.out.println(String.format("根节点的右子树的左边界下标：%d，右边界下标：%d", idx + 1, inorder.length - 1));

        return fun(preorder, inorder);

    }
    TreeNode fun(int[] preorder, int[] inorder) {
        int left = 0;
        int right = preorder.length - 1;

        if(left == right) return new TreeNode(preorder[0]);

//        System.out.println(left);
//        System.out.println(right);

        int rootValue = preorder[left];
        int idx = getIndex(inorder, rootValue, left, right);
//        System.out.println(String.format("%d -> %d, %d -> %d", left, idx - 1, idx + 1, right));
//
//        System.out.println(Arrays.toString(Arrays.copyOfRange(preorder, 1, idx - left + 1)));
//        System.out.println(Arrays.toString(Arrays.copyOfRange(inorder, left, idx)));
//        System.out.println(Arrays.toString(Arrays.copyOfRange(preorder, idx - left + 1, right + 1)));
//        System.out.println(Arrays.toString(Arrays.copyOfRange(inorder, idx + 1, right + 1)));
        TreeNode root = new TreeNode(rootValue);
        TreeNode leftNode = fun(Arrays.copyOfRange(preorder, 1, idx - left + 1),Arrays.copyOfRange(inorder, left, idx));
        TreeNode rightNode = fun(Arrays.copyOfRange(preorder, idx - left + 1, right + 1),Arrays.copyOfRange(inorder, idx + 1, right + 1));
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    int getIndex(int[] arr, int v, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (v == arr[i]) {
                return i;
            }
        }
        return -1;
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
        SolutionDebug sol = new SolutionDebug();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = sol.buildTree(preorder, inorder);
        System.out.println("done");
    }
}
