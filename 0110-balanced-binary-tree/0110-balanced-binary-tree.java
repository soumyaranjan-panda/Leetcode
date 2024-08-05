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
    public boolean isBalanced(TreeNode root) {
        boolean[] ans = new boolean[1];
        ans[0] = true;
        height(root, ans);
        return ans[0];
        
    }
    public int height(TreeNode node, boolean[] ans){
        if(node == null){
            return 0;
        }
        int lh = height(node.left, ans);
        int rh = height(node.right, ans);
        if(Math.abs(lh - rh) > 1){
            ans[0] = false;
        }
        return 1 + Math.max(lh, rh);
    }
}