import java.util.Scanner;

public class Chapter0407 {
    public static void main(String[] args) {
        boolean run = true;
        int bal = 0;
        Scanner scanner = new Scanner(System.in);

        while (run) {
            System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
            int n = scanner.nextInt();
            int money = 0;

            if(n == 1){
                System.out.println("예금액 > ");
                money = scanner.nextInt();
                bal += money;
            } else if (n == 2){
                System.out.println("출금액 > ");
                money = scanner.nextInt();
                bal -= money;
            } else if (n == 3){
                System.out.println("잔고 > "+ bal);
            }else {
                run = false;
            }

        }

        System.out.println("종료");

    }

}
