import util.TreeNode;

import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class util.TreeNode {
 * int val;
 * util.TreeNode left;
 * util.TreeNode right;
 * util.TreeNode() {}
 * util.TreeNode(int val) { this.val = val; }
 * util.TreeNode(int val, util.TreeNode left, util.TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 *
 * @author shanxiaokai
 * @date 2021/3/19 16:21
 * @author shanxiaokai
 * @date 2021/3/19 16:21
 * @author shanxiaokai
 * @date 2021/3/19 16:21
 */

/**
 * @author shanxiaokai
 * @date 2021/3/19 16:21
 */

//输入：
//[1,2,2,2,null,2]
//输出：
//true
//预期：
//false

/**
 * 经检验：上面的测试用例无法通过
 *
 * 此种解法是错误的
 */

class SolutionError {
    ArrayList<Integer> pre;
    ArrayList<Integer> post;

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        pre = new ArrayList<>();
        post = new ArrayList<>();
        preOrder(root);
        postOrder(root);
        for (int i = 0; i < pre.size(); i++) {
            if (!pre.get(i).equals(post.get(i))) return false;
        }
        return true;
    }

    void preOrder(TreeNode root) {
        if (root != null) {
            preOrder(root.left);
            pre.add(root.val);
            preOrder(root.right);
        }
    }

    void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.right);
            post.add(root.val);
            postOrder(root.left);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(3);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        SolutionError sol = new SolutionError();
        System.out.println(sol.isSymmetric(root));
        System.out.println("done");

    }
}