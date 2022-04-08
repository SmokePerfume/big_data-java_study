package com.econ;
class Econ{
	int a=10;
	String b="안녕";
	int sum(int a, int b) {
		return this.a+b;
	}
}

public class L04PrimtiveType {
	public static void main(String[] args) {
		//참조형과 기본현 데이터 타입
		//기본형을 제외한 모든 데이터는 참조형이다.
		//기본형의 특징
		//1.메모리에 저장된 값이 변하지 않는다. (리터럴)
		//2.보통 수와 관련 있다. (세상의 모든 데이터를 수로 표현 -> 수치화 -> 컴퓨터 데이터)
		//3.기본데이터 타입은 프로그래밍에서 가장 많이 사용되는 data로 사람의 언어를 컴퓨터에게 전달하는 것이 프로그래밍이기 때문
		/* 자바의 기본형의 특징
		 * 1. type이 소문자로 시작한다. byte, short, int, long, float, double, char, boolean
		 * 2. 문자열은 기본형이 아니다. 대신!! 리터럴 표기법을 지원하고 만약 리터럴하게 선언하면 똑같은 데이터가 있을때 생성하지않고 똑같은 데이터를 참조
		 * 3. 기본형의 랩퍼클래스가 존재한다. Byte, Short, Integer, Long, Float, Double, Character, Boolean
		 * 4. 자바의 기본형은 중복된 데이터가 없기 때문에 비교할수 있다.
		 * int a=10; int b=10; 10이란 데이터가 1번 만들어지고 a와 b에 참조된다.
		 * Integer a=new Integer(10),  Integer b=new Integer(10); 객체 생성후 a가 참조된고, 객체 생성후 b가 참조
		 * */
		/* 참조형 데이터의 특징
		 * 1. 여러 객체를 참조한다 => 참조하는 데이터가 바뀔 수 있다.
		 * 2. 데이터의 설계도인 타입이 존재한다.
		 * 3. 필드의 내용이 바껴도 객체가 다 바뀌지 않는다.
		 * 
		 * 자바 참조형 데이터의 특징
		 * 1. 객체지향 언어는 new 연산자로 생성자를 호출해서 생성한다.
		 * 2. 전역(class 최상위 블럭[scope])에 선언하는 변수나 상수, 메소드가 필드가 된다.
		 * 3. this 는 객체의 필드 접근자다.
		 * 4. 참조형은 자기 자신을 제외하고 ==으로 비교할 수 없다. (수없이 많은 필드중에 어떤 것이 같다는 기준이 없기 때문)
		 * 5. 만약 필드중에 같은 것이 있으면 같다고 하고 싶다면 equals()를 구현할 수 있다.
		 */
		int a = 10;
		int b = 10; //메모리에 10이란 데이터가 있으면 만들지 않고 찾아서 사용 -> 기본형의 특징
		System.out.println("a==10 : "+(a==10));
		System.out.println("a==b : "+(a==b));
		Integer c=new Integer(10);
		Integer d=new Integer(10);
		System.out.println("c : "+c);
		System.out.println("c + 1 : "+(c+1));
		System.out.println("c.MAX_VALUE : "+(c.MAX_VALUE));
		//System.out.println("a.MAX_VALUE : "+(a.MAX_VALUE)); //불가능
		
		System.out.println("c == d : "+(c==d));
		System.out.println("c == c : "+(c==c));
		System.out.println("c.equals(b) : "+(c.equals(b))); //특정 필드가 같으면 두 객체의 앖이 같다고 볼 수 있다고 구현됨
		
		Econ e=new Econ();
		e.a=100;
		System.out.println("e.a : "+e.a);
		System.out.println("e.b : "+e.b);
		// == 주수고 같은지 비교하는 비교 연산
		// 모든 데이터는 메모리의 주소를 갖는다.
		
		String txt1="안녕";
		String txt2=new String("안녕");
		String txt3="안녕";
		//문자열은 리터럴하게(기보데이터타입처럼) 선언할 수 있지만 txt1과 txt2는 둘다 참조형으로 완전히 똑같은 필드를 갖는다.
		//txt1 필드 90
		//txt2 필드 90
		System.out.println("txt1==txt2 : "+(txt1==txt2));
		System.out.println("txt1==txt3 : "+(txt1==txt3)); 
		//리터럴하게 선언하면 메모리에서 같은 것이 있는지 검색한 후 있으면 기본데이터 타입처럼 참조한다.=> 문자열을 많이 사용하기 때문에
		System.out.println("txt1.equals(txt2) : "+(txt1.equals(txt2)));
		
		
		
		
	}
}
