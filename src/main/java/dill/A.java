package dill;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @User krisjin
 * @date 2020/9/11
 */
public class A {

    public static int sayNumber(int n) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                map.put(i, 1);
            } else {
                map.put(i, 0);
            }
        }
        int result = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result = entry.getKey();
            }
        }
        return result;
    }


    public static void test() {

        User u1 = new User();
        u1.setAge(11);
        u1.setName("zhang");
        u1.setDt("2021-12-11");


        User u2 = new User();
        u2.setAge(11);
        u2.setName("zhang");
        u2.setDt("2021-12-10");


        User u3 = new User();
        u3.setAge(11);
        u3.setName("li");
        u3.setDt("2021-12-03");

        User u4 = new User();
        u4.setAge(11);
        u4.setName("li");
        u4.setDt("2021-12-19");

        List<User> userList = new ArrayList<>();

        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        userList.add(u4);


        userList.sort(Comparator.comparing(User::getDt));

        System.err.println(userList.size());

//        Map<String, List<User>> aa = userList.stream().collect(Collectors.groupingBy(User::getName));
//
//        aa.forEach((k,v) ->{
//            System.err.println(k);
//
//        });

    }

    public static class User {
        private String name;
        private Integer age;
        private String dt;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getDt() {
            return dt;
        }

        public void setDt(String dt) {
            this.dt = dt;
        }
    }


    public static void main(String[] args) {
test();
    }



}
