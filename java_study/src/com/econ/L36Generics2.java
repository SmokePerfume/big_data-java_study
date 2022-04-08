package com.econ;

class ArrayPrint2{
	
	//�迭�� �⺻���� �Ű������� �������� �Ű������� Ȯ���� �����Ѵ�.
	public ArrayPrint2(Object[] arr) {
		String msg=arr.getClass()+" = ";
		for(int i=0;i<arr.length;i++) {
			msg+=arr[i]+", ";
		}
		System.out.println(msg);
	}
	//��� Ÿ���� �Ű������� �ޱ����� Object�� ����ϸ�
	//���� �ʵ� ȣ��� or ����ȯ �Ұ��� type���� ����ȯ�� ���� !
	//�⺻ ������ Ÿ���� �迭�� ����� �� ����.
	//�ڵ尡 � ���� �ϰ� ������ �Һи��ϴ�.
}


public class L36Generics2 {
	public static void main(String[] args) {
		Object[] arr= {100,20,1,-200,300,new Integer(120)};
		System.out.println(arr[0].getClass());
		//System.out.println(100.getClass());
		new ArrayPrint2(arr);
		
		String[] arr2= {"100","20","1","-200","300","120"};
		new ArrayPrint2(arr2);
		
		Object[] arr3= {1.02,2.03,3.001,4.00001,5.21,7.11};
		System.out.println(arr3[0].getClass());
		new ArrayPrint2(arr3);
		
		Double[] arr4= {1.02,2.03,3.001,4.00001,5.21,7.11};
		System.out.println(arr4[0].getClass());
		new ArrayPrint2(arr4);
		
		double[] arr5= {1.02,2.03,3.001,4.00001,5.21,7.11};
//		new ArrayPrint2((Object)arr5); //�迭�� ĳ���� ����ȯ�� �Ұ����ϴ�
	}
}
