public class Solution {
    
    public boolean isPossibleToAllocate(int[] books, int nStudents, long thresholdPages){
        long currentPages = 0;
        int studentCount = 1;
        
        int n = books.length;
        int i=0;
        while(i < n){
            if(currentPages + books[i] <= thresholdPages){
                currentPages += books[i];
            }
            else{
                studentCount++;
                currentPages = books[i];
            }
            
            if(studentCount > nStudents){
                return false;
            }
                        
            i++;
        }
        
        return true;
    }
    
    public int books(int[] books, int nStudents) {
        long totalPages = 0;
        long maxPages = Integer.MIN_VALUE;
        int nBooks = books.length;
        
        if(nBooks < nStudents){
            return -1;
        }
        
        for(int pages: books){
            totalPages += pages;
            maxPages = Math.max(maxPages, pages);
        }
        
        long low = maxPages;
        long high = totalPages;
        
        long ans = -1;
        while(low <= high){
            long mid = low + (high - low) / 2;     // threshold
            
            if(isPossibleToAllocate(books, nStudents, mid)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        
        return (int)ans;
    }
}
