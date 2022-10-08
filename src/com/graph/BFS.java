package com.graph;

import java.util.*;
//BFS insures minimum distance
public class BFS {
	public void bfs(ArrayList<Edge>[] graph, int src) {
		// TODO Auto-generated method stub
		LinkedList<PairBFS> que = new LinkedList<>();
		int vtces = graph.length;
		boolean[] vis = new boolean[vtces];
		que.addLast(new PairBFS(src,src+""));
		int level = 0;
		// when to mark visited a node -> 1. when adding to the queue & 2. when removing from a queue
		
		while(!que.isEmpty()) {
			int size = que.size();
			while(size-->0) {
				PairBFS t = que.removeFirst();
				int node = t.node;
				String psf = t.path;
				if(vis[node])continue;
				vis[node] = true;
				System.out.println(node+"@"+psf);
				for(Edge e:graph[node]) {
					int nbr = e.v;
					if(!vis[nbr]) {
						que.addLast(new PairBFS(nbr,psf+nbr));
					}
				}
			}
			level++;
		}
		System.out.println("Level :" + level);
	}
	
}

	
