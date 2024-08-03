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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        boolean reverse = false;
        while(!deque.isEmpty()){
            int levelSize = deque.size();
            List<Integer> subList = new ArrayList<>();
            for(int i = 0; i < levelSize; i++){
                if(reverse){
                    TreeNode node = deque.pollLast();
                    subList.add(node.val);
                    if(node.right != null){
                        deque.addFirst(node.right);
                    }
                    if(node.left != null){
                        deque.addFirst(node.left);
                    }
                }else{
                    TreeNode node = deque.pollFirst();
                    subList.add(node.val);
                    if(node.left != null){
                        deque.addLast(node.left);
                    }
                    if(node.right != null){
                        deque.addLast(node.right);
                    }
                }
            }
            reverse = !reverse;
            list.add(subList);
        }
        return list;
    }
}