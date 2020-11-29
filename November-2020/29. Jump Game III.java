class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        
        while(que.isEmpty() == false) {
            int temp = que.remove();
            if(arr[temp] == 0)
                return true;
            
            if(arr[temp] < 0)
                continue;
            
            if(temp + arr[temp] < arr.length)
                que.add(temp + arr[temp]);
            if(temp - arr[temp] >= 0)
                que.add(temp - arr[temp]);
            
            arr[temp] = -arr[temp];
        }
        
        return false;
    }
}
