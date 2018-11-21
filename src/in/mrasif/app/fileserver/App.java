package in.mrasif.app.fileserver;

public class App {
    public static void main(String[] args) {
        FileServer fileServer=new FileServer(9999);
        fileServer.start();
    }
}
