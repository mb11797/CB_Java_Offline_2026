public class Solution {
    
    public boolean isPossibleToPaintUsingGivenPainters(int[] boards, int maxPaintersAllowed, long thresholdBoardLen){
        long currentBoardLenPainted = 0;
        int paintersCount = 1;
        
        int nBoards = boards.length;
        int i = 0;
        while(i < nBoards){
            if(currentBoardLenPainted + boards[i] <= thresholdBoardLen){
                currentBoardLenPainted += boards[i];
            }
            else{
                paintersCount++;
                currentBoardLenPainted = boards[i];
            }
            
            if(paintersCount > maxPaintersAllowed){
                return false;
            }
            
            i++;
        }
        
        return true;
    }
    
    public int paint(int nPainters, int B, int[] boards) {
        int nBoards = boards.length;
        
        int maxBoardLen = Integer.MIN_VALUE;
        long totalBoardLen = 0;
        
        for(int i=0; i<nBoards; i++){
            maxBoardLen = Math.max(maxBoardLen, boards[i]);
            totalBoardLen += boards[i];
        }
        
        long low = maxBoardLen, high = totalBoardLen;
        
        long ans = 0;
        while(low <= high){
            long mid = low + (high - low) / 2;        // threshold board length
            
            if(isPossibleToPaintUsingGivenPainters(boards, nPainters, mid)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        
        return (int) ((ans * B) % 10000003);
    }
}
