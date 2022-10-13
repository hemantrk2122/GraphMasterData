package com.graph;

import java.util.HashMap;
import java.util.Scanner;

public class ThreeSum {

	public void solve() {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int target = scn.nextInt();
		int[] arr = new int[n];
		for(int i =0;i<n;i++){
			arr[i] = scn.nextInt();
		}
		boolean found = false;
		for(int i = 0;i<n-2;i++){
			int newTarget = target - arr[i];
			HashMap<Integer,Integer> mp = new HashMap<>();//{element,index}
			for(int j = i+1;j<n;j++){
				if(mp.containsKey(newTarget-arr[j])){
					int l = i+1;
					int m = mp.get(newTarget-arr[j])+1;
					int r = j+1;
					System.out.println(l+" "+m+" "+r );
					found = true;
					break;
				}
				mp.put(arr[j],j);
			}
			if(found)break;
		}
		if(!found)System.out.println(-1);
		
	}

}
