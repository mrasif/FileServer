package in.mrasif.app.fileserver;

import java.io.*;
import java.net.Socket;

public class FileClient {
    public static void main(String[] args) throws Exception{
        Socket socket=new Socket("172.31.1.181",9999);

        File file=new File("/Users/asif/Pictures/fizzy_logo.png");
        FileInputStream fis=new FileInputStream(file);

        FileData fileData=new FileData();
        fileData.setContent_type("image/png");
        fileData.setName("fizzy_logo.png");
        fileData.setExtension("png");
        fileData.setData(fis.readAllBytes());

        ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(fileData);
        oos.flush();
        fis.close();

        ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
        Response response=(Response)ois.readObject();
        System.out.println(response.getMessage()+"\nPath: "+response.getPath());

    }
}
