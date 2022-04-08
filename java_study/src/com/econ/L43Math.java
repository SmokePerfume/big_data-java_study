package com.econ;

public class L43Math {

	public static void main(String[] args) {
		// 반올림 내림 버림
		//double d=10.6;
		System.out.println("/////Math.round() 반올림/////");
		System.out.println("Math.round(10.3) : "+Math.round(10.3));
		System.out.println("Math.round(10.6) : "+Math.round(10.6));
		System.out.println("Math.round(-10.6) : "+Math.round(-10.6));
		System.out.println("Math.round(-10.2) : "+Math.round(-10.2));
		
		System.out.println("\n/////Math.floor() 내림/////");
		System.out.println("Math.floor(10.3) : "+Math.floor(10.3));
		System.out.println("Math.floor(10.6) : "+Math.floor(10.6));
		System.out.println("Math.floor(-10.6) : "+Math.floor(-10.6));
		System.out.println("Math.floor(-10.2) : "+Math.floor(-10.2));
		
		System.out.println("\n/////Math.ceil() 올림/////");
		System.out.println("Math.ceil(10.3) : "+Math.ceil(10.3));
		System.out.println("Math.ceil(10.6) : "+Math.ceil(10.6));
		System.out.println("Math.ceil(-10.6) : "+Math.ceil(-10.6));
		System.out.println("Math.ceil(-10.2) : "+Math.ceil(-10.2));
		
		System.out.println("\n/////(int)10.3 버림/////");
		System.out.println("(int)10.3 : "+(int)10.3);
		System.out.println("(int)10.6 : "+(int)10.6);
		System.out.println("(int)-10.6 : "+(int)-10.6);
		System.out.println("(int)-10.2 : "+(int)-10.2);

		System.out.println("\n/////Math.rint() 소수로 반환하는 반올림/////");
		System.out.println("Math.rint(10.3) : "+Math.rint(10.3));
		System.out.println("Math.rint(10.6) : "+Math.rint(10.6));
		System.out.println("Math.rint(-10.6) : "+Math.rint(-10.6));
		System.out.println("Math.rint(-10.2) : "+Math.rint(-10.2));

		System.out.println("\n/////Math.pow(a,b) a의 b제곱(거듭제곱)/////");
		System.out.println("Math.pow(2,5) : "+Math.pow(2,5));
		

		System.out.println("\n/////Math.random()/////");
		System.out.println("Math.random() : "+Math.random()); //0~1사이 실수
		System.out.println("((int)(Math.random()*3)+1) : "+((int)(Math.random()*3)+1)); 
		//(int)(Math.random()*(원하는 수))+1)
		
	}

}
