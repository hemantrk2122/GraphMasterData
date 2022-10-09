package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class SpreadOfInfection {

	public int spreadofinfection(ArrayList<Edge>[] graph, boolean[] vis, int src, int t) {
		int ans = 0,level = 1;
		LinkedList<Integer> q = new LinkedList<>();
		q.addLast(src);
		vis[src] = true;
		while(!q.isEmpty()) {
			int size = q.size();
			ans+=size;
			while(size-->0) {
				int node = q.removeFirst();
				for(Edge e:graph[node]) {
					int nbr = e.v;
					if(!vis[nbr]) {
						q.addLast(nbr);
						vis[nbr] = true;
					}
				}
			}
			level++;
			if(level == t+1) {
				break;
			}
		}
		return ans;
	}

}
