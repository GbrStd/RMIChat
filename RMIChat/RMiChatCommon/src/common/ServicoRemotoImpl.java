package common;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServicoRemotoImpl extends UnicastRemoteObject implements IServicoRemoto {

    private static final ArrayList<Message> messages = new ArrayList<>();

    public ServicoRemotoImpl() throws RemoteException {
    }

    @Override
    public List<Message> receiveAllMessages() throws RemoteException {
        return messages;
    }

    @Override
    public void sendMessage(String owner, String message) throws RemoteException {
        if (owner != null && message != null
                && owner.trim().length() > 0 && message.trim().length() > 0) {
            messages.add(new Message(owner, message));
        }
    }

}
