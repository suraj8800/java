package Time_space_and_complexity;

import java.sql.Blob;
import java.util.Scanner;

public class mergesort {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }

        arr = mergeSort(arr, 0, arr.length-1);

        for(int val:arr){
            System.out.print(val+" ");
        }
        System.out.println(".");
    }

    public static int[] mergeSort(int[] arr, int lo, int hi){
        if(lo == hi){
            int[] ba = new int[1];
            ba[0] = arr[lo];
            return ba;
        }
        int mid = (lo+hi)/2;
        int[] fsh = mergeSort(arr, lo, mid);
        int[] ssh = mergeSort(arr, mid+1, hi);
        int[] fsa = merge2sortedarray(fsh, ssh);
        return fsa;
    }

    public static int[] merge2sortedarray(int[] a, int[] b){
        int[] ans = new int[a.length + b.length];
        int i =0; 
        int j =0;
        int k = 0;
        while(i< a.length && j < b.length){
            if(a[i] < b[j]){
                ans[k] = a[i];
                i++;
                k++;
            }else if(a[i] > b[j]){
                ans[k] = b[j];
                j++;
                k++;
            }
        }

        if(i==a.length){
            while(j<b.length){
                ans[k] = b[j];
                j++;
                k++;
            }
        }else{
            while(i < a.length){
                ans[k] = a[i];
                i++;
                k++;
            }
        }
        return ans;
    }
}
