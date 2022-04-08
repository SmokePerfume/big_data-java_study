package com.econ;

class Engine{
	int oil;
	int RPM;
//	Engine(int oil){
//		this.oil=oil;
//		++this.RPM;
//	}
	public void downAccel(int push) {}
}


//interface�� class�� ���赵 (type�� ����ϱ� ���� ����ġ�� �ϴ� ��)
interface Carable{ //�ڵ����� ���赵 -> �ٵ� ����� �� ����.
	String handle="�ڵ�"; //String final static handle = "�ڵ�"; (class ����)
	//Carable(){} //�������̽��� ��ü�� ���赵�� ������ �����ڸ� ����� �� ����.
	public void turnLeft(int left);
	public void turnRight(int right);
	public void downAccel(int push);
	//private void upRPM(int oil) {}; //private�� ���ο����� ��밡���ѵ� �������̽��� ���赵�� ���赵�̱� ������ private�� ���� ����
}
interface Carable2{
	//�ٵ� �������� ���� �޼ҵ带 �߻� �޼ҵ尡 �ϰ� interface ���ο����� ��������(��� �޼ҵ尡 �߻� �޼ҵ�)�ϴ�.
	public abstract void moveForward();
	public abstract void moveBackward();
	public abstract void downAccel(int push);
}



//�������̽��� implements�� �����ؾ��Ѵ�.
class BMW extends Engine implements Carable, Carable2{
	//�������̽����� �޼ҵ常 �����ϰ� ��� ������ ���� ������ ��ӹ��� ������ ��� ������ ��ġ�� �ʴ´�.
	//�������̽��� �޼ҵ�� �������� ���� ���赵 ���±� ������ ��ӹ��� �޼ҵ�� �̸��� ���ĵ� �ƹ� ����� ����.
	public void turnLeft(int left){}
	public void turnRight(int right) {}
	public void downAccel(int push){} //Engine�� �޼ҵ尡 �켱������ ����.
	public void moveForward() {}
	public void moveBackward() {}
}
class QM3 extends Engine implements Carable{
	public void turnLeft(int left) {};
	public void turnRight(int right) {
		super.downAccel(20);
	};
}
class MoveCar{
	Carable b;	//�������̽��� ���� �� Ŭ������ �������̽��� ���հ���(����� Ÿ��-> �Ű����� ���ϰ���)
	public MoveCar(Carable b) {
		this.b=b;
	}

	public void leftMove(int a) {
		b.turnLeft(a);
		System.out.println(a+"��ŭ �������� ��������.");
	}
	public void rightMove(int a) {
		b.turnRight(a);
		System.out.println(a+"��ŭ ���������� ��������.");
	}
}


/*
 * 1.�������̽��� �߻� �޼ҵ� ������ "{}" �ٵ� �߰��ϴ°���? ��
 * 2.class�� �޼ҵ�� �����Ǿ� �ְ� �߻�޼ҵ�� �������� �ʾұ� ������ �켱������ ����. 
 * 3.�߻�޼ҵ�(�ٵ���� abstract��� ���� �޼ҵ�),
 * interface (��� �޼ҵ尡 �߻��̰� ��� ������ ���� ������ ���赵),\
 * implements (class�� �������̽��� ������ �� ����ϴ� ��ɾ�)
 * 
 * */
public class L29Interface {
	public static void main(String[] args) {
		System.out.println(Carable.handle);
		//Carable c = new Carable(); //�������̽��� ��ü�� �� �� ����.
		Carable bmw=(Carable)new BMW();
		Carable qm3=new QM3();
		//�ΰ��� �ٸ� Ÿ���� ��ü�� 1���� Ÿ������ ������
		
		int i = new Integer(10);
		
		new MoveCar(new BMW()).rightMove(100);
		new MoveCar(new QM3()).rightMove(50);
	}
}
