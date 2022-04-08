package com.econ;
//����
//�����ڿ� ������ ���� �Է��ϰ�
//abstract sum()���� ������ �����ϰ�
//enter()�� ȣ���ϸ� �ֿܼ� sum�� ����� ���
abstract class Calculator{
	int a,b;
	public Calculator(int a,int b) {
		this.a=a;
		this.b=b;
	}
	abstract int calc();//������ ����� ��ȯ
	public void enter() {
		System.out.println("������ ����� "+this.calc()+"�Դϴ�.");
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
		//�߻�Ŭ������ ������ ���� ���� �ֱ� ������ ������ �ٵ� �ۼ��Ѵ�.
		Calculator cal = new Calculator(10,20) {
			int calc() {
				return (this.a+this.b);
			}
		};
		cal.enter();
		// a/b ����� ����ϼ���
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
