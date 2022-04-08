package com.econ;

import java.util.Scanner;

public class L14IfElse {

	public static void main(String[] args) {
		int month=12; //1~12;
		String[] month_arr= {"Jan", "Feb", "Mar", "Apr", "May", "Jun","Jul", "Aug", "Sep","Oct","Nov", "Dec"};
		//1~12까지의 입력이 들어오면 오늘은 Mar 달입니다. 출력하세요.
		//1~12까지가 아니면 1~12까지의 수를 입력하세요 출력!!
		if(month>=1&&month<=12) {
			System.out.println("오늘은 "+month+"월 "+month_arr[month-1]+"입니다.");
		}else {
			System.out.println("1~12까지 수를 입력하세요.");
		}
		//개발단에서 처리하는 예외처리!
		int week=8; //1~7;
		String[] week_arr=new String[7];
		week_arr[0]="SUn";
		week_arr[1]="Mon";
		week_arr[2]="Tues";
		week_arr[3]="Wed";
		week_arr[4]="Thus";
		week_arr[5]="Fri";
		week_arr[6]="Sat";
		//오류가 발생했을 때 예외처리
		try {
			System.out.println("오늘은"+week_arr[week-1]+"입니다.");
			System.out.println("오류가 발생하면 catch로 바로 이동한다.");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("오류 : "+e.getMessage()); //개발자만 봐야하는 메세지
			System.out.println("1~7까지만 입력하세요!");
		}
		System.out.println("오류가 발생하면 자바는 실행을 멈춘다.");
		//if문으로 예외처리 할 때 이득
		//1. 어떤 문제가 코드상에서 발생하는지 알 수 있다. => 구체적으로 오류를 막을 수 있다.
		//2. 오류가 발생하기전에 막을 수 있다.
		
		//try catch를 사용할 수 밖에 없는 상태
		//1. 통신을 할 때 생기는 문제를 처리할 때
		//2. 라이브러리를 사용할때 if문 사용에 한계가 있을 때
		
		//콘솔에 입력한 문자를 입력받는 System.in
		System.out.print("영어로 확인하고 싶은 달 입력: ");
		Scanner sc= new Scanner(System.in); //문자를 입력하고 라인 개행을 하면 라인개행 하기 전까지 입력한 문자를 받을 수 있다.
		String month_input=sc.nextLine();// 문자중에 숫자가 아닌 것이 있는지 검사
		
		
		
		
		
		
		//문자열 입력시 다시 입력받으세요!
		//1~12까지도 검사하세요!!
//		try {
//			int month_par=Integer.parseInt(month_input);
//			System.out.println("당신이 입력한 달은 "+ month_arr[month_par-1]+"입니다.");
//		}catch(ArrayIndexOutOfBoundsException e){
//			System.out.println("1~12사이의 정수가 아님");
//		}catch(NumberFormatException e){
//			System.out.println("숫자가 아님");
//		}
		
		if(stringIntTest(month_input)) {
			int month_par=Integer.parseInt(month_input);
			if(month_par>0&&month_par<13) {
				System.out.println("당신이 입력한 달은 "+ month_arr[month_par-1]+"입니다.");
			}else {
				System.out.println("1~12사이의 정수가 아님");
			}
		}else {
			System.out.println("정수만 입력하세요!!");
		}		
		
		
		
	}
	static Boolean stringIntTest(String a){
		//문자열중에 1개의 문자라도 숫자가 아니면 false
		for(int i=0; i<a.length();i++){
			int a_par=(int)a.charAt(i);
			System.out.println(a.charAt(i)+" : "+a_par);
			if(a_par<48||a_par>58) {
				return false;
			}
		} 
		return true;
	}

}
