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
    public int maxPathSum(TreeNode root) {
    int[] arr = new int[]{Integer.MIN_VALUE};
    helper(root, arr);
    return arr[0];
}

public int helper(TreeNode root, int[] ans) {
    if (root == null) return 0;
    int leftSum = Math.max(helper(root.left, ans), 0);
    int rightSum = Math.max(helper(root.right, ans), 0);
    ans[0] = Math.max(ans[0], leftSum + rightSum + root.val);
    return root.val + Math.max(leftSum, rightSum);
}
    
}