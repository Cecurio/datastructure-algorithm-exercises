package cn.cecurio.algorithm.tree;

public class TreeNode {
    private Object data;
    private TreeNode lchild;
    private TreeNode rchild;
    private boolean isFirst; //被初始化为false

    public TreeNode() {
    }

    public TreeNode(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public TreeNode getLchild() {
        return lchild;
    }

    public void setLchild(TreeNode lchild) {
        this.lchild = lchild;
    }

    public TreeNode getRchild() {
        return rchild;
    }

    public void setRchild(TreeNode rchild) {
        this.rchild = rchild;
    }

    public Boolean getFirst() {
        return isFirst;
    }

    public void setFirst(Boolean first) {
        isFirst = first;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", lchild=" + lchild +
                ", rchild=" + rchild +
                ", isFirst=" + isFirst +
                '}';
    }
}
