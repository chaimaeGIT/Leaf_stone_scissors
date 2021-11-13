/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author HP
 */
public class Server extends  Thread {
    final  int port =9644;
    String choixJ ;
        int choixO ;
        int cJ=0;
        int cO=0;
        String[] choix = {"papier" ,"pierre","ciseaux" };
        Random r = new Random();
        Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
       new Server().start();
        }
    public void run() {
         try {
            
            ServerSocket ss=new ServerSocket(port);
         while(true){
                Socket cs = ss.accept();
                System.out.println("Connexion avec : " + cs.getInetAddress() );
                BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
                OutputStream os = cs.getOutputStream();
                PrintWriter out = new PrintWriter(os,true);
               // out.println("Veullez saisir votre compte :");
               // String Compte =in.readLine();
               out.println("Veullez choisir :  ");
            out.println("0 pour papier  ");
            out.println("1 pour pierre  ");
            out.println("2 pour ciseaux  ");
            
              while (cJ<3 && cO<3){
                  
                  choixJ =in.readLine();
                  choixO = r.nextInt(3);
                 // System.out.println(+choixO);
                 // System.out.println(choixJ);
               if ( !choixJ.equals("2") && !choixJ.equals("0") &&!choixJ.equals("1")){
                  // System.out.println(" Entrer un choix valable");
                   out.println("Entrer un choix valable");
                   choixJ =in.readLine();
               } 
 
               System.out.println(+choixO);
                System.out.println(choixJ);
               out.println("Ordinateur :" +choix[choixO]);
                   
               if (choixJ.equals("0") && choixO == 1) {
                   cJ++;
                  out.println( cJ+"/"+cO);
                  System.out.println( cJ+"/"+cO);
               }
               if(choixJ.equals("1") && choixO  == 2){ 
                    cJ++;
                  out.println( cJ+"/"+cO);
                  System.out.println( cJ+"/"+cO);
               }
                if(choixJ.equals("2") && choixO  == 0){ 
                    cJ++;
                 System.out.println( cJ+"/"+cO);
                  out.println( cJ+"/"+cO);
               }
              if(choixO ==2 && choixJ.equals("0") ){
               
                  cO++;
                  System.out.println( cJ+"/"+cO);
                  out.println( cJ+"/"+cO);
                    }
             
               if(choixO ==0 && choixJ.equals("1") ){
                  
                  cO++;
                  System.out.println( cJ+"/"+cO); 
               out.println( cJ+"/"+cO);
              } 
               if(choixO ==1 && choixJ.equals("2")) {
                  
                  cO++;
                  System.out.println( cJ+"/"+cO);
                 out.println( cJ+"/"+cO);
              }
              if(choixJ.equals(Integer.toString(choixO))){
                  System.out.println( "Egalité");
                   System.out.println( cJ+"/"+cO);
                   out.println( cJ+"/"+cO);
               }
              }
              if (cJ < cO ){
                  out.println("vous avez ganger");
              }else if(cO < cJ ){
                  out.println("ordi a ganger");
              }else{
                  out.println("egalite");
              }
                  
               cs.close();
                
            }
            
        }catch(IOException e){
            System.out.println(e);
        }
    
}
}

    
