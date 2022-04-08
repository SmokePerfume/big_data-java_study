package com.econ;

import java.util.Scanner;

public class L14IfElse {

	public static void main(String[] args) {
		int month=12; //1~12;
		String[] month_arr= {"Jan", "Feb", "Mar", "Apr", "May", "Jun","Jul", "Aug", "Sep","Oct","Nov", "Dec"};
		//1~12������ �Է��� ������ ������ Mar ���Դϴ�. ����ϼ���.
		//1~12������ �ƴϸ� 1~12������ ���� �Է��ϼ��� ���!!
		if(month>=1&&month<=12) {
			System.out.println("������ "+month+"�� "+month_arr[month-1]+"�Դϴ�.");
		}else {
			System.out.println("1~12���� ���� �Է��ϼ���.");
		}
		//���ߴܿ��� ó���ϴ� ����ó��!
		int week=8; //1~7;
		String[] week_arr=new String[7];
		week_arr[0]="SUn";
		week_arr[1]="Mon";
		week_arr[2]="Tues";
		week_arr[3]="Wed";
		week_arr[4]="Thus";
		week_arr[5]="Fri";
		week_arr[6]="Sat";
		//������ �߻����� �� ����ó��
		try {
			System.out.println("������"+week_arr[week-1]+"�Դϴ�.");
			System.out.println("������ �߻��ϸ� catch�� �ٷ� �̵��Ѵ�.");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("���� : "+e.getMessage()); //�����ڸ� �����ϴ� �޼���
			System.out.println("1~7������ �Է��ϼ���!");
		}
		System.out.println("������ �߻��ϸ� �ڹٴ� ������ �����.");
		//if������ ����ó�� �� �� �̵�
		//1. � ������ �ڵ�󿡼� �߻��ϴ��� �� �� �ִ�. => ��ü������ ������ ���� �� �ִ�.
		//2. ������ �߻��ϱ����� ���� �� �ִ�.
		
		//try catch�� ����� �� �ۿ� ���� ����
		//1. ����� �� �� ����� ������ ó���� ��
		//2. ���̺귯���� ����Ҷ� if�� ��뿡 �Ѱ谡 ���� ��
		
		//�ֿܼ� �Է��� ���ڸ� �Է¹޴� System.in
		System.out.print("����� Ȯ���ϰ� ���� �� �Է�: ");
		Scanner sc= new Scanner(System.in); //���ڸ� �Է��ϰ� ���� ������ �ϸ� ���ΰ��� �ϱ� ������ �Է��� ���ڸ� ���� �� �ִ�.
		String month_input=sc.nextLine();// �����߿� ���ڰ� �ƴ� ���� �ִ��� �˻�
		
		
		
		
		
		
		//���ڿ� �Է½� �ٽ� �Է¹�������!
		//1~12������ �˻��ϼ���!!
//		try {
//			int month_par=Integer.parseInt(month_input);
//			System.out.println("����� �Է��� ���� "+ month_arr[month_par-1]+"�Դϴ�.");
//		}catch(ArrayIndexOutOfBoundsException e){
//			System.out.println("1~12������ ������ �ƴ�");
//		}catch(NumberFormatException e){
//			System.out.println("���ڰ� �ƴ�");
//		}
		
		if(stringIntTest(month_input)) {
			int month_par=Integer.parseInt(month_input);
			if(month_par>0&&month_par<13) {
				System.out.println("����� �Է��� ���� "+ month_arr[month_par-1]+"�Դϴ�.");
			}else {
				System.out.println("1~12������ ������ �ƴ�");
			}
		}else {
			System.out.println("������ �Է��ϼ���!!");
		}		
		
		
		
	}
	static Boolean stringIntTest(String a){
		//���ڿ��߿� 1���� ���ڶ� ���ڰ� �ƴϸ� false
		for(int i=0; i<a.length();i++){
			int a_par=(int)a.charAt(i);
			System.out.println(a.charAt(i)+" : "+a_par);
			if(a_par<48||a_par>58) {
				return false;
			}
		} 
		return true;
	}

}
