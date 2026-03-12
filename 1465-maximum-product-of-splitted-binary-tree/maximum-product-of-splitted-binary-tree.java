class Solution {

    long total = 0;
    long maxProduct = 0;
    int MOD = 1000000007;

    public int maxProduct(TreeNode root) {

        total = treeSum(root);
        dfs(root);

        return (int)(maxProduct % MOD);
    }

    public long treeSum(TreeNode node) {
        if(node == null) return 0;

        return node.val + treeSum(node.left) + treeSum(node.right);
    }

    public long dfs(TreeNode node) {
        if(node == null) return 0;

        long left = dfs(node.left);
        long right = dfs(node.right);

        long sub = node.val + left + right;

        maxProduct = Math.max(maxProduct, sub * (total - sub));

        return sub;
    }
}