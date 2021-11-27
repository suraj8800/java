package Time_space_and_complexity;

import java.util.Scanner;
import java.io.*;

public class quick_select {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();
        System.out.println(quickselect(arr, 0, arr.length-1, k-1));
    }

    public static void swap(int[] arr, int i, int j){
        System.out.println("Swapping "+ arr[i]+ " and " +arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int quickselect(int[] arr, int low, int high, int k){
        int pivot = arr[high];
        int pivotindex = partition(arr, low, high, pivot);
        if(k == pivotindex){
            return pivot;
        } else if(k > pivotindex){
            return quickselect(arr, pivotindex+1, high, k);
        } else {
            return quickselect(arr, low, pivotindex-1, k);
        }
    }

    public static int partition(int[] arr, int low, int high, int pivot){
        System.out.println("pivot -> "+ pivot);
        int i =low; 
        int j =low;
        while(i<=high){
            if(arr[i] > pivot){
                i++;
            } else{
                swap(arr, i, j);
                i++;
                j++;
            }
        }
        System.out.println("pivot index -> " + (j-1));
        return (j-1); 
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
          System.out.print(arr[i] + " ");
        }
        System.out.println();
      }
}
