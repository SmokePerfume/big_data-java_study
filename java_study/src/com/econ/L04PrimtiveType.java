package com.econ;
class Econ{
	int a=10;
	String b="�ȳ�";
	int sum(int a, int b) {
		return this.a+b;
	}
}

public class L04PrimtiveType {
	public static void main(String[] args) {
		//�������� �⺻�� ������ Ÿ��
		//�⺻���� ������ ��� �����ʹ� �������̴�.
		//�⺻���� Ư¡
		//1.�޸𸮿� ����� ���� ������ �ʴ´�. (���ͷ�)
		//2.���� ���� ���� �ִ�. (������ ��� �����͸� ���� ǥ�� -> ��ġȭ -> ��ǻ�� ������)
		//3.�⺻������ Ÿ���� ���α׷��ֿ��� ���� ���� ���Ǵ� data�� ����� �� ��ǻ�Ϳ��� �����ϴ� ���� ���α׷����̱� ����
		/* �ڹ��� �⺻���� Ư¡
		 * 1. type�� �ҹ��ڷ� �����Ѵ�. byte, short, int, long, float, double, char, boolean
		 * 2. ���ڿ��� �⺻���� �ƴϴ�. ���!! ���ͷ� ǥ����� �����ϰ� ���� ���ͷ��ϰ� �����ϸ� �Ȱ��� �����Ͱ� ������ ���������ʰ� �Ȱ��� �����͸� ����
		 * 3. �⺻���� ����Ŭ������ �����Ѵ�. Byte, Short, Integer, Long, Float, Double, Character, Boolean
		 * 4. �ڹ��� �⺻���� �ߺ��� �����Ͱ� ���� ������ ���Ҽ� �ִ�.
		 * int a=10; int b=10; 10�̶� �����Ͱ� 1�� ��������� a�� b�� �����ȴ�.
		 * Integer a=new Integer(10),  Integer b=new Integer(10); ��ü ������ a�� �����Ȱ�, ��ü ������ b�� ����
		 * */
		/* ������ �������� Ư¡
		 * 1. ���� ��ü�� �����Ѵ� => �����ϴ� �����Ͱ� �ٲ� �� �ִ�.
		 * 2. �������� ���赵�� Ÿ���� �����Ѵ�.
		 * 3. �ʵ��� ������ �ٲ��� ��ü�� �� �ٲ��� �ʴ´�.
		 * 
		 * �ڹ� ������ �������� Ư¡
		 * 1. ��ü���� ���� new �����ڷ� �����ڸ� ȣ���ؼ� �����Ѵ�.
		 * 2. ����(class �ֻ��� ��[scope])�� �����ϴ� ������ ���, �޼ҵ尡 �ʵ尡 �ȴ�.
		 * 3. this �� ��ü�� �ʵ� �����ڴ�.
		 * 4. �������� �ڱ� �ڽ��� �����ϰ� ==���� ���� �� ����. (������ ���� �ʵ��߿� � ���� ���ٴ� ������ ���� ����)
		 * 5. ���� �ʵ��߿� ���� ���� ������ ���ٰ� �ϰ� �ʹٸ� equals()�� ������ �� �ִ�.
		 */
		int a = 10;
		int b = 10; //�޸𸮿� 10�̶� �����Ͱ� ������ ������ �ʰ� ã�Ƽ� ��� -> �⺻���� Ư¡
		System.out.println("a==10 : "+(a==10));
		System.out.println("a==b : "+(a==b));
		Integer c=new Integer(10);
		Integer d=new Integer(10);
		System.out.println("c : "+c);
		System.out.println("c + 1 : "+(c+1));
		System.out.println("c.MAX_VALUE : "+(c.MAX_VALUE));
		//System.out.println("a.MAX_VALUE : "+(a.MAX_VALUE)); //�Ұ���
		
		System.out.println("c == d : "+(c==d));
		System.out.println("c == c : "+(c==c));
		System.out.println("c.equals(b) : "+(c.equals(b))); //Ư�� �ʵ尡 ������ �� ��ü�� ���� ���ٰ� �� �� �ִٰ� ������
		
		Econ e=new Econ();
		e.a=100;
		System.out.println("e.a : "+e.a);
		System.out.println("e.b : "+e.b);
		// == �ּ��� ������ ���ϴ� �� ����
		// ��� �����ʹ� �޸��� �ּҸ� ���´�.
		
		String txt1="�ȳ�";
		String txt2=new String("�ȳ�");
		String txt3="�ȳ�";
		//���ڿ��� ���ͷ��ϰ�(�⺸������Ÿ��ó��) ������ �� ������ txt1�� txt2�� �Ѵ� ���������� ������ �Ȱ��� �ʵ带 ���´�.
		//txt1 �ʵ� 90
		//txt2 �ʵ� 90
		System.out.println("txt1==txt2 : "+(txt1==txt2));
		System.out.println("txt1==txt3 : "+(txt1==txt3)); 
		//���ͷ��ϰ� �����ϸ� �޸𸮿��� ���� ���� �ִ��� �˻��� �� ������ �⺻������ Ÿ��ó�� �����Ѵ�.=> ���ڿ��� ���� ����ϱ� ������
		System.out.println("txt1.equals(txt2) : "+(txt1.equals(txt2)));
		
		
		
		
	}
}
