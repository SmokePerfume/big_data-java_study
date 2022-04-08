package com.econ;
class StringParseInt{
	char[] c_num= {'9','a','1','2'};
	int par_num=0;
	public StringParseInt(String nums){
		if(checkInt(nums)) {
			System.out.println("정수로 이루어진 문자열");
			this.par_num=Integer.parseInt(nums);
		}else {
			System.out.println("정수로 이루어진 문자열이 아닙니다.");
		}
	}
	
	public boolean checkInt(String nums) { //정수의 문자열인지 체크
		for(int i=0;i<nums.length();i++) {
			if(nums.charAt(i)<48||nums.charAt(i)>57) {
				return false; //하나라도 문자가 있다.
			}
		}
		return true;
	}

	public int forceparseInt() {
		//this.c_num;
		String s_num="";
		for(int i=0;i<this.c_num.length;i++) {
			if(this.c_num[i]>=48&&this.c_num[i]<=48) {
				s_num+=this.c_num[i];
			}
		}
		int pars_c=Integer.parseInt(s_num);
		return pars_c;
	}
}








public class L17Break {
	public static void main(String[] args) {
		char[] c_num= {'9','a','1','2'};
		String s_num="";
		for(int i=0;i<c_num.length;i++) {
			if(c_num[i]<48||c_num[i]>57) {
				continue; //컨티뉴를 실행한 시점에서 다시 반복문 실행 시점으로 되돌아간다.
			}
			s_num+=c_num[i]; //a일 때는 제외하고 더하고 싶다.
		}
		System.out.println(Integer.parseInt(s_num+10));
		
		s_num="";
		String nums="16a7b5"; //=>"1675"로 바꿔서 +10 연산을 하세요!
		for(int i=0;i<nums.length();i++) {
			if(nums.charAt(i)<48||nums.charAt(i)>57) {
				continue; //컨티뉴를 실행한 시점에서 다시 반복문 실행 시점으로 되돌아간다.
			}
			s_num+=nums.charAt(i); //a일 때는 제외하고 더하고 싶다.
		}
		System.out.println(Integer.parseInt(s_num+10));
		
		//수로 형변환 가능한지 검사 후 변환 불가면 false를 반환
		int num_check=0; //있을 때 증가
		for(int i=0;i<nums.length();i++) {
			char c=nums.charAt(i);
			if(c<48||c>57) {
				num_check++;
			}
		}
		System.out.println("형 변환 가능?:"+((num_check==0)?"true":"false"));
		
		boolean bool_check=true; //있을 때 증가
		for(int i=0;i<nums.length();i++) {
			char c=nums.charAt(i);
			if(c<48||c>57) {
				bool_check=false;
				break;
			}
		}
		System.out.println("형 변환 가능?:"+bool_check);
	}

}
