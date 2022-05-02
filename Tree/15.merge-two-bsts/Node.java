public class Node {
    int data;
    Node left;
    Node right;

    Node() {
    }

    Node(int val)
    {
        this.data = val;
    }

    Node(int data,Node left,Node right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }


}
