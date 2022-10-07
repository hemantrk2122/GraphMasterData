package com.graph;

class Pair implements Comparable<Pair>{

	int wsf;
	String psf;
	Pair(int wsf, String psf){
		this.wsf = wsf;
		this.psf = psf;
	}
	@Override
	public int compareTo(Pair o) {
		return this.wsf - o.wsf;
	}
	
}