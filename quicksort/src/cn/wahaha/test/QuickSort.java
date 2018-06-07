package cn.wahaha.test;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;

public class QuickSort {
	@Test
	public void test1(){
		Scanner s=new Scanner(System.in);
		Random r=new Random();
		int[] arr=new int[15];
		for(int i=0;i<arr.length;i++){
			arr[i]=r.nextInt(500);
		}
		printArr(arr);
		quickSort(arr,0,arr.length-1);
		printArr(arr);
		int nextInt = s.nextInt();
		int num = binarySearch(arr,nextInt,0,arr.length-1);
		System.out.println(num);
	}
	public void printArr(int[] arr){
		System.out.print("[");
		for (int i = 0; i < arr.length; i++){
			if(i==arr.length-1){
				System.out.print(arr[i]);
			}else{
				System.out.print(arr[i]+",");
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
		quickSort(arr,i+1,right);
		quickSort(arr,left,i-1);
	}
	public int binarySearch(int[] arr,int num,int left,int right){
		if(left>=right){
			return -1;
		}
		int index=(right+left)/2;
		if(num==arr[index]){
			return index;
		}
		if(num==arr[left]){
			return left;
		}
		if(num==arr[right]){
			return right;
		}
		if(num>arr[index]){
			return binarySearch(arr,num,index+1,right);
		}else{
			
			return binarySearch(arr,num,left,index-1);
		}
	}
}
