package dill.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;


/**
 * 1. 简要概述，为什么需要buffer
 * NIO的buffer就是为了提升性能
 * User:krisjin
 * Date:2020-08-01
 */
public class BufferTest {

    public static void main(String[] args) {
        byteBufferTest();
    }

    /**
     * 创建buffer具体实现有哪些方式
     */
    public static void createBuffer() {
        byte[] buff = new byte[2];
        //使用allocate分配指定容量大小，大小设置完成后，就不能修改。
        ByteBuffer byteBuffer = ByteBuffer.allocate(6);

        //使用wrap包装器，传入一个初始化的字节数组
        ByteBuffer.wrap(buff);

        ByteBuffer.allocateDirect(3);

    }

    public static void byteBufferTest() {
        byte[] bytes = new byte[]{1, 2, 3, 4, 5};

        //创建缓冲区对象
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);

        println("初始操作：");
        println("position=" + byteBuffer.position());
        println("capacity=" + byteBuffer.capacity());
        println("limit=" + byteBuffer.limit());
        println("-------------------------------------------------------------------");


//        ByteBuffer byteBuffer = ByteBuffer.allocate(4);

        //put数据
        byteBuffer.put((byte) 1);
        byteBuffer.put((byte) 2);

        println("put数据：");
        println("position=" + byteBuffer.position());
        println("capacity=" + byteBuffer.capacity());
        println("limit=" + byteBuffer.limit());
        println("-------------------------------------------------------------------");

        println(byteBuffer.get(1));//我在这里读并不会报错
        //切换为读模式
        byteBuffer.flip();
        println("flip切换读：");
        println("position=" + byteBuffer.position());
        println("capacity=" + byteBuffer.capacity());
        println("limit=" + byteBuffer.limit());
        println("-------------------------------------------------------------------");

        //切换为写模式
        byteBuffer.clear();
        println("clear切换为写模式：");
        println("position=" + byteBuffer.position());
        println("capacity=" + byteBuffer.capacity());
        println("limit=" + byteBuffer.limit());
        println("-------------------------------------------------------------------");


        //重新put数据,并在index=2时 mark一下
        byteBuffer.put((byte) 1);
        byteBuffer.put((byte) 2);
        byteBuffer.mark();
        byteBuffer.limit(4);
        byteBuffer.put((byte) 3);
        byteBuffer.put((byte) 4);

        println("重新put数据,并在index=2时 mark一下,limit(4)：");
        println("position=" + byteBuffer.position());
        println("capacity=" + byteBuffer.capacity());
        println("limit=" + byteBuffer.limit());
        println("-------------------------------------------------------------------");

        //reset 从标记位置开始读
        byteBuffer.reset();
        println("reset buffer:");
        println("position=" + byteBuffer.position());
        println("capacity=" + byteBuffer.capacity());
        println("limit=" + byteBuffer.limit());
        println("-------------------------------------------------------------------");

        println("get()数据,这里连续取了两次值，在取值就报错了");
        println(byteBuffer.get());
        println(byteBuffer.get());
        println("-------------------------------------------------------------------");


        //rewind
        byteBuffer.rewind();
        println("rewind: 把position设为0,在读一遍");
        println("position=" + byteBuffer.position());
        println("capacity=" + byteBuffer.capacity());
        println("limit=" + byteBuffer.limit());
        println("-------------------------------------------------------------------");

    }

    private static void println(Object obj) {
        System.out.println(obj);
    }

}
