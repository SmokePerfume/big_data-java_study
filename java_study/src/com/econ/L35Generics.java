package com.econ;
class Abc{

	@Override
	public String toString() {
		return this.getClass()+"�Դϴ�.";
	}
	
}

class PrintObj{
//	PrintObj(int a){
//		System.out.println("���� : "+a);
//	}
//	PrintObj(String a){
//		System.out.println("���ڿ� : "+a);
//	}
//	PrintObj(double a){
//		System.out.println("�Ǽ�(double) : "+a);
//	}
//	PrintObj(float a){
//		System.out.println("�Ǽ�(float) : "+a);
//	}
//	PrintObj(Abc a){
//		System.out.println("Ŭ����(Abc) : "+a);
//	}
	PrintObj(Object a){
		System.out.println(a.getClass()+ " : "+a);
	}
}


public class L35Generics {
	public static void main(String[] args) {
		new PrintObj(10);
		new PrintObj("����");
		new PrintObj(10.0005);
		new PrintObj(10.0005f);
		new PrintObj(new Abc());
	}

}
