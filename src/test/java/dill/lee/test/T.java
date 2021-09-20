package dill.lee.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class T {
    public static void main(String[] args) {
        User u1 = new User("2021-06-04", 1);
        User u2 = new User("2021-06-05", 1);
        User u3 = new User("2021-06-06", 1);

        List<User> userList = new ArrayList<>();
        List<User> userList2 = new ArrayList<>();
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);

        userList2.add(new User("11", 11));
        userList.addAll(userList2);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date targetDt = null;
        try {
            targetDt = sdf.parse("2021-06-05");
            Iterator<User> userIterator = userList.iterator();
            while (userIterator.hasNext()) {
                User u = userIterator.next();
                Date date = sdf.parse(u.dt);
                if (date.getTime() < targetDt.getTime()) {
                    userIterator.remove();
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.err.println(userList.size());
    }

    static class User {
        public String dt;
        public Integer id;

        public User(String dt, Integer id) {
            this.dt = dt;
            this.id = id;
        }
    }
}
