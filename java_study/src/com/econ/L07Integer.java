package com.econ;

public class L07Integer {
	public static void main(String[] args) {
		long l=100l; //l을 포함하고 선언해야 long 의 수다.
		l=1; //l을 빼고 선언한 수의 type는 int\
		//=12345678901; //int로 표현할 수 있는 최대값을 넘어서 선언불가
		l=1234567890123456789l;
		System.out.println(l);
		
		int i=1234567890;
		//큰 수를 작은 타입으로 형변환 하는 3가지 방법으로 형변환(캐스팅)

		//1. 나눠서 넣는다 -> 최대값을 넘으면 다시 최소값부터 센다. (int, short, byte)
		i=Integer.MAX_VALUE+1;
		System.out.println(i);
		System.out.println(Integer.MIN_VALUE-1);
		byte b=127; //(-128~127);
		b=(byte)128;
		System.out.println(b);
		
		
		//2. 최대값만 취하고 나머진 버린다. (long)
		l=(long)1.12e30;
		System.out.println(l);
		System.out.println(Long.MAX_VALUE);
		
		//3. 무한대로 표시한다.(float, double)

		//System.out.println(i);
		
		
	}
}
