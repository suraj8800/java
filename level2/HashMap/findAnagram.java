package level2.HashMap;

import java.util.*;

public class findAnagram {
	public static void findAnagrams(String s, String p) {
        int[] m2 = new int[26];
        for(int i=0; i<p.length(); i++){
            char ch = p.charAt(i);
            m2[ch - 'a']++;
        }

        int[] m1 = new int[26];
        for(int i=0; i<p.length(); i++){
            char ch = s.charAt(i);
            m1[ch - 'a']++;
        }

        ArrayList<Integer> res = new ArrayList<>();
        if(areAngm(m1, m2) == true){
            res.add(0);
        }

        int i= p.length();
        int j =0;
        
        while(i <s.length()){
            char ci = s.charAt(i);
            m1[ci - 'a']++;

            char cj = s.charAt(j);
            m1[cj - 'a']--;

            if(areAngm(m1, m2) == true){
                res.add(j+1);
            }

            j++;
            i++;
        }
        System.out.println(res.size());
        for(int val:res){
            System.out.print(val + " ");
        }
	}
    
    public static boolean areAngm(int[] m1, int[]m2){
        for(int i=0; i<26; i++){
            if(m1[i] != m2[i]){
                return false;
            }
        }
        return true;
    }
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		String p = scn.next();
		findAnagrams(s, p);
	}

}

