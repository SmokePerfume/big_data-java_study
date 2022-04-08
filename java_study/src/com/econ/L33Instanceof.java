package com.econ;
interface Personable{};
class Child extends Parent implements Personable{
	int b=20;
}
class Parent{
	int a=10;
}
class ArrayPrint{
	ArrayPrint(Object[] nums){
		String msg="";
		for(int i=0; i<nums.length; i++) {
			msg+=nums[i].toString()+",";
		}
		System.out.println(msg);
	}
}
public class L33Instanceof {
	public static void main(String[] args) {
		Object[] nums= {10,20,30};
		new ArrayPrint(nums);
		Object[] strs= {"��","��","��","��","��"};
		new ArrayPrint(strs);
		String a="�ȳ�";
		System.out.println(a instanceof String); //��ü�� Ÿ���� Ȯ��
		System.out.println("�ȳ�" instanceof String);
		System.out.println(a instanceof Object); //��ü�� �θ��� Ÿ�Ե� true
		////////////////////////////
		Child c = new Child();
		//System.out.println(c instanceof String);
		System.out.println(c instanceof Child);
		System.out.println(c instanceof Parent);
		System.out.println(c instanceof Object);
		System.out.println(c instanceof Personable); //type��
		
		//"��ü" instanceof "type" �� ������ ��ü�� �� ������
		///////!!!!�ں����� �⺻������ Ÿ���� data�� Ÿ���� Ȯ���� ����� ����.
		//System.out.println(10 instanceof int);

		System.out.println(new Integer(10) instanceof Integer);
		
		Object obj_c=new Child();
		Object obj_str=new String("�ȳ�");
		Object obj_str2="�ȳ�";
		Object obj_int=10;
		Object obj_db=10.0;
		Object obj_f=10.0f;
		Object[] obj_arr= {10,20,30,100};
		//System.out.println(obj_int+20);
		//��� ��ü�� �θ��� Object�� ��� Ÿ���� ��ü�� ������ �� ������ Object �ʵ常 ��밡��
		
		byte b=(byte)200;
		System.out.println(b);
	}
}
