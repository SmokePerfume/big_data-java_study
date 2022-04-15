package com.econ.myproject;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.awt.event.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.time.LocalTime;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
//import javax.imageio.ImageIO;
//import javax.swing.AbstractButton;
//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



interface CardColor{ //���� ���ó����
	Color ACTIVE=new Color(220, 245, 115);
	Color OVER=new Color(145, 145, 145);
	
	Color CHOICE=new Color(86, 180, 223);
	
	Color FRONT=new Color(239, 255, 125);
	Color FRONT_TEXT=new Color(0, 0, 0);
	

	Color BACK=new Color(175, 175, 175);
	Color BACK_TEXT=new Color(0, 0, 0);
	
	Color FAILED=new Color(255, 0, 0);
	Color FAILED_TEXT=new Color(255, 255, 255);
	
	Color SUCCESS=new Color(200, 240, 200);
	Color SUCCESS_TEXT=new Color(15, 115, 25);	
}
class Card extends JButton{
	public int card_num;
	public boolean success=false; //�̹� ���� ī��
	public boolean gaming=false; //ī�尡 �� ���ΰ� Ȯ���ϱ����� ����(�� ��ȭ ����, setEnabled���)
	public Card(int card_num) throws IOException {
		this.card_num=card_num;
	}
	public Card() { super(); decorate(); } 
	public Card(String text) { super(text); decorate(); } 
	public Card(Action action) { super(action); decorate(); } 
	public Card(Icon icon) { super(icon); decorate(); } 
	public Card(String text, Icon icon) { super(text, icon); decorate(); } 
	protected void decorate() { setBorderPainted(false); setOpaque(false); }
	
	@Override
	protected void paintComponent(Graphics g) {
        int width = getWidth(); 
        int height = getHeight(); 
        Graphics2D graphics = (Graphics2D) g; 
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
        if (getModel().isArmed()) { graphics.setColor(getBackground()); } 
        else if (getModel().isRollover()) { graphics.setColor(getBackground()); } 
        else { graphics.setColor(getBackground()); } 
        graphics.fillRoundRect(0, 0, width, height, 20, 20); 
        FontMetrics fontMetrics = graphics.getFontMetrics(); 
        Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
        //���� ��ġ ���� & �⺻ ��, �⺻ ��Ʈ �̿�
        int textX = (width - stringBounds.width) / 2; 
        int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();  
        graphics.setColor(getForeground()); 
        graphics.setFont(getFont());
        graphics.drawString(getText(), textX, textY); 
        graphics.dispose(); 
        super.paintComponent(g); 
        }
}
class CardGameFrame extends JFrame{
	AtomicInteger time=new AtomicInteger(30);
	public static int score=0;
	public static int succes_cnt=0;
	JLabel timeL=new JLabel(time.get()+"��");
	JLabel scoreL=new JLabel(score+"��");
	Container cont = getContentPane(); 
	JPanel header = new JPanel();
	JPanel main = new JPanel();
	JPanel footer = new JPanel();
	JButton startBtn = new JButton("���� ����");

	Thread t1;
	Thread t2;
	Thread t3;
	Thread t4;
	
	JFrame f=this;
	Integer [] cards_nums= {1,1,2,2,3,3,4,4,5,5,6,6};
	Card[] cards=new Card[cards_nums.length];
	Card[] cards_clone=new Card[cards_nums.length]; //������ ī����� ����(�ٽ� �����ϱ� ����)
	LinkedList<Card> click_cards=new LinkedList<Card>();// ������ ī��	
	
	public CardGameFrame(String title) throws InterruptedException {
		super("ī�����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //�ݱ�
	
		cont.setLayout(new BorderLayout()); 
		cont.setBackground(new Color(150,34,255));
		
		header.add(timeL);
		header.add(scoreL);
		
		main.setLayout(new GridLayout(3,4,10,10));  //cards_nums����� ���ȭ�� �����ʿ�
		main.setBackground(Color.pink);
		footer.add(startBtn);
		
		cont.add(header,BorderLayout.NORTH);
		cont.add(main,BorderLayout.CENTER);
		cont.add(footer,BorderLayout.SOUTH);
		
		this.setBounds(0,0,400,500); 
		this.setVisible(true); 
		this.setResizable(false);
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
					scoreL.setText(score+"��");
					if(t1!=null)t1.stop();			
					if(t2!=null)t2.stop();	
					if(t3!=null)t3.stop();	
					if(t4!=null)t4.stop();	
					t1=new ShowCards();
					t2=new HideCards();
					t3=new SuccesCards();
					t4=new Cntdown();
					//t1~t2���� ������� ���� �� t1,t2 ������ t3, t4���ÿ� ����
					t1.start();
					try {t1.join();} catch (InterruptedException e1) {e1.printStackTrace();}
					t2.start();
					try {t2.join();} catch (InterruptedException e2) {e2.printStackTrace();}
					for(Card c: cards) { //��ư�� �̺�Ʈ �߰�
						c.addMouseListener(new ChoiceCard(c));
					}
					startBtn.setEnabled(true);
					t3.start();
					t4.start();
				}
			}.start();
		}
	}

	public void clearCard() {//���� ī��� ������ �����
		if(cards_clone[0]!=null) { 
			for(Card c :cards_clone) { 
				main.remove(c);
			}
			for(int i=0;i<cards_clone.length;i++) { 
				cards_clone[i]=null;
			}
		}
	}
	
	public void cardset() {//ī�� ����
		int i=0;
		for(Card c :cards) {  
			c.setOpaque(false);
			main.add(c); 
			cards_clone[i++]=c;
		}
	}
	
	class Cntdown extends Thread {
		@Override
		public void run() {
			time.set(30);
			timeL.setText(time+"��");
			while(time.get()>0) {
				try {Thread.sleep(1000);} catch (InterruptedException e) {return;}
				if(succes_cnt>=cards_nums.length) {
					JOptionPane.showMessageDialog(null,"�ҿ�ð�:"+ time+"�� / �� ����: "+(score+(time.get()*5)));
					succes_cnt=0;
					break;
				}else {
					time.set(time.get()-1); 
					timeL.setText(time+"��");
				}
			}
			if(time.get()<=0&&succes_cnt<cards_nums.length) { 
				for(Card c :cards) {
					c.gaming=true;
					if(!c.success) {
						c.setText(c.card_num+"");
					}
				}
				succes_cnt=0;
				JOptionPane.showMessageDialog(null,"����");
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
			while(true) { 
				try {Thread.sleep(300);} catch (InterruptedException e1) {	e1.printStackTrace();}
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
							c.gaming=false;
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
							c.gaming=false;
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
			try {
				cards[i]=new Card(card_list.remove(random));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	
	//ī�� ���ý�
	class ChoiceCard extends MouseAdapter{
		Card c;
		public ChoiceCard(Card c) {
			this.c=c;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			if(c.success||c.gaming) return; //������ ī�带 ���� 
			if(click_cards.size()<2) {//������ ī�带 �����ϰ� ���� & �������� ���� ī��� ���
				if(click_cards.size()==1 && c==click_cards.get(0) ) return; 
				click_cards.add(c);
				c.setText(c.card_num+"");
				c.setBackground(CardColor.CHOICE);
				c.gaming=true;
			}
		}
		public void mousePressed(MouseEvent e) {
			if(c.success||c.gaming) return; //������ ī�带 �����߰ų� �׽����� ī�带 ����
			c.setBackground(CardColor.ACTIVE);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			if(c.success||c.gaming) return; //������ ī�带 �����߰ų� �׽����� ī�带 ����
			c.setBackground(CardColor.BACK);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			if(c.success||c.gaming) return; //������ ī�带 �����߰ų� �׽����� ī�带 ����
			c.setBackground(CardColor.OVER);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			if(c.success||c.gaming) return; //������ ī�带 �����߰ų� �׽����� ī�带 ����
			c.setBackground(CardColor.BACK);
		}
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
