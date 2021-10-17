package recurrsion;
import java.io.*;
import java.util.*;
public class printincreasing {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        PrintInc(n);
    }

    public static void PrintInc(int n){
        if(n == 0){
            return;
        }
        PrintInc(n-1);
        System.out.println(n);
    }
}
