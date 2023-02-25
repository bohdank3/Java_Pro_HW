mport java.util.*;

public class FileNavigator {

    public static Map<String, List<FileData>> files = new HashMap<>();
    private List<FileData> fileList;

    public FileNavigator() {
        fileList = new ArrayList<>();
    }

    public static void add(FileData fileData) {
        String path = fileData.getPath();
        if (files.containsKey(path)) {
            files.get(path).add(fileData);
            System.out.println("add(): Мы успешно добавили данный элемент, так как путь уже был");

        } else {
            List<FileData> fileList = new ArrayList<>();
            fileList.add(fileData);
            files.put(path, fileList);
            System.out.println("add(): Мы успешно добавили данный элемент и новый путь");
        }
    }

    public List<FileData> find(String path) {
        if (files.containsKey(path)) {
            return files.get(path);
        } else {
            return null;
        }
    }
    /*4. Реалізувати метод filterBySize у класі FileNavigator. Метод повертає список файлів, розмір (в байтах) яких не перевищує значення, передане як параметр.*/

    public List<FileData> filterBySize(int maxSize) {
        List<FileData> result = new ArrayList<>();
        for (List<FileData> fileList : files.values()) {
            for (FileData fileData : fileList) {
                if (fileData.size <= maxSize) {
                    result.add(fileData);
                }
            }
        }
        return result;
    }

    /*5. Реалізувати метод remove у класі FileNavigator. Метод видаляє шлях і пов'язані з ним файли, виходячи з значення шляху, переданого як параметр.*/
    public void remove(String path) {
        if (files.containsKey(path)) {
            System.out.println(files.get(path).size()+" элементов удалили с пути "+path);
        } else {
            System.out.println("не нашли файлов по этому пути "+path);
        }
        files.remove(path);
    }

    public List<FileData> sortBySize() {
        List<FileData> fileList = new ArrayList<>();
        for (List<FileData> files : files.values()) {
            fileList.addAll(files);
        }
        fileList.sort(Comparator.comparingLong(FileData::getSize));
        return fileList;
    }

    @Override
    public String toString() {
        return "files=" + files;
    }

}