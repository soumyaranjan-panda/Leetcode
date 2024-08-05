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
    int[] arr = new int[]{Integer.MIN_VALUE}; // Initialize with minimum value
    helper(root, arr);
    return arr[0];
}

public int helper(TreeNode root, int[] ans) {
    if (root == null) return 0;
    
    // Recursively get the maximum path sum of left and right subtrees
    int leftSum = Math.max(helper(root.left, ans), 0); // Ignore paths with negative sum
    int rightSum = Math.max(helper(root.right, ans), 0); // Ignore paths with negative sum
    
    // Update the maximum path sum with the sum of the current node and its left and right children
    ans[0] = Math.max(ans[0], leftSum + rightSum + root.val);
    
    // Return the maximum path sum including the current node and either of its subtrees
    return root.val + Math.max(leftSum, rightSum);
}

}