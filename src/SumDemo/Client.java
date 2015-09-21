/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SumDemo;

import java.io.*;
import java.net.*;

/**
 *
 * @author Admin
 */
public class Client {
    public static void main(String[] args) throws Exception{
        Socket clientSocket = new Socket("adminpc",6789);
//        Client Nhập Dữ liệu gửi về Server
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a,b;
        System.out.println("a = "); a = reader.readLine();
        System.out.println("b = "); b = reader.readLine();
        
//        Kết nối đến Server
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
//        Gửi dữ liệu đến Server
        outToServer.writeBytes(a + "\n");
        outToServer.writeBytes(b + "\n");
        
//        Đọc kết quả tử Server gửi về
//        Tạo luồng nhập gắn với Server
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//        Đọc dữ liệu từ server gửi về
        String result = inFromServer.readLine();
//        In kết quả ra
        System.out.printf("sum("+a+","+b+") = "+result);
        
//        Đóng kết nối
        clientSocket.close();
        
        
    }
}
