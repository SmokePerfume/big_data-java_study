package com.econ;

public class L43Math {

	public static void main(String[] args) {
		// �ݿø� ���� ����
		//double d=10.6;
		System.out.println("/////Math.round() �ݿø�/////");
		System.out.println("Math.round(10.3) : "+Math.round(10.3));
		System.out.println("Math.round(10.6) : "+Math.round(10.6));
		System.out.println("Math.round(-10.6) : "+Math.round(-10.6));
		System.out.println("Math.round(-10.2) : "+Math.round(-10.2));
		
		System.out.println("\n/////Math.floor() ����/////");
		System.out.println("Math.floor(10.3) : "+Math.floor(10.3));
		System.out.println("Math.floor(10.6) : "+Math.floor(10.6));
		System.out.println("Math.floor(-10.6) : "+Math.floor(-10.6));
		System.out.println("Math.floor(-10.2) : "+Math.floor(-10.2));
		
		System.out.println("\n/////Math.ceil() �ø�/////");
		System.out.println("Math.ceil(10.3) : "+Math.ceil(10.3));
		System.out.println("Math.ceil(10.6) : "+Math.ceil(10.6));
		System.out.println("Math.ceil(-10.6) : "+Math.ceil(-10.6));
		System.out.println("Math.ceil(-10.2) : "+Math.ceil(-10.2));
		
		System.out.println("\n/////(int)10.3 ����/////");
		System.out.println("(int)10.3 : "+(int)10.3);
		System.out.println("(int)10.6 : "+(int)10.6);
		System.out.println("(int)-10.6 : "+(int)-10.6);
		System.out.println("(int)-10.2 : "+(int)-10.2);

		System.out.println("\n/////Math.rint() �Ҽ��� ��ȯ�ϴ� �ݿø�/////");
		System.out.println("Math.rint(10.3) : "+Math.rint(10.3));
		System.out.println("Math.rint(10.6) : "+Math.rint(10.6));
		System.out.println("Math.rint(-10.6) : "+Math.rint(-10.6));
		System.out.println("Math.rint(-10.2) : "+Math.rint(-10.2));

		System.out.println("\n/////Math.pow(a,b) a�� b����(�ŵ�����)/////");
		System.out.println("Math.pow(2,5) : "+Math.pow(2,5));
		

		System.out.println("\n/////Math.random()/////");
		System.out.println("Math.random() : "+Math.random()); //0~1���� �Ǽ�
		System.out.println("((int)(Math.random()*3)+1) : "+((int)(Math.random()*3)+1)); 
		//(int)(Math.random()*(���ϴ� ��))+1)
		
	}

}
