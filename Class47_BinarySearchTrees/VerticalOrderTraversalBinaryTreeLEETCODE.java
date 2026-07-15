/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Pair{
    int level;
    int node;

    public Pair(int level, int node){
        this.level = level;
        this.node = node;
    }
}

class Solution {

    private void verticalOrderTraversal(TreeNode root, int dist, int level, Map<Integer, List<Pair>> distVsPairs){
        if(root == null)
            return;
        
        distVsPairs.putIfAbsent(dist, new ArrayList<>());
        distVsPairs.get(dist).add(new Pair(level, root.val));
        System.out.println(dist + " | " + level + " | " + root.val);

        verticalOrderTraversal(root.left, dist-1, level+1, distVsPairs);
        verticalOrderTraversal(root.right, dist+1, level+1, distVsPairs);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> verticalOrder = new ArrayList<>();
        Map<Integer, List<Pair>> distVsPairs = new HashMap<>();
        verticalOrderTraversal(root, 0, 0, distVsPairs);

        List<Map.Entry<Integer, List<Pair>>> entryList = new ArrayList<>(distVsPairs.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, List<Pair>>>() {
            @Override
            public int compare(Map.Entry<Integer, List<Pair>> a, Map.Entry<Integer, List<Pair>> b){
                return a.getKey() - b.getKey();
            }
        });

        for(Map.Entry<Integer, List<Pair>> entry: entryList){
            List<Pair> columnPair = entry.getValue();
            Collections.sort(columnPair, new Comparator<Pair>(){
                @Override
                public int compare(Pair a, Pair b){
                    if(a.level == b.level){
                        return a.node - b.node;
                    }
                    else{
                        return a.level - b.level;
                    }
                }
            });
            List<Integer> column = new ArrayList<>();
            for(Pair p: columnPair){
                column.add(p.node);
            }

            verticalOrder.add(column);
        }

        return verticalOrder;
    }
}