package com.graph;

import java.util.*;

public class Graph {
	public static void addEdge(int u,int v,int w, ArrayList<Edge>[] graph) {
		graph[u].add(new Edge(u,v,w));
		graph[v].add(new Edge(v,u,w));
	}
	public static void display(ArrayList<Edge>[] graph) {
		for(int i = 0;i<graph.length;i++) {
			for(Edge e:graph[i]){
				System.out.println(e.u+ +e.v+ +e.w);
			}
		}
	}
	public static void main(String[] args) {
//		Scanner scn = new Scanner(System.in);
//		int vtces = scn.nextInt();
//		ArrayList<Edge>[] graph = new ArrayList[vtces];
//		for(int i = 0;i<vtces;i++) {
//			graph[i] = new ArrayList<>();
//		}
//		int edge_count = scn.nextInt();
//		for(int i = 0;i<edge_count;i++) {
//			int u = scn.nextInt();
//			int v = scn.nextInt();
//			int w = scn.nextInt();
//			addEdge(u,v,w,graph);
//		}
//		int src = scn.nextInt();
//		int t = scn.nextInt();
//		SpreadOfInfection instance = new SpreadOfInfection();
//		System.out.println(instance.spreadofinfection2(graph,new boolean[vtces],src,t));
		int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
		int[][] graph2 = {{1,2,3},{0,2},{0,1,3},{0,2}};
		int vtces = graph.length;
		int[] vis = new int[vtces];
		Arrays.fill(vis,-1);
		Bipartite instance = new Bipartite();
		boolean ans = true;
		for(int i = 0;i<vtces;i++) {
			if(vis[i]==-1) {
				boolean even = instance.bipartite(graph,i,vis);
				if(!even)ans = false;
			}
		}
		System.out.println(ans);
	}
}
