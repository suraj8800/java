package Time_space_and_complexity;

import java.util.Scanner;

public class print_permutation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printPermutation(str, "");
    }

    public static void printPermutation(String str, String asf){
        if(str.length()==0){
            System.out.println(asf);
            return;
        }

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            String leftofch = str.substring(0, i);
            String rightofch = str.substring(i+1);
            String roq = leftofch + rightofch;
            printPermutation(roq, asf+ch);
        }
    }
}
