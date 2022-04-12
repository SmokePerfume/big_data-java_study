package com.econ.synchronize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L01ThreadError {
	static int a=0;
	static List arr=new ArrayList();
	static Map map=new HashMap();
	
	public static void main(String[] args) throws InterruptedException {
		Thread[] t_arr=new Thread[1000];
		for(int k=0;k<1000;k++) {
			t_arr[k]=new Thread() {
				@Override
				public void run() {
					for(int i=0;i<100;i++) {
						a++;
						arr.add(i);
						map.put(i, i);
					}
				}
			};
			t_arr[k].start();
		}
		for(Thread t:t_arr) {
			t.join();
		}

		System.out.println("a:"+a);
		System.out.println("arr.size():"+arr.size());
		System.out.println("map.size():"+map.size());
	}
}
