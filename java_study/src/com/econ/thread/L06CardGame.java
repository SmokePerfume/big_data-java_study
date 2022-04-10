package com.econ.thread;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;


class CardGameFrame extends JFrame{
	Card[] cards=new Card[12];
	Integer [] cards_nums= {1,1,2,2,3,3,4,4,5,5,6,6};
	LinkedList<Card> click_cards=new LinkedList<Card>();// 선택한 카드	
	JFrame f=this;
	public CardGameFrame(String title) throws InterruptedException {
		super(title);
		randomCards();
		for(Card c :cards) { //생성과 동시에 버튼에 이벤트 설정
			add(c); 
		}
		
		Thread t1=new Thread(new Runnable() {
			public void run() {
				for(Card c :cards) {
					try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
					c.setText(c.card_num+"");
					f.validate();
				}
			}
		});
		Thread t2=new Thread(new Runnable() {//다시 가리기	(숫자 지우기)
			@Override
			public void run() {
				for(Card c :cards) {
					try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
					c.setText("");
					f.validate();
				}
			}
		});
		Thread t3=new Thread(new Runnable() {
			@Override
			public void run() {
				//선택한 두개의 카드가 같은지 .5초마다 무한히 검사하는 코드 
				while(true) {
					try {Thread.sleep(500);} catch (InterruptedException e1) {	e1.printStackTrace();}
					if(click_cards.size()==2) { 
						//실패했을 때 다시 뒤집기
						if(click_cards.get(0).card_num!=click_cards.get(1).card_num) {
							try {Thread.sleep(500);} catch (InterruptedException e1) {e1.printStackTrace();}
							for(Card c: click_cards) {
								c.setText(c.card_num+"");	
							}
							try {Thread.sleep(200);} catch (InterruptedException e1) {	e1.printStackTrace();}								
							for(Card c: click_cards) {
								c.setText("");								
							}
						}else{
						//성공했을 때 다시 뒤집어지지 않도록 true로 바꾸기
							for(Card c: click_cards) {
								c.success=true;
								c.setText(c.card_num+"");					
							}
						}
						click_cards.clear();	
						//성공하든 실패하든 2번 클릭하고 나면 클릭 초기화
					}
				}
			}
		});
		this.setLayout(new GridLayout(3,4));
		this.setBounds(600,100,600,800);
		this.setVisible(true);
		this.validate();	//새로고침
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		for(Card c: cards) { //버튼
			c.addActionListener(new ChoiceCard(c));
		}
		t3.start();
		
		
		
	}
	
	public void randomCards() {//링크리스트 변환 후 그 크기안에서 랜덤한 위치의 숫자를 뽑아냄
		LinkedList<Integer> card_list=new LinkedList<Integer>(Arrays.asList(cards_nums)); 
		for(int i=0; i< cards_nums.length; i++){
			int random=(int)(new Random().nextDouble()*card_list.size());
			cards[i]=new Card(card_list.remove(random));
		}	
	}
	
	class ChoiceCard implements ActionListener{
		Card c;
		public ChoiceCard(Card c) {
			this.c=c;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(c.success) return; //성공한 카드를 선택 
			if(click_cards.size()<2) {//성공한 카드를 제외하고 선택 & 숫보여줌 같은 카드면 취소
				if(click_cards.size()==1 && c==click_cards.get(0) ) return; 
				click_cards.add(c);
				c.setText(c.card_num+"");
			}
		}

	}
}
class Card extends JButton{
	public int card_num;
	public boolean success=false; //이미 끝난 카드
	public Card(int card_num) {
		this.card_num=card_num;
	}
}

public class L06CardGame{
	public static void main(String[]args) {	
		try{
			new CardGameFrame("카드게임");
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
