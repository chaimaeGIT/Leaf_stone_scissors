/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
   import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
/**
 *
 * @author HP
 */
public class Client {
  



        final static int port=9644;

        public static void main(String[] args) {
            final Scanner sc = new Scanner(System.in);
            try {

                // Socket cs = new Socket("localhost",6666);
                InetAddress IPserver = InetAddress.getLocalHost();
                System.out.println("Adress Server it: "+IPserver.getHostAddress().toString());
                Socket socket=new Socket(IPserver.getHostAddress(),port);

                InputStream iss = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(iss);
                BufferedReader in = new BufferedReader(isr);

                OutputStream os = socket.getOutputStream();
                PrintStream out = new PrintStream(os);

                Scanner scan = new Scanner(System.in);

                Thread envoyer = new Thread(new Runnable() {
                    String msg;
                    @Override
                    public void run() {
                        while(true){
                            System.out.println("Vous :");
                            msg = scan.nextLine();
                            out.println(msg);
                            out.flush();   } } });
                envoyer.start();

                Thread recevoir;
                recevoir = new Thread(new Runnable() {
                    String msg;
                    @Override
                    public void run() {
                        try {
                            msg = in.readLine();
                            while(msg!=null){
                                System.out.println("Serveur : "+msg);
                                msg = in.readLine();
                            }
                            System.out.println("Serveur déconecté");
                            out.close();
                            socket.close();
                        } catch (IOException e) { e.printStackTrace(); } } });
                recevoir.start();



            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }



    

