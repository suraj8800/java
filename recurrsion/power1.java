package recurrsion;

import java.util.Scanner;

public class power1 {
    public static void main(String[] args) {
       
        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        int x = scn.nextInt();
            
        int xpn = powerone(x, n);
        System.out.println(xpn);
    }

    public static int powerone(int x, int n){
        if(n == 0){
            return 1;
        }

        int xpnm1 = powerone(x, n-1);
        int xpn = xpnm1 * x;
        return xpn;
    }
}
