package com.econ.lib;

public class StringParseInt {
	String str_num; //�޾ƿ;��ϴ� ���� �ʵ� "1a23"
	char[] c_num; //{'1', 'a', '2', '3'}
	private boolean check_num; //����ȯ ������ ���ڿ����� üũ�ϴ� �ʵ�
	int num; // => Integer.parseInt("123")
	String check_str_num=""; //���ڷ� �ٲ���� ���ڿ�
	//public StringParseInt(){} �����Ǿ� �ִٰ� �����ϸ� �������.
	public StringParseInt(String str_num){
		//�������� ������ ��ü�� ó�� �����Ҷ� �� �ʿ��� ���� �ʱ�ȭ�ϱ� ���ؼ���.
		this.str_num=str_num;	
		this.c_num=new char[str_num.length()];
		for(int i=0; i<str_num.length();i++) {
			this.c_num[i]=str_num.charAt(i);
			//this �� ��ü ���ο��� �ʵ带 �����ϴ� ������
		}
	}
	/**
	 * ���ڿ��� ������ �ƴ� ���� ã���� false�� ��ȯ
	 * ��) 	"1a92" => flase
	 * 	   	"1234" => true
	 */
	public boolean parseIntCheck() { //������ ���ڿ����� üũ
		check_num=true;//�ڹٴ� this ��������
		for(int i=0;i<c_num.length;i++) {
			if(!(c_num[i]>=48&&c_num[i]<=57)) {
				check_num=false;
				return check_num; //�ϳ��� ���ڰ� �ִ�.
			}
		}
		return check_num;
	}
	/**
	 * ���ڿ��� ������ �ƴ� ���� ã�Ƽ� ������ �� ��ȯ�� �ִ� �Լ�
	 * "1a93" =>"193"
	 */
	public  String forceParseInt() {
		for(int i=0;i<c_num.length;i++) {
			if(c_num[i]>=48&&c_num[i]<=57) {
				check_str_num+=c_num[i];
			}
		}
		return check_str_num;
	}
}
class TestJRE{
	public static void main(String[] args) {
		//const arr=new Array(1,2,3)
		//const arr=[1,2,3];
		//String a="1a23";
		//String a_copy="1a23"; //���ͷ��ϰ� �ι� �̻� �����ϸ� ������ �ʰ� ������ ��ü�� ����
		//String a2=new String("1a23");
		//Integer i1=new Integer(11);
		//int i2=11;
		String str="78a9b5"; //=> 7895
		StringParseInt spi=new StringParseInt(str);
		//System.out.println("spi.check_num : "+spi.check_num);
		if(spi.parseIntCheck()) {
			int num=Integer.parseInt("str");
			System.out.println("num : "+num);
		}else {
			System.out.println(str+"�� ������ ����ȯ �Ұ��� ���ڿ� �Դϴ�.");
			int num=Integer.parseInt(spi.forceParseInt());
			System.out.println(str+"�� ������ ����ȯ ������ ������ ���� : "+num);
		}
		
		for(int i=0; i<spi.c_num.length;i++) {
			System.out.print(spi.c_num[i]+", ");
			//this �� ��ü ���ο��� �ʵ带 �����ϴ� ������
		}
	}
}

//int�� �⺻���� �����ϰ� ���ڿ��� ������ �������̶� string �ΰ����� ���� int�� Integer�� �ٸ�����?
//
//�׷� String a="1a23";�� ������������ ���ͷ�ȭ�ϰ� �������� ���� ǥ���Ѱǰ���?
//String a2=new String("1a23");
//int i2=11; (����)
//----------------------------- 
//String a="1a23";
//�̷��� ǥ���ϴ� ����
//
//	 * String=������Ʈ(������)
//Int=���ͷ�(�⺻��)
//Integer=�⺻��int�� ��üȭ�ϴ� 
//������Ʈ(������),����Ŭ����


//}
//public int forceparseInt() {
////this.c_num;
//String s_num="";
//for(int i=0;i<this.c_num.length;i++) {
//	if(this.c_num[i]>=48&&this.c_num[i]<=48) {
//		s_num+=this.c_num[i];
//	}
//}
//int pars_c=Integer.parseInt(s_num);
//return pars_c;
//}