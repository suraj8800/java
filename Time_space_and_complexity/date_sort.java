package Time_space_and_complexity;

import java.io.*;
import java.util.*;

public class date_sort {

  public static void sortDates(String[] arr) {
    // write your code here
    //dates
    countSort(arr, 1000000, 100, 32);

    // month
    countSort(arr, 10000, 100, 13);

    // years
    countSort(arr, 1, 10000, 2051);
  }

  public static void countSort(String[] arr,int div, int mod, int range) {
    // write your code here
    int[] farr = new int[range];
    String[] ans = new String[arr.length];

    // collecting the frequencies
    for(int i=0; i< farr.length; i++){
        int val = Integer.parseInt(arr[i]) / div % mod;
        farr[val]++;
    }

    // convert the farr into psa(prefix sum array)
    for(int i=1; i<farr.length; i++){
        farr[i] += farr[i-1];
    }

    // fill the answer array
    for(int i= arr.length-1; i>=0; i--){
        int val = Integer.parseInt(arr[i])/div % mod;
        int pos = farr[val];
        ans[pos-1] = arr[i];
        farr[val]--;
    }

    // fill the original array
    for(int i=0; i<arr.length; i++){
        arr[i] = ans[i];
    }
  }

  public static void print(String[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      String str = scn.next();
      arr[i] = str;
    }
    sortDates(arr);
    print(arr);
  }

}
