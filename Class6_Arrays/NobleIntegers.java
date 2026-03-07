public class Solution {
    public int solve(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        
        for(int i=0; i<n; i++){
            while(i+1 < n && A[i] == A[i+1])
                i++;
            
            int p = A[i];
            int count = n - i - 1;
            
            if(p == count){
                return 1;
            }
        }
        
        return -1;
    }
}
