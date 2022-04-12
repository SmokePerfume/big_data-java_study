package com.econ.exception;

class Calc{
	private int a,b;
	Calc(int a, int b){
		this.a=a;
		this.b=b;
	}
	public int div() throws Exception{
		//예외 위임: 사용하는 쪽에서 Try catch 작성을 강제한다.
		return a/b;
	}
	public int sum() {
		return a+b;
	}
}

public class L01TryCatch {
	//main에 throws를 사용하면 예외처리릏 하지 않는다는 의미다.
	public static void main(String[] args){
		Calc c=new Calc(10,00);
		try {
			System.out.println(c.div());
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			System.out.println("오류가 뜨지 않아도 마지막에 무조건 실행");
			//통신을 할때 연결도니 망을 끊을 때 사용된다. 예) mysql conn을 end() 해야하는 것
		}
		System.out.println(c.sum()); //오류가 발생하면 시스템이 멈춘다. ->반드시 예외처리를 해야한다.

	}
}
