package com.citi.tds.dna.consumer.externalenricher.qps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
//for finding the longest increasing and decreasing subsequence//
public class LIS {

	 public static int lis(int []arr,int n)
	 {
		 int lis[]=new int[n];
		 int max=0;
		for(int i=0;i<n;i++)
			lis[i]=1;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<=i;j++)
			{
				if(arr[i]>arr[j] && lis[i]<lis[j]+1)
					lis[i]=lis[j]+1;
			}
		}
		for(int i=0;i<n;i++)
		{
			if(lis[i]>max)
				max=lis[i];
		}
		printLIS(lis,arr,n);
		return max;
	 }
	 public static void printLIS(int []lis,int []arr,int n)
	 {
		 Map<Integer,Integer> map =new TreeMap<Integer,Integer>();
		 List<Integer> al=new ArrayList<Integer>();
		 for(int i=0;i<n;i++)
		 {
			 if(map.containsKey(lis[i])==false)
			 {
              		map.put(lis[i],i);	
              		al.add(arr[i]);
			 }
		 }
		 Collections.sort(al);
		 System.out.println(al);
		 
		 
	 }
	 public static void printLID(int []lid,int []arr,int n)
	 {
		 Map<Integer,Integer> map =new TreeMap<Integer,Integer>();
		 List<Integer> al=new ArrayList<Integer>();
		 for(int i=0;i<n;i++)
		 {
			 if(map.containsKey(lid[i])==false)
			 {
              		map.put(lid[i],i);	
              		al.add(arr[i]);
			 }
		 }
		 Collections.sort(al,new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
			 
		 });
		 System.out.println(al); 
	 }
	 public static int lid(int arr[],int n)
	 {
		 int lid[]=new int[n];
		 for(int i=0;i<n;i++)
			 lid[i]=1;
		 int max=0;
		 for(int i=n-1;i>=0;i--)
		 {
			 for(int j=n-1;j>=i;j--)
			 {
				 if(arr[i]>arr[j] && lid[i]<lid[j]+1)
					 lid[i]=lid[j]+1;
			 }
		 }
		 for(int i=0;i<n;i++)
			{
				if(lid[i]>max)
					max=lid[i];
			}
		 printLID(lid,arr,n);
		 return max;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int[] arr={3,10,2,11};
     int []arr1={12,10,9,10,12};
    // System.out.println(lis(arr,4));
     System.out.println(lid(arr1,5));
	}

}
