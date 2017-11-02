/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import serverinterface.ServerInterface;
import serverimp.ServerImp;
/**
 *
 * @author Sulejman
 */
public class Server {

  
    public static void main(String[] args) {
        
        Registry registry;
        
        try {
            registry = LocateRegistry.createRegistry(8081);
            ServerImp s = new ServerImp();
            s.initializeStream();
            registry.bind("RecnikService", s);
            System.out.println("Server is running!");
            
        } catch(Exception e) {
            System.out.println(e.toString());
        }
       
    }
    
}
