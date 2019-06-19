package leetcode.tree;

import Test.Tree;

import java.util.*;
import java.util.concurrent.CyclicBarrier;

// 对称二叉树
// 给定一个二叉树，检查它是否是镜像对称的。
//
//例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
public class Solution101_ {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 层序遍历法判断
    // 维持两个队列 分别对应每行从左往右遍历 与从右往左遍历
    // 因此遍历的 节点 都是同一层，位置镜像的
    // 因此判断的条件：1.两个节点 是否值相等
    // 2. 假设两节点分别为 node1 node2  若 node1.left != null node2.right == null 一定不是镜像 因为在位置上就没有对称性
    // 相同的 node1.left == null node2.right != null
    // node1.right != null node2.left == null  node1.right == null node2.left != null 都不是镜像的
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }

        TreeNode node1 = root;
        TreeNode node2 = root;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(node1);
        queue2.offer(node2);

        while (!queue1.isEmpty() && !queue2.isEmpty()){

            node1 = queue1.poll();
            node2 = queue2.poll();

            if (node1.val != node2.val){
                return false;
            }

            if ((node1.left!=null&&node2.right==null) || (node1.left==null&&node2.right!=null)
                    ||(node1.right!=null&&node2.left==null) || (node1.right==null&&node2.left!=null)){
                return false;
            }

            if (node1.left  != null){
                queue1.offer(node1.left);
            }
            if (node1.right != null){
                queue1.offer(node1.right);
            }

            if (node2.right != null){
                queue2.offer(node2.right);
            }
            if (node2.left != null){
                queue2.offer(node2.left);
            }
        }
        return true;

    }


    // 递归
    // 判断两棵树 是否是镜像
    // 1. 两棵树 根节点root1 root2值是否相同
    // 2. tree1左子树 tree2右子树是否镜像
    //   tree1右子树 tree2左子树是否镜像
    public boolean isSymmetric2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)){
            return true;
        }
        return process(root, root);
    }

    private boolean process(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null){
            return true;
        }
        if (root1 == null||root2==null){
            return false;
        }
        if (root1 == root2){
            return process(root1.left, root1.right);
        }

        if (root1.val == root2.val){
            return process(root1.left, root2.right) && process(root1.right, root2.left);
        }
        return false;
    }
}
