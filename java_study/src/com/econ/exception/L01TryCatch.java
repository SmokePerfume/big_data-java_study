package com.econ.exception;

class Calc{
	private int a,b;
	Calc(int a, int b){
		this.a=a;
		this.b=b;
	}
	public int div() throws Exception{
		//���� ����: ����ϴ� �ʿ��� Try catch �ۼ��� �����Ѵ�.
		return a/b;
	}
	public int sum() {
		return a+b;
	}
}

public class L01TryCatch {
	//main�� throws�� ����ϸ� ����ó���k ���� �ʴ´ٴ� �ǹ̴�.
	public static void main(String[] args){
		Calc c=new Calc(10,00);
		try {
			System.out.println(c.div());
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			System.out.println("������ ���� �ʾƵ� �������� ������ ����");
			//����� �Ҷ� ���ᵵ�� ���� ���� �� ���ȴ�. ��) mysql conn�� end() �ؾ��ϴ� ��
		}
		System.out.println(c.sum()); //������ �߻��ϸ� �ý����� �����. ->�ݵ�� ����ó���� �ؾ��Ѵ�.

	}
}
