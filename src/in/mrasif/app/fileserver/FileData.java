package in.mrasif.app.fileserver;

import java.io.Serializable;

public class FileData implements Serializable {
    private int id;
    private String name;
    private String content_type;
    private String extension;
    private byte[] data;

    public FileData() {

    }

    public FileData(String name, String content_type, String extension, byte[] data) {
        this.name = name;
        this.content_type = content_type;
        this.extension = extension;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "FileData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content_type='" + content_type + '\'' +
                ", extension='" + extension + '\'' +
                '}';
    }
}
