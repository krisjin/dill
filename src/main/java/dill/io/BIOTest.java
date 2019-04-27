package dill.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <pre>
 *    处理读写服务
 *    同步阻塞IO，读写阻塞，线程等待时间过长
 *
 *    在制定线程策略的时候，只能根据CPU的数目来限定可用线程资源，不能根据连接并发数目来制定，也就是连接有限制。否则很难保证对客户端请求的高效和公平。
 *
 *    多线程之间的上下文切换，造成线程使用效率并不高，并且不易扩展
 *
 *    状态数据以及其他需要保持一致的数据，需要采用并发同步控制
 *    </pre>
 * User:krisjin
 * Date:2019/4/24
 */
public class BIOTest {


    // 主线程维护连接
    public void run() {
        ServerSocket serverSocket = null;
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try {
            serverSocket = new ServerSocket(8989, 512);

            while (true) {
                Socket socket = serverSocket.accept();
                //提交线程池处理
                executorService.submit(new Handler(socket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    static class Handler implements Runnable {

        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                //获取Socket的输入流，接收数据
                BufferedReader buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String readData = buf.readLine();
                while (readData != null) {
                    readData = buf.readLine();
                    System.out.println(readData);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
