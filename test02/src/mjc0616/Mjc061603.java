package mjc0616;

import java.util.Map;
import java.util.HashMap;

public class Mjc061603 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        String name = null;
        int maxScore = 0;
        int totalScore = 0;

        double average = (double) totalScore / map.size();

        System.out.println("평균: " + average);
        System.out.println("최고점수: " + maxScore);
        System.out.println("최고점수 받은 아이디: " + name);
    }
}
