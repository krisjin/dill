package dill.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;


/**
 * User:krisjin
 * Date:2020-08-01
 */
public class BufferTest {

    public static void main(String[] args) {
        byteBufferTest();
        limitTest();
    }

    public static void byteBufferTest() {
        println("----------------------- buffer crate start -----------------------");
        byte[] bytes = new byte[]{1, 2, 3, 4};
        //创建并为写模式，position就是写数据的位置操作
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
//        ByteBuffer byteBuffer = ByteBuffer.allocate(4);

        byteBuffer.put((byte)1);//必须要put数据

        String byteBufferName = byteBuffer.getClass().getName();
        println(byteBufferName);
        println("position=" + byteBuffer.position());
        println("capacity=" + byteBuffer.capacity());
        println("limit=" + byteBuffer.limit());
        println("----------------------- buffer crate  end ----------------------- \n");

        byteBuffer.flip();//flip切换为写模式
        println("-------------------------flip after------------------------------");
        println("position=" + byteBuffer.position());
        println("capacity=" + byteBuffer.capacity());
        println("limit=" + byteBuffer.limit());

        byte b = byteBuffer.get();
        println(b);
    }

    public static void limitTest() {
        println("----------------------- limit start -----------------------");
        char[] chars = new char[6];
        CharBuffer charBuffer = CharBuffer.allocate(6);
        println(charBuffer.getClass().getName());
//        CharBuffer charBuffer = CharBuffer.wrap(chars);


//        charBuffer.limit(3);

//        charBuffer.put('0');
        charBuffer.put(1, '1');
//        charBuffer.put(2, '2');
//        charBuffer.put(3, '3');
        println("T1 capacity=" + charBuffer.capacity() + ", limit=" + charBuffer.limit() + " ,position=" + charBuffer.position());
        charBuffer.flip();
        println("T2 capacity=" + charBuffer.capacity() + ", limit=" + charBuffer.limit() + " ,position=" + charBuffer.position());


        println("----------------------- limit end -----------------------");
    }


    private static void println(Object obj) {
        System.out.println(obj);
    }

}
