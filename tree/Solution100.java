package leetcode.tree;

//相同的二叉树
// 给定两个二叉树，编写一个函数来检验它们是否相同。
//
//如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
public class Solution100 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q==null){
            return p==null&&q==null;
        }

        return process(p, q);
    }
    private boolean process(TreeNode p, TreeNode q){
        if (p==null&&q==null){
            return true;
        }
        if (p!=null && q!=null&&p.val == q.val){
            return process(p.left, q.left)&&process(p.right, q.right);
        }
        return false;
    }
}
