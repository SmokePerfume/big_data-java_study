package com.econ;
class Flower{
	//�ʵ� ���ٶ� �� undefined�� ������� �ʴ´�.
	int ����=1;
	int �ϼ�=1;
	int ����;
	static int �׽���=0; //�޸� �̹� �����
	int �׽���2=0;
	//�����ڸ� �����ϸ� default �����ڰ� ������鼭 ������ ��Ģ�� �����.
	Flower(){}
	Flower(int ����){
		//������ ������ ������ ������ �̸��� ���� �� ������ �켱�̴�. 
		this.���� = ����;
	}
	Flower(int ����, int �ϼ�, int ����){ //�����ڸ� �����ε�
		this.����=����;
		this.����=����;
		this.�ϼ�=�ϼ�;
	}
	int sum() {
		return 10;
	}
}
public class L21Constructor {
	//������
	public static void main(String[] args) {
		Flower ����ȭ = new Flower(6);
		System.out.println(����ȭ.����);
		Flower ����ȭ2=new Flower(6,8,1);
		//�����ڴ� new�θ� ȣ���� ��  �ִ�,
		
		
		
		
		
		//////////static ���ؿ� (��ü �����ϱ⵵�� class�� �а� �޸𸮿� ����)////////////
		Flower number1 = new Flower(); //ù��° number
		Flower number2 = new Flower(); //�ι��� number
    	
    	number1.�׽���++; //Ŭ���� �ʵ� num�� 1������Ŵ(static)
    	number1.�׽���2++; //�ν��Ͻ� �ʵ� num�� 1������Ŵ
        
        //�ι�° number�� Ŭ���� �ʵ� ��� (static)
    	//��°� 1
        System.out.println(number2.�׽���); 
    	//�ι�° number�� �ν��Ͻ� �ʵ� ���
        //��°� 0
        System.out.println(number2.�׽���2); 
	}
}
