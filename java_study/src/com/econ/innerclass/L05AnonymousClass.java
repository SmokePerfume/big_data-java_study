package com.econ.innerclass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Timer extends JFrame{
	JFrame f= this;
	AtomicInteger i=new AtomicInteger(10);
	JButton startBtn=new JButton("����");
	JButton endBtn=new JButton("����");
	JLabel screen=new JLabel(i.get()+" ��");
	JPanel btnP=new JPanel();
	JPanel screenP=new JPanel();
	boolean time_b=true;
	
	public Timer() {
		screenP.add(screen);
		startBtn.addActionListener(new StartBtnHandler());
		endBtn.addActionListener(new EndBtnHandler());
		btnP.add(startBtn);
		btnP.add(endBtn);;
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		this.add(screenP);
		this.add(btnP);
		this.setBounds(0,0,300,300);
		this.setVisible(true);
		
	}
	class StartBtnHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//Timer$StartBtnHandler$1.class
			//�͸�Ŭ���� : �߻� Ŭ���� ���� �״�� �������� �� ��������� Ŭ������ 1���� �̸��� �����.
			new Thread() {
				@Override
				public void run() {
					boolean start=true;
					while(i.get()>0&&start&&time_b) {
						try {Thread.sleep(1000);} catch (InterruptedException e1) {e1.printStackTrace();}
						i.decrementAndGet();
						screen.setText(i.get()+"��");
						f.validate();
					}
				}
			}.start();
			
		}
		
	}
	class EndBtnHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//Timer$StartBtnHandler$1.class
			//�͸�Ŭ���� : �߻� Ŭ���� ���� �״�� �������� �� ��������� Ŭ������ 1���� �̸��� �����.
			new Thread() {
				@Override
				public void run() {
					time_b=false;
				}
			}.start();
			
		}
		
	}
	
	
}

public class L05AnonymousClass {
	public static void main(String[] args) {
		new Timer();
	}
}
