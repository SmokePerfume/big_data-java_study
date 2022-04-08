package com.econ;
//미완성type인 abstaract class를 정의하자 (interface와 class의 사이)
interface TVable{ //인터페이스 내부의 모든 메소드는 public abstract가 생략된 추상 메소드다
	void turnChannel();
	void powerOff();
	void powerOn();
	void choiceChannel(int num);
}
abstract class MTV implements TVable{
	//추상클래스는 추상 메서드를 포함할 수 있다.
	int volume;
	public void speaker(int volume) {
		this.volume=volume;
		System.out.println("소리가 "+this.volume+"만큼 커졌어요.");
	}
	public void powerOn() {
		System.out.println("tv전원이 켜졌습니다.");
	}
	public void powerOff() {
		System.out.println("tv전원이 꺼졌습니다.");
	}
}

class TV extends MTV{
	public void turnChannel() {
		System.out.println("채널이 한칸 움직였어요!");
	}
	public void choiceChannel(int num) {
		System.out.println("채널이 "+num+"으로 움직였어요.");
	}
	
}

public class L30AbstaractClass {
	public static void main(String[] args) {
		//MTV tv = new MTV();
		MTV tv = new TV(); //추상클래스도 타입이 될 수 있다.
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
		//tv2.speaker(10); 불가능
	}
}
