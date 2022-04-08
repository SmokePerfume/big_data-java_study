package com.econ;
class Flower{
	//필드 정읳라 때 undefined를 허용하지 않는다.
	int 수술=1;
	int 암술=1;
	int 꽃잎;
	static int 테스팅=0; //메모리 이미 선언됨
	int 테스팅2=0;
	//생성자를 선언하면 default 생성자가 사라지면서 생성자 규칙이 생긴다.
	Flower(){}
	Flower(int 꽃잎){
		//전역과 지역에 선언한 변수의 이름이 같을 때 지역이 우선이다. 
		this.꽃잎 = 꽃잎;
	}
	Flower(int 꽃잎, int 암술, int 수술){ //생성자를 오버로드
		this.꽃잎=꽃잎;
		this.수술=수술;
		this.암술=암술;
	}
	int sum() {
		return 10;
	}
}
public class L21Constructor {
	//생성자
	public static void main(String[] args) {
		Flower 수선화 = new Flower(6);
		System.out.println(수선화.꽃잎);
		Flower 수선화2=new Flower(6,8,1);
		//생성자는 new로만 호출할 수  있다,
		
		
		
		
		
		//////////static 이해용 (객체 생성하기도전 class를 읽고 메모리에 선언)////////////
		Flower number1 = new Flower(); //첫번째 number
		Flower number2 = new Flower(); //두번쨰 number
    	
    	number1.테스팅++; //클래스 필드 num을 1증가시킴(static)
    	number1.테스팅2++; //인스턴스 필드 num을 1증가시킴
        
        //두번째 number의 클래스 필드 출력 (static)
    	//출력값 1
        System.out.println(number2.테스팅); 
    	//두번째 number의 인스턴스 필드 출력
        //출력값 0
        System.out.println(number2.테스팅2); 
	}
}
