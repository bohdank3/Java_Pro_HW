public class SimpleTree {
    TreeNode root;

    public SimpleTree() {
        this.root = null;
    }

    public void insert(int val) {
        this.root = insertRec(this.root, val);
    }

    private TreeNode insertRec(TreeNode node, int val) {
        if (node == null) {
            node = new TreeNode(val);
            return node;
        }

        if (val < node.val) {
            node.left = insertRec(node.left, val);
        } else if (val > node.val) {
            node.right = insertRec(node.right, val);
        }

        return node;
    }

    public void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);
        System.out.print(node.val + " ");
        inorderTraversal(node.right);
    }
}
