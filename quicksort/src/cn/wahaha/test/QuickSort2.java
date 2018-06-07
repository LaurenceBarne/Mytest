package cn.wahaha.test;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class QuickSort2 {
	@Test
	public void test(){
		Random r=new Random();
		int[] arr=new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=r.nextInt(100);
		}
		pintln(arr);
		quickSort(arr,0,arr.length-1);
//		Arrays.sort(arr);
		System.out.println("排序后为");
		pintln(arr);
		
	}
	public void pintln(int[] arr){
		System.out.print("该数组为：arr:[");
		for (int i = 0; i < arr.length; i++) {
			
			if(i!=arr.length-1){
				System.out.print(arr[i]+",");
			}else{
				System.out.print(arr[i]);
			}
		}
		System.out.println("]");
	}
	public void quickSort(int[] arr,int left,int right){
		if(left>right){
			return;
		}
		int base=arr[left];
		int i=left;
		int j=right;
		while(i<j){
			while(arr[j]>=base&&i<j){
				j--;
			}
			while(arr[i]<=base&&i<j){
				i++;
			}
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
		arr[left]=arr[i];
		arr[i]=base;
		quickSort(arr,left,i-1);
		quickSort(arr,i+1,right);
	}
	
}
