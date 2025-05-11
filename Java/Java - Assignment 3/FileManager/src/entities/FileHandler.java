package entities;

public abstract class FileHandler {
    protected String fileName;

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    public abstract void read();
    public abstract void write();
    public abstract void delete();
    public String getFileName() {
        return fileName;
    }
}
