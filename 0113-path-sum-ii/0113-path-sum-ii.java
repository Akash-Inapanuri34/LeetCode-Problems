/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode node, int targetSum, List<Integer> path) {
        if (node == null) {
            return;
        }

        // Add current node to path
        path.add(node.val);
        targetSum -= node.val;

        // Check if it's a leaf and target sum is achieved
        if (node.left == null && node.right == null && targetSum == 0) {
            result.add(new ArrayList<>(path)); // Store a copy of the path
        } else {
            dfs(node.left, targetSum, path);
            dfs(node.right, targetSum, path);
        }

        // Backtrack
        path.remove(path.size() - 1);
    }
}