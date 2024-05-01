package trees;

public class AVLTree {

    public static class Node {
        Node right;
        Node left;
        int height;
        int value;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    Node root;

    public void insert(int value) {
        root = insert(value, root);
    }

    public int height () {
        return height(root);
    }
    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value <= node.getValue()) {
            node.left = insert(value, node.left);
        } else {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
    }

    public Node rotate(Node node) {

        // left heavy
        if (height(node.left) - height(node.right) > 1) {


            // left-left case
            if (height(node.left.left) - height(node.left.right) > 0) {
                return rightRotate(node);
            // left-right case
            }  else if (height(node.left.right) - height(node.left.left) > 0)
            {
                node.left = leftRotate(node.left);
                return leftRotate(node);
            }
        } else if (height(node.right) -  height(node.left) > 1) {
            // right-left
            if (height(node.right.right) - height(node.right.left) < 0) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            } else if (height(node.right.left) - height(node.right.right) < 0) {
                return leftRotate(node);
            }
        }
        return node;
    }

    public Node leftRotate(Node c) {
      Node p = c.right;
      Node t = p.left;

      p.left = c;
      c.right = t;

      p.height = Math.max(height(p.left), height(p.right) + 1);
      c.height = Math.max(height(c.left), height(c.right) + 1);
      return p;

    }

    public Node rightRotate(Node p) {

        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right)  + 1);
        return c;
    }



    public boolean balanced() {
        return balanced(root);
    }

    public boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }


    public static void main (String args[]) {
        AVLTree avlTree = new AVLTree();
        for (int i =0; i<1000; i++) {
            avlTree.insert(i);
        }
        System.out.println(avlTree.height());
    }



}
