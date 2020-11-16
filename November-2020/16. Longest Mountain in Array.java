class Solution {
    public int longestMountain(int[] A) {
        if(A.length < 3) 
            return 0;
        int j = -1, k = -1, d = 0;
        for(int i = 0; i < A.length - 1; i++) {
            // starting of new mountain
            if(A[i + 1] > A[i]) {
                // When a new mountain sub-array is 
                // found, there is a need to set the
                // variables k, j to -1 in order to 
                // help calculate the length of new 
                // mountain sub-array
                if(k != -1) {
                    k = -1;
                    j = -1;
                }
                
                // j marks the starting index of a
                // new mountain sub-array. So set the
                // value of j to current index i.
                if(j == -1) {
                    j = i;
                }
            } 
            else {
                if(A[i + 1] < A[i]) {
                    // Checks if starting element exists
                    // or not, if the starting element of
                    // the mountain sub-array exists then
                    // the index of ending element is 
                    // stored in k
                    if(j != -1) {
                        k = i + 1;
                    }
                    
                    // This condition checks if both 
                    // starting index and ending index
                    // exists or not, if yes,the length 
                    // is calculated.
                    if(j != -1 && k != -1) {
                        // d holds the lenght of the 
                        // longest mountain sub-array.
                        // If the current length is 
                        // greater than the calculated 
                        // length, then value of d is 
                        // updated.
                        if(d < k - j + 1) {    
                            d = k - j + 1;
                        }
                    }
                }
                // no increase or decrease
                else {
                    k = -1;
                    j = -1;
                }
            }
        }
        
        if(k != -1 && j != -1) {
            if(d < k - j + 1) 
                d = k - j + 1;
        }
        
        return d;
    }
}
