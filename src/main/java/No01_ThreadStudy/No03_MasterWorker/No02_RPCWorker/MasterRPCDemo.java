package No01_ThreadStudy.No03_MasterWorker.No02_RPCWorker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 */
@Service
public class MasterRPCDemo {

    @Autowired()
    @Qualifier("serverSocket")
    private static ServerSocket serverSocket;

    public static void startServerSocket() {


        while (true) {
            try (Socket socket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()))
            ) {
                String info = null;
                while ((info = in.readLine()) != null) {


                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}