package algo.fun.algofun_prep.month.week4.lowestancestor;

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
    public static Node lca(Node root, int v1, int v2) {
        final int rootData = root.data;
        
        if (rootData == v1 || rootData == v2) {
            return root;
        }

        final int lowerV = Math.min(v1, v2);
        final int greaterV = Math.max(v1, v2);

        if (lowerV < rootData) {
            if (greaterV > rootData) {
                return root;
            }

            return lca(root.left, v1, v2);
        }

        return lca(root.right, v1, v2);
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
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }
}