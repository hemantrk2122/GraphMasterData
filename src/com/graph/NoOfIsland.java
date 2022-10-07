package com.graph;

public class NoOfIsland {
	public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        
        int ans = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    dfs(grid,i,j,vis);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] graph,int i,int j,boolean[][] vis){
        int n = graph.length;
        int m = graph[0].length;
        vis[i][j] = true;
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        for(int[] dir:dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            
            if(x>=0 && x<n && y>=0 && y<m && !vis[x][y] && graph[x][y] == '1'){
                dfs(graph,x,y,vis);
            }
        }
    }
//    char[][] grid = {
//            {'1','1','1','1','0'},
//            {'1','1','0','1','0'},
//            {'1','1','0','0','0'},
//            {'0','0','0','1','0'}
//          };
//NoOfIsland instance = new NoOfIsland();
//System.out.println(instance.numIslands(grid));
}
