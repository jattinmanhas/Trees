package Traversals;

import TreeQuestions.RecoverBST;

import java.util.ArrayList;
import java.util.List;

public class Morris {
    private TreeNode root;
    public class TreeNode {
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

    public void constructTree(){
        root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right =new TreeNode(4);
        root.right.left = new TreeNode(2);
    }

    public void MorrisTraversalMain(){
        System.out.println(MorrisTraversal(root));
    }

    public List<Integer> MorrisTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        TreeNode curr = root;

        while(curr != null){
            if(curr.left == null){
                ans.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode temp = curr.left;
                while(temp.right != null && temp.right != curr){
                    temp = temp.right;
                }

                if(temp.right == null){
                    temp.right = curr;
                    curr = curr.left;
                }else{
                    temp.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
}
