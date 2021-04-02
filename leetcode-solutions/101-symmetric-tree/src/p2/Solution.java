package p2;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shanxiaokai
 * @date 2021/3/19 17:13
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    boolean check(TreeNode t1, TreeNode t2) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(t1);
        queue.add(t2);
        while (!queue.isEmpty()) {
            t1 = queue.remove();
            t2 = queue.remove();
            if(t1 == null && t2 == null) continue;
            if((t1 == null || t2 == null) || (t1.val != t2.val)) {
                return false;
            }
            queue.add(t1.left);
            queue.add(t2.right);

            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
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
