package trees;

public class BST {

    Node root;
    public static class Node {
        int height;
        Node right;
        Node left;
        int value;

        Node(int value) {
            this.value = value;
        }

        int getValue() {
            return value;
        }
    }

    public void insert(int value) {
        root = insertNode(root,value);
    }

    public Node insertNode(Node node,int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value <= node.getValue()) {
            node.left = insertNode(node.left, value);
        } else {
            node.right = insertNode(node.right, value);
        }
        return node;
    }

   public void display() {
        display(root, "Root node");
   }
    public void display(Node node, String details) {
        if (node == null) {
            return;
        }
       System.out.println(details +" " +node.value);
       display(node.right,"Right node of  " + node.value);
       display(node.left,"Left node of  " + node.value);
    }

    public void preorder() {
        preorder(root);
    }

    public void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    public void postOrder () {
      postOrder(root);
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }
    public void inOrder() {
      inOrder(root);
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }
    public static void main(String[] args) {
       BST bst = new BST();
       bst.insert(100);
       bst.insert(200);
       bst.insert(10);
       bst.insert(500);
        bst.insert(400);
       bst.insert(10000);
       bst.insert(1);
        bst.insert(18);
       bst.display();
       bst.preorder();
       System.out.println("-----");
       bst.inOrder();
        System.out.println("-----");
        bst.postOrder();
    }
}
