package dill.io;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * <pre>
 *
 * 这是最基本的单Reactor单线程模型。其中Reactor线程，负责多路分离套接字，有新连接到来触发connect 事件之后，
 * 交由Acceptor进行处理，有IO读写事件之后交给hanlder 处理。
 *
 * Acceptor主要任务就是构建handler ，在获取到和client相关的SocketChannel之后 ，
 * 绑定到相应的hanlder上，对应的SocketChannel有读写事件之后，基于racotor 分发,hanlder就可以处理了（所有的IO事件都绑定到selector上，有Reactor分发）。
 *
 * 该模型 适用于处理器链中业务处理组件能快速完成的场景。不过，这种单线程模型不能充分利用多核资源，所以实际使用的不多。
 * </pre>
 */
public class ReactorTest {


    ServerSocketChannel ssc;
    Selector selector;

    class Reactor implements Runnable {
        private Reactor() throws Exception {
            SelectionKey sk =
                    ssc.register(selector,
                            SelectionKey.OP_ACCEPT);
            // attach Acceptor 处理新连接
            sk.attach(new Acceptor());
        }

        public void run() {
            try {
                while (!Thread.interrupted()) {
                    selector.select();
                    Set selected = selector.selectedKeys();
                    Iterator it = selected.iterator();
                    while (it.hasNext()) {
                        it.remove();
                        //分发事件处理
                        dispatch((SelectionKey) (it.next()));
                    }
                }
            } catch (IOException ex) {
                //do something
            }
        }

        void dispatch(SelectionKey k) {
            // 若是连接事件获取是acceptor
            // 若是IO读写事件获取是handler
            Runnable runnable = (Runnable) (k.attachment());
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /**
     * 连接事件就绪,处理连接事件
     */
    class Acceptor implements Runnable {
        @Override
        public void run() {
            try {
                SocketChannel c = ssc.accept();
                if (c != null) {// 注册读写
//                    new Handler(c, selector);
                }
            } catch (Exception e) {
            }
        }
    }
}
