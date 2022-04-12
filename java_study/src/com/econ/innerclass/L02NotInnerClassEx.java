package com.econ.innerclass;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JButton;



public class L02NotInnerClassEx {
	public static void main(String[] args) {
		Calculator cal=new Calculator();
		cal.setBounds(0,0,300,600);
		cal.setVisible(true);
	}
}
class Calculator extends JFrame{
	JPanel bp= new JPanel();
	JButton[] b_arr=new JButton[12];
	JButton b7= new JButton("7");
	JButton b8= new JButton("8");
	JButton b9= new JButton("9");
	JButton b4= new JButton("4");
	JButton b5= new JButton("5");
	JButton b6= new JButton("6");
	JButton b1= new JButton("1");
	JButton b2= new JButton("2");
	JButton b3= new JButton("3");
	JButton bm= new JButton("+/-");
	JButton b0= new JButton("0");
	JButton bd= new JButton(".");
	JTextField screen=new JTextField();
	public Calculator() {
		b_arr[0]=b7;
		b_arr[1]=b8;
		b_arr[2]=b9;
		b_arr[3]=b4;
		b_arr[4]=b5;
		b_arr[5]=b6;
		b_arr[6]=b1;
		b_arr[7]=b2;
		b_arr[8]=b3;
		b_arr[9]=bm;
		b_arr[10]=b0;
		b_arr[11]=bd;
		screen.setSize(300,50);
		this.setLayout(new BorderLayout());
		this.add(screen,BorderLayout.NORTH);
		bp.setLayout(new GridLayout(4,3,1,1));
		for(JButton b:b_arr) {
			b.addMouseListener(new ButtonHandler(screen));
			b.setBackground(ButtonColor.DEFAULT);
			b.setOpaque(true);
			b.setBorderPainted(false);
			bp.add(b);
		}
		this.add(bp,BorderLayout.CENTER);
	}
}
class ButtonHandler extends MouseAdapter{
	JTextField screen;
	public ButtonHandler(JTextField screen) {
		this.screen=screen;
	}
	@Override
	public void mouseClicked(MouseEvent e) {//addActionListerner랑 동일한 이벤트
	}
	@Override
	public void mousePressed(MouseEvent e) {
		JButton b=(JButton)e.getSource();
		String b_text=b.getText();
		b.setBackground(ButtonColor.ACTIVE);
		screen.setText(screen.getText()+b_text);
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		JButton b=(JButton)e.getSource();
		b.setBackground(ButtonColor.DEFAULT);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		JButton b=(JButton)e.getSource();
		b.setBackground(ButtonColor.OVER);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		JButton b=(JButton)e.getSource();
		b.setBackground(ButtonColor.DEFAULT);
	}
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
	}
	@Override
	public void mouseDragged(MouseEvent e) {
	}
	@Override
	public void mouseMoved(MouseEvent e) {
	}
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		JButton b=(JButton)e.getSource();
//		b.setBackground(ButtonColor.ACTIVE);
//		
//	}
	
}