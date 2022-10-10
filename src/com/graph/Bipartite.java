package com.graph;
import java.util.ArrayList;
import java.util.LinkedList;
/*
 * Bipartite -> no cycle
 * Even Cycle -> Bipartite
 * Odd Cycle -> No Bipartite
 */
public class Bipartite {

	public boolean bipartite(int[][] graph, int src, int[] vis) {
		// TODO Auto-generated method stub
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.addLast(src);
		int color = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			while(size-->0) {
				int node = q.removeFirst();
				if(vis[node]!=-1) {
					if(vis[node]!=color)return false;
				}
				vis[node] = color;
				for(int e:graph[node]) {
					if(vis[e] == -1) {
						q.addLast(e);
					}
				}
			}
			color = (color+1)%2;
		}
		return true;
	}
	

}
