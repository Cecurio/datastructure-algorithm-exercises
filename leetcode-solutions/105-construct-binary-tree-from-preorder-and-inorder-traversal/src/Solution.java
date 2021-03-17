

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
public class Solution {
    int count = 1;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        System.out.println(count++);
        System.out.println(Arrays.toString(preorder));
        System.out.println(Arrays.toString(inorder));
        if (preorder == null || inorder == null) return null;
        if (preorder.length != inorder.length) return null;
        if (preorder.length == 0) return null;
        int left = 0;
        int right = preorder.length - 1;
        // 只有一个元素
        if (left == right) return new TreeNode(preorder[0]);

        int rootValue = preorder[left];
        int idx = getIndex(inorder, rootValue);
        TreeNode root = new TreeNode(rootValue);
        TreeNode leftNode = buildTree(Arrays.copyOfRange(preorder, 1, idx - left + 1),
                Arrays.copyOfRange(inorder, left, idx));
        TreeNode rightNode = buildTree(Arrays.copyOfRange(preorder, idx - left + 1, right + 1),
                Arrays.copyOfRange(inorder, idx + 1, right + 1));
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
        test2();
    }

    static void test1(){
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        Solution sol = new Solution();
        TreeNode root = sol.buildTree(preorder, inorder);
        System.out.println("done");
    }

    static void test2(){
        Solution sol = new Solution();
        int[] preorder = {3, 9, 20, 15};
        int[] inorder = {9, 3, 15, 20};

        TreeNode root = sol.buildTree(preorder, inorder);
        System.out.println("done");
    }
}
