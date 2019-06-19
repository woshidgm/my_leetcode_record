package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
//
//例如:
//给定二叉树: [3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//返回其层次遍历结果：
//
//[
//  [3],
//  [9,20],
//  [15,7]
//]
public class Solution102_ {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        queue.offer(node);
        int next = 0;
        int cur = 1;
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()){
            cur--;
            node = queue.poll();
            tmp.add(node.val);
            if (node.left != null){
                queue.offer(node.left);
                next++;
            }
            if (node.right != null){
                queue.offer(node.right);
                next++;
            }

            if (cur == 0){
                res.add(new ArrayList<>(tmp));
                tmp.clear();
                cur = next;
                next = 0;
            }
        }

        return res;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        queue.offer(node);
        int count = 0;
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()){
            count = queue.size();

            while (count != 0){
                node = queue.poll();
                tmp.add(node.val);
                count--;
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            res.add(new ArrayList<>(tmp));
            tmp.clear();
        }

        return res;
    }

    //递归解法
    // 层次其实就是深度，
    // 我们记录遍历到每一层级到深度，为每一层级创建List，根据当前深度找到对应的List，然后追加进去
    // 相当于就是 level作为索引，每一个list作为结果的list的一个元素。
    // 前序遍历的时候， 遍历到某一个节点 根据它所在的层 将它添加进对应的 list
    // level >= res.size() 表示遍历到某一层的时候，没有该层对应的list元素，因此要新建
    public List<List<Integer>> levelOrder3(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        process(0, root, res);
        return res;
    }

    private void process(int level, TreeNode node, List<List<Integer>> res){
        if (node == null){
            return;
        }

        if (level >= res.size()){
            res.add(new ArrayList<>());
        }

        res.get(level).add(node.val);

        process(level+1, node.left, res);
        process(level+1, node.right, res);
    }
}
