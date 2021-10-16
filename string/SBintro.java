package string;

public class SBintro {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        
        char ch = sb.charAt(0);
        System.out.println(ch);

        sb.setCharAt(0, 'b');
        System.out.println(sb);

        sb.deleteCharAt(0);
        System.out.println(sb);

        sb.insert(0, 't');
        System.out.println(sb);
    }
}
