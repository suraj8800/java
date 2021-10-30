package recurrsion.recursion_on_the_way;

import java.io.*;
import java.util.*;

public class getss {

  public static void main(String[] args) throws Exception {
      Scanner scn = new Scanner(System.in);
      String st = scn.nextLine();
      printSS(st, "");
  }

  public static void printSS(String str, String ans) {
      if(str.length() == 0){
          System.out.println(ans);
          return;
      }

      char ch = str.charAt(0);
      str = str.substring(1);
      printSS(str, ans+ch);
      printSS(str, ans);
  }

}
