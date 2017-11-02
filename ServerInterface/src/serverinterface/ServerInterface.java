/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Sulejman
 */
public interface ServerInterface  extends Remote {

public  void initializeStream() throws RemoteException;
public String izaberiRec() throws RemoteException;
    
}
