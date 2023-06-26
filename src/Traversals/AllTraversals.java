package Traversals;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllTraversals {
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
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
    }

    private class TreeAll{
        TreeNode node;
        int num;

        public TreeAll(TreeNode node, int num){
            this.node = node;
            this.num = num;
        }
    }

    public void displayAll(){
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        AllTreeTraversals(root, preorder, inorder, postorder);
        System.out.println("PREORDER: "+preorder);
        System.out.println("INORDER: "+inorder);
        System.out.println("POSTORDER: "+postorder);
    }

    public void AllTreeTraversals(TreeNode root, List<Integer> preorder, List<Integer> inorder,List<Integer> postorder){
        Stack<TreeAll> st = new Stack<>();
        st.push(new TreeAll(root, 1));

        while(!st.isEmpty()){
            if(st.peek().num == 1){
                preorder.add(st.peek().node.val);
                st.peek().num++;
                if(st.peek().node.left != null){
                    st.push(new TreeAll(st.peek().node.left,1));
                    continue;
                }
            }
            if(st.peek().num == 2){
                inorder.add(st.peek().node.val);
                st.peek().num++;
                if(st.peek().node.right != null){
                    st.push(new TreeAll(st.peek().node.right,1));
                    continue;
                }
            }
            if(st.peek().num == 3){
                postorder.add(st.peek().node.val);
                st.pop();
            }
        }
    }
}
