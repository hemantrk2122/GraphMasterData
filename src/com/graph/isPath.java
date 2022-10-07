package com.graph;

import java.util.*;


public class isPath {
	
	public static boolean ispath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
		if(src == dest)return true;
		vis[src] = true;
		for(Edge e: graph[src]) {
			int nbr = e.v;
			if(!vis[nbr]) {
				if(ispath(graph,nbr,dest,vis))return true;
			}
		}
		return false;
	}
}
