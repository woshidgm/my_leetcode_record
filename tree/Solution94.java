package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution94 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty()||node!=null){

            if (node != null){
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }

        }
        return res;
    }
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null){
            return res;
        }

        process(root);
        return res;
    }

    private void process(TreeNode root){
        if (root == null){
            return;
        }
        process(root.left);
        res.add(root.val);
        process(root.right);

    }
}
