import java.util.*;
import java.io.IOException;
import java.net.*;

public final class Program
{
    private static final int serverPort = 8051;

    private static ServerSocket serverSocket = null;
    private static boolean isGameRunning = true;

    private static java.util.Map<Socket, ClientData> ClientMap = new HashMap<>();

    public static int hostClient()
    {

        return 0;
    }


    /** Entrypoint of server application. No GUI. */
    public static void main(String[] args)
    {
        // Init the server
        try
        {
            serverSocket = new ServerSocket(serverPort);
        }
        catch (IOException e)
        {
            System.out.println("Socket bootup fail");
            return;
        }

        System.out.println("Server app init success");

        int i = 0; // for testing multiple clients, this is the *address*

        while (isGameRunning)
        {
            Socket socket;
            try
            {
                socket = serverSocket.accept();
                if(ClientMap.keySet().contains(socket) != true) ClientMap.put(socket, new ClientData(i)); i++;
                
                for(Socket client : ClientMap.keySet())
                {
                    onRequestReceived(client);
                    client.close();
                }
            }
            catch (Exception e)
            {
                // If failed, just skip for now
                continue;
            }
        }

        System.out.println("Server ended");
    }

    private static void onRequestReceived(Socket socket) throws IOException
    {
        Objects.requireNonNull(socket);
        System.out.println("connection received from" + ClientMap.get(socket).getAddress());

        //byte[] receivedData = socket.getInputStream().readAllBytes();
        //System.out.println(new String(receivedData));
    }
}