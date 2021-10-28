package recurrsion.recurrsion_with_aArrayList;

import java.io.*;
import java.util.*;

public class get_mazepath {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int rows = scn.nextInt();
        int cols = scn.nextInt();
        ArrayList<String> path = getMazePaths(1, 1, rows, cols);
        System.out.println(path);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr > dr || sc > dc){
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        } else if(sr == dr && sc == dc){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        ArrayList<String> mpaths = new ArrayList<>();
        ArrayList<String> hpaths = getMazePaths(sr, sc + 1, dr, dc);
        ArrayList<String> vpaths = getMazePaths(sr+1, sc, dr, dc);

        for(String hpath: hpaths){
            mpaths.add("h" + hpath);
        }

        for(String vpath: vpaths){
            mpaths.add("v"+ vpath);
        }
        return mpaths;
    }

}