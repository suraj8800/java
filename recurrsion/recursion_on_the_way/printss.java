package recurrsion.recursion_on_the_way;

import java.util.ArrayList;
import java.util.Scanner;

public class printss {
    public static void main(String[] args) {
        Scanner  scn = new Scanner(System.in);
        String str = scn.nextLine();
        pss(str, "");
    }
    public static void pss(String ques, String asf ){
        if(ques.length()==0){
            System.out.println(asf);
            return;
        }

        char ch = ques.charAt(0);
        String roq = ques.substring(1);
        pss(roq, asf + ch);
        pss(roq, asf);
    }
}
