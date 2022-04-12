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
	boolean thread_check=false;
	Thread timeThread;
	
	public Timer() {
		screenP.add(screen);
		startBtn.addActionListener(new StartBtnHandler());
		//ActuibKusteber �����оƼ�-> �߻�޼ҵ� (������ �Ǿ������ʴ�, �ٵ� ����)
		//�̶� innerClass�� �͸�Ŭ������ ���������.
		endBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				time_b=false;
				timeThread.stop();
				timeThread=null;
			}
		});//�͸�Ŭ������ ����
		
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
			time_b=true;
			if(timeThread!=null) return;
			timeThread=new Thread() {
				@Override
				public void run() {
					//������ Thraed�� ���ߴ� ���
					//1. ������ InterruptedException�� �߻����Ѽ� ����
					//2. stop()���� ���߸�ȴ�.(���忡 �������� ���� ����)
					while(i.get()>0&&time_b) {
						i.decrementAndGet();
						screen.setText(i.get()+"��");
						screen.validate();
						try {Thread.sleep(1000);} catch (InterruptedException e1) {e1.printStackTrace();}		
					}
				}
			};
			timeThread.start();
		}
	}
	
}

public class L05AnonymousClass {
	public static void main(String[] args) {
		new Timer();
	}
}
