public class Main {
    public static void main(String[] args) {

        SimpleTree tree = new SimpleTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        tree.insert(0);
        tree.insert(11);
        tree.insert(33);
        tree.insert(25);


        tree.inorderTraversal(tree.root);

    }

}