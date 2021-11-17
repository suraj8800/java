package Time_space_and_complexity;

import java.util.Arrays;
import java.util.Scanner;

public class checkduplicate {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }

        Arrays.sort(arr);
        
        int dup = -1;
        for(int i=0; i<= arr.length; i++){
            if(arr[i] == arr[i+1]){
                dup =arr[i];
                break;
            }
        }
        
        System.out.println(dup);
    }
}
