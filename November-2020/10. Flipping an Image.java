class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int r = A.length;
        int c = A.length;
        
        int[][] res = new int[r][c];
        
        for(int i = 0; i < r; i++) {
            int k = 0;
            for(int j = c - 1; j >= 0; j--) {
                if(A[i][j] == 1)
                    res[i][k++] = 0;
                else 
                    res[i][k++] = 1; 
                
            }
        }
        
        return res;
    }
}
