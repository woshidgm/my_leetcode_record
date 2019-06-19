package leetcode.tree;

import Test.Tree;

import java.util.*;

// 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
//例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//返回锯齿形层次遍历如下：
//
//[
//  [3],
//  [20,9],
//  [15,7]
//]
public class Solution103 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode node = root;
        stack1.push(node);
        int level = 0;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            if (level%2 == 0){
                while (!stack1.isEmpty()){
                    node = stack1.pop();
                    tmp.add(node.val);
                    if (node.left != null){
                        stack2.push(node.left);
                    }
                    if (node.right != null){
                        stack2.push(node.right);
                    }
                }
            }else {
                while (!stack2.isEmpty()){
                    node = stack2.pop();
                    tmp.add(node.val);
                    if (node.right != null){
                        stack1.push(node.right);
                    }
                    if (node.left != null){
                        stack1.push(node.left);
                    }
                }
            }
            level++;
            res.add(new ArrayList<>(tmp));
            tmp.clear();
        }

        return res;
    }
}
