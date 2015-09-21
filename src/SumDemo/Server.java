/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SumDemo;

//Khai báo thư viện
import java.io.*;
import java.net.*;

/**
 *
 * @author Admin
 */
public class Server {
    public static void main(String args[]) throws Exception {
        ServerSocket welcomeSocket = new ServerSocket(6789);
        
//        Chờ dữ liệu gửi lên và xử lý 
        while(true){
//            Đọc dữ liệu được gửi lên từ CLient
//            Chấp nhận kết nối
            Socket connectionSocket = welcomeSocket.accept();
//            Tao luồng nhập gắn với Socket
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
//            Đọc giá trị từ Socket
            String str_a = inFromClient.readLine();
            String str_b = inFromClient.readLine();
//            Xử lý dữ liệu
//            Chuyển dữ liệu từ string sang float
            float a = Float.parseFloat(str_a);
            float b = Float.parseFloat(str_b);
//            Tính tổng a và b
            float sum = a + b;
//            Chuyển kết quả sang string 
            String result = sum + "\n";
//            Gửi kết quả cho Client
//            tạo luồng ra gắn với Socket
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
//            Gửi dữ liệu cho Client
            outToClient.writeBytes(result + "\n");
        }
        
    }
}
