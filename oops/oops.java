package oops;

public class oops {
    public static class student{
        int age;
        String name;
        void announceyourself(){
            System.out.println(this.name + "[" + this.age + "]");
        }
    }

    public static void swap1(student s1, student s2){
        student temp = s1;
        s1 = s2;
        s2 = temp;
    }

    public static void swap2(student s1, student s2){
        int tage = s1.age;
        s1.age = s2.age;
        s2.age = tage;

        s2 = new student();
        
        String tname = s1.name;
        s1.name = s2.name;
        s2.name = tname;
        s1 = new student();
    }

    public static void main(String[] args) {
        student s1;
        s1 = new student();
        s1.age = 40;
        s1.name = "A";
        
        student s2 = new student();
        s2.age = 30;
        s2.name = "B";

        s1.announceyourself();
        s2.announceyourself();
        //swap(s1, s2);
        swap2(s1, s2);
        s1.announceyourself();
        s2.announceyourself();

        // student s3 = s2;
        // s3.age =20;
        // s3.name = "C";
        // s3.announceyourself();
        // s2.announceyourself();
    }
}
