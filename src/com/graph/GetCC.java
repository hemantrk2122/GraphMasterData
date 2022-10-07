package com.graph;

import java.util.ArrayList;

public class GetCC {

	ArrayList<ArrayList<Integer>> cc = new ArrayList<>();
	public void getcc(ArrayList<Edge>[] graph, boolean[] vis) {
		// TODO Auto-generated method stub
		
		for(int i = 0;i<vis.length;i++) {
			if(!vis[i]) {
				ArrayList<Integer> comp= new ArrayList<>();
				dfs(graph,i,vis,comp);
				cc.add(comp);
			}
		}
	}
	private void dfs(ArrayList<Edge>[] graph, int i, boolean[] vis, ArrayList<Integer> comp) {
		// TODO Auto-generated method stub
		vis[i] = true;
		comp.add(i);
		for(Edge e:graph[i]) {
			int nbr = e.v;
			if(!vis[nbr]) {
				dfs(graph,nbr,vis,comp);
			}
		}
		
	}
//	GetCC instance = new GetCC();
//	instance.getcc(graph,new boolean[vtces]);
//	System.out.println(instance.cc);
	
}
