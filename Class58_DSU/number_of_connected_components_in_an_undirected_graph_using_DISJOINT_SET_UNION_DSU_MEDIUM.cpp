class Solution {
public:
    
    int findParent(vector<int> &parent, int node){
        if(parent[node] != node){
            return parent[node] = findParent(parent, parent[node]);
        }
        return node;
    }
    
    int unionByRank(vector<int> &parent, vector<int> &rank, int u, int v){
        int leaderOfX = findParent(parent, u);
        int leaderOfY = findParent(parent, v);
        
        if(leaderOfX != leaderOfY){
            if(rank[leaderOfX] > rank[leaderOfY])
                parent[leaderOfY] = leaderOfX;
            else if(rank[leaderOfX] < rank[leaderOfY])
                parent[leaderOfX] = leaderOfY;
            else{
                parent[leaderOfY] = leaderOfX;
                rank[leaderOfX]++;
            }
                
            return 1;
        }
        else
            return 0;
    }
    
    int countComponents(int n, vector<vector<int>>& edges) {
        vector<int> parent(n);
        vector<int> rank(n);
        
        for(int i=0; i<n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        int components = n;
        for(auto edge: edges){
            components -= unionByRank(parent, rank, edge[0], edge[1]);
        }
        
        return components;
    }
};