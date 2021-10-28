package recurrsion.recurrsion_with_aArrayList;

import java.io.*;
import java.util.*;

public class get_kpc {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        ArrayList<String> words = getKPC(str);
        System.out.println(words);
    }
    
    public static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    public static ArrayList<String> getKPC(String str) {
        if( str.length() == 0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        char ch = str.charAt(0); // 367 -> 3
        String ros = str.substring(1); // 367 ->  67
        ArrayList<String> rres = getKPC(ros); // all word of 67
        ArrayList<String> mres = new  ArrayList<>();

        String code = codes[ch-48]; // to convert the char into int
        for(int i=0; i<code.length(); i++){
            char chi = code.charAt(i);
            for(String rstr: rres){
                mres.add(chi + rstr);
            }
        }

        return mres;
    }

}