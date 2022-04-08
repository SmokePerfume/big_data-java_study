package com.econ.test;

public class T01IfSwitch {
	public static void main(String[] args) {
		long start2=System.currentTimeMillis();
		System.out.println(2+3);
		long end2=System.currentTimeMillis(); //	1/1000초
		System.out.println("2+3(소요시간):"+(end2-start2));

		long start=System.nanoTime();
		System.out.println(2+3);
		long end=System.nanoTime(); //	1/1000000000초 jvm이 켜지는 시간부터 0이 시작
		System.out.println("2+3(소요시간):"+(end-start));
		
		
		////////////////////////////////////
		int score=55;
		int score2=45;
		String A1 ="A+";
		String A ="A";
		String B1 ="B+";
		String B ="B";
		String C1 ="C+";
		String C ="C";
		String D1 ="D+";
		String D ="D";
		String F ="F";

		
		System.out.println("/////////////////////////");
		start=System.nanoTime();
		String grade="";
		if(score>=95) {
			grade=A1;
		}else if(score>=90) {
			grade=B;
		}else if(score>=85) {
			grade=B1;
		}else if(score>=80) {
			grade=B;
		}else if(score>=75) {
			grade=C1;
		}else if(score>=70) {
			grade=C;
		}else if(score>=65) {
			grade=D1;
		}else if(score>=60) {
			grade=D;
		}else {
			grade=F;
		}
		System.out.println("당신의 성적은 "+grade);
		end=System.nanoTime();
		System.out.println("성적 if(소요시간) : " + (end-start));
		
		System.out.println("/////////////////////////");
		
		start=System.nanoTime();
		String grade2="";
		switch(score2/10) {
		case 10:
			grade2=A1;
			break;
		case 9:
			grade2=A;
			break;
		case 8:
			grade2=B;
			break;
		case 7:
			grade2=C;
			break;
		case 6:
			grade2=D;
			break;
		default:
			grade2=F;
			break;
		}
		if(score2%10>=5&&score2>=65)grade2+="+";
		System.out.println("당신의 성적은 "+grade2);
		end=System.nanoTime();
		System.out.println("성적 switch(소요시간) : " + (end-start));
		System.out.println("/////////////////////////");
	}
}
