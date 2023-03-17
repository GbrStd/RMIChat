package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IServicoRemoto extends Remote {

    List<Message> receiveAllMessages() throws RemoteException;

    void sendMessage(String owner, String message) throws RemoteException;

}
