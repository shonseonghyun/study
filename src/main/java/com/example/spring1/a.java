package com.example.spring1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a {
	public static void main(String[] args) {
		String[] genre={"classic","pop", "classic", "classic", "pop"};
		int[] plays= {500, 600, 150, 800, 2500};
		
		Map<String, Integer> map=new HashMap<>();
		for(int i=0;i<genre.length;i++) {
			map.put(genre[i], map.getOrDefault(genre[i], 0)+plays[i]);
		}
	
		for(String g:map.keySet()) {
			List<Integer> number=new ArrayList<Integer>();
			for(int i=0;i<genre.length;i++) {
				if(genre[i].equals(g)) {
					number.add(i);
				}
			}
			
			for(int n : number) {
				System.out.print(g+":"+n+",");
			}
		}
	}
		
		
	
}