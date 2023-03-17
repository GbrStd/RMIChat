package server;

import common.ServicoRemotoImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {

    public Server() throws RemoteException {
        try {
            LocateRegistry.createRegistry(15123);
            Naming.rebind("rmi://localhost:15123/chat", new ServicoRemotoImpl());
            System.out.println("Servidor Online");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws RemoteException {
        new Server();
    }

}
