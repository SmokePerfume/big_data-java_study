package com.econ.thread;

import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class L05Runnable3 {
	public static void main(String[] args){
		JFrame f= new JFrame("������ �ð�");
		JPanel p=new JPanel();
		JLabel l=new JLabel();
		p.add(l);
		f.add(p);
		boolean clock_b=true;
		
		new Thread(new Runnable() {
			public void run() {
				while(clock_b) {
					Date d= new Date();
					l.setText(d.getHours()+":"+d.getMinutes()+":"+d.getSeconds());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();

		//runnalbe�� ������ ���� �� ���� ���� �� ������ ȭ�鿡 �ߵ��� �ϼ���.
		System.out.println("���� ���� �� ������");
		JPanel p2=new JPanel();
		JLabel l2=new JLabel("���� ���� �� ����");
		p2.add(l2);
		f.add(p2);
		f.setLayout(new GridLayout(2,1));;
		f.setBounds(900,300,300,300);
		f.setVisible(true);

	}
}
