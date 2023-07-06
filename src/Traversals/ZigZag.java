package Traversals;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZag {
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

    public void ZigzagMain(){
        System.out.println(ZigZag(root));
    }

    public List<List<Integer>> ZigZag(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean topLeft = true;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> subli = new ArrayList<>();
            for(int i = 0;i < size; i++){
                if(q.peek().left != null){
                    q.offer(q.peek().left);
                }

                if(q.peek().right != null){
                    q.offer(q.peek().right);
                }

                if(topLeft){
                    subli.add(q.poll().val);
                }
                else{
                    subli.add(0,q.poll().val);
                }
            }
            topLeft = !topLeft;
            result.add(subli);
        }

        return result;
    }
}
