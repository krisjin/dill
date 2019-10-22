package dill.base.question;

import java.util.HashMap;

/**
 * User:krisjin
 * Date:2019-10-22
 */
public class HashMapTest {


    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();


        map.put("xx", "xxx");


        String str = "x";
        int h;

        int code = (str == null) ? 0 : (h = str.hashCode()) ^ (h >>> 16);


        System.out.println(16 << 3);


    }
}
