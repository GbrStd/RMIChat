import common.IServicoRemoto;
import common.Message;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class Chat {

    private final ArrayList<Message> chatHistory = new ArrayList<>();

    private IServicoRemoto server = null;

    private String username;

    public void join(String username) throws MalformedURLException, NotBoundException, RemoteException {
        server = (IServicoRemoto) Naming.lookup("rmi://localhost:15123/chat");
        this.username = username;
        Thread threadMessages = new Thread(() -> {
            while (true) {
                try {
                    List<Message> messages = server.receiveAllMessages();
                    if (messages.size() > chatHistory.size()) {
                        chatHistory.clear();
                        chatHistory.addAll(messages);

                        System.out.println("\n".repeat(40));

                        messages.forEach(message -> System.out.println(message.getOwner() + ": " + message.getContent()));
                    }
                    Thread.sleep(1);
                } catch (RemoteException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        threadMessages.start();
    }

    public void sendMessage(String message) throws RemoteException {
        if (server != null) {
            server.sendMessage(this.username, message);
        }
    }

}
