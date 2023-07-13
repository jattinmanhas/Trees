package TreeQuestions;

import Traversals.VerticalOrder;

import java.util.*;

public class DistanceK {
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
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
    }

    public void distanceKMain(){
        System.out.println(distanceK(root, root.left, 2));
    }

    public void MarkParents(TreeNode root, Map<TreeNode, TreeNode> parent_map){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            if(node.left != null){
                parent_map.put(node.left, node);
                queue.offer(node.left);
            }

            if(node.right != null){
                parent_map.put(node.right, node);
                queue.offer(node.right);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode , TreeNode> parent_map = new HashMap<>();
        MarkParents(root, parent_map);
        Queue<TreeNode> que = new LinkedList<>();
        Map<TreeNode, Boolean> visit = new HashMap<>();
        que.offer(target);
        visit.put(target, true);
        int curr = 0;

        while(!que.isEmpty()){
            int size = que.size();
            if(curr == k) break;

            curr++;

            for(int i = 0; i<size;i++){
                TreeNode node = que.poll();

                if(node.left != null && visit.get(node.left) == null){
                    visit.put(node.left, true);
                    que.offer(node.left);
                }

                if(node.right != null && visit.get(node.right) == null){
                    visit.put(node.right, true);
                    que.offer(node.right);
                }

                if(parent_map.get(node) != null && visit.get(parent_map.get(node)) == null){
                    visit.put(parent_map.get(node), true);
                    que.offer(parent_map.get(node));
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(!que.isEmpty()){
            TreeNode current = que.poll();
            ans.add(current.val);
        }

        return ans;
    }
}
