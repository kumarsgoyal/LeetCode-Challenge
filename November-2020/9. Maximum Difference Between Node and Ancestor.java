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
    int res = Integer.MIN_VALUE;
    
    public void maxAncestorDiffUtil(TreeNode root, int min, int max) {
        if(root == null) 
            return; 
        
        res = Math.max(res, Math.max(Math.abs(root.val - min), Math.abs(root.val - max)));
        
        maxAncestorDiffUtil(root.left, Math.min(root.val, min), Math.max(root.val, max));
        maxAncestorDiffUtil(root.right, Math.min(root.val, min), Math.max(root.val, max));
    }
    
    public int maxAncestorDiff(TreeNode root) {
        maxAncestorDiffUtil(root, root.val, root.val);
        
        return res;
    }
}
