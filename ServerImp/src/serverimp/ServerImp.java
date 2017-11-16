/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverimp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;
import serverinterface.ServerInterface;
/**
 *
 * @author Sulejman
 */
public class ServerImp extends UnicastRemoteObject implements ServerInterface {

    static ArrayList<String> recnik = new ArrayList<>();
    private static FileReader fileReader;
    private static BufferedReader buffFileReader;
    public static String trazenaRec;
   
   public ServerImp () throws RemoteException{
       super();
   }

    @Override
    public void initializeStream() throws RemoteException {

        try {
            File inFile = new File("recnik.txt");
            fileReader = new FileReader(inFile);
            buffFileReader = new BufferedReader(fileReader);
        
        String currentLine = buffFileReader.readLine();
        
            while(currentLine != null) {

                recnik.add(currentLine);
                currentLine = buffFileReader.readLine();

            } 

            buffFileReader.close();
            fileReader.close();

        } catch (IOException e) {
            System.out.println("stream error!");
        }
    }

    @Override
    public String izaberiRec() throws RemoteException {
        
        Random rand = new Random();
        int wordId = Math.abs(rand.nextInt()) % recnik.size();
   
        return recnik.get(wordId);
    }
    
}
