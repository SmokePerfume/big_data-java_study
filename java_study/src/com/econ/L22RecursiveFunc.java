package com.econ;

import com.econ.lib.ArrayUtil;

public class L22RecursiveFunc {
	public static int arraySum(int[] nums,int i) {
		int total=0;
		if(i<nums.length-1) {
			total=arraySum(nums, i+1);
			System.out.println("i ��: "+i+"nums[i] ��: "+nums[i]+" ����Լ����� total : "+total);
			return total+nums[i];
		}else {
			System.out.println("i ��: "+i+"nums[i] ��: "+nums[i]+" ����Լ����� total : "+total);
			return total+nums[i];
		}
	}
	/**
	 * �迭�� ����� �� �ִ� ���ڿ��� ��ȯ�ϴ� �Լ�
	 * (int[] arr, int length)
	 * arr: ����� �迭
	 * length : 0���� ����� ����
	 * 
	 * */
	
	public static String ArrayToString(int[] arr,int start) {
		String msg="";
		if(start<arr.length)
			msg+=arr[start]+","+L22RecursiveFunc.ArrayToString(arr, start+1);
		return msg;
	}
	
	//int[] nums2= {4,5,3,2,6,1};
	public static int searchMax(int[] arr, int end) { //����Լ��� �ִ밪 ã�� �Լ�
		int max;
		if(end==1) {					//���̰� 1�̸� �ڱ��ڽ��� �ִ밪
			System.out.println("�迭 [0]�� ������ �ʱⰪ ����: "+arr[0]);
			return arr[0];
		}else {
			max=searchMax(arr,end-1);	//���̰� 1�ƴϸ� �ƽ� ���� ���϶�!
			//max�� ���� �Ҵ�ǰų� arr[0]�� ��ȯ
			//������ ���̰� 1�� �ƴѰ�� max�� ���� �Ҵ�Ǿ� ������
			// �迭�� 0���� �����ϹǷ� �� �񱳵� end-1���� ����
			if(max<arr[end-1]) { 
				System.out.println("�迭 ["+(end-1)+"]�� ������ "+"�ִ밪 ����: "+arr[end-1]);
				return arr[end-1]; 
			}else {
				System.out.println("�迭 ["+(end-1)+"]�� �����δ� "+"���� ����: "+arr[end-1]);
				return max;
			}
		}
		
	}
	
	//����Լ��� ���� ����
//	static int temp;
//	public static int Select_sort(int[] arr,int length) {
//		int min=0;
//		for(int i=0;i<arr.length-1;i++) {
//			min=arr[i];
//			for(int j=i;j<arr.length-1;j++) {
//				temp=arr[j];
//				arr[j]=arr[j+1]
//				arr[j+1]=temp;
//			}
//			
//		}
//		return 1;
//	}
	
	
	
	///////////////���� �����/////////////////
//	public static String ArrayToString(int[] nums,int n) {
//		String msg="";
//		if(n==0)msg="{";
//		msg+=nums[n];
//		if(n==nums.length-1) {
//			msg+="}";
//			return msg;
//		}else {
//			msg+=",";
//			return msg+ArrayToString(nums,n+1);
//		}
//	}
	
	public static void main(String[] args) {
//		int[] nums= {1,2,3,4,5,6}; //������ ����Լ��� ���ϼ���.
//		int total=arraySum(nums,0);
//		System.out.println("���� ��� total = "+total);
//		//�⺻ ������ Ÿ���� ������ �迭�� ����� �� �ִ� ���ڿ��� ��ȯ�ϴ� ���ڿ��� ������ִ� ����Լ��� ���弼��.
//		
//		System.out.println("new ArrayUtil().toString(nums,0) : "+new ArrayUtil().toString(nums,0));
//		String msg=ArrayToString(nums,0);
//		System.out.println("nums="+msg);
		int[] nums2= {4,5,3,2,6,1};
		int max=searchMax(nums2,nums2.length);
		System.out.println("�ִ밪 : "+max);
		
	}	
}
