package cmk.suanfa.tree;

import cmk.suanfa.tree.entity.AVLTreeNode;

/**
 * @auther changmk
 * @date 2019/7/4 下午3:44
 */
public class AVLTreeMethod {

    public int height(AVLTreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.getHeight();
    }

    /**
     * 左旋转
     * @param X
     * @return
     */
    AVLTreeNode singleRotateLeft(AVLTreeNode X) {
        AVLTreeNode W = X.getLeft();
        X.setLeft(W.getRight());
        W.setRight(X);
        X.setHeight(Math.max(height(X.getLeft()), height(X.getRight())) + 1);
        W.setHeight(Math.max(height(W.getLeft()), X.getHeight()) + 1);
        return W;
    }

    /**
     * 右旋转
     * @param W
     * @return
     */
    AVLTreeNode singleRotateRight(AVLTreeNode W) {
        AVLTreeNode X = W.getLeft();
        W.setRight(X.getLeft());
        X.setLeft(W);
        W.setHeight(Math.max(height(W.getRight()), height(W.getLeft())) + 1);
        X.setHeight(Math.max(height(X.getRight()), W.getHeight()) + 1);
        return W;
    }

    AVLTreeNode doubleRotateWithLeft(AVLTreeNode Z) {
        Z.setLeft(singleRotateRight(Z.getLeft()));
        return singleRotateLeft(Z);
    }

    AVLTreeNode doubleRotateWithRight(AVLTreeNode Z) {
        Z.setRight(singleRotateLeft(Z.getRight()));
        return singleRotateRight(Z);
    }

    /**
     * AVL树插入操作
     * @param root
     * @param parent
     * @param data
     * @return
     */
    AVLTreeNode insert(AVLTreeNode root, AVLTreeNode parent, int data) {
        if (root == null) {
            root = new AVLTreeNode();
            root.setHeight(0);
            root.setData(data);
            root.setLeft(null);
            root.setRight(null);
            return root;
        } else if (data < root.getData()){
            root.setLeft(insert(root.getLeft(), root, data));
            if (height(root.getLeft()) - height(root.getRight()) == 2) {
                if (data < root.getLeft().getData()) {
                    root = singleRotateLeft(root);
                } else {
                    root = doubleRotateWithLeft(root);
                }
            }
        } else if (data > root.getData()) {
            root.setRight(insert(root.getRight(), root, data));
            if (height(root.getRight()) - height(root.getLeft()) == 2) {
                if (data > root.getRight().getData()) {
                    root = singleRotateRight(root);
                } else {
                    root = doubleRotateWithRight(root);
                }
            }
        }
        root.setHeight(Math.max(height(root.getLeft()), height(root.getRight())) + 1);
        return root;
    }

}
