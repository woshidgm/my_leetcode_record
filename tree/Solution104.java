package leetcode.tree;

// 给定一个二叉树，找出其最大深度。
//
//二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
public class Solution104 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    //法2 层序遍历求高度
}
