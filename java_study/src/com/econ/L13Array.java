package com.econ;
class Month{
	int month; //1,2,3,4,~12
	String en_month;//Jan, Feb ...
	String kr_month; //1월, 2월
	Month(int month, String en_month){
		this.month=month;
		this.en_month=en_month;
		this.kr_month=month+"월";
		
	}
}
public class L13Array {

	public static void main(String[] args) {
		// Array는 인덱스를 참조키로 사용하는 참조형 데이터 타입
		// 인덱스와 길이를 제외하고 Object의 필드로만 구성된 경량 배열 타입이다.
		String[] month= {"Jan", "Feb", "Mar", "Apr", "May", "Jun","Jul", "Aug", "Sep","Oct","Nov", "Dec"};
		Month[] obj_mon= {new Month(1,"Jan"), new Month(2,"Feb"), new Month(3,"Mar"), new Month(4,"Apr"), new Month(5,"May"),
				 		  new Month(6,"Jun"), new Month(7,"Jul"), new Month(8,"Aug"), new Month(9,"Sep"), new Month(10,"Oct"),
				 		  new Month(11,"Nov"), new Month(12,"Dec")};
		int[] p_arr= {12000,-3000,1000,2500,500,3000};
		System.out.println(p_arr.length);
		System.out.println(p_arr[4]);
		try {
			System.out.println(p_arr[5]);//길이는 1부터, index는 0부터 시작
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("실행좀되나");
		
		int p_arr_total=0;
		
		for(int i=0;i<p_arr.length;i++) {
			p_arr_total+=p_arr[i];
		}
		System.out.println(p_arr_total+"won");
		int max=0; //처음에 발견한 것이 max
		int max_i=0;
		for(int i=0; i<p_arr.length;i++) {
			if(i==0) {
				max=p_arr[i];
			}else {
				if(max<p_arr[i]) {
					max=p_arr[i];
					max_i=i;
				}
			}
		}
		System.out.println(max_i+" : "+max);
		//최소값을 찾으세요
		int min=9999999;
		int min_i=0;
		for(int i=0; i<p_arr.length;i++) {
			if(i==0) {
				min=p_arr[i];
			}else {
				if(min>p_arr[i]) {
					min=p_arr[i];
					min_i=i;
				}
			}
		}
		System.out.println(min_i+" : "+min);
		//최대값을 맨 앞으로 옮겨서 정렬하세요 (선택정렬)
		int sel_min=0;
		int sel_i=0;
		int temp;
		for(int i=0;i<p_arr.length;i++) {
			System.out.print(p_arr[i]+", ");
		}
		System.out.println();
		for(int i=0; i<p_arr.length;i++) {
			sel_min=p_arr[i];
			sel_i=i;
			for(int j=i+1;j<p_arr.length;j++) {
				if(sel_min>p_arr[j]) {
					sel_min=p_arr[j];
					sel_i=j;
				}
			}
			temp=p_arr[i];
			p_arr[i]=p_arr[sel_i];
			p_arr[sel_i]=temp;
			System.out.print(p_arr[i]+", ");
		}
		//for(int i=0;i<p_arr.length;i++) {
		//	System.out.print(p_arr[i]+", ");
		//}
		
		
		String[] weeks = new String[7];
		weeks[0]="월요일";
		weeks[1]="화요일";
		weeks[2]="수요일";
		weeks[3]="목요일";
		weeks[4]="금요일";
		weeks[5]="토요일";
		weeks[6]="일요일";
		String[] weeks2= {"월","화","수","목","긑","토","일"};
		
		
	}

}
