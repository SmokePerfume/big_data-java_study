package com.econ;
class StringParseInt{
	char[] c_num= {'9','a','1','2'};
	int par_num=0;
	public StringParseInt(String nums){
		if(checkInt(nums)) {
			System.out.println("������ �̷���� ���ڿ�");
			this.par_num=Integer.parseInt(nums);
		}else {
			System.out.println("������ �̷���� ���ڿ��� �ƴմϴ�.");
		}
	}
	
	public boolean checkInt(String nums) { //������ ���ڿ����� üũ
		for(int i=0;i<nums.length();i++) {
			if(nums.charAt(i)<48||nums.charAt(i)>57) {
				return false; //�ϳ��� ���ڰ� �ִ�.
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
				continue; //��Ƽ���� ������ �������� �ٽ� �ݺ��� ���� �������� �ǵ��ư���.
			}
			s_num+=c_num[i]; //a�� ���� �����ϰ� ���ϰ� �ʹ�.
		}
		System.out.println(Integer.parseInt(s_num+10));
		
		s_num="";
		String nums="16a7b5"; //=>"1675"�� �ٲ㼭 +10 ������ �ϼ���!
		for(int i=0;i<nums.length();i++) {
			if(nums.charAt(i)<48||nums.charAt(i)>57) {
				continue; //��Ƽ���� ������ �������� �ٽ� �ݺ��� ���� �������� �ǵ��ư���.
			}
			s_num+=nums.charAt(i); //a�� ���� �����ϰ� ���ϰ� �ʹ�.
		}
		System.out.println(Integer.parseInt(s_num+10));
		
		//���� ����ȯ �������� �˻� �� ��ȯ �Ұ��� false�� ��ȯ
		int num_check=0; //���� �� ����
		for(int i=0;i<nums.length();i++) {
			char c=nums.charAt(i);
			if(c<48||c>57) {
				num_check++;
			}
		}
		System.out.println("�� ��ȯ ����?:"+((num_check==0)?"true":"false"));
		
		boolean bool_check=true; //���� �� ����
		for(int i=0;i<nums.length();i++) {
			char c=nums.charAt(i);
			if(c<48||c>57) {
				bool_check=false;
				break;
			}
		}
		System.out.println("�� ��ȯ ����?:"+bool_check);
	}

}
