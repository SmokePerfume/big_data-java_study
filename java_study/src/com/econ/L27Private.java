package com.econ;
import com.econ.lib.O;
import com.econ.lib.P;


public class L27Private {
	public static void main(String[] args) {
		O o = new O(100);
		//System.out.println("o.a:"+o.a);//�ܺο��� ���� �Ұ�
		System.out.println("o.getA() : "+o.getA());//�ܺο��� ���� �Ұ�
		//System.out.println("o.b : "+o.b);//�ܺο��� ���� �Ұ� //protected �� ���� ��Ű���� ��ӵ� Ŭ���� ���� ��밡���� �ʵ�
		//System.out.println("o.c : "+o.c);//���� ��Ű�� ���ο����� ��밡��
		System.out.println("o.d : "+o.d); //public ��𼭵� ��� ����
		
		
		P p = new P(111);
		//System.out.println("p.a:"+p.a);//private
		//System.out.println("p.b : "+p.b);//protected
		//System.out.println("p.c : "+p.c);//default
		System.out.println("p.d : "+p.d);  //public
		
		/*				class ����	���� ��Ű��	�ٸ���Ű��+���	  �ٸ���Ű��
		 * private			o			x			x			 x	
		 * (default)		o			o			x			 x
		 * protected		o			o			o			 x
		 * public			o			o			o			 o
		 */
	}
}
