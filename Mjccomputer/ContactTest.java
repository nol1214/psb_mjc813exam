import java.util.Arrays;

public class ContactTest {
    public static void main(String[] args) {
        Contact[] contacts = {
                new Contact("홍길동", "010-1234-5678", 21),
                new Contact("김민지", "010-2345-6789", 24),
                new Contact("이수현", "010-3456-7890", 27),
                new Contact("정재훈", "010-4567-8901", 23),
                new Contact("박하늘", "010-5678-9012", 26)
        };

        double averageAge = Arrays.stream(contacts)
                .mapToInt(Contact::getAge)
                .average()
                .orElse(0);

        System.out.printf("평균 나이: %.1f세\n", averageAge);
    }
}
