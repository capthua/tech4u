package me.ffulauh.net.socket.simple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

    public static void main(String[] args)throws Exception {
        ServerSocket serverSocket=new ServerSocket(8024);
        Socket clientSocket=serverSocket.accept();
        BufferedReader in=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
        String request, response;
        int responseId=0;
        while ((request=in.readLine())!=null){
            if("done".equals(request)){
                break;
            } else {
                System.out.println("客户端请求: "+request);
            }
            out.println("我收到了"+request);
        }
    }

}
