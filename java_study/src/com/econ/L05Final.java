package com.econ;
class MathInfo{
	final double PI=3.141592653589793238462643;
}
public class L05Final {
	public static void main(String[] args) {
		//���� (���� �� �ִ� ��) 
		//1. �����ϴ� ��ü�� �ٲ� �� �ִ�.
		int i=10; //is : let (int) i=10;
		i=20;
		//���(������ �ʴ�[const] ��) const i=10;
		final int I=10;
		//I=20;
		System.out.println(I);
		//is ����� ���� ����ϳ���?
		//let arr=[1,2,3,4];
		//arr=20;
		//arr[0]: ����!
		//arr=20; �Ұ�
		//������ �����ϱ� ����
		//�ٲ�� �ȵǴ� ���� �����ϱ� ����
		System.out.println(Integer.MAX_VALUE);
		final double PI=3.14; //�ٲ��� �ʴ� ������ �����Ҷ�
		//����� �빮�ڷ� �ۼ��ϴ� ������ ������ ���̸� �ֱ����� (�����ڰ��� ���)
		
		//�������� 2�� ���� ����
		System.out.println("�������� 2�� ���� ���� : "+2*2*new MathInfo().PI);
		MathInfo math=new MathInfo();
		System.out.println("�������� 2�� ���� ���� : "+2*2*math.PI);
		
	}
}
