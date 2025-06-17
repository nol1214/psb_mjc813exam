package mjc0616;

import java.util.HashSet;
import java.util.Set;

/*public class mjc061602 {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<Student>();

        set.add(new Student(1, "홍길동"));
        set.add(new Student(2, "신용권"));
        set.add(new Student(3, "조민우"));

        System.out.println("저장된 객체 수 :" + set.size());
        for (Student student : set) {
            System.out.println(student.Studentnum + ":" + student.name);
        }
    }
}

public class Student{
    public String name;
    public int Studentnum;

    pubilc Student (int Studnetnum, String name){
        this.Studentnum = Studnetnum;
        this.name = name;
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(Studentnum);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student other = (Student) obj;
        return this.Studentnum == other.Studentnum;
    }
*