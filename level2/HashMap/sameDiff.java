package level2.HashMap;

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scn = new Scanner(System.in);
            int t = scn.nextInt();
            for(int j =0; j<t; j++){
                int n = scn.nextInt();
                int[] arr = new int[n];
                for(int i=0; i<arr.length;i++){
                    arr[i] = scn.nextInt();
                }
                HashMap<Integer, Integer> map = new HashMap<>();
                for(int i=0; i<arr.length; i++){
                    int diff = arr[i] - i;
                    map.put(diff, map.getOrDefault(diff, 0) + 1);
                }
                
                long ans = 0;
                for(int key: map.keySet()){
                    long frq = (long)map.get(key);
                    long val = (frq * (frq -1)/2);
                    ans+= val;
                }
                System.out.println(ans);
            }
	}
}
