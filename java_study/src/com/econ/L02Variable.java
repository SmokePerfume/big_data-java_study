package com.econ;

public class L02Variable {

	public static void main(String[] args) {
		//let s="�ȳ�"; //let : ������ �����ϰڴ�. s: ������ �̸�, "�ȳ�" : ���ڿ� Ÿ���� ��ü (��ó�� �����)
		String s= "�ȳ�"; //�ڹ��� ���ڿ��� �⺻�� ������ Ÿ���� �ƴϴ�. (�⺻ ������ Ÿ���� �ƴ� �������� �빮�ڷ� ����)
		System.out.println(s.length());
		//"�ȳ�"�� �����ϸ� js�� "�ȳ�" data�� ������� �����ؼ� �⺻������ Ÿ���̶� �θ� �� �־�����
		//java������ "�ȳ�"�� ==new String("�ȳ�")�� ������ �ʵ�(�Ӽ�)�� ���´�.("�ȳ��� �����ϴ� ���� �ʵ尡 �����Ѵ�.")
		//���ͷ��ϰ� ������ �� �ִ� data ??? => �⺻ ������ Ÿ��
		//s="10"; //������ ó�� ������ ��ü�� �ٲ� �� �ֱ� ������ ������.
		s=new String("10");
		System.out.println(s);
		
		
		byte b=127;
		short sh=32767;
		System.out.println(sh); //�⺻ ������ Ÿ���� �ʵ尡 ����.
		//System.out.println(sh.MAX_VALUE : "+sh.MAX_VALUE); //�⺻ ������ Ÿ���� �ʵ尡 ����.
		System.out.println("Short.MAX_VALUE : "+Short.MAX_VALUE); //�⺻ ������ Ÿ���� �ʵ尡 ����.
		//�⺻ ������ Ÿ���� ���� Ŭ������ �����Ѵ�.(�⺻ ������ Ÿ���� �����ϴ� ��ü[����ȯ, Ÿ�Կ� ���� ���� == ���, �⺻ ������ Ÿ���� ó��])
		System.out.println("1+s : "+(1+s));
		System.out.println("1+Integer.parseInt(s) : "+(1+Integer.parseInt(s)));
		int i=10;
		double d= 10.12345678901234567890123456790;
		float f= 10.12345678901234567890123456790f;
		long l=123456789123456789l;
		


	}

}
