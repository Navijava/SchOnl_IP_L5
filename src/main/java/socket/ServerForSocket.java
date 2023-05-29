package socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ServerForSocket {

    public static void main(String [] arg){
        ServerForSocket soc1 = new ServerForSocket();
        soc1.createServer();
        System.out.println("Bye!");
    }
    void createServer(){

        try(ServerSocket serverSocket = new ServerSocket(57680);
            Socket socket = serverSocket.accept();
            Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)){
            System.out.println("Hello!");

            final InetAddress localAddress = socket.getInetAddress();
            final List<String> ipList = ReadMain.getText("src/socket/black.txt");
            boolean flag = true;
            for(String ip : ipList){
                if(ip.equals(localAddress.getHostAddress())){
                    System.out.println("IP was blocked.");
                    writer.write("stop");
                    writer.close();
                    flag = false;
                    break;
                }
            }
            if (flag) {
                writer.write("continue");
                writer.close();
                System.out.println("Everything is ok.");
            }
            String s;
            Scanner scannerMy = new Scanner(System.in);

            do {
                System.out.println("If you have IP for blacklist enter it, or write \"exit\""
                        + " to finish.");
                s = scannerMy.nextLine();
                if(s.equals("exit")){
                    break;
                }
                s = "\n" + s;
                WriteFiles.write1("black.txt", s);
                writer.flush();
                scannerMy = new Scanner(System.in);
            } while(true);

        }catch(IOException e){
            System.out.println("Something go wrong...");
        }
    }
}
