package TreeQuestions;

import com.sun.source.tree.Tree;

public class DiameterTree {
    private TreeNode root;
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void treeConstruct(){
        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
    }

    public void diameterTreeMain(){
        diameterTree(root);
    }
    public void diameterTree(TreeNode root){
        int[] dia = new int[1];
        diameter(root, dia);
        System.out.println(dia[0]);
    }

    public int diameter(TreeNode root, int[] dia){
        if(root == null) return 0;

        int left = diameter(root.left, dia);
        int right = diameter(root.right, dia);

        dia[0] = Math.max(dia[0], left + right);

        return 1 + Math.max(left , right);
    }
}
