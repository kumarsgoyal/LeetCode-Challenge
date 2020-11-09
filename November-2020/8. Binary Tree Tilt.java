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
    int sum = 0;
    
    public int findTiltUtil(TreeNode root) {
        if(root == null) 
            return 0; 
        int left = findTiltUtil(root.left);
        int right = findTiltUtil(root.right);
        
        int val = root.val;
        root.val = Math.abs(left - right);
        sum += root.val;
        return left + right + val;
    }
    
    public int findTilt(TreeNode root) {
        if(root == null) 
            return 0; 
        
        findTiltUtil(root);
        return sum;
    }
}
