package TreeQuestions;

public class CheckDeadEnd {
    private Node root;
    private class Node {
        int val;
        Node left;
        Node right;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void treeConstruct(){
        root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(9);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.left.left.left = new Node(1);
    }

    public void isDeadEndMain(){
        System.out.println(isDeadEnd(root));
    }
    public  boolean isLeaf(Node root){
        return root.left == null && root.right == null;
    }
    public  boolean isDeadEnd(Node root)
    {
        //Add your code here.
        if(root == null) return false;

        int max = Integer.MAX_VALUE;
        int min = 1;

        return isDeadEndHelper(root, min, max);
    }

    public  boolean isDeadEndHelper(Node root, int min, int max){
        if(root == null) return false;

        if(isLeaf(root)){
            if(max == min) return true;
        }

        return isDeadEndHelper(root.left, min, root.val - 1) || isDeadEndHelper(root.right,root.val + 1, max);
    }
}
