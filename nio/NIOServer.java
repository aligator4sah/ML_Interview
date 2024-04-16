package nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;


public class NIOServer extends Thread{
    public void run() {
        try (Selector selector = Selector.open();
        ServerSocketChannel serverSocket = ServerSocketChannel.open(); ) {
            serverSocket.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
            serverSocket.configureBlocking(false);
            // register to Selector, 
            serverSocket.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                selector.select(); // block and wait for the channels which are ready
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> iter = selectedKeys.iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    // check ready status in production
                    sayHelloWorld((ServerSocketChannel)key.channel());
                    iter.remove();
                }
            }

            
        } catch (IOException e) {
            e.printStackTrace();
        }
        // AsynchronousServerSocketChannel serverSock = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(888));
        // serverSock.accept(serverSock, new CompletionHandler<>() {
        //     @Override
        //     public void completed() {
        //         serverSock.accept(serverSock, this);
        //         sayHelloWorld(sockChannel, Charset.defaultCharset().encode("Hello World!"));
        //     }
        // });
       
    }

    private void sayHelloWorld(ServerSocketChannel server) throws IOException {
        try (SocketChannel client = server.accept();) {
            client.write(Charset.defaultCharset().encode("Hello World"));
        }
    }
}
