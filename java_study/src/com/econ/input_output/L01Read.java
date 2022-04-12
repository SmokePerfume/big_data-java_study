package com.econ.input_output;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class L01Read {
	public static void main(String[] args) {
		//input과 Output은 통신이다. (JVM과 os의 콘솔(CLI, 터미널)시스템과 통신)
		//통신은 무조건 예외처리를 한다.
		ArrayList<Integer> char_arr=new ArrayList<Integer>();
		String str="";
		//System.out.println("(char)13: "+(char)13); //윈도우는 라인 개행에 공백이 추가되서 들어간다.
		//System.out.println("(char)190+....: "+(char)190+(char)200+(char)179+(char)190+(char)231);
		try {//라인 개행 문자==10
			//input=System.in.read(); //문자를 입력하면 char 번호를 반환
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
		//콘솔출력도 예외처리를 해야하지만 같은 컴퓨터 내부에서 통신이 이루어지기 때문에 오류의 가능성이 적다.

	}

}
