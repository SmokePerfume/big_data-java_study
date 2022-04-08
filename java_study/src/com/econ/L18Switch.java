package com.econ;
import com.econ.lib.StringParseInt;
import java.util.Scanner;

class GradeApp{
	private int score;
	private String grade;
	//오버로드 : 이름은 똑같은데 매개변수가 달라서 다르게 호출되는 함수나 생성자를 의미 => 다형성 (개발을 용이하게 하는)
	//자바 스크립트는 오버로드가 불가능이다. (default 값이 대체한다.) : constructor(score=10){}
	public GradeApp() {}
	public GradeApp(int score){
		this.score=score;
		this.setGrade();
	}
	
	public void setScore(int score) {
		this.score=score;
		this.setGrade();
	}
	
	private void setGrade() {
		//switch
		switch(this.score/10) { //88=>8.8 이 아니라 8
		case 10:
			this.grade="A+";
			break;
		case 9:
			this.grade="A";
			break;
		case 8:
			this.grade="B";
			break;
		case 7:
			this.grade="C";
			break;
		case 6:
			this.grade="D";
			break;
		default:
			this.grade="F";
			break;
		}
		if(score%10>=5) { grade="+"+grade;}
	}
	
	public int getScore() {
		return this.score;
	}
	public String getGrade() {
		return this.grade;
	}
}
public class L18Switch {

	public static void main(String[] args) {
		int score=88;
		String grade="F";
		if(score>=90 && score<=100) {
			grade="A";
		}else if(score>=80 && score<90) {
			grade="B";
		}else if(score>=70 && score<80) {
			grade="C";
		}else if(score>=60 && score<70) {
			grade="D";
		}else {
			grade="F";
		}
//		///////////////////
//		System.out.println("당신의 성적은 "+grade);
//		/////////////////
//		System.out.println("성적 입력 프로그램입니다.");
//		System.out.print("점수 입력: ");
//		Scanner sc=new Scanner(System.in);
//		String str_score=sc.nextLine();
//		int score2=Integer.parseInt(str_score);
//		GradeApp gradeApp=new GradeApp(score2);
//		System.out.println("당신의 성적은 "+gradeApp.getGrade());
//		///////////////////
		
		
		//GradeApp public void setScore()를 구현해서 사용하세요.
		int count=7;
		int[] score_arr=new int[count]; //7번 성적을 입력 반은 후 grade_arr을 완성하고 grade_arr를 출력하세요.
		String[] grade_arr=new String[count];
		System.out.println("7개의 성적을 계산하는 프로그램입니다. (국,영,수,사,음,미,역) 순으로 입력하세요.");
		GradeApp ga = new GradeApp();
		int i=0;
		do {
			System.out.print("성적: ");
			Scanner sc= new Scanner(System.in);
			String str_str=sc.nextLine();
			StringParseInt spi=new StringParseInt(str_str);
			score_arr[i]=Integer.parseInt(spi.forceParseInt());
			ga.setScore(score_arr[i]);
			grade_arr[i]=ga.getGrade();
			i++;
			if(i==count) {
				for(i=0;i<score_arr.length;i++) {
					System.out.print(score_arr[i]+",");
				}
				System.out.println("입력하신 성적이 맞나요?(y/n)");
				sc=new Scanner(System.in);
				String msg=sc.nextLine();
				if(msg.equals("n")) {
					i=0;
				}else if(msg.equals("y")) {
					System.out.println("입력하신 성적의 등급입니다. ");
					System.out.print("{");
					for(i=0;i<grade_arr.length;i++) {
						System.out.print(grade_arr[i]+",");
					}
				}
				System.out.print("}");
			}
			
		}while(i<count);
		
		
		
		
		
		
		
		
		
		
//		for(int i=0;i<7;i++) {
//			System.out.print("점수 ["+i+"] 입력: ");
//			sc=new Scanner(System.in);
//			String str_score3=sc.nextLine();
//			int score3=Integer.parseInt(str_score3);
//			gradeApp.setScore(score3);
//			grade_arr[i]=gradeApp.getGrade();
//		}
//		for(int i=0;i<7;i++) {
//			System.out.print(grade_arr[i]+", ");
//		}
	}

}
