package recurrsion.recurrsion_with_aArrayList;

import java.io.*;
import java.util.*;

public class get_subsequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        ArrayList<String> ss = gss(str);
        System.out.println(ss);
    }

    public static ArrayList<String> gss(String str){
        if(str.length() == 0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = str.charAt(0); // x
        String ros = str.substring(1); //yz
        ArrayList<String> rres = gss(ros);
        ArrayList<String> mres = new ArrayList<>();

        for(String rstr:rres){
            String mstr = rstr;
            mres.add(mstr);
        }

        for(String rstr: rres){
            String mstr = ch + rstr;
            mres.add(mstr);
        }
        return mres;
    }
}
