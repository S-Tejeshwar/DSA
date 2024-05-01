package trees;

public class SegmentTree {

    Node root;
    public static class Node {
        int data;
        Node left;
        Node right;
        int start; 
        int end;
        
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public SegmentTree(int[] arr) {
     this.root = constructTree(arr, 0, arr.length-1);
    }

    
    public Node constructTree(int[] arr, int start, int end) {
        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }
        Node currNode = new Node(start, end);
        int mid = start + (end - start)/2;
        currNode.left = constructTree(arr, start, mid);
        currNode.right = constructTree(arr, mid+1, end);
        currNode.data = currNode.right.data + currNode.left.data;
        return currNode;
    }
    
    public int queryTree(int start, int end) {
        return queryTree(root, start, end);
    }
    
    private int queryTree(Node node, int start, int end) {
        if (node.start > end || node.end < start) {
            return 0;
        } else if (node.start >= start && node.end <= end) {
            return node.data;
        } else {
            return queryTree(node.right, start, end) + queryTree(node.left, start, end);
        }
    }
    
    public void updateTree(int index, int value) {
        int ans = updateTree(root, index, value);
        System.out.println("Updated root node value" +  ans);
    }

    private int updateTree(Node node, int index, int value) {
        if (node.start == index && node.end == index) {
            node.data = value;
            return node.data;
        } else if (node.start > index || node.end < index) {
            return node.data;
        } else {
            node.data = updateTree(node.right, index, value) + updateTree(node.left, index, value);
            return node.data;
        }

    }

    public void display() {
        display(this.root);
    }
    private void display(Node node) {
        String str = "";

        if(node.left != null) {
            str = str + "Interval=[" + node.left.start + "-" + node.left.end + "] and data: " + node.left.data + " => ";
        } else {
            str = str + "No left child";
        }

        // for current node
        str = str + "Interval=[" + node.start + "-" + node.end + "] and data: " + node.data + " <= ";

        if(node.right != null) {
            str = str + "Interval=[" + node.right.start + "-" + node.right.end + "] and data: " + node.right.data;
        } else {
            str = str + "No right child";
        }

        System.out.println(str + '\n');

        // call recursion
        if(node.left != null) {
            display(node.left);
        }

        if(node.right != null) {
            display(node.right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 7, -2, -8, 4, 9};
        SegmentTree tree = new SegmentTree(arr);
//        tree.display();
        System.out.println(tree.queryTree(4,5));
        tree.updateTree(3,10);
        tree.display();
        System.out.println(tree.queryTree(0,7));
    }

}
