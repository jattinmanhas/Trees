package TreeQuestions;

public class HeightTree {
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

    public void maxDepthMain(){
        System.out.println(diameterOfBinaryTree(root));
    }

    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int lt = maxDepth(root.left);
        int rt = maxDepth(root.right);

        return  1 + Math.max(lt,rt);
    }

    // Brute force approach to check if a tree is balanced binary tree or not
    public boolean isBalanced(TreeNode root){
        if(root == null){
            return true;
        }

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        if(Math.abs(lh - rh)>1){
            return false;
        }
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        if(!left || !right) return false;

        return true;
    }

    // optimized approach for the above question:(balanced binary tree)
    public int isBooleanOptimized(TreeNode root){
        if(root == null){
            return 0;
        }
        int lt = maxDepth(root.left);
        if(lt == -1) return -1;
        int rt = maxDepth(root.right);
        if(rt == -1) return -1;

        if(Math.abs(lt - rt) > 1) return -1;

        return  1 + Math.max(lt,rt);
    }

    // diameter of the tree in optimized way...
    // Here we have used array instead of variable to pass variable by reference
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }

    public int height(TreeNode root, int[] diameter){
        if(root == null){
            return 0;
        }

        int lt = height(root.left, diameter);
        int rt = height(root.right, diameter);

        diameter[0] = Math.max(lt + rt, diameter[0]);

        return 1 + Math.max(lt , rt);
    }

}
