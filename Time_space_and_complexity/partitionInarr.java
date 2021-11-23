package Time_space_and_complexity;

import java.io.*;
import java.util.*;

public class partitionInarr {

  public static void partition(int[] arr, int pivot){
    //write your code here
    // 3 regions
    // 1. 0 to j-1 -> lesser than pivot area.
    // 2. j - i-1 -> greater than pivot area.
    // 3. i - end -> unknown area.
    int i = 0;
    int j = 0;
    while(i < arr.length){
      if(arr[i] > pivot){
        i++;
      } else{
        swap(arr, i, j);
        i++;
        j++;
      }
    }
    
  }

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping " + arr[i] + " and " + arr[j]);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
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
    int pivot = scn.nextInt();
    partition(arr,pivot);
    print(arr);
  }

}
