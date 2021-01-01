package com.example.spring1;

import java.util.ArrayList;
import java.util.List;


public class a3 {
	static List<int[]> list=new ArrayList<>();
	
	public static int factorial(int n) {
		if(n<1 || n==1) return 1;
		else {
			return factorial(n-1)*n;
		}
	}
	
	public static void swap(int[] arr,int x,int y) {
		int temp=arr[x];
		arr[x]=arr[y];
		arr[y]=temp;
	}
	public static void print(int[] arr){
		for (int i = 0; i < arr.length; i++){
			if (i == arr.length - 1) System.out.println(arr[i]);
			else System.out.print(arr[i] + ","); }
	}

	
	public static void perm(int[] arr,int pivot) {
		if(pivot==arr.length) {
			list.add(arr);
			return;
		}
		for(int i=pivot;i<arr.length;i++) {
			swap(arr,i,pivot);
			perm(arr,pivot+1);
			swap(arr,i,pivot);
		}
	}
	
	public static void main(String[] args) {
		int[] b= {6,10,2};
		int[] combination=new int[factorial(b.length)];
		perm(b,0);
		
		
		
	}
	
}