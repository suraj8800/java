package recurrsion.recursion_on_the_way;

import java.io.*;
import java.util.*;

public class printencoding {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        printEncoding(str, "");
    }

    public  static void printEncoding(String str, String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0);
        if(ch == '0'){
            return;
        }
        int num = ch - '0';
        char chtobeadded = (char)('a'+ num - 1);
        printEncoding(str.substring(1), ans+chtobeadded);

        if(str.length() > 1){
            char ch2 = str.charAt(1);
            int num2 = ch2 - '0';
            int fnum = num * 10 + num2;
            if(fnum <=26){
                char ch2tobeadded = (char)('a'+fnum -1);
                printEncoding(str.substring(2), ans+ch2tobeadded);

            }

        }

    }
}
