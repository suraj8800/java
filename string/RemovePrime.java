package string;
import java.io.*;
import java.util.*;
public class RemovePrime {

    public static boolean isprime(int num){
        boolean isprime = true;
        for(int div =2; div * div <= num; div++){
            if(num % div == 0){
                isprime = false;
                break;
            }
        }
        return isprime;
    }

    public static void solution(ArrayList<Integer> al){
        for(int i =al.size() -1; i>=0; i--){
            int val = al.get(i);
            boolean isThisPrime = isprime(val);
            if(isThisPrime == true){
                al.remove(i);
            }
        }
    }

    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 0 ; i < n; i++){
			al.add(scn.nextInt());
		}
		solution(al);
		System.out.println(al);
	}
}
