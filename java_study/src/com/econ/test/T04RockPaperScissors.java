package com.econ.test;

import java.util.Random;
import java.util.Scanner;

public class T04RockPaperScissors {
	public static void main(String[] args) {
		System.out.println(new Random().nextDouble()); //==Math.random
		String[] rps= {"����","����","��"};
		Scanner sc = new Scanner(System.in);
		System.out.print("����(0), ����(1), ��(2) : ");
		String input=sc.nextLine();
		int parse_int=Integer.parseInt(input);
		int you=(int)((new Random().nextDouble())*3);
		//������ �̿��ؼ� ��ǻ�Ͱ� ���� ���� �� �߿� �ڰ��� ����.
		System.out.println(rps[parse_int]+"vs"+rps[you]);
		int result=parse_int-you;
		if(result==0) {
			System.out.println("���º�");
		}else if(result==-1||result==2) { //���� �ָ� (-1)/ �ָ� �� (-1)/ �� ���� 2
			System.out.println("�й�");
		}else if(result==1||result==-2){  // �ָ� ���� 1 / ���� �� -2 / �� ���� 1
			System.out.println("�¸�");
		}
		
	}

}
