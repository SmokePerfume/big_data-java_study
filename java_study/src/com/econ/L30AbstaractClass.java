package com.econ;
//�̿ϼ�type�� abstaract class�� �������� (interface�� class�� ����)
interface TVable{ //�������̽� ������ ��� �޼ҵ�� public abstract�� ������ �߻� �޼ҵ��
	void turnChannel();
	void powerOff();
	void powerOn();
	void choiceChannel(int num);
}
abstract class MTV implements TVable{
	//�߻�Ŭ������ �߻� �޼��带 ������ �� �ִ�.
	int volume;
	public void speaker(int volume) {
		this.volume=volume;
		System.out.println("�Ҹ��� "+this.volume+"��ŭ Ŀ�����.");
	}
	public void powerOn() {
		System.out.println("tv������ �������ϴ�.");
	}
	public void powerOff() {
		System.out.println("tv������ �������ϴ�.");
	}
}

class TV extends MTV{
	public void turnChannel() {
		System.out.println("ä���� ��ĭ ���������!");
	}
	public void choiceChannel(int num) {
		System.out.println("ä���� "+num+"���� ���������.");
	}
	
}

public class L30AbstaractClass {
	public static void main(String[] args) {
		//MTV tv = new MTV();
		MTV tv = new TV(); //�߻�Ŭ������ Ÿ���� �� �� �ִ�.
		TVable tv2 = new TV();
		TV tv3=new TV();
		
		
		
		
		
		
		tv.powerOn();
		tv.powerOff();
		tv.turnChannel();
		tv.choiceChannel(5);
		tv.speaker(10);
		System.out.println();
		tv2.powerOn();
		tv2.powerOff();
		tv2.turnChannel();
		tv2.choiceChannel(5);
		//tv2.speaker(10); �Ұ���
	}
}
