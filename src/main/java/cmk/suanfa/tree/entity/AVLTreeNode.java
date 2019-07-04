package cmk.suanfa.tree.entity;

/**
 * @auther changmk
 * @date 2019/7/4 下午3:42
 */
public class AVLTreeNode {
    private int data;
    private int height;
    private AVLTreeNode left;
    private AVLTreeNode right;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AVLTreeNode getLeft() {
        return left;
    }

    public void setLeft(AVLTreeNode left) {
        this.left = left;
    }

    public AVLTreeNode getRight() {
        return right;
    }

    public void setRight(AVLTreeNode right) {
        this.right = right;
    }
}
