package string;
import java.io.*;
import java.util.*;
public class IntroToArray {
    public static void main(String[] args) throws Exception{
        ArrayList<Integer> list; //declare
        list = new ArrayList<>(); // define
        System.out.println(list.size()+ " -> " + list);

        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list.size() + " -> "+ list);

        list.set(1, 200); // changes the value, does not add new value
        System.out.println(list.size() + " -> "+ list);

        list.add(1, 2000); // adds new value is different from set
        System.out.println(list.size() + " -> "+ list);

        int val = list.get(1);
        System.out.println(val); // will get 2000 (list[1] does not work)
        System.out.println(list.size() + " -> "+ list);

        list.remove(1); // delete the value at index 1
        System.out.println(list.size() + " -> "+ list);

        for(int i=0; i<list.size(); i++){
            int val1 = list.get(i);
            System.out.println(val1);
        }

        for(int val2: list){
            System.out.println(val2);
        }

    }
}
