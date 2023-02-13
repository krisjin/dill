package dill.base;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author kris
 * @date 2023/2/9
 */
public class IntStreamSample {


    public static void main(String[] args) {

//        initIntStream();

        sumList();

    }


    public static void initIntStream() {

        //1. 生成一个无限流，传入一个IntSupplier函数式接口实例
        IntStream intStream = IntStream.generate(() -> {
            return (int) (Math.random() * 10);
        });
        intStream.limit(3).forEach(System.out::print);
        System.out.println("--------------------------");

        //2.产生指定区间的有序IntStream，这里需要传入一个区间（左闭右开），产生的元素不包含最后一个
        IntStream.range(0, 10).forEach(System.out::print);
        System.out.println("--------------------------");

        //3.产生指定区间的有序IntStream，与IntStream.range()不同的是，产生的元素包含最后一个，即左闭右闭
        IntStream.rangeClosed(0, 3).forEach(System.out::print);
        System.out.println("--------------------------");

        //4.IntStream.of()填充一个或多个int元素构造流
        IntStream.of(1, 2).forEach(System.out::print);


    }

    public static void sumList() {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person(11));
        personList.add(new Person(22));
        Integer num = personList.stream().map(Person::getAge).reduce(0, (a, b) -> a + b);

        System.err.println(num);


    }

    static class Person {

        private int age;

        public Person(int age) {
            this.age = age;
        }


        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

}
