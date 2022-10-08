package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class IsGraphCyclic {

	public boolean isgraphcyclic(ArrayList<Edge>[] graph, int vtces) {
		// TODO Auto-generated method stub
		boolean ans = false;
		boolean[] vis = new boolean[vtces];
		for(int i =0;i<vtces;i++) {
			if(vis[i]==false)
			ans = ans || bfs(graph,i,vis);
		}
		return ans;
	}

	public boolean bfs(ArrayList<Edge>[] graph, int src, boolean[] vis) {
		// TODO Auto-generated method stub
		LinkedList<Integer> q = new LinkedList<>();
	      q.addLast(src);
	      while(q.size()>0){
	         int node = q.removeFirst();
	         if(vis[node]==true){
	            return true;
	         }
	         vis[node] = true;
	         for(Edge e:graph[node]){
	            int nbr = e.v;
	            if(!vis[nbr]) {
	            	q.addLast(nbr);
	            }
	         }
	      }
	      return false;
	}

}
