package com.econ.myproject;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



interface CardColor{ //전부 상수처리됨
	Color ACTIVE=new Color(220, 245, 115);
	Color OVER=new Color(145, 145, 145);
	
	Color FRONT=new Color(239, 255, 125);
	Color FRONT_TEXT=new Color(0, 0, 0);
	

	Color BACK=new Color(175, 175, 175);
	Color BACK_TEXT=new Color(0, 0, 0);
	
	Color FAILED=new Color(255, 0, 0);
	Color FAILED_TEXT=new Color(255, 255, 255);
	
	Color SUCCESS=new Color(200, 240, 200);
	Color SUCCESS_TEXT=new Color(15, 115, 25);	
}

class CardGameFrame extends JFrame{
	//public static int time=30;
	AtomicInteger time=new AtomicInteger(30);
	public static int score=0;
	public static int succes_cnt=0;
	JLabel timeL=new JLabel(time.get()+"초");
	JLabel scoreL=new JLabel(score+"점");
	Container cont = getContentPane(); 
	JPanel header = new JPanel();
	JPanel main = new JPanel();
	JPanel footer = new JPanel();
	JButton startBtn = new JButton("게임 시작");

	Thread t1;
	Thread t2;
	Thread t3;
	Thread t4;
	
	JFrame f=this;
	Integer [] cards_nums= {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10,11,11,12,12};
	Card[] cards=new Card[cards_nums.length];
	Card[] cards_clone=new Card[cards_nums.length]; //생성된 카드들을 저장(다시 삭제하기 위함)
	LinkedList<Card> click_cards=new LinkedList<Card>();// 선택한 카드	
	
	public CardGameFrame(String title) throws InterruptedException, IOException {
		super("카드게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫기
		
		
		cont.setLayout(new BorderLayout()); 
		cont.setBackground(new Color(150,34,255));
		
		header.add(timeL);
		header.add(scoreL);
		
		main.setLayout(new GridLayout(4,6,10,10));  //cards_nums변경시 출력화면 변경필요
		footer.add(startBtn);
		
		cont.add(header,BorderLayout.NORTH);
		cont.add(main,BorderLayout.CENTER);
		cont.add(footer,BorderLayout.SOUTH);
		
		this.setBounds(0,0,400,500); 
		this.setVisible(true); 
		
		startBtn.addActionListener(new StartBtnHandler());
	}
	
	class StartBtnHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			new Thread() {
				public void run() {
				startBtn.setEnabled(false);
				randomCards();
				clearCard();
				cardset();
				score=0;
				scoreL.setText(score+"점");
				if(t1!=null)t1.stop();			
				if(t2!=null)t2.stop();	
				if(t3!=null)t3.stop();	
				if(t4!=null)t4.stop();	
				t1=new ShowCards();
				t2=new HideCards();
				t3=new SuccesCards();
				t4=new Cntdown();
				//t1~t2까지 순서대로 진행 후 t1,t2 끝나면 t3, t4동시에 시작
				t1.start();
				try {t1.join();} catch (InterruptedException e1) {e1.printStackTrace();}
				t2.start();
				try {t2.join();} catch (InterruptedException e2) {e2.printStackTrace();}
				for(Card c: cards) { //버튼에 이벤트 추가
					c.addMouseListener(new ChoiceCard(c));
					c.setEnabled(true);
				}
				startBtn.setEnabled(true);
				t3.start();
				t4.start();
				}
			}.start();
		}
	}

	public void clearCard() {//기존 카드들 삭제후 재시작
		if(cards_clone[0]!=null) { 
			for(Card c :cards_clone) { 
				main.remove(c);
			}
			for(int i=0;i<cards_clone.length;i++) { 
				cards_clone[i]=null;
			}
		}
	}
	
	public void cardset() {//카드 설정
		int i=0;
		for(Card c :cards) {  
			c.setEnabled(false);
			c.setOpaque(true);
			c.setBorderPainted(false);
			main.add(c); 
			cards_clone[i++]=c;
		}
	}
	
	class Cntdown extends Thread {
		@Override
		public void run() {
			time.set(30);
			timeL.setText(time+"초");
			while(time.get()>0) {
				try {Thread.sleep(1000);} catch (InterruptedException e) {return;}
				if(succes_cnt>=cards_nums.length) {
					JOptionPane.showMessageDialog(null,"소요시간:"+ time+"초 / 총 점수: "+(score+(time.get()*5)));
					for(Card c :cards) {
						c.setEnabled(false);
					}
					succes_cnt=0;
					break;
				}else {
					time.set(time.get()-1); 
					timeL.setText(time+"초");
				}
			}
			if(time.get()<=0&&succes_cnt<cards_nums.length) { 
				JOptionPane.showMessageDialog(null,"실패");
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
	
	//2개의 카드 선택시
	class SuccesCards extends Thread {
		@Override
		public void run() {
			while(true) { //카드 .5초마다 무한히 검사하는 코드 
				try {Thread.sleep(500);} catch (InterruptedException e1) {	e1.printStackTrace();}
				if(click_cards.size()==2) { 
					//실패했을 때 다시 뒤집기
					if(click_cards.get(0).card_num!=click_cards.get(1).card_num) { //카드가 다름 
						try {Thread.sleep(500);} catch (InterruptedException e1) {e1.printStackTrace();}
						for(Card c: click_cards) {
							c.setText(c.card_num+"");	
							c.setBackground(CardColor.FAILED);
							c.setForeground(CardColor.FAILED_TEXT);	
						}
						try {Thread.sleep(500);} catch (InterruptedException e1) {	e1.printStackTrace();}								
						for(Card c: click_cards) {
							c.setText("");		
							score+=-5; //(총 2번 반복하므로 -10)
							scoreL.setText(score+"점");
							c.setBackground(CardColor.BACK);
							c.setForeground(CardColor.BACK_TEXT);	
						}
					}else{ //카드가 같음 
						for(Card c: click_cards) {
							c.success=true;
							score+=5; //(총 2번 반복하므로 +10)
							succes_cnt+=1;
							scoreL.setText(score+"점");
							c.setText(c.card_num+"");	
							c.setBackground(CardColor.SUCCESS);
							c.setFont(new Font("고딕",Font.ITALIC,25));
							c.setForeground(CardColor.SUCCESS_TEXT);	
						}
					}
					click_cards.clear();	//2번 클릭 후 초기화
				}
			}
		}
	}
	
	//카드 생성
	public void randomCards() {
		LinkedList<Integer> card_list=new LinkedList<Integer>(Arrays.asList(cards_nums)); 
		for(int i=0; i< cards_nums.length; i++){
			int random=(int)(new Random().nextDouble()*card_list.size());
			cards[i]=new Card(card_list.remove(random));
		}	
	}
	
	//카드 선택시
	class ChoiceCard extends MouseAdapter{
		Card c;
		public ChoiceCard(Card c) {
			this.c=c;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			if(c.success) return; //성공한 카드를 선택 
			if(click_cards.size()<2) {//성공한 카드를 제외하고 선택 & 숫보여줌 같은 카드면 취소
				if(click_cards.size()==1 && c==click_cards.get(0) ) return; 
				click_cards.add(c);
				c.setText(c.card_num+"");
			}
		}
		public void mousePressed(MouseEvent e) {
			JButton c=(JButton)e.getSource();
			c.setBackground(CardColor.ACTIVE);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			JButton c=(JButton)e.getSource();
			c.setBackground(CardColor.BACK);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			JButton c=(JButton)e.getSource();
			c.setBackground(CardColor.OVER);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			JButton c=(JButton)e.getSource();
			c.setBackground(CardColor.BACK);
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

public class CardGame{
	public static void main(String[]args) {	
		try{
			new CardGameFrame("카드게임");
		}catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
