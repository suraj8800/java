package recurrsion.recurrsion_with_aArrayList;

import java.io.*;
import java.util.*;

public class get_subsequence {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        ArrayList<String> ss = gss(str);
        System.out.println(ss);
    }

    public static ArrayList<String> gss(String str) {
        if(str.length() == 0){
            ArrayList<String> bres = new ArrayList<>();
            String theSS = "";
            bres.add(theSS);
            return bres;
        }

        char ch = str.charAt(0); // abc -> a
        String ros = str.substring(1); // abc -> bc

        ArrayList<String> rres = gss(ros); // ros = [.., .c, bc]
        ArrayList<String> mres = new ArrayList<>();

        for(String rstr: rres){
            mres.add(rstr);
        }

        for(String rstr: rres){
            mres.add(ch + rstr);
        }
        return mres;
    }

}
