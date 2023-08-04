package TreeQuestions;

import com.sun.source.tree.Tree;

public class RecoverBST {
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

  public void recoverTreeMain(){
        recoverTree(root);
      System.out.println(root.val);
  }


    public void recoverTree(TreeNode root){
        if(root == null) return;
        TreeNode curr = root;
        TreeNode prev = null;
        TreeNode first = null;
        TreeNode second = null;

        while(curr != null){
            if(curr.left == null){
                if(prev!= null && prev.val > curr.val){
                    if(first == null && second == null){
                        first = prev;
                        second = curr;
                    }else{
                        second = curr;
                    }
                }
                prev = curr;
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
                    if(prev!= null && prev.val > curr.val){
                        if(first == null && second == null){
                            first = prev;
                            second = curr;
                        }else{
                            second = curr;
                        }
                    }
                    prev = curr;
                    temp.right = null;
                    curr = curr.right;
                }
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
