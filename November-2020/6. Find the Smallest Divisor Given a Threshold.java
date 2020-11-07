class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = 1000000;
        
        while(low < high) {
            int mid = (low + high) / 2;
            int sum = 0;
            for(int i = 0; i < nums.length; i++)
            {
                sum += (nums[i] + mid - 1) / mid;
            }
            if(sum > threshold)
            {
                low = mid + 1;
            }
            else
            {
                high = mid;
            }
        }
        
        return low;
    }
}
