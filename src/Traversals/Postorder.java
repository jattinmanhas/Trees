package Traversals;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class Postorder {
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

    public void PostorderDisplay(){
//        PostorderRecursion(root);
//        System.out.println(PostorderIterativeTwoStack(root));
        System.out.println(PostOrderIterativeOneStack(root));
    }

    public void PostorderRecursion(TreeNode root){
        if(root == null){
            return;
        }

        PostorderRecursion(root.left);
        PostorderRecursion(root.right);
        System.out.println(root.val);
    }

    // 1. Using Two Stacks
    public List<Integer> PostorderIterativeTwoStack(TreeNode root){
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        st1.push(root);
        while(!st1.isEmpty()){
            st2.push(st1.pop());
            if(st2.peek().left != null) st1.push(st2.peek().left);
            if(st2.peek().right != null) st1.push(st2.peek().right);
        }

        while(!st2.isEmpty()){
            ans.add(st2.pop().val);
        }

        return ans;
    }

    // 2. Using 1 Stack
    public List<Integer> PostOrderIterativeOneStack(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        List<Integer> ans = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !st.isEmpty()){
            if(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            else{
                TreeNode temp = st.peek().right;
                if(temp == null){
                    temp = st.pop();
                    ans.add(temp.val);
                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.pop();
                        ans.add(temp.val);
                    }
                }else{
                    curr = temp;
                }
            }
        }

        return ans;
    }
}
