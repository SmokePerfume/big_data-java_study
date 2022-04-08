package com.econ;
//계산기
//생성자에 연산할 수를 입력하고
//abstract sum()에서 연산을 구현하고
//enter()를 호출하면 콘솔에 sum의 결과를 출력
abstract class Calculator{
	int a,b;
	public Calculator(int a,int b) {
		this.a=a;
		this.b=b;
	}
	abstract int calc();//연산의 결과를 반환
	public void enter() {
		System.out.println("연산의 결과는 "+this.calc()+"입니다.");
	}
}

class CalMul extends Calculator{
	public CalMul(int a, int b) {
		super(a, b);
	}
	@Override
	int calc() {
		return this.a/this.b;
	}
	
}


public class L31AbstractClass3 {
	public static void main(String[] args) {
		//추상클래스는 구현이 덜된 것이 있기 때문에 무조건 바디를 작성한다.
		Calculator cal = new Calculator(10,20) {
			int calc() {
				return (this.a+this.b);
			}
		};
		cal.enter();
		// a/b 결과를 출력하세요
		//////////////////////
		Calculator cal2= new Calculator(50,10) {
			int calc() {
				return this.a/this.b;
			}
		};
		cal2.enter();
	
		Calculator cal3=new CalMul(30,10);
		cal3.calc();
		cal3.enter();
		
		
	}
}
