import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class AppChat {

    public static void main(String[] args) {

        System.out.println("Test chat do bi and ti");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual é o seu nome?");
        String nomeUser = scanner.nextLine();

        Chat chat = new Chat();

        System.out.println("\n".repeat(40));

        try {
            chat.join(nomeUser);

            while (true) {
                String menssagemUser = scanner.nextLine();
                try {
                    chat.sendMessage(menssagemUser);
                } catch (RemoteException e) {
                    System.out.println("Falha ao enviar a mensagem");
                }
            }

        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            throw new RuntimeException(e);
        }

    }
}