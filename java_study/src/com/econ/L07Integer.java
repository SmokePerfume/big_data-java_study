package com.econ;

public class L07Integer {
	public static void main(String[] args) {
		long l=100l; //l�� �����ϰ� �����ؾ� long �� ����.
		l=1; //l�� ���� ������ ���� type�� int\
		//=12345678901; //int�� ǥ���� �� �ִ� �ִ밪�� �Ѿ ����Ұ�
		l=1234567890123456789l;
		System.out.println(l);
		
		int i=1234567890;
		//ū ���� ���� Ÿ������ ����ȯ �ϴ� 3���� ������� ����ȯ(ĳ����)

		//1. ������ �ִ´� -> �ִ밪�� ������ �ٽ� �ּҰ����� ����. (int, short, byte)
		i=Integer.MAX_VALUE+1;
		System.out.println(i);
		System.out.println(Integer.MIN_VALUE-1);
		byte b=127; //(-128~127);
		b=(byte)128;
		System.out.println(b);
		
		
		//2. �ִ밪�� ���ϰ� ������ ������. (long)
		l=(long)1.12e30;
		System.out.println(l);
		System.out.println(Long.MAX_VALUE);
		
		//3. ���Ѵ�� ǥ���Ѵ�.(float, double)

		//System.out.println(i);
		
		
	}
}
