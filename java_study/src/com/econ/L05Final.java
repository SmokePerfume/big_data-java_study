package com.econ;
class MathInfo{
	final double PI=3.141592653589793238462643;
}
public class L05Final {
	public static void main(String[] args) {
		//변수 (변할 수 있는 수) 
		//1. 참조하는 객체가 바뀔 수 있다.
		int i=10; //is : let (int) i=10;
		i=20;
		//상수(변한지 않는[const] 수) const i=10;
		final int I=10;
		//I=20;
		System.out.println(I);
		//is 상수는 언제 사용하나요?
		//let arr=[1,2,3,4];
		//arr=20;
		//arr[0]: 오류!
		//arr=20; 불가
		//정보를 전달하기 위해
		//바뀌면 안되는 값을 정의하기 위해
		System.out.println(Integer.MAX_VALUE);
		final double PI=3.14; //바뀌지 않는 정보를 참조할때
		//상수를 대문자로 작성하는 이유는 변수와 차이를 주기위해 (개발자간의 약속)
		
		//반지름이 2인 원의 부피
		System.out.println("반지름이 2인 원의 부피 : "+2*2*new MathInfo().PI);
		MathInfo math=new MathInfo();
		System.out.println("반지름이 2인 원의 부피 : "+2*2*math.PI);
		
	}
}
