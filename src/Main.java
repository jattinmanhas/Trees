import Traversals.*;
import TreeQuestions.*;

public class Main {
    public static void main(String[] args) {
//        Preorder pr = new Preorder();
//        pr.treeConstruct();
//        pr.PreorderDisplay();

//        Inorder io = new Inorder();
//        io.treeConstruct();
//        io.InorderDisplay();

//        Postorder po = new Postorder();
//        po.treeConstruct();
//        po.PostorderDisplay();

//        Levelorder lo = new Levelorder();
//        lo.treeConstruct();
//        lo.LevelOrderDisplay();

//        AllTraversals at = new AllTraversals();
//        at.treeConstruct();
//        at.displayAll();

//        HeightTree ht = new HeightTree();
//        ht.treeConstruct();
//        ht.maxDepthMain();

//        ZigZag zz = new ZigZag();
//        zz.treeConstruct();
//        zz.ZigzagMain();

//        Boundary b = new Boundary();
//        b.treeConstruct();
//        b.printBoundary();

//        VerticalOrder vo = new VerticalOrder();
//        vo.treeConstruct();
//        vo.verticalOrderMain();

//        DistanceK kk = new DistanceK();
//        kk.treeConstruct();
//        kk.distanceKMain();

//        DiameterTree dt = new DiameterTree();
//        dt.treeConstruct();
//        dt.diameterTreeMain();

//        CheckDeadEnd cd = new CheckDeadEnd();
//        cd.treeConstruct();
//        cd.isDeadEndMain();

//        RecoverBST rbst = new RecoverBST();
//        rbst.constructTree();
//        rbst.recoverTreeMain();

        Morris mo = new Morris();
        mo.constructTree();
        mo.MorrisTraversalMain();
    }
}