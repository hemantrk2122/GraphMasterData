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
				System.out.println(e.u+' '+e.v+' '+e.w);
			}
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int vtces = scn.nextInt();
		ArrayList<Edge>[] graph = new ArrayList[vtces];
		for(int i = 0;i<vtces;i++) {
			graph[i] = new ArrayList<>();
		}
		int edge_count = scn.nextInt();
		for(int i = 0;i<edge_count;i++) {
			int u = scn.nextInt();
			int v = scn.nextInt();
			int w = scn.nextInt();
			addEdge(u,v,w,graph);
		}
		GraphConnected instance = new GraphConnected();
		instance.isgraphconnected(graph,new boolean[vtces],vtces);
		System.out.println(instance.cc.size() == 1);
		
		
	}
}
