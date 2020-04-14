package com.feizc;

import java.util.HashMap;
import java.util.Map;

/**
 *  输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字
 *
 * 输入：
 *  前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * 输出
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildTree {

    public static void main(String[] args) {
        int[] pre = {3, 9, 20, 15, 7};//前序遍历序列
        int[] in = {9, 3, 15, 20, 7};//中序遍历序列
        BuildTree b = new BuildTree();
        TreeNode treeNode = b.buildTree(pre, in);
//        TreeNode treeNode = b.buildTree(pre, in, Integer.MAX_VALUE);
//        b.lastOrder(treeNode);
        Utils utils = new Utils();
        utils.show(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        int length = preorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, length - 1, inorder, 0, length - 1, map);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        if (preStart == preEnd) {
            return root;
        } else {
            int rootIndex = map.get(rootVal);
            int leftNodes = rootIndex - inStart;
            int rightNodes = inEnd - rootIndex;
            TreeNode leftSubTree = buildTree(preorder, preStart + 1, preStart + leftNodes, inorder, inStart, rootIndex - 1, map);
            TreeNode rightSubTree = buildTree(preorder, preEnd - rightNodes + 1, preEnd, inorder, rootIndex + 1, inEnd, map);
            root.left = leftSubTree;
            root.right = rightSubTree;
            return root;
        }
    }

    private int pre = 0;

    private int in = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder, int leafNodeVal) {
        if (pre == preorder.length) {
            return null;
        }
        if (inorder[in] == leafNodeVal) {
            in++;
            return null;
        }
        int val = preorder[pre++];
        TreeNode root = new TreeNode(val);
        root.left = buildTree(preorder, inorder, val);
        root.right = buildTree(preorder, inorder, leafNodeVal);
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
