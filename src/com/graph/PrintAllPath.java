package com.graph;

import java.util.ArrayList;

public class PrintAllPath {
	public static void printAllPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis, String psf) {
		if(src == dest) {
			System.out.println(psf);
			return;
		}
		vis[src]=true;
		for(Edge e:graph[src]) {
			int nbr = e.v;
			if(!vis[nbr]) {
				printAllPath(graph,nbr,dest,vis,psf+nbr);
			}
		}
		vis[src] = false;
	}
}
