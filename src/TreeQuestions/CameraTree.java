package TreeQuestions;
// No of camera needed to install in a tree so that all nodes are monitored...
// Remember a camera can monitor only parent and immediate child.
public class CameraTree {
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

  public void construct(){
        root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
  }

  private int noOfCamera = 0;
  public void installCamera(){
      System.out.println(minCameraCover(root));
  }

  public int minCameraCover(TreeNode root){
      return solveCamera(root) == -1 ? noOfCamera + 1 : noOfCamera;
  }

  public int solveCamera(TreeNode root){
      if(root == null) return 0;

      int left = solveCamera(root.left);
      int right = solveCamera(root.right);

      if(left == -1 || right == -1 ){
          noOfCamera++;
          return 1;
      }

      if(left == 1 || right == 1 ){
          return 0;
      }

      return -1;
  }

}
