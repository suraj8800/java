package recurrsion.recurrsion_in_array;

import java.io.*;
import java.util.*;

public class displayArr {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i =0; i< arr.length; i++){
            arr[i] = scn.nextInt();
        }
        displayArray(arr, 0);
    }
    
    public static void displayArray(int[] arr, int idx){
        if(idx == arr.length){
            return;
        }
        System.out.println(arr[idx]);
        displayArray(arr, idx+1);
    }

}


