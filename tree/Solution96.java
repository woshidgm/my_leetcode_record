package leetcode.tree;

// 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
public class Solution96 {
    public int numTrees(int n) {
        if (n <= 0){
            return 0;
        }

        return  process(0, n-1);
    }
    // 仿照95题过程
    private int process(int start, int end){
        if (start >= end){
            return 1;
        }
        int res = 0;
        for (int i=start; i<=end; i++){
            int left = process(start, i-1);
            int right=process(i+1, end);
            res += left*right;
        }
        return res;
    }

    // dp
    // 卡特兰数

    // 用G(n)表示n个结点的不同二叉树数量。
    // 用f(i)表示结点数为n时，以i为根结点二叉树的数量。
    // 那么G(n)=f(1)+f(2)……+f(n)。
    // 而f(i)=G(i-1)G(n-i)——即以i为根结点的二叉树数量等于其左子树个数乘右子树个数。 那么G(n)=G(1)G(n-1)+G(2)G(n-2)……+G(n-1)G(1)
    public int numTrees2(int n) {
        if (n == 0){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        // 2个元素的数组 对应二叉树的情况
        // 左子树0个元素 右子树1个元素  dp[2] = dp[0]*dp[1] + dp[1] * dp[0]
        // 左子树1个元素 右子树0个元素

        // 3个元素
        // 左1 右1 左0 右2
        // 左2 右1     dp[3] = dp[1] *d[1] + dp[0]*dp[2] + dp[2]*dp[0]
        for (int i=2; i<n+1; i++){
            for (int j=1; j<=i; j++){
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }

}
