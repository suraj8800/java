package recurrsion.recursion_on_the_way;

import java.util.Scanner;

public class getmpWjump {
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int dr = scn.nextInt();
        int dc = scn.nextInt();
        printMazepathwithjump(0, 0, dr-1, dc-1,"");
    }
    public static void printMazepathwithjump(int sr, int sc, int dr, int dc, String psf){
        if(sr> dr || sc> dc){
            return;
        }

        if(sr == dr && sc == dc){
            System.out.println(psf);
            return;
        }

        // horizontal move
        for(int jumps = 1; jumps <= dc-sc; jumps++){
            printMazepathwithjump(sr, sc+jumps, dr, dc, psf+"h"+jumps);
        }

        // vertical move
        for(int jumps=1; jumps<= dr-sr; jumps++){
            printMazepathwithjump(sr+jumps, sc, dr, dc, psf+"v"+jumps);
        }

        // digonal move
        for(int jumps=1; jumps<=Math.min(dc-sc, dr-sr); jumps++){
            printMazepathwithjump(sr+jumps, sc+jumps, dr, dc, 
            psf+"d"+jumps);
        }
    }
}
