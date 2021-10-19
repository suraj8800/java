package recurrsion;
import java.io.*;
import java.util.*;

public class factorial {
    public static void main(String[] args) {
        Scanner scn = new  Scanner(System.in);
        int n = scn.nextInt();
        int fn = Factorial(n);
        System.out.println(fn);
    }

    public static int Factorial(int n){
        if(n==0){
            return 1;
        }

        int fnm1 = Factorial(n-1);
        int fn = n * fnm1;

        return fn;
    }
}
