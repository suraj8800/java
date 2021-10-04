import java.util.*;
public class wavedisplay {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();

        int[][] arr = new int[r][c];

        for(int i=0; i<arr.length; i++){
            for(int j =0; j<arr[0].length; j++){
                System.out.println(arr[i][j]);
            }
        }

        for(int j=0; j<arr[0].length; j++){
            if(j%2 == 0){
                for(int i=0; i<arr.length; i++){
                    System.out.println(arr[i][j]);
                }
            }else{
                for(int i=0; i<arr.length; i++){
                    System.out.println(arr[i][j]);
                }
            }
        }
    }
}
