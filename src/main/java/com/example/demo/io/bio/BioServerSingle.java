package com.example.demo.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  高并发场景下 bio 阻塞频繁地创建线程，导致cpu资源不够用
 */
public class BioServerSingle {

    public static void main(String[] args) {

        int port = 8080;

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            serverSocket = new ServerSocket(port);

            while (true) {
                socket = serverSocket.accept(); // 阻塞状态 进行三次握手
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();

                int lenth = 0;
                byte[] req = new byte[1024];
                while ((lenth = inputStream.read(req)) > 0) {// 阻塞
                    System.out.println("req:"+ new String(req,lenth));

                    outputStream = socket.getOutputStream();
                    outputStream.write("res".getBytes());

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 释放
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (outputStream!= null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
