package dill.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;


/**
 * User:krisjin
 * Date:2020-08-01
 */
public class BufferDemo {

    public static void main(String[] args) {
        createBuffer();
        limitTest();
    }


    public static void createBuffer() {
        println("----------------------- buffer crate start -----------------------");
        byte[] bytes = new byte[]{1, 2, 3, 4};

        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);

        String byteBufferName = byteBuffer.getClass().getName();
        println(byteBufferName);
        println(byteBuffer.capacity() + "," + byteBuffer.position());
        println("----------------------- buffer crate  end ----------------------- \n");
    }

    public static void limitTest() {
        println("----------------------- limit start -----------------------");

        char[] chars = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j'};

        CharBuffer charBuffer = CharBuffer.wrap(chars);

        println("T1 capacity=" + charBuffer.capacity() + ", limit=" + charBuffer.limit() + " ,position=" + charBuffer.position());

        charBuffer.limit(3);

        println("T2 capacity=" + charBuffer.capacity() + ", limit=" + charBuffer.limit() + " ,position=" + charBuffer.position());
        charBuffer.put(0, '0');
        charBuffer.put(1, '1');
        charBuffer.put(2, '2');
        charBuffer.put(3, '3');

        println("----------------------- limit end -----------------------");
    }


    private static void println(Object obj) {
        System.out.println(obj);
    }

}
