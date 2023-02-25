public class FileData {

    int size;
    String name;
    String path;


    public FileData(int size, String name, String path) {
        this.size = size;
        this.name = name;
        this.path = path;
    }

    public String getPath() {
        return path;
    }
    public int getSize(){
        return  size;
    }

    @Override
    public String toString() {
        return "FileData{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", path='" + path + '\'' +
                '}';
    }

}