package leetcode.tree;

// 给定一个二叉树，判断它是否是高度平衡的二叉树。
//
//本题中，一棵高度平衡二叉树定义为：
//
//一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
public class Solution110 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 1. 当前树平衡的条件是 左右子树高度差不超过1
    // 2. 左右子树是否都平衡
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (Math.abs(left-right)>1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }
    private int getHeight(TreeNode root){
        if (root == null){
            return 0;
        }
        return 1+Math.max(getHeight(root.left), getHeight(root.right));
    }

}
