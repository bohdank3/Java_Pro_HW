public class Main {
    public static void main(String[] args) {
        FileNavigator navigator = new FileNavigator();
        FileData file1 = new FileData(200,"file1.txt", "/path/to/file/");
        FileData file2 = new FileData(100,"file2.txt", "/path/to/file/");

        //navigator.add("/path/to/file", file1);
        navigator.add(file1);
        navigator.add(file2);

        System.out.println(navigator.find("/path/to/file/"));
        System.out.println(navigator.filterBySize(100));
        System.out.println(navigator.sortBySize());
/*
        navigator.remove("/path/to/file/");*/

    }
}