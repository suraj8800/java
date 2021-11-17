// sieve of eratosthenes
package Time_space_and_complexity;

import java.util.Scanner;

public class soe {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        boolean[] arr= new boolean[n+1];
        for(int i=2; i * i<arr.length; i++){
            if(arr[i]==false){
                for(int ja = i; i * ja < arr.length; ja++){
                    arr[i*ja] = true;
                }
            }
        }

        for(int i=2; i<arr.length;i++){
            if(arr[i]==false){
                System.out.println(i);
            }
        }
    }
}
