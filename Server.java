package com.company;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Server {
    static Scanner inp = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Server activated");
        ServerSocket ss = null;
        Socket s = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter=null;
        OutputStreamWriter outputStreamWriter=null;
        InputStreamReader inputStreamReader = null;
        while (true) {
            ss = new ServerSocket(9999);
            s = ss.accept();
            System.out.println("Client connected");

            try {
                inputStreamReader = new InputStreamReader(s.getInputStream());
                bufferedReader = new BufferedReader(inputStreamReader);
                outputStreamWriter=new OutputStreamWriter(s.getOutputStream());
                bufferedWriter=new BufferedWriter(outputStreamWriter);

                while (true) {
                    String  s1=bufferedReader.readLine();
                    if(s1.equals("SEND")) {
                        String str = bufferedReader.readLine();
                        str=str.substring(1);
                        System.out.println("client:" + str);
                    }
                    else if(s1.equals("WHO")){
                        InetAddress inetAddress=InetAddress.getLocalHost();
                        bufferedWriter.write(String.valueOf(inetAddress));
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }



    }
}

