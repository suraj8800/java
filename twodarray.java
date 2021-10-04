import java.util.*;

public class twodarray{
    public static void main(String[] args) {
       int[][] arr = new int[3][4];
       
       arr[0][0] = 11;
       arr[0][1] = 12;
       arr[0][2] = 13;
       arr[0][3] = 14;

       arr[1][0] = 21;
       arr[1][1] = 22;
       arr[1][2] = 23;
       arr[1][3] = 24;

       arr[2][0] = 31;
       arr[2][1] = 32;
       arr[2][2] = 33;
       arr[2][3] = 34;

       for(int i =0; i<arr.length; i++){
           for(int j=0; j<arr[0].length; j++){
               System.out.print(arr[i][j]+ "\t");
           }
           System.out.println();
       }
    }
}