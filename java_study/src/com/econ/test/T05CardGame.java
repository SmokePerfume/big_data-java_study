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
		// ¦���߱� ī�� ����
		int[] cards= {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9};
		int[] random_cards=new int[18];
		////////////////////Array���� ����///////////////////////////
		for(int i=0;i<cards.length;) {
			int ran_num=(int)(Math.random()*18);
			if(random_cards[ran_num]==0) {
				random_cards[ran_num]=cards[i];
				i++;
			}
		}
		////////////////////Array���ӽ���///////////////////////////
		boolean cardOn=true;
		while(cardOn) {
			System.out.print("��ġ �� | ");
			for(int i=0;i<random_cards.length;i++) {
				System.out.printf("%4d",i);
			}
			System.out.println();
			System.out.print("���� �� | ");
			for(int i=0;i<random_cards.length;i++) {
				System.out.printf("%4d",random_cards[i]);
			}
			
			System.out.print("\n�ϳ��� �����ϼ���.(1~18) : ");
			Scanner sc= new Scanner(System.in);
			int ch_num=Integer.parseInt(sc.nextLine())-1;
			int mycard=random_cards[ch_num];
			System.out.println("��ġ("+(ch_num+1)+")�� ������ ī�� : "+mycard);
			if(mycard==0) {
				System.out.println("�̹� ¦�� ���� ī���Դϴ�. �ٽ� �����ϼ���.");
				continue;
			}
			
			System.out.print("������ �ϳ��� �����ϼ���.(1~18) : ");
			sc= new Scanner(System.in);
			int ch_num2=Integer.parseInt(sc.nextLine())-1;
			int mycard2=random_cards[ch_num2];
			System.out.println("��ġ("+(ch_num2+1)+")�� ������ ī�� : "+mycard2);
			if(mycard2==0) {
				System.out.println("�̹� ¦�� ���� ī���Դϴ�. �ٽ� �����ϼ���.");
				continue;
			}
			
			if(mycard==mycard2) {
				System.out.println("���� ī���Դϴ�.");
				random_cards[ch_num]=0;
				random_cards[ch_num2]=0;
			}else {
				System.out.println("�ٸ� ī���Դϴ�.");
			}
			
			
			int j=0;
			for(int i=0;i<random_cards.length;i++) {
				if(random_cards[i]==0) {
					j++;
				}
			}
			if(j==18) {
				System.out.println("��������");
				cardOn=false;
			}
		}
		
		

		
		
		
		
		
//		////////////////////ArrayList����///////////////////////////		
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
//		////////////////////ArrayList����2///////////////////////////		
//		System.out.println();
//		
//		Integer[] cards2= {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9};
//		ArrayList<Integer> cards2_arr_list=new ArrayList<>(Arrays.asList(cards2));
//		List<Integer> random2_arr_list=new ArrayList<>();
//		
//		for(int i=0;i<cards2.length;i++) { //18 or cards2.length�� ����ξ� ���� �迭�� ũ�Ⱑ �����ϱ� ����
//			int ran_num=(int)(Math.random()*9)+1;
//			int index=cards2_arr_list.indexOf(ran_num); //�� ��ġ
//			
//			if(index==-1) { //���� �迭�� ���� ���� ���Ѵ�!! �ٽ� �ؾ���
//				i--;
//				continue;
//			}else { //���� �����Ѵ�
//				random2_arr_list.add(ran_num);
//				cards2_arr_list.remove(index); //���� �迭�� �ش� ��ġ�� �� ����
//			}
//		}
//		System.out.println(cards2_arr_list);
//		System.out.println(random2_arr_list);
//		////////////////////ArrayList���ӽ���///////////////////////////
		
	}


}
