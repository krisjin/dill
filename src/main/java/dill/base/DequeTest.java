package dill.base;

import java.util.LinkedList;

/**
 * @author krisjin
 * @date 2020/12/21
 */
public class DequeTest {

    public static void main(String[] args) {

        LinkedList deque = new LinkedList<>();

        deque.push(1);
        deque.push(2);

        System.err.println(deque.pop());
        System.err.println(deque.pop());
    }
}
