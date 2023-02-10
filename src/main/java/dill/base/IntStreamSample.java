package dill.base;

import java.util.stream.IntStream;

/**
 * @author kris
 * @date 2023/2/9
 */
public class IntStreamSample {


    public static void main(String[] args) {

        initIntStream();

    }


    public static void initIntStream() {

        //1. 生成一个无限流，传入一个IntSupplier函数式接口实例
        IntStream intStream = IntStream.generate(() -> {
            return (int) (Math.random() * 10);
        });
        intStream.limit(3).forEach(System.out::println);
        System.out.println("--------------------------");

        //2.IntStream.range()产生指定区间的有序IntStream，这里需要传入一个区间（左闭右开），产生的元素不包含最后一个
        IntStream.range(0, 10).forEach(System.out::println);

    }

}
