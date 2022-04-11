package com.econ.myproject;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.awt.event.*;
import java.time.LocalTime;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

interface CardColor{
	Color FRONT=new Color(239, 255, 125);
	Color FRONT_TEXT=new Color(0, 0, 0);
	
	Color BACK=new Color(145, 145, 145);
	Color BACK_TEXT=new Color(0, 0, 0);
	
	Color FAILED=new Color(255, 0, 0);
	Color FAILED_TEXT=new Color(255, 255, 255);
	
	Color SUCCESS=new Color(200, 240, 200);
	Color SUCCESS_TEXT=new Color(15, 115, 25);	
}

class CardGameFrame extends JFrame{
	public static int time=30;
	public static int score=0;
	public static int succes_cnt=0;
	JLabel timeL=new JLabel(time+"��");
	JLabel scoreL=new JLabel(score+"��");
	
	Card[] cards=new Card[12];
	Integer [] cards_nums= {1,1,2,2,3,3,4,4,5,5,6,6};
	LinkedList<Card> click_cards=new LinkedList<Card>();// ������ ī��	
	JFrame f=this;
	boolean start=false;
	public CardGameFrame(String title) throws InterruptedException {
		super("ī�����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //�ݱ�
		
		Container cont = getContentPane(); 
		cont.setLayout(new BorderLayout()); 
		cont.setBackground(new Color(150,34,255));
		
		JPanel header = new JPanel();
		header.add(timeL);
		header.add(scoreL);
		JPanel main = new JPanel();
		main.setLayout(new GridLayout(3,4,10,10));
		
		JPanel footer = new JPanel();
		JButton startBtn = new JButton("���� ����!");
		
		footer.add(startBtn);
		
		///////////////////
//		JLabel imageLabel = new JLabel(img0);
//		JLabel test= new JLabel(new ImageIcon("src/com/econ/stutudent/john/c011.png"));
//		JPanel mp=new JPanel();
//		mp.setLayout(null);
//		imageLabel.setBounds(0, 0, 400, 400);
//		test.setBounds(0, 0, 400, 400);
//		mp.add(test);
//		mp.add(imageLabel);
//		mp.setPreferredSize(test.getPreferredSize());
		/////////////////////

		cont.add(header,BorderLayout.NORTH);
		cont.add(main,BorderLayout.CENTER);
		cont.add(footer,BorderLayout.SOUTH);
		setSize(400,500); 
		setVisible(true); 

		randomCards();
		for(Card c :cards) { //������ ���ÿ� ��ư�� �̺�Ʈ ����
			c.setEnabled(false);
			main.add(c); 
		}
		Thread GameT=new WaitingGame();
		GameT.start();
		startBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("���۹�ư �۵�");
				time=30;
				score=0;
				scoreL.setText(score+"��");
				start=true;
			}
		});
		
		
	}
	
	
	class WaitingGame extends Thread {
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(500);
					System.out.println("������ �����");
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if(start) {
					Thread t1=new ShowCards();
					Thread t2=new HideCards();
					Thread t3=new SuccesCards();
					Thread t4=new Cntdown();
					t1.start();
					try {t1.join();} catch (InterruptedException e) {e.printStackTrace();}
					t2.start();
					try {t2.join();} catch (InterruptedException e) {e.printStackTrace();}
					for(Card c: cards) { //��ư�� �̺�Ʈ �߰�
						c.addActionListener(new ChoiceCard(c));
						c.setEnabled(true);
					}
					t3.start();
					t4.start();
					start=false;
					System.out.println("������ ����");
				}
			}
		}
	}
	
	
	class Cntdown extends Thread {
		@Override
		public void run() {
			while(time>0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("ī��Ʈ ����");
					return;
				}
				time-=1; 
				timeL.setText(time+"��");
				if(succes_cnt>=12) {
					JOptionPane.showMessageDialog(null,"�ҿ�ð�:"+ time+"�� / �� ����: "+(score+(time*5)));
					for(Card c :cards) {
						c.setEnabled(false);
					}
					break;
				}
			}
			if(succes_cnt<12) { 
				JOptionPane.showMessageDialog(null,"����");
					for(Card c :cards) {
						c.setEnabled(false);
					}
			}
		}
	}

	class ShowCards extends Thread {
		public void run() {
			for(Card c :cards) {
				try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
				c.setText(c.card_num+"");
				c.setBackground(CardColor.FRONT);
				c.setForeground(CardColor.FRONT_TEXT);	
				f.validate();
			}
		}
	}
	
	class HideCards extends Thread {
		@Override
		public void run() {
			for(Card c :cards) {
				try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
				c.setText("");
				c.setBackground(CardColor.BACK);
				c.setForeground(CardColor.BACK_TEXT);	
				f.validate();
			}
		}
	}
	
	//2���� ī�� ���ý�
	class SuccesCards extends Thread {
		@Override
		public void run() {
			while(true) { //ī�� .5�ʸ��� ������ �˻��ϴ� �ڵ� 
				try {Thread.sleep(500);} catch (InterruptedException e1) {	e1.printStackTrace();}
				if(click_cards.size()==2) { 
					//�������� �� �ٽ� ������
					if(click_cards.get(0).card_num!=click_cards.get(1).card_num) { //ī�尡 �ٸ� 
						try {Thread.sleep(500);} catch (InterruptedException e1) {e1.printStackTrace();}
						for(Card c: click_cards) {
							c.setText(c.card_num+"");	
							c.setBackground(CardColor.FAILED);
							c.setForeground(CardColor.FAILED_TEXT);	
						}
						try {Thread.sleep(500);} catch (InterruptedException e1) {	e1.printStackTrace();}								
						for(Card c: click_cards) {
							c.setText("");		
							score+=-5; //(�� 2�� �ݺ��ϹǷ� -10)
							scoreL.setText(score+"��");
							c.setBackground(CardColor.BACK);
							c.setForeground(CardColor.BACK_TEXT);	
						}
					}else{ //ī�尡 ���� 
						for(Card c: click_cards) {
							c.success=true;
							score+=5; //(�� 2�� �ݺ��ϹǷ� +10)
							succes_cnt+=1;
							scoreL.setText(score+"��");
							c.setText(c.card_num+"");	
							c.setBackground(CardColor.SUCCESS);
							c.setFont(new Font("���",Font.ITALIC,25));
							c.setForeground(CardColor.SUCCESS_TEXT);	
						}
					}
					click_cards.clear();	//2�� Ŭ�� �� �ʱ�ȭ
				}
			}
		}
	}
	
	//ī�� ����
	public void randomCards() {
		LinkedList<Integer> card_list=new LinkedList<Integer>(Arrays.asList(cards_nums)); 
		for(int i=0; i< cards_nums.length; i++){
			int random=(int)(new Random().nextDouble()*card_list.size());
			cards[i]=new Card(card_list.remove(random));
		}	
	}
	
	//ī�� ���ý�
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

public class CardGame{
	public static void main(String[]args) {	
		try{
			new CardGameFrame("ī�����");
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
