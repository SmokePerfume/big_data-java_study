package com.econ.test;

import java.util.Random;
import java.util.Scanner;

public class T04RockPaperScissors {
	public static void main(String[] args) {
		System.out.println(new Random().nextDouble()); //==Math.random
		String[] rps= {"가위","바위","보"};
		Scanner sc = new Scanner(System.in);
		System.out.print("가위(0), 바위(1), 보(2) : ");
		String input=sc.nextLine();
		int parse_int=Integer.parseInt(input);
		int you=(int)((new Random().nextDouble())*3);
		//랜덤을 이용해서 컴퓨터가 가위 바위 보 중에 핸개를 낸다.
		System.out.println(rps[parse_int]+"vs"+rps[you]);
		int result=parse_int-you;
		if(result==0) {
			System.out.println("무승부");
		}else if(result==-1||result==2) { //가위 주먹 (-1)/ 주먹 보 (-1)/ 보 가위 2
			System.out.println("패배");
		}else if(result==1||result==-2){  // 주먹 가위 1 / 가위 보 -2 / 보 바위 1
			System.out.println("승리");
		}
		
	}

}
