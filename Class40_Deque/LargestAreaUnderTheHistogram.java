class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stk = new Stack<>();     // index

        int maxArea = 0;
        for(int i=0; i<=n; i++){
            while(!stk.isEmpty() && (i == n || heights[i] < heights[stk.peek()])){
                int ht = heights[stk.pop()];
                int nseRight = i;
                int nseLeft;
                if(stk.isEmpty()){
                    nseLeft = -1;
                }
                else{
                    nseLeft = stk.peek();
                }

                int width = nseRight - nseLeft - 1;

                maxArea = Math.max(maxArea, ht * width);
            }

            stk.push(i);
        }
        
        return maxArea;
    }
}







