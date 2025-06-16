package test02.src;
import java.lang.reflect.Member;

public class ch1208 { 
    public static void main(String[] args) {
        Member m = new Member("winter","눈송이",25);
        System.out.println(m.id());
        System.out.println(m.nam1e());
        System.out.println(m.age());
        System.out.println(m.toString());
        System.out.println();

        Member m1 = new Member("winter","눈송이",25);
        Member m2 = new Member("winter","눈송이",25);
        System.out.println("m1.hashCode() = " + m1.hashCode());
        System.out.println("m2.hashCode() = " + m2.hashCode());
        System.out.println(m1.equals(m2));

    }
}
