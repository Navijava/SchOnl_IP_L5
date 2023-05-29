package socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocForServer {

    public static void main(String[] args) {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), 57680), 1000);
            Scanner scanner = new Scanner(socket.getInputStream());
            if(scanner.next().equals("stop")) {
                System.out.println("IP in blacklist. Get out of here!");
                System.exit(100);
            }
            Scanner scannIn = new Scanner(System.in);
            System.out.println("Welcome! Let's begin.");
            String str;
            do {
                System.out.println("You can write whatever you want. "
                        + "To finish write \"exit\".");
                str = scannIn.nextLine();
                if(str.equals("exit")){
                    break;
                }
                System.out.println("\nYou wrote:\n" + str + "\n");
                } while (true);
            System.out.println("Bye!");
        } catch (IOException e) {
            System.out.println("Something go wrong.");
        }
    }

}