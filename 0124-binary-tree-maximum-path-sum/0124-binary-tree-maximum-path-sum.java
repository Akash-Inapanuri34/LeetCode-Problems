class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {

        if (node == null)
            return 0;

        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        // Path passing through current node
        maxSum = Math.max(maxSum, left + right + node.val);

        // Return one side to parent
        return node.val + Math.max(left, right);
    }
}