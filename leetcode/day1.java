package leetcode;

import java.util.*;
public class day1{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int tar = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }
        
        Arrays.sort(arr);
        
        for(int i=0; i<arr.length; i++){
            int ntar =tar - arr[i];
            
            int left = i+1;
            int right = arr.length-1;
            while(left<=right){
                int mid = (left+right)/2;
                if(ntar<arr[mid]){
                    right = mid -1;
                } else if(ntar>arr[mid]){
                    left = mid+1;
                } else{
                    System.out.println(arr[i]+" "+arr[mid]);
                    break;
                }
            }
            
        }
    }
}