package leetcode.tree;

// 恢复二叉搜索树

import Test.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 请在不改变其结构的情况下，恢复这棵树。
public class Solution99 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    TreeNode pre = null;
    TreeNode small = null;
    TreeNode big = null;
    public void recoverTree(TreeNode root) {
        if (root == null||(root.left == null && root.right ==null)){
            return;
        }
        process(root);
        int tmp = small.val;
        small.val = big.val;
        big.val = tmp;
    }

    // 二叉搜索树中序遍历
    // 第一个pre>cur big=pre
    // 最后一个 pre>cur  small =cur;
    private void process(TreeNode root){
        if (root == null){
            return;
        }
        process(root.left);
        if (pre == null){
            pre = root;
        }else {
            if (root.val < pre.val){
                small = root;
                if (big == null) {
                    big = pre;
                }
            }
        }
        process(root.right);
    }

    List<TreeNode> list = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    public void recoverTree2(TreeNode root) {
        if (root == null||(root.left == null && root.right ==null)){
            return;
        }

        process2(root);
        Collections.sort(list2);
        TreeNode small = null;
        TreeNode big = null;
        for (int i=0;i <list.size(); i++){
            if (list.get(i).val > list2.get(i)){
                big = list.get(i);
            } else if (list.get(i).val < list2.get(i)){
                small = list.get(i);
            }
        }
        int tmp = small.val;
        small.val = big.val;
        big.val = tmp;

    }

    private void process2(TreeNode root){
        if (root == null){
            return;
        }
        process2(root.left);
        list.add(root);
        list2.add(root.val);
        process2(root.right);

    }

}
