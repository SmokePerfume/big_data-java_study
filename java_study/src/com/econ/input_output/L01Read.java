package com.econ.input_output;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class L01Read {
	public static void main(String[] args) {
		//input�� Output�� ����̴�. (JVM�� os�� �ܼ�(CLI, �͹̳�)�ý��۰� ���)
		//����� ������ ����ó���� �Ѵ�.
		ArrayList<Integer> char_arr=new ArrayList<Integer>();
		String str="";
		//System.out.println("(char)13: "+(char)13); //������� ���� ���࿡ ������ �߰��Ǽ� ����.
		//System.out.println("(char)190+....: "+(char)190+(char)200+(char)179+(char)190+(char)231);
		try {//���� ���� ����==10
			//input=System.in.read(); //���ڸ� �Է��ϸ� char ��ȣ�� ��ȯ
			int input=0;
			while((input=System.in.read())!=10) {
				char_arr.add(input);
				str+=(char)input;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(char_arr); 
		System.out.println(str); 
		//�ܼ���µ� ����ó���� �ؾ������� ���� ��ǻ�� ���ο��� ����� �̷������ ������ ������ ���ɼ��� ����.

	}

}
