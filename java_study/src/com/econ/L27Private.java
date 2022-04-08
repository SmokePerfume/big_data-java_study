package com.econ;
import com.econ.lib.O;
import com.econ.lib.P;


public class L27Private {
	public static void main(String[] args) {
		O o = new O(100);
		//System.out.println("o.a:"+o.a);//외부에서 참조 불가
		System.out.println("o.getA() : "+o.getA());//외부에서 참조 불가
		//System.out.println("o.b : "+o.b);//외부에서 참조 불가 //protected 는 같은 패키지와 상속된 클래스 에서 사용가능한 필드
		//System.out.println("o.c : "+o.c);//같은 패키지 내부에서만 사용가능
		System.out.println("o.d : "+o.d); //public 어디서든 사용 가능
		
		
		P p = new P(111);
		//System.out.println("p.a:"+p.a);//private
		//System.out.println("p.b : "+p.b);//protected
		//System.out.println("p.c : "+p.c);//default
		System.out.println("p.d : "+p.d);  //public
		
		/*				class 내부	같은 패키지	다른패키지+상속	  다른패키지
		 * private			o			x			x			 x	
		 * (default)		o			o			x			 x
		 * protected		o			o			o			 x
		 * public			o			o			o			 o
		 */
	}
}
