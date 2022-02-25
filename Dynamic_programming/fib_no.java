package Dynamic_programming;

import java.util.Scanner;

public class fib_no {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int fn = fib_mem_dp(n, new int[n+1]);
        System.out.println(fn);
    }

    static int fib_mem_dp(int n, int[] strg){
        
        if(n == 0 || n == 1){
            return n;
        }

        if(strg[n] != 0){
            return strg[n];
        }

        int fnm1 = fib_mem_dp(n-1, strg);
        int fnm2 = fib_mem_dp(n-2, strg);
        int fn = fnm1 + fnm2;

        strg[n] = fn;
        return fn;
    }
}
