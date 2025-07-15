package algo.fun.algofun_prep.threemonth.week12.treeheight;

import java.util.Scanner;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    /*
    class Node 
        int data;
        Node left;
        Node right;
    */
    public static int height(Node root) {
        return height(root, 0);
    }

    private static int height(final Node root, final int height) {
        int localHeight = 0;

        if (root.left != null) {
            localHeight = height(root.left, height + 1);
        }
        
        if (root.right != null) {
            localHeight = Math.max(height(root.right, height + 1), localHeight);
        }

        return Math.max(localHeight, height);
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}