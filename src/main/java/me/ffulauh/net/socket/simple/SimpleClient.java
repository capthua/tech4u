package me.ffulauh.net.socket.simple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SimpleClient {
    public static void main(String[] args) throws Exception{
        Socket socket=new Socket("localhost",8024);
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()),1);
        String response;
        for(int i=0;i<100;i++){
            out.println(new BufferedReader(new InputStreamReader(System.in)).readLine());
            response=in.readLine();
            System.out.println(response);
            TimeUnit.SECONDS.sleep(2);
        }

    }
}
