public class NoInterfaceThread {
    public static void main(String[] args) {
        int multiple = 7; // 예: 7의 배수 출력

        Thread thread = new Thread(() -> {
            for (int i = 1; i <= 100000; i++) {
                if (i % multiple == 0) {
                    System.out.println(i);
                }
            }
        });

        thread.start();
    }
}
