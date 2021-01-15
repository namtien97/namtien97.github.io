import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _701Leetcode {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode root;

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if (newNode.val < root.val) {
            if (root.left == null) {
                return root.left = newNode;
            } else {
                return insertIntoBST(root.left, newNode.val);
            }
        }
        if (newNode.val > root.val) {
            if (root.right == null) {
                return root.right = newNode;
            } else {
                return insertIntoBST(root.right, newNode.val);
            }
        }
        return newNode;
    }

    public static void subPreOrderTravel(TreeNode curNode, List<Integer> result) {
        if (curNode == null) {
            return;
        }

        result.add(curNode.val);
        subPreOrderTravel(curNode.left, result);
        subPreOrderTravel(curNode.right, result);
    }

    public static List<Integer> preOrderTravel(TreeNode curNode) {
        List<Integer> result = new ArrayList<>();
        subPreOrderTravel(curNode, result);
        return result;
    }


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);

        n4.left = n2;
        n4.right = n7;

        n2.left = n1;
        n2.right = n3;



        List<Integer> resultPreOrder = (preOrderTravel(n4));
        for (Integer integer : resultPreOrder) {
            System.out.println(integer);
        }


    }
}
