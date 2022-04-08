package com.econ;

import com.econ.lib.ArrayUtil;

public class L22RecursiveFunc {
	public static int arraySum(int[] nums,int i) {
		int total=0;
		if(i<nums.length-1) {
			total=arraySum(nums, i+1);
			System.out.println("i 값: "+i+"nums[i] 값: "+nums[i]+" 재귀함수내부 total : "+total);
			return total+nums[i];
		}else {
			System.out.println("i 값: "+i+"nums[i] 값: "+nums[i]+" 재귀함수내부 total : "+total);
			return total+nums[i];
		}
	}
	/**
	 * 배열을 출력할 수 있는 문자열로 반환하는 함수
	 * (int[] arr, int length)
	 * arr: 출력할 배열
	 * length : 0부터 출력할 길이
	 * 
	 * */
	
	public static String ArrayToString(int[] arr,int start) {
		String msg="";
		if(start<arr.length)
			msg+=arr[start]+","+L22RecursiveFunc.ArrayToString(arr, start+1);
		return msg;
	}
	
	//int[] nums2= {4,5,3,2,6,1};
	public static int searchMax(int[] arr, int end) { //재귀함수로 최대값 찾는 함수
		int max;
		if(end==1) {					//길이가 1이면 자기자신이 최대값
			System.out.println("배열 [0]의 값으로 초기값 설정: "+arr[0]);
			return arr[0];
		}else {
			max=searchMax(arr,end-1);	//길이가 1아니면 맥스 값을 구하라!
			//max에 값이 할당되거나 arr[0]을 반환
			//위에서 길이가 1이 아닌경우 max에 값이 할당되어 내려옴
			// 배열은 0부터 시작하므로 그 비교도 end-1에서 시작
			if(max<arr[end-1]) { 
				System.out.println("배열 ["+(end-1)+"]의 값으로 "+"최대값 변경: "+arr[end-1]);
				return arr[end-1]; 
			}else {
				System.out.println("배열 ["+(end-1)+"]의 값으로는 "+"변경 없음: "+arr[end-1]);
				return max;
			}
		}
		
	}
	
	//재귀함수로 선택 정렬
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
	
	
	
	///////////////내가 만든거/////////////////
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
//		int[] nums= {1,2,3,4,5,6}; //총합을 재귀함수로 구하세요.
//		int total=arraySum(nums,0);
//		System.out.println("최종 결과 total = "+total);
//		//기본 데이터 타입인 정수의 배열을 출력할 수 있는 문자열을 반환하는 문자열로 출력해주는 재귀함수를 만드세요.
//		
//		System.out.println("new ArrayUtil().toString(nums,0) : "+new ArrayUtil().toString(nums,0));
//		String msg=ArrayToString(nums,0);
//		System.out.println("nums="+msg);
		int[] nums2= {4,5,3,2,6,1};
		int max=searchMax(nums2,nums2.length);
		System.out.println("최대값 : "+max);
		
	}	
}
