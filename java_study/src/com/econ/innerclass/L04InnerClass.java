package com.econ.innerclass;

public class L04InnerClass {
	int a=10;
	int b=20;
	public static void main(String[] args) {	
		L04InnerClass i=new L04InnerClass();
		//문제 Sum.result()를 호출해서 a+b의 값을 받으세요.
		System.out.println(new com.econ.innerclass.Sum(i.a,i.b).result());
		System.out.println(i.new Sum().result());
	}
	class Sum{//com.econ.innerclass.L04InnerClass.sum
		public int result() {
			return a+b;
		}
	}
}

class Sum{//com.econ.innerclass.Sum
	int a,b;
	Sum(int a, int b){
		this.a=a;
		this.b=b;
	}
	public int result() {
		return this.a+this.b;
	}
}
