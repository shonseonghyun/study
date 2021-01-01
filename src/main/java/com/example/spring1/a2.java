package com.example.spring1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class a2 {
	public static void main(String[] args) {
		int[] pro={93,30,55};
		int[] speeds={1,30,5};
		Queue<Integer> q=new LinkedList<>();
		
		int len = pro.length;
		for(int i=0;i<len;i++) {
			int Leftprogress=100-pro[i]; //70
			int Leftdays=0;
			if(Leftprogress%speeds[i]!=0) { //70/30 나머지가 있을 경우;
				Leftdays=Leftprogress/speeds[i]+1;
			}
			else {
				Leftdays=Leftprogress/speeds[i];
			}
			//큐에 남은 날짜 삽입
			q.add(Leftdays);
			
		}
		q.add(0);
		for(Integer i:q) {
			System.out.print(i );
		}
		
		int before=q.poll(); //5 //10
		int after=q.poll();  //10 //1
		int cnt=1;
		while(!q.isEmpty()) { 
			if(before<after) {
				cnt=1;
				if(!q.isEmpty() && q.peek()==0){
					before=after;
					after=q.poll();
					q.poll();
					System.out.println(1);
				}
				if(q.isEmpty())
				{
					System.out.println(2);
					break;
				}
			}
			
			else {//before>after
				after=q.poll();
				cnt++;
				if(before<after) {
					System.out.println("상승:"+cnt);
				}
			}
		}
	}	
}