package cn.cecurio.algorithm.tree;

import org.junit.Test;

public class TreeTest {

    @Test
    public void test1() {
        Tree tree = new Tree();

        TreeNode a = new TreeNode("A");
        TreeNode b = new TreeNode("B");
        TreeNode c = new TreeNode("C");
        TreeNode d = new TreeNode("D");
        TreeNode e = new TreeNode("E");
        TreeNode f = new TreeNode("F");
        TreeNode g = new TreeNode("G");
        TreeNode h = new TreeNode("H");

        a.setLchild(b);
        b.setLchild(c);
        c.setLchild(d);
        d.setLchild(e);

        a.setRchild(f);
        f.setRchild(g);
        g.setRchild(h);

        tree.setRoot(a);

        tree.preOrderTravelNoRecursion();

    }

    @Test
    public void test2() {
        Tree tree = new Tree();

        TreeNode a = new TreeNode("A");
        TreeNode b = new TreeNode("B");
        TreeNode c = new TreeNode("C");
        TreeNode d = new TreeNode("D");
        TreeNode e = new TreeNode("E");
        TreeNode f = new TreeNode("F");
        TreeNode g = new TreeNode("G");
        TreeNode h = new TreeNode("H");

        a.setLchild(b);
        b.setRchild(c);
        c.setLchild(d);
        c.setRchild(e);
        e.setLchild(f);

        a.setRchild(g);
        g.setLchild(h);

        tree.setRoot(a);

        System.out.println("前序遍历：");
        tree.preOrderTravel();
        tree.preOrderTravelNoRecursion();

        System.out.println("前序遍历：");
        tree.inOrderTravel();
        tree.inOrderTravelNoRecursion();

        System.out.println("前序遍历：");
        tree.postOrderTravel();
        tree.postOrderTravelNoRecursion();
    }
}
