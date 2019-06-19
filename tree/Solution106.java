package leetcode.tree;

// 从中序与后序遍历序列构造二叉树
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3]
//返回如下的二叉树：
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
public class Solution106 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder ==null||postorder==null||inorder.length == 0||postorder.length==0){
            return null;
        }

        return process(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    private TreeNode process(int[] inorder, int[] postorder, int instart, int inend, int poststart, int postend){
        if (instart >= inend){
            return new TreeNode(inorder[instart]);
        }

        int rootVal = postorder[postend];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = getIndex(inorder, rootVal, instart, inend);
        int leftLen = rootIndex - instart;
        int rightLen = inend - rootIndex;
        root.left = process(inorder, postorder, instart, instart+leftLen-1, poststart, poststart+leftLen-1);
        root.right = process(inorder, postorder, rootIndex+1, inend, postend-rightLen, postend-1);
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
