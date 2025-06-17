import java.util.*;

public class TreeTest {
    public static void main(String[] args) {
        TreeMap<Computer, String> map = new TreeMap<>();

        System.out.println("== TreeMap (CPU 성능 기준 자동 정렬) ==");
        for (Map.Entry<Computer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey().getName() + " : " + entry.getValue());
        }
    }
}
