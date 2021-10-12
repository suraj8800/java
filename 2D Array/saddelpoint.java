import java.io.*;
import java.util.*;

public class saddelpoint {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int min = arr[i][0];
            int psj = 0;
            for (int j = 1; j < arr[0].length; j++) {
                if (arr[i][j] < min) {
                    min = arr[i][j];
                    psj = j;
                }
            }

            boolean issaddel = true;
            for (int ii = 0; ii < arr.length; ii++) {
                if (arr[ii][psj] > min) {
                    issaddel = false;
                    break;
                }
            }

            if(issaddel == true){
                System.out.println(min);
                return;
            }
        }
        System.out.println("Invalid input");
    }
}
