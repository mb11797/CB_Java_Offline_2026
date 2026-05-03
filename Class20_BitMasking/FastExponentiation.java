class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        // n = -2^31;      // Integer.MIN_VALUE
        // Integer range -> -2^31 to 2^31 - 1
        // int N = n;

        long N = n;
        if(n < 0){
            N = -1 * N;     // -1 * -2^31 = 2^31
            // N = -1 * (long) n;       // Alternate way
        }

        while(N > 0){
            if((N % 2) == 1){
                // N -> odd
                ans = ans * x;
                N--;
            }
            else{
                // N -> even
                x = x * x;
                N /= 2;
            }
        }

        if(n < 0){
            ans = 1.0 / ans;
        }

        return ans;
    }
}