package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public final class SocketInfo {
    private Socket dataSocket;
    private Socket gameSocket;
    private ObjectOutputStream dataOut;
    private ObjectInputStream dataIn;
    private ObjectOutputStream gameOut;
    private ObjectInputStream gameIn;

    public SocketInfo() {
        try {
            String serverAddress = java.net.InetAddress.getLocalHost().getHostAddress();
            //serverAddress = "172.20.10.3";
            dataSocket = new Socket(serverAddress, 1111);
            gameSocket = new Socket(serverAddress, 1112);
            dataOut = new ObjectOutputStream(dataSocket.getOutputStream());
            dataIn = new ObjectInputStream(dataSocket.getInputStream());
            gameOut = new ObjectOutputStream(gameSocket.getOutputStream());
            gameIn = new ObjectInputStream(gameSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObjectOutputStream getDataOutputStream() {
        return dataOut;
    }

    public ObjectInputStream getDataInputStream() {
        return dataIn;
    }

    public ObjectOutputStream getGameOutputStream() {
        return gameOut;
    }

    public ObjectInputStream getGameInputStream() {
        return gameIn;
    }

    public void closeSocket() {
        try {
            dataIn.close();
            dataOut.close();
            gameIn.close();
            gameOut.close();
            dataSocket.close();
            gameSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
