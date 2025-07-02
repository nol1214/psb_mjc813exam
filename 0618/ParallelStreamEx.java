import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamEx {
    /*public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        //병렬 처리
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
    }*/
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Product product = new Product(i, "상품"+i, "멋진회사",(int)
                    (10000*Math.random()));
            list.add(product);
        }
        Stream<Product> stream = list.stream();
        stream.forEach(System.out::println);
    }
}
