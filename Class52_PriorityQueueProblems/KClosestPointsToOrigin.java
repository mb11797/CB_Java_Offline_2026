class Solution {
    class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public class PointDistFromOriginComparator implements Comparator<Point>{
        public int compare(Point a, Point b){
            return (b.x * b.x + b.y * b.y) - (a.x * a.x + a.y * a.y);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        PriorityQueue<Point> maxHeap = new PriorityQueue<>(new PointDistFromOriginComparator());

        for(int i=0; i<k; i++){
            maxHeap.offer(new Point(points[i][0], points[i][1]));
        }

        for(int i=k; i<n; i++){
            maxHeap.offer(new Point(points[i][0], points[i][1]));           // blindly insert
            maxHeap.poll();         // maximum dist point from origin removed
        }

        int[][] ans = new int[k][2];
        int i=0;
        while(!maxHeap.isEmpty()){
            Point removedPoint = maxHeap.poll();
            ans[i][0] = removedPoint.x;
            ans[i][1] = removedPoint.y;
            i++;
        }

        return ans;
    }
}