package com.company;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    static Scanner inp = new Scanner(System.in);

    public static String main(String x) throws IOException {
        OutputStreamWriter out = null;
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        BufferedWriter bufferedWriter = null;
        Socket socket = null;
        try {
            socket = new Socket("localhost", 9999);
            out = new OutputStreamWriter(socket.getOutputStream());
            bufferedWriter = new BufferedWriter(out);
            inputStreamReader = new InputStreamReader(socket.getInputStream());
            bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                String str = x;
                String string = "";
                if (x.contains("SEND")) {
                    bufferedWriter.write(str);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();                         
                    String s1 = inp.nextLine();
                    bufferedWriter.write(s1);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                   return s1;
                } else if (x.equals("WHO")) {
                    bufferedWriter.write(String.valueOf(x));
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    System.out.println("Server: ");
                    String a=bufferedReader.readLine();
                    return a;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return x;
    }


}
