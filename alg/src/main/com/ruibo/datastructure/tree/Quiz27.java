package com.ruibo.datastructure.tree;

/**
 * 输出一个二叉树的镜像
 * 请完成一个函数，输入一棵二叉树，该函数输出它的镜像。
 *
 * 备注：
 * 该题的思想和反转字符串和左旋字符串思想有些类似
 */
public class Quiz27 {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(5);
        BinaryTreeNode leftOfRoot = new BinaryTreeNode(4);
        BinaryTreeNode rightOfRoot = new BinaryTreeNode(3);

        root.leftNode = leftOfRoot;
        root.rightNode = rightOfRoot;

        BinaryTreeNode leftOfLeft = new BinaryTreeNode(1);
        BinaryTreeNode rightOfLeft = new BinaryTreeNode(2);
        leftOfRoot.leftNode = leftOfLeft;
        leftOfRoot.rightNode = rightOfLeft;

        BinaryTreeNode leftOfRight = new BinaryTreeNode(9);
        BinaryTreeNode rightOfRight = new BinaryTreeNode(0);
        rightOfRoot.leftNode = leftOfRight;
        rightOfRoot.rightNode = rightOfRight;


        switchChild(root);

        System.out.println();
    }

    public static void switchChild(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        BinaryTreeNode leftChildUsed = treeNode.leftNode;
        BinaryTreeNode rightChildUsed = treeNode.rightNode;

        treeNode.rightNode = leftChildUsed;
        treeNode.leftNode = rightChildUsed;

        switchChild(treeNode.rightNode);
        switchChild(treeNode.leftNode);

    }

    /**
     * 二叉树定义
     */
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode leftNode;
        BinaryTreeNode rightNode;

        public BinaryTreeNode(int value) {
            this.value = value;
        }
    }


}
