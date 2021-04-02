import util.TreeNode;

/**
 * @author shanxiaokai
 * @date 2021/3/19 16:47
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        return fun(root, root);
    }

    boolean fun(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        if(t1.val != t2.val) return false;
        return fun(t1.left, t2.right) && fun(t1.right, t2.left);
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
        Solution sol = new Solution();
        System.out.println(sol.isSymmetric(root));
    }
}
