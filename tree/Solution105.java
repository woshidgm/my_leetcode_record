package leetcode.tree;

import Test.Tree;

// 从前序与中序遍历序列构造二叉树
// 根据一棵树的前序遍历与中序遍历构造二叉树。
//
//注意:
//你可以假设树中没有重复的元素。
//
//例如，给出
//
//前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//返回如下的二叉树：
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
public class Solution105 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder==null||inorder == null||preorder.length == 0||inorder.length==0){
            return null;
        }
        return process(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode process(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend){
        if (instart>inend){
            return null;
        }
        int rootVal = preorder[prestart];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = getIndex(inorder, rootVal, instart, inend);
        int leftlen = rootIndex - instart;
        int rightlen = inend - rootIndex;
        root.left = process(preorder, prestart+1, prestart+leftlen, inorder, instart, rootIndex-1);
        root.right = process(preorder, prestart+leftlen+1, preend, inorder, rootIndex+1, inend);
        return root;
    }
    private int getIndex(int[] inorder, int rootVal, int start, int end){
        int index = 0;
        for (int i=start; i<=end; i++){
            if (inorder[i] == rootVal){
                index = i;
                break;
            }
        }
        return index;
    }
}
