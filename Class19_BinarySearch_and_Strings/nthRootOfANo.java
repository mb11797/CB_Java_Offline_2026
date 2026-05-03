class Solution {
    
    public int a_power_b(int a, int b){
        int ans = 1;
        for(int i=0; i<b; i++){
            ans *= a;
        }
        return ans;
    }
    
    public int nthRoot(int n, int m) {
        // code here
        int low = 0, high = m;
        while(low <= high){
            int mid = (low + high) / 2;
            
            int prod = a_power_b(mid, n);
            
            if(prod < m){
                low = mid + 1;
            }
            else if(prod > m){
                high = mid - 1;
            }
            else{
                // prod == m
                return mid;
            }
        }
        
        return -1;
    }
}
