package com.econ;
//com.econ.WIDTH (X) ���簡 ���� �̸��� �������� �ʴ´�.
//public static final double WIDTH=250.01;

class Car{
	public static final double WIDTH=250.01; 
	//����� ���� ���� ���� �������� ���� ���Ǳ� ������ static �ʵ忡 ����ǰ� ��𼭵� ���������ϴٴ� �ǹ̷� public�� �����Ѵ�.
	final double HEIGHT = 500.01;
	private final String ENGINE = "N012421"; //class ���ο����� ��밡��
}

public class L06Static {
	public static void main(String[] args) {
		//static �ʵ�� �ν��Ͻ� ��ü���� ����
		//static �ʵ�� class�� �ؼ��Ҷ� ��ü�� �����.
		//�ν��Ͻ� ��ü�� new �����ڷ� �����ڸ� ȣ���� �� ���������.
		System.out.println(Car.WIDTH);
		System.out.println(Car.WIDTH);
		System.out.println(Car.WIDTH);
		
		System.out.println(new Car().HEIGHT);
		System.out.println(new Car().HEIGHT);
		System.out.println(new Car().HEIGHT);
		//static �ʵ�� new Car()�� ��ü�� �ƴϳ�,
		//static �ʵ�� class�� �̸��� �����´�. (���� �޸𸮶� �θ��� ���� �����, jre �� main�� �⺻������Ÿ���� ����Ǵ� �޸�)
		//��ü�� (���� �޸� heap�̶�� �θ��� ���� ����� => �������÷��ǿ� ���� �޸𸮰� �ڵ� �����Ǵ� ����)
		
		//�ڹٴ� class �ۿ��� �� �� �ִ� ���� �ƹ� �͵� ����.
		//System.out.println(new Car().ENGINE);
		//System.out.println(Car.ENGINE);
	}
}
