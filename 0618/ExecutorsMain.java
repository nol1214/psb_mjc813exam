import java.util.concurrent.*;

public class ExecutorsMain {
    public static void main(String[] args) {
        Long ms = System.currentTimeMillis();
        ExecutorService es = Executors.newFixedThreadPool(5);

        for ( int i = 1; i <= 100000; i++ ) {
            final int idx = i;
            Future<Long> future = es.submit(new Callable<Long>() {
                @Override
                public Long call() throws Exception {
                    Long sum = 0L;
                    for ( int j = 1; j <= idx; j++ ) {
                        sum += j;
                    }
//                    System.out.printf("[%s] 1~%d = %d\n"
//                            , Thread.currentThread().getName()
//                            , idx
//                            , sum
//                    );
                    return sum;
                }
            });

            Long result = 0L;
            try {
                result = future.get();
                //System.out.printf("result = %d\n", result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        es.shutdown();
        ms = System.currentTimeMillis() - ms;
        System.out.printf("totalMills = %d\n", ms);
    }
}
