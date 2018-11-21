package in.mrasif.app.fileserver;

import javax.net.ServerSocketFactory;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer extends Thread {
    private int PORT;
    private ServerSocketFactory serverSocketFactory = ServerSocketFactory.getDefault();
    private ServerSocket serverSocket;

    public FileServer(int PORT) {
        this.PORT = PORT;
    }

    @Override
    public void run() {
        super.run();
        try {
            serverSocket = serverSocketFactory.createServerSocket(PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                try {
                    doBackground(socket);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void doBackground(Socket socket) throws Exception{
        InputStream is=socket.getInputStream();

        ObjectInputStream ois=new ObjectInputStream(is);

        FileData fileData=(FileData) ois.readObject();

        File file=new File("storage/"+fileData.getName());
        FileOutputStream fos=new FileOutputStream(file);
        fos.write(fileData.getData());
        fos.flush();
        fos.close();

        Response response=new Response();
        response.setMessage("Completed.");
        response.setPath(file.getPath());

        ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(response);
        oos.flush();
        oos.close();
        is.close();

        System.out.println(fileData);
        System.out.println(response);
    }

}
