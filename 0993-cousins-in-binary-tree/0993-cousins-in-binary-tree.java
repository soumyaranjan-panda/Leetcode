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
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            boolean xFound = false;
            boolean yFound = false;
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                
                // Check if the current node is either x or y
                if (currentNode.val == x) {
                    xFound = true;
                }
                if (currentNode.val == y) {
                    yFound = true;
                }
                
                // Check if x and y are siblings (i.e., have the same parent)
                if (currentNode.left != null && currentNode.right != null) {
                    if ((currentNode.left.val == x && currentNode.right.val == y) || 
                        (currentNode.left.val == y && currentNode.right.val == x)) {
                        return false;
                    }
                }
                
                // Add children to the queue
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            
            // If both x and y are found on the same level and are not siblings
            if (xFound && yFound) {
                return true;
            }
            
            // If only one of x or y is found on the current level
            if (xFound || yFound) {
                return false;
            }
        }
        
        return false;
    }
}
