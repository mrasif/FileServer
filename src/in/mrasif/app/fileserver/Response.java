package in.mrasif.app.fileserver;

import java.io.Serializable;

public class Response implements Serializable {
    private int id;
    private String message;
    private String path;

    public Response() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Response{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
