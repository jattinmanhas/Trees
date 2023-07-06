package Traversals;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Stack;

public class Boundary {
    public TreeNode root;
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


    public boolean isLeaf(TreeNode root){
        return (root.left == null) && (root.right == null);
    }

    public void leftBoundary(TreeNode root, ArrayList<Integer> res){
        TreeNode curr = root;
        while(curr != null){
            if(!isLeaf(curr)) res.add(curr.val);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }

    public void rightBoundary(TreeNode root, ArrayList<Integer> res){
        TreeNode curr = root.right;
        Stack<Integer> st = new Stack<>();
        while(curr != null){
            if(!isLeaf(curr)) st.push(curr.val);
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }

        while(!st.isEmpty()){
            res.add(st.pop());
        }
    }

    public void addLeaves(TreeNode root, ArrayList<Integer> res){
        if(isLeaf(root)){
            res.add(root.val);
            return;
        }
        if(root.left != null) addLeaves(root.left, res);
        if(root.right != null) addLeaves(root.right, res);
    }

    public void printBoundary(){
        ArrayList<Integer> ans = new ArrayList<>();
        if(!isLeaf(root)){
            leftBoundary(root, ans);
            addLeaves(root, ans);
            rightBoundary(root, ans);
        }

        System.out.println(ans);
    }

}
