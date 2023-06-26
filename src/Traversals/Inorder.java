package Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Inorder {
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
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.right = new TreeNode(7);
    }

    public void InorderDisplay(){
//        InorderRecursion(root);
        System.out.println(InorderIterative(root));
    }

    public void InorderRecursion(TreeNode root){
        if(root == null){
            return;
        }
        InorderRecursion(root.left);
        System.out.println(root.val);
        InorderRecursion(root.right);
    }

    public List<Integer> InorderIterative(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode node = root;
        while(true){
            if(node != null){
                st.push(node);
                node = node.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                node = st.pop();
                ans.add(node.val);
                node = node.right;
            }
        }
        return ans;
    }
}
