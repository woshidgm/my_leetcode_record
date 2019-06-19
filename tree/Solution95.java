package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

// 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
// 输入: 3
//  输出:
//  [
//      [1,null,3,2],
//      [3,2,null,1],
//      [3,1,null,null,2],
//      [2,1,3],
//      [1,null,2,null,3]
//  ]
public class Solution95 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 求出[i, i+1, i+2, ... ,i+n]这样一个序列的所有的 二叉搜索数 List
    // 假设1为根节点 那么[] [2,3,4...]两个序列 产生可能的 左右子树的 集合
    // 求得 List<TreeNode> lefts （n个元素）      List<TreeNode> rights （m个元素）
    // 那么 以 1 为根节点 对应的 树的情况有  n*m种
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0){
            return null;
        }
        int[] tree = new int[n];
        for (int i=0; i<n; i++){
            tree[i] = i+1;
        }
        List<TreeNode> res = process(tree, 0, n-1);
        return res;
    }
 // 卡特兰数的规律
    private List<TreeNode> process(int[] tree, int start, int end){
        List<TreeNode> cur = new ArrayList<>();
        if (start>end){
            return cur;
        }
        if (start == end){
            cur.add(new TreeNode(tree[start]));
            return cur;
        }

        for (int i=start; i<=end; i++){
            List<TreeNode> lefts = process(tree, start, i-1);
            List<TreeNode> rights = process(tree, i+1, end);
            for (TreeNode left: lefts){
                for (TreeNode right: rights){
                    TreeNode root = new TreeNode(tree[i]);
                    root.left = left;
                    root.right = right;
                    cur.add(root);
                }
            }
        }
        return cur;
    }

}
