package com.graph;

public class IslandPerimiter {
	public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int ans = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1){
                    ans+=dfs(grid,i,j);        
                }
            }
        }
        return ans;
        
    }
    int dfs(int[][] grid, int i,int j){
        int n = grid.length;
        int m = grid[0].length;
        
        int count = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        for(int[] dir:dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            
            if(x>=0 && x<n && y>=0 && y<m && grid[x][y] == 1){
                count++;
            }
        }
        return 4-count;
    }
//    int[][] grid = {
//    		{1,1,1,1,0},
//    		{1,1,0,1,0},
//    		{1,1,0,0,0},
//    		{0,0,0,0,0}
//    };
//    IslandPerimiter instance = new IslandPerimiter();
//    System.out.println(instance.islandPerimeter(grid));
}
