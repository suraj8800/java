package recurrsion.recursion_on_the_way;

import java.io.*;
import java.util.*;

public class getkpc {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        printKPC(str, "");
    }
    public static String[] arr = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    public static void printKPC(String str, String asf) {
        if(str.length() == 0){
            System.out.println(asf);
            return ;
        }

        char ch = str.charAt(0);
        str = str.substring(1);

        String tobeexpressed = arr[ch - '0'];
        for(int i=0; i<tobeexpressed.length(); i++){
            char choices = tobeexpressed.charAt(i);
            printKPC(str, asf+choices);
        }
    }

}
