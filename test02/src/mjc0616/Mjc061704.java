package mjc0616;
import java.util.List;
import java.util.Arrays;


public class Mjc061704 {
    public interface INumberProc {
        public void process(String str, Integer age);
    }

    public class LambdaExample {

        public static void printHuman(INumberProc inp) {
            String name = "홍길동";
            Integer age = 25;
            inp.process(name, age);
        }

        public static void main(String[] args) {
            printHuman((str, age) -> {
                System.out.printf("%s 님의 나이는 %d 입니다.\n", str, age);
            });
        }
    }

    public class LambdaExample2 {
        public static void printCar(INumberProc inp) {
            String carName = "소나타";
            Integer year = 2025;
            inp.process(carName, year);
        }

        public static void main(String[] args) {
            printCar((str, age) -> {
                System.out.printf("자동차 %s 의 년식은 %d 입니다.\n", str, age);
            });
        }
    }


    public interface IArrayProc {
        public Long process(List<Integer> list);
    }
    public class LambdaExample3 {

            public static void sum() {
                List<Integer> list = Arrays.asList(10, 20, 30, 40);

                IArrayProc sumProc = (nums) -> {
                    long sum = 0;
                    for (int n : nums) {
                        sum += n;
                    }
                    return sum;
                };

                Long sum = sumProc.process(list);
                System.out.printf("합은 {%d}\n", sum);
            }

            public static void main(String[] args) {
                sum();
            }
        }
        public class LambdaExample4 {
            public static void avg() {
                List<Integer> list = Arrays.asList(10, 20, 30, 40);

                IArrayProc avgProc = (nums) -> {
                    long sum = 0;
                    for (int n : nums) {
                        sum += n;
                    }
                    return sum / nums.size();
                };

                Long avg = avgProc.process(list);
                System.out.printf("평균은 {%d}\n", avg);
            }

            public static void main(String[] args) {
                avg();
            }
    }
}
