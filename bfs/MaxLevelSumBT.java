package bfs;

import java.util.*;

public class MaxLevelSumBT {

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

    public static TreeNode populate(Scanner sc) {
        System.out.print("Enter the root TreeNode: ");
        int value = sc.nextInt();
        TreeNode root = new TreeNode(value);

        populate(sc, root);

        return root;
    }

    private static void populate(Scanner sc, TreeNode node) {
        System.out.printf("Do you want to enter left of %d: ", node.val);
        boolean isLeft = sc.nextBoolean();

        if (isLeft) {
            System.out.print("Enter the value of the left TreeNode: ");
            int value = sc.nextInt();
            TreeNode left = new TreeNode(value);
            node.left = left;
            populate(sc, left);
        }

        System.out.printf("Do you want to enter right of %d: ", node.val);
        boolean isRight = sc.nextBoolean();

        if (isRight) {
            System.out.print("Enter the value of the right TreeNode: ");
            int value = sc.nextInt();
            TreeNode right = new TreeNode(value);
            node.right = right;
            populate(sc, right);
        }

    }

    public static void prettyDisplay(TreeNode root) {
        prettyDisplay(root, 0);
    }

    private static void prettyDisplay(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        prettyDisplay(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.val);
        } else {
            System.out.println(node.val);
        }

        prettyDisplay(node.left, level + 1);

    }

    public static int maxLevelSum(TreeNode root) {
        
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        int maxSum = root.val;
        int maxLevel = 1;

        int level = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            int levelSum = 0;

            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();

                levelSum+=node.val;

                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }
            }

            if(levelSum>maxSum){
                maxSum = levelSum;
                maxLevel = level;
            }

            level++;
        }

        return maxLevel;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = populate(sc);

        prettyDisplay(root);

        System.out.println("\n"+maxLevelSum(root));
    }
}
