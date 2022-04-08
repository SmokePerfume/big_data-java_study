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
	JFrame f=this;
	
	public CardGameFrame(String title) {
		super(title);
		randomCards();
		//Card ��ư 12���� flame�� ���̱�
		for(Card c :cards) {
			add(c);
			
			c.addActionListener(new ChoiceCard(c,f)); //�ܼ�â�� tf�� �Էµ� ���� ���!!
		}
		//card ��ư 12���� flame�� ���̱�
		new Thread(new Runnable() {
			public void run() {
				for(Card c :cards) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					c.setText(c.card_num+"");
					f.validate();
				}
			}
		}).start();
		//�ٽ� ������
		new Thread(new Runnable() {			
			@Override
			public void run() {
				try {
					Thread.sleep(1200);
					for(Card c :cards) {
						Thread.sleep(100);
						c.setText("");
						f.validate();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		this.setLayout(new GridLayout(3,4));
		this.setBounds(600,100,600,800);
		this.setVisible(true);
		this.validate();	//���ΰ�ħ
	}
	//ī�弯��
	public void randomCards() {
		LinkedList<Integer> card_list=new LinkedList<Integer>(Arrays.asList(cards_nums)); 
		for(int i=0; i< cards_nums.length; i++){
			int random=(int)(new Random().nextDouble()*card_list.size());
			cards[i]=new Card(card_list.remove(random));
		}	
	}
}

class ChoiceCard implements ActionListener{
	Card c;
	JFrame f;
	public int card_num;
	public static int cnt_num=1;
	public static int temp=0;
	public static Card tempC=null;
	public ChoiceCard(Card c,JFrame f) {
		this.c=c;
		this.f=f;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(c.ending==true) {
			System.out.println(cnt_num+"��°"+"������ ī��:"+c.card_num);
			System.out.println("�̹� �Ϸ�� ī��");
		}else if(c.checking==true) {
			System.out.println(cnt_num+"��°"+"������ ī��:"+c.card_num);
			System.out.println("�����ߴ� ī�带 �� ����");
			c.setText("");
			tempC=null;
			temp=0;
			cnt_num=1;
			c.checking=false;
		}else if(c.checking==true) {
			System.out.println(cnt_num+"��°"+"������ ī��:"+c.card_num);
			System.out.println("�����ߴ� ī�带 �� ����");
			c.setText("");
			tempC=null;
			temp=0;
			cnt_num=1;
			c.checking=false;
		}
		else if(cnt_num==2&&(temp==c.card_num)) {
			System.out.println(cnt_num+"��°"+"������ ī��:"+c.card_num);
			System.out.println("���� ī��");
			c.setText(c.card_num+"");
			c.ending=true;
			tempC.ending=true;
			cnt_num=1;
			temp=0;
			tempC=null;
		}else if(cnt_num==2&&(temp!=c.card_num)){
			System.out.println(cnt_num+"��°"+"������ ī��:"+c.card_num);
			System.out.println("�ٸ� ī��");
			cnt_num=1;
			temp=0;
			f.validate();
			c.setText(c.card_num+"");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			c.setText("");
			f.validate();
			tempC.setText("");
			tempC=null;
		}else {
			System.out.println(cnt_num+"��°"+"������ ī��:"+c.card_num);
			temp=c.card_num;
			tempC=c;
			c.checking=true;
			c.setText(c.card_num+"");
			cnt_num++;
		}
		System.out.println("-----------�� ����Ŭ ����-------------");
	}
}


class Card extends JButton{
	public int card_num;
	public boolean checking=false;
	public boolean ending=false;
	public Card(int card_num) {
		this.card_num=card_num;
		//this.setText(card_num+"");
	}
}

public class L06CardGame{
	public static void main(String[]args) {		
		new CardGameFrame("ī�����");
	}
}
