package com.econ.lib;

public class StringParseInt {
	String str_num; //받아와야하는 원본 필드 "1a23"
	char[] c_num; //{'1', 'a', '2', '3'}
	private boolean check_num; //형변환 가능한 문자열인지 체크하는 필드
	int num; // => Integer.parseInt("123")
	String check_str_num=""; //숫자로 바꿔넣은 문자열
	//public StringParseInt(){} 생략되어 있다가 정의하면 사라진다.
	public StringParseInt(String str_num){
		//생성자의 목적은 객체를 처음 생성할때 꼭 필요한 것을 초기화하기 위해서다.
		this.str_num=str_num;	
		this.c_num=new char[str_num.length()];
		for(int i=0; i<str_num.length();i++) {
			this.c_num[i]=str_num.charAt(i);
			//this 는 객체 내부에서 필드를 접근하는 접근자
		}
	}
	/**
	 * 문자열에 정수가 아닌 것을 찾으면 false를 반환
	 * 예) 	"1a92" => flase
	 * 	   	"1234" => true
	 */
	public boolean parseIntCheck() { //정수의 문자열인지 체크
		check_num=true;//자바는 this 생략가능
		for(int i=0;i<c_num.length;i++) {
			if(!(c_num[i]>=48&&c_num[i]<=57)) {
				check_num=false;
				return check_num; //하나라도 문자가 있다.
			}
		}
		return check_num;
	}
	/**
	 * 문자열에 정수가 아닌 것을 찾아서 제거한 후 반환해 주는 함수
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
		//String a_copy="1a23"; //리터럴하게 두번 이상 선언하면 만들지 않고 기존의 객체를 참조
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
			System.out.println(str+"은 정수로 형변환 불가한 문자열 입니다.");
			int num=Integer.parseInt(spi.forceParseInt());
			System.out.println(str+"은 강제로 형변환 가능한 정수로 변형 : "+num);
		}
		
		for(int i=0; i<spi.c_num.length;i++) {
			System.out.print(spi.c_num[i]+", ");
			//this 는 객체 내부에서 필드를 접근하는 접근자
		}
	}
}

//int는 기본형이 존재하고 문자열을 무조건 참조형이라 string 두가지는 같고 int와 Integer이 다른거죠?
//
//그럼 String a="1a23";은 참조형이지만 리터럴화하게 가독성을 위해 표현한건가요?
//String a2=new String("1a23");
//int i2=11; (원형)
//----------------------------- 
//String a="1a23";
//이렇게 표현하는 이유
//
//	 * String=오브젝트(참조형)
//Int=리터럴(기본형)
//Integer=기본형int를 객체화하는 
//오브젝트(참조형),랩퍼클래스


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