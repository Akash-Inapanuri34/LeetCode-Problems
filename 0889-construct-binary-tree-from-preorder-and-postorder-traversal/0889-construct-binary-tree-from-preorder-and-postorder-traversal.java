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

    private int[] preorder;
    private int[] postorder;
    private Map<Integer, Integer> postIndex;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.preorder = preorder;
        this.postorder = postorder;
        postIndex = new HashMap<>();

        for (int i = 0; i < postorder.length; i++) {
            postIndex.put(postorder[i], i);
        }

        return build(0, preorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode build(int preL, int preR, int postL, int postR) {

        if (preL > preR)
            return null;

        TreeNode root = new TreeNode(preorder[preL]);

        if (preL == preR)
            return root;

        int leftRoot = preorder[preL + 1];
        int idx = postIndex.get(leftRoot);

        int leftSize = idx - postL + 1;

        root.left = build(
                preL + 1,
                preL + leftSize,
                postL,
                idx
        );

        root.right = build(
                preL + leftSize + 1,
                preR,
                idx + 1,
                postR - 1
        );

        return root;
    }
}