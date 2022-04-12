package com.econ.myproject;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.awt.event.*;
import java.time.LocalTime;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

interface CardColor{ //전부 상수처리됨
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
	public static boolean ready=true;
	public static boolean cnt_run=false;
	JLabel timeL=new JLabel(time+"초");
	JLabel scoreL=new JLabel(score+"점");
	
	Card[] cards=new Card[12];
	Card[] cards_clone=new Card[12];
	Integer [] cards_nums= {1,1,2,2,3,3,4,4,5,5,6,6};
	LinkedList<Card> click_cards=new LinkedList<Card>();// 선택한 카드	
	JFrame f=this;
	boolean start=false;
	public CardGameFrame(String title) throws InterruptedException {
		super("카드게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫기
		
		Container cont = getContentPane(); 
		cont.setLayout(new BorderLayout()); 
		cont.setBackground(new Color(150,34,255));
		
		JPanel header = new JPanel();
		header.add(timeL);
		header.add(scoreL);
		JPanel main = new JPanel();
		main.setLayout(new GridLayout(3,4,10,10));
		
		JPanel footer = new JPanel();
		JButton startBtn = new JButton("게임 시작!");
		
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

		
		Thread GameT=new WaitingGame();
		Thread btnready=new BtnReady(startBtn);
		btnready.start();
		GameT.start();//항상 게임시작을 준비하는 중
		
		startBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startBtn.setEnabled(false);
				ready=false;
				randomCards();
				if(cards_clone[0]!=null) { //기존 카드들 삭제후 재시작
					for(Card c :cards_clone) { 
						main.remove(c);
					}
					for(int i=0;i<cards_clone.length;i++) { 
						cards_clone[i]=null;
					}
				}
				int i=0;
				for(Card c :cards) {  //카드 설정
					c.setEnabled(false);
					main.add(c); 
					cards_clone[i++]=c;
				}
				i=0;
				System.out.println("시작버튼 작동");
				time=30;
				timeL.setText(time+"초");
				score=0;
				scoreL.setText(score+"점");
				start=true; //GameT의 게임시작 트리거
			}
		});
	}
	
	class BtnReady extends Thread { //버튼 제어용 
		JButton startBtn;
		public BtnReady(JButton startBtn) {
			this.startBtn=startBtn;
		}
		public void run(){
			while(true) {
				try {Thread.sleep(100);} catch (InterruptedException e1) {e1.printStackTrace();}
				if(ready==false) {
					System.out.println("버튼꺼짐");
					try {
						Thread.sleep(3500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					startBtn.setEnabled(true);
					ready=true;
				}
			}
		}
	}
	
	
	class WaitingGame extends Thread {
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(500);
					System.out.println("게임 시작 스레드 대기중");
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if(start) {
					Thread t1=new ShowCards();
					Thread t2=new HideCards();
					Thread t3=new SuccesCards();
					Thread t4=new Cntdown();
					cnt_run=true;
					//t1~t2까지 순서대로 진행 후 t1,t2 끝나면 t3, t4동시에 시작
					t1.start();
					try {t1.join();} catch (InterruptedException e) {e.printStackTrace();}
					t2.start();
					try {t2.join();} catch (InterruptedException e) {e.printStackTrace();}
					for(Card c: cards) { //버튼에 이벤트 추가
						c.addActionListener(new ChoiceCard(c));
						c.setEnabled(true);
					}
					cnt_run=false;
					t3.start();
					t4.start();
					start=false;
					System.out.println("------게임 시작 했음--------");
					
				}
			}
		}
	}
	
	class Cntdown extends Thread {
		@Override
		public void run() {
			while(time>0) {
				System.out.println("Cntdown 스레드 실행중");
				if(cnt_run) { 
					System.out.println("기존 Cntdown 스레드 꺼짐");
					time=30;
					timeL.setText(time+"초");
					this.interrupt();	
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("카운트 오류");
					return;
				}
				if(succes_cnt>=12) {
					JOptionPane.showMessageDialog(null,"소요시간:"+ time+"초 / 총 점수: "+(score+(time*5)));
					for(Card c :cards) {
						c.setEnabled(false);
					}
					succes_cnt=0;
					break;
				}
				time-=1; 
				timeL.setText(time+"초");
			}
			if(time<=0&&succes_cnt<12) { 
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
				System.out.println("succes 스레드 실행중");
				if(cnt_run||succes_cnt>=12) { 
					System.out.println("기존 succes 스레드 꺼짐");
					this.interrupt();
					break;
				}
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

public class CardGame{
	public static void main(String[]args) {	
		try{
			new CardGameFrame("카드게임");
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
