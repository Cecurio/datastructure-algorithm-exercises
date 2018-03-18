package cn.cecurio.algorithm.tree;


import java.util.ArrayList;
import java.util.Stack;

/**
 * binary tree node (TNode)
 * <p>
 * binary tree (BinTree)
 */
public class Tree {

    /**
     * 根节点
     */
    private TreeNode root;

    // 遍历时存放数据的线性表
    private ArrayList<TreeNode> nodes;

    public Tree() {

    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    /**
     * 前序遍历
     **/

    private void preOrderTravel(TreeNode t) {
        // base condition
        if (t == null) return;
        nodes.add(t);
        preOrderTravel(t.getLchild());
        preOrderTravel(t.getRchild());
    }

    public void preOrderTravel() {
        initNodes();
        preOrderTravel(this.root);
        outputNodes();
    }

    /**
     * 非递归 前序遍历二叉树
     */
    public void preOrderTravelNoRecursion() {
        initNodes();

        TreeNode currentNode = this.root;
        TreeNode tempNode;

        Stack<TreeNode> stack = new Stack<>();

        while (currentNode != null || !stack.empty()) {

            // 一直向左找
            while (currentNode != null) {
                nodes.add(currentNode);
                stack.push(currentNode);
                currentNode = currentNode.getLchild();
            }

            if (!stack.empty()) {
                tempNode = stack.pop();
                currentNode = tempNode.getRchild();
            }
        }

        outputNodes();
    }

    /**
     * 中序遍历
     **/
    private void inOrderTravel0(TreeNode t) {
        if (t == null) return;

        inOrderTravel0(t.getLchild());
        nodes.add(t);
        inOrderTravel0(t.getRchild());
    }

    public void inOrderTravel() {
        initNodes();
        inOrderTravel0(this.root);
        outputNodes();
    }

    /**
     * 非递归中序遍历
     */
    public void inOrderTravelNoRecursion() {
        initNodes();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode currentNode = root;
        TreeNode tempNode = null;

        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.getLchild();
            }

            if (!stack.isEmpty()) {
                tempNode = stack.pop();
                nodes.add(tempNode);
                currentNode = tempNode.getRchild();
            }
        }

        outputNodes();

    }

    /**
     * 后序遍历
     **/
    public void postOrderTravel() {
        initNodes();
        postOrderTravel(this.root);
        outputNodes();
    }

    private void postOrderTravel(TreeNode t) {
        if (t == null) return;
        postOrderTravel(t.getLchild());
        postOrderTravel(t.getRchild());
        nodes.add(t);
    }

    public void postOrderTravelNoRecursion() {
        initNodes();

        TreeNode currentNode;
        TreeNode tempNode;

        currentNode = this.root;

        Stack<TreeNode> stack = new Stack<>();

        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.getLchild();
            }

            if (!stack.isEmpty()) {
                // 获取栈顶元素
                tempNode = stack.peek();

                // 从左子树返回，判断右子树是否已经访问

                // 右子树还未被访问
                if (!tempNode.getFirst()) {
                    tempNode.setFirst(true);
                    currentNode = tempNode.getRchild();
                } else {
                    tempNode = stack.pop();
                    nodes.add(tempNode);
                }
            }
        }

        outputNodes();
    }


    /**
     * 工具函数
     **/
    private void initNodes() {
        nodes = new ArrayList<>();
    }

    /**
     * 格式化输出结点
     */
    private void outputNodes() {
        int i = 0;
        for (TreeNode obj : nodes) {
            if (i != 0) System.out.print(" , ");
            i++;
            System.out.print(obj.getData());
        }
        System.out.println();
    }
}

/*

注意：算法中是 多次while循环 ， 还是 一次的分支判断， 他们组合起来形成流程控制结构，

后序遍历时， 一个临时结点 完成 从指向左子树到指向右子树的切换， 需要经过根节点， 根节点什么时候出栈就成了关键的问题，
右子树被遍历以后，根节点才可以出栈
 */