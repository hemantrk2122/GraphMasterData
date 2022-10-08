package com.graph;

import java.util.LinkedList;

public class RottenOranges {

	public int rottenoranges(int[][] grid) {
		// TODO Auto-generated method stub
		int n = grid.length;
        int m = grid[0].length;
        
        LinkedList<Integer> q = new LinkedList<>();
        
        int freshOranges = 0;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j] == 1){
                    freshOranges++;
                }
                else if(grid[i][j] == 2){
                    q.addLast(i*m+j);
                }
            }
        }
        if(freshOranges == 0)return 0; 
        
        int level = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(q.size()>0){
            int size = q.size();
            while(size-->0){
                int t = q.removeFirst();
                
                int i = t/m;
                int j = t%m;
                
                for(int[] dir:dirs){
                    int x = i + dir[0];
                    int y = j + dir[1];
                    
                    if(x>=0 && x<n && y>=0 && y<m && grid[x][y] == 1){
                        grid[x][y] = 2;
                        freshOranges--;
                        
                        if(freshOranges == 0){
                            return level+1;
                        }
                        q.addLast(x*m+y);
                    }
                }
            }level+=1;
        }
        return -1;
	}

}
