package com.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;


class Multisolver{
	String spath;
	int spathwt = Integer.MAX_VALUE;
	String lpath;
	int lpathwt = Integer.MIN_VALUE;
	String cpath;
	int cpathwt = Integer.MAX_VALUE;
	String fpath;
	int fpathwt = Integer.MIN_VALUE;
	PriorityQueue<Pair> pq= new PriorityQueue<>();
	public void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis, int criteria, int k, String psf,
			int wsf) {
		if(src == dest) {
			if(wsf<spathwt) {
				spathwt = wsf;
				spath = psf;
			}
			if(wsf>lpathwt) {
				lpathwt = wsf;
				lpath = psf;
			}
			if(wsf>criteria && wsf<cpathwt) {
            cpathwt = wsf;
				cpath = psf;
			}
			if(wsf<criteria && wsf>fpathwt) {
				fpathwt = wsf;
				fpath = psf;
			}
			pq.add(new Pair(wsf,psf));
			if(pq.size()>k) {
				pq.remove();
			}
		}
		
		vis[src] = true;
		for(Edge e:graph[src]) {
			int nbr = e.v;
			int w = e.w;
			if(!vis[nbr]) {
				multisolver(graph,nbr,dest,vis,criteria,k,psf+nbr,wsf+w);
			}
		}
		vis[src] = false;
	}
//	String psf = src+"";
//	int criteria = scn.nextInt();
//	int k = scn.nextInt();
//	int wsf = 0;
//	Multisolver instance = new Multisolver();
//	instance.multisolver(graph, src, dest, new boolean[vtces],  criteria,  k,  psf,  wsf);
//	System.out.println("Smallest Path = " + instance.spath + "@" + instance.spathwt);
//    System.out.println("Largest Path = " + instance.lpath + "@" + instance.lpathwt);
//    System.out.println("Just Larger Path than " + criteria + " = " + instance.cpath + "@" + instance.cpathwt);
//    System.out.println("Just Smaller Path than " + criteria + " = " + instance.fpath + "@" + instance.fpathwt);
//    System.out.println(k + "th largest path = " + instance.pq.peek().psf + "@" + instance.pq.peek().wsf);
	
}
