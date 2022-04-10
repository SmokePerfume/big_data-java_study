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
	LinkedList<Card> click_cards=new LinkedList<Card>();// ������ ī��	
	JFrame f=this;
	public CardGameFrame(String title) throws InterruptedException {
		super(title);
		randomCards();
		for(Card c :cards) { //������ ���ÿ� ��ư�� �̺�Ʈ ����
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
		Thread t2=new Thread(new Runnable() {//�ٽ� ������	(���� �����)
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
				//������ �ΰ��� ī�尡 ������ .5�ʸ��� ������ �˻��ϴ� �ڵ� 
				while(true) {
					try {Thread.sleep(500);} catch (InterruptedException e1) {	e1.printStackTrace();}
					if(click_cards.size()==2) { 
						//�������� �� �ٽ� ������
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
						//�������� �� �ٽ� ���������� �ʵ��� true�� �ٲٱ�
							for(Card c: click_cards) {
								c.success=true;
								c.setText(c.card_num+"");					
							}
						}
						click_cards.clear();	
						//�����ϵ� �����ϵ� 2�� Ŭ���ϰ� ���� Ŭ�� �ʱ�ȭ
					}
				}
			}
		});
		this.setLayout(new GridLayout(3,4));
		this.setBounds(600,100,600,800);
		this.setVisible(true);
		this.validate();	//���ΰ�ħ
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		for(Card c: cards) { //��ư
			c.addActionListener(new ChoiceCard(c));
		}
		t3.start();
		
		
		
	}
	
	public void randomCards() {//��ũ����Ʈ ��ȯ �� �� ũ��ȿ��� ������ ��ġ�� ���ڸ� �̾Ƴ�
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
			if(c.success) return; //������ ī�带 ���� 
			if(click_cards.size()<2) {//������ ī�带 �����ϰ� ���� & �������� ���� ī��� ���
				if(click_cards.size()==1 && c==click_cards.get(0) ) return; 
				click_cards.add(c);
				c.setText(c.card_num+"");
			}
		}

	}
}
class Card extends JButton{
	public int card_num;
	public boolean success=false; //�̹� ���� ī��
	public Card(int card_num) {
		this.card_num=card_num;
	}
}

public class L06CardGame{
	public static void main(String[]args) {	
		try{
			new CardGameFrame("ī�����");
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
