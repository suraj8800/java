package Time_space_and_complexity;


import java.io.*;
import java.util.*;

public class radix_sort {

  public static void radixSort(int[] arr) {
    // write code here
    int max = arr[0];
    for(int i=0; i<arr.length; i++){
        if(arr[i]> max){
            max = arr[i];
        }
    }
    
    int place = 1;
    while(max/place > 0){
        countSort(arr, place);
        place = place *10;
    }
  }

  public static void countSort(int[] arr, int place) {
    // write code here

    // create frequency ans answer array
    int[] farr = new int[10]; // arr size is 10,  because the range is(0-9)
    int[] ans = new int[arr.length];

    //collecting the frequencies
    for(int i=0; i<arr.length; i++){
        int value = arr[i]/place % 10;
        farr[value]++;
    }

    // convert freq into psa.
    for(int i=1; i<farr.length; i++){
        farr[i] += farr[i-1];
    }

    // fill the ans
    for(int i=arr.length-1; i>=0; i--){
        int value = arr[i]/place % 10;
        int position = farr[value];
        ans[position-1] = arr[i];
        farr[value]--;
    }

    // fill  the original array
    for(int i=0; i<arr.length; i++){
        arr[i] = ans[i];
    }
    System.out.print("After sorting on " + place + " place -> ");
    print(arr);
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    radixSort(arr);
    print(arr);
  }

}
