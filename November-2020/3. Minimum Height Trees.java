class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> list = new ArrayList<> ();
        if(n == 1) {
            list.add(0);
            return list;
        }
        
        List<List<Integer>> adj = new ArrayList<List<Integer>> ();
        int V = n;
        
        for(int i = 0; i < n; i++) 
            adj.add(new ArrayList<Integer> ());
        
        int[] degree = new int[n];
        
        for(int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }
        
        Queue<Integer> que = new LinkedList<> ();
        
        for(int i = 0; i < n; i++)  
            if(degree[i] == 1) 
                que.add(i); 
        
        while(V > 2) {
            int size = que.size();
            V = V - size;
            
            for(int i = 0; i < size; i++) {
                int u = que.remove();
                
                for(int x : adj.get(u)) {
                    degree[x]--;
                    if(degree[x] == 1) 
                        que.add(x);
                }
            }
        }
        
        while(que.isEmpty() == false) 
            list.add(que.remove());
        
        return list;
    }
}
