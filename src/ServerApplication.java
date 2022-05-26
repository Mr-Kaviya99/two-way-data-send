import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApplication {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Waiting For A Client ... ");

        Socket socket = serverSocket.accept();
        System.out.println("Client Accepted ... ");

        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String data = bufferedReader.readLine();
        System.out.println("Client : " + data);

        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println("Hello Client...");
        printWriter.flush();

        serverSocket.close();
        socket.close();
        inputStreamReader.close();
        bufferedReader.close();
        printWriter.close();
    }
}
