package com.econ.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Card{
	int num;
	String img;
	boolean flip;
	Card(int num){
		this.num=num;
	}
}
public class T05CardGame {
	public static void main(String[] args) {
		// 짝맞추기 카드 게임
		int[] cards= {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9};
		int[] random_cards=new int[18];
		////////////////////Array버전 설정///////////////////////////
		for(int i=0;i<cards.length;) {
			int ran_num=(int)(Math.random()*18);
			if(random_cards[ran_num]==0) {
				random_cards[ran_num]=cards[i];
				i++;
			}
		}
		////////////////////Array게임시작///////////////////////////
		boolean cardOn=true;
		while(cardOn) {
			System.out.print("위치 값 | ");
			for(int i=0;i<random_cards.length;i++) {
				System.out.printf("%4d",i);
			}
			System.out.println();
			System.out.print("내부 값 | ");
			for(int i=0;i<random_cards.length;i++) {
				System.out.printf("%4d",random_cards[i]);
			}
			
			System.out.print("\n하나를 선택하세요.(1~18) : ");
			Scanner sc= new Scanner(System.in);
			int ch_num=Integer.parseInt(sc.nextLine())-1;
			int mycard=random_cards[ch_num];
			System.out.println("위치("+(ch_num+1)+")의 선택한 카드 : "+mycard);
			if(mycard==0) {
				System.out.println("이미 짝을 맞춘 카드입니다. 다시 선택하세요.");
				continue;
			}
			
			System.out.print("나머지 하나를 선택하세요.(1~18) : ");
			sc= new Scanner(System.in);
			int ch_num2=Integer.parseInt(sc.nextLine())-1;
			int mycard2=random_cards[ch_num2];
			System.out.println("위치("+(ch_num2+1)+")의 선택한 카드 : "+mycard2);
			if(mycard2==0) {
				System.out.println("이미 짝을 맞춘 카드입니다. 다시 선택하세요.");
				continue;
			}
			
			if(mycard==mycard2) {
				System.out.println("같은 카드입니다.");
				random_cards[ch_num]=0;
				random_cards[ch_num2]=0;
			}else {
				System.out.println("다른 카드입니다.");
			}
			
			
			int j=0;
			for(int i=0;i<random_cards.length;i++) {
				if(random_cards[i]==0) {
					j++;
				}
			}
			if(j==18) {
				System.out.println("게임종료");
				cardOn=false;
			}
		}
		
		

		
		
		
		
		
//		////////////////////ArrayList버전///////////////////////////		
//		Integer[] cards= {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9};
//		Integer[] random_cards=new Integer[18];
//		for(int i=0;i<cards.length;) {
//			int random=(int)((new Random().nextDouble())*18);
//			if(random_cards[random]==null) {
//				random_cards[random]=cards[i];
//				i++;
//			}
//		}
//		System.out.println(new ArrayList(Arrays.asList(random_cards)));
//		////////////////////ArrayList버전2///////////////////////////		
//		System.out.println();
//		
//		Integer[] cards2= {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9};
//		ArrayList<Integer> cards2_arr_list=new ArrayList<>(Arrays.asList(cards2));
//		List<Integer> random2_arr_list=new ArrayList<>();
//		
//		for(int i=0;i<cards2.length;i++) { //18 or cards2.length로 상수로씀 원래 배열의 크기가 변동하기 때문
//			int ran_num=(int)(Math.random()*9)+1;
//			int index=cards2_arr_list.indexOf(ran_num); //그 위치
//			
//			if(index==-1) { //원래 배열에 값이 존재 안한다!! 다시 해야함
//				i--;
//				continue;
//			}else { //값이 존재한다
//				random2_arr_list.add(ran_num);
//				cards2_arr_list.remove(index); //원래 배열의 해당 위치의 값 삭제
//			}
//		}
//		System.out.println(cards2_arr_list);
//		System.out.println(random2_arr_list);
//		////////////////////ArrayList게임시작///////////////////////////
		
	}


}
