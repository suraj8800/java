package Time_space_and_complexity;

import java.util.Arrays;
import java.util.Scanner;

public class targetsumpairwithbinary {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tar = scn.nextInt();
        int n = scn.nextInt();
        int[] arr= new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }

        Arrays.sort(arr);

        for(int i=0;i<arr.length;i++){
            int ntar = tar - arr[i];
            if(ntar<arr[i]){
                break;
            }
            int left =0; 
            int right = arr.length-1;
            while(left<right){
                int mid = (left+right)/2;
                if(ntar <arr[mid]){
                    right = mid -1;
                } else if(ntar>arr[mid]){
                    left = mid+1;
                }else{
                    System.out.println(arr[i]+" "+arr[mid]);
                    break;
                }
            }
        }
    }
}
