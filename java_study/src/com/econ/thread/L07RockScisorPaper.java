package com.econ.thread;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class RSPGame extends JFrame{
	JPanel p1= new JPanel();
	JPanel p2= new JPanel();
	JPanel p3= new JPanel();
	JLabel enemyL=new JLabel();
	JLabel resultL=new JLabel();
	JButton sb=new GameButton("가위",0);
	JButton rb=new GameButton("바위",1);
	JButton pb=new GameButton("보",2);
	public RSPGame() {
		p1.add(enemyL);
		p2.add(resultL);
		p3.add(sb);
		p3.add(rb);
		p3.add(pb);
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.setBounds(800,300,300,300);
		this.setVisible(true);
	}
	class GameButton extends JButton{
		int num;
		GameButton(String txt, int num){
			super(txt);
			this.num=num;
		}
	}
	

}

public class L07RockScisorPaper {
	public static void main(String[] args) {
		new RSPGame();
	}
}
