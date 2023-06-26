package Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Preorder {

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

    public void PreorderDisplay(){
//        PreorderRecursion(root);
        List<Integer> ans = new ArrayList<>();
        System.out.println(PreorderIterative(root));
    }

  public void PreorderRecursion(TreeNode root){
        if(root == null){
            return;
        }

      System.out.println(root.val);
        PreorderRecursion(root.left);
        PreorderRecursion(root.right);
  }

  public List<Integer> PreorderIterative(TreeNode root){
      Stack<TreeNode> st = new Stack<>();
      List<Integer> ans = new ArrayList<>();
      if(root == null) return ans;
      st.push(root);
      while(!st.isEmpty()){
          root = st.pop();
          ans.add(root.val);
          if(root.right != null) st.push(root.right);
          if(root.left != null) st.push(root.left);
      }
      return ans;
  }

}
