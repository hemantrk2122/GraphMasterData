package com.graph;

import java.util.ArrayList;

/*
 * In a directed graph if there a edge exists from u->v then in Topological ordering u should come before v
 * If Cycle exist in a directed graph then Topological sort is not possible
 * Topological order is not possible in Undirected graph 
 */
public class TopologicalSort {

	public int[] toposort(ArrayList<Edge>[] graph) {
		// TODO Auto-generated method stub
		ArrayList<Integer> al = new ArrayList<>();
		boolean[] vis = new boolean[graph.length];
		for(int i =0;i<graph.length;i++) {
			if(!vis[i]) {
				dfs(graph,i,vis,al);
			}
		}
		int[] topo = new int[graph.length];
		int j = 0;
		for(int i = graph.length-1;i>=0;i--) {
			topo[j++] = al.get(i);
		}
		return topo;
	}

	private void dfs(ArrayList<Edge>[] graph, int src, boolean[] vis, ArrayList<Integer> al) {
		vis[src] = true;
		for(Edge e:graph[src]) {
			int nbr = e.v;
			if(!vis[nbr]) {
				dfs(graph,nbr,vis,al);
			}
		}
		al.add(src);
	}
	
//	4
//	3
//	3 0
//	3 2
//	0 2
//	3 1 0 2 

}
