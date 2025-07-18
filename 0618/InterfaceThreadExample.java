interface MultiplePrinter {
    void print(int number);
}

class MultiplesThread extends Thread {
    private int multiple;
    private MultiplePrinter printer;

    public MultiplesThread(int multiple, MultiplePrinter printer) {
        this.multiple = multiple;
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100000; i++) {
            if (i % multiple == 0) {
                printer.print(i);
            }
        }
    }
}

public class InterfaceThreadExample {
    public static void main(String[] args) {
        int multiple = 7;

        MultiplePrinter printer = (n) -> System.out.println(n);

        Thread thread = new MultiplesThread(multiple, printer);
        thread.start();
    }
}