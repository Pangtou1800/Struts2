package pt.server;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(9000);
        Socket socket = server.accept();
        OutputStream os = socket.getOutputStream();
        FileInputStream fs = new FileInputStream("C:\\Users\\aband\\Desktop\\v2ray-windows-64\\config.json");

        byte[] buffer= new byte[1024];
        int len =0;
        while((len = fs.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
    }
}
