package Traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Levelorder {
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
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
    }

    public void LevelOrderDisplay(){
        System.out.println(LevelOrder(root));
    }

    public List<List<Integer>> LevelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> li = new ArrayList<>();
        if(root == null) return li;
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subli = new ArrayList<>();
            for(int i = 0; i<levelNum; i++){
                if(queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }

                if(queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }

                subli.add(queue.poll().val);
            }
            li.add(subli);
        }

        return li;
    }
}
