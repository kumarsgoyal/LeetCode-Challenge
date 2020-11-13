/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root != null) {
            Node curr = root;
            Queue<Node> que = new LinkedList<> ();
            
            que.add(curr);
            
            while(que.isEmpty() == false) {
                int size = que.size();
                
                for(int i = 0; i < size - 1; i++) {
                    curr = que.remove();
                    curr.next = que.peek();
                    if(curr.left != null) 
                        que.add(curr.left);
                    if(curr.right != null) 
                        que.add(curr.right);
                }
                
                curr = que.remove();
                if(curr.left != null) 
                    que.add(curr.left);
                if(curr.right != null) 
                    que.add(curr.right);
            }
        }
        
        return root;
    }
}
