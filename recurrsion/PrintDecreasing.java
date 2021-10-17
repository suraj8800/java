package recurrsion;
import java.io.*;
import java.util.*;
public class PrintDecreasing {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Printdec(n);
    }

    // Expection => pd(n) = n n-1 n-2 .. . . . 3 2 1
    // Faith => pd(n-1) = n-1 n-2 n-3 ..... 3 2 1
    // Expection with Faith => pd(n) = n pd(n-1)
    public static void Printdec(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        Printdec(n-1);
    }
}
