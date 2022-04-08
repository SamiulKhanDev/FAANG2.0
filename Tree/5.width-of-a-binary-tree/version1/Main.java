import java.util.*;
public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    
    public static void widthHelper(TreeNode root,int curr,int[] arr)
    {
        if(root==null) return;
        
        arr[0] = Math.min(arr[0],curr);
        arr[1] = Math.max(arr[1],curr);
        widthHelper(root.left,curr-1,arr);
        widthHelper(root.right,curr+1,arr);
        
    }
    

    public static int width(TreeNode root)
    {
        int[] arr = new int[2];
       widthHelper(root,0,arr);
       return arr[1] -arr[0]+1;
    }

    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        System.out.println(width(root));
    }

    public static void main(String[] args) {
        solve();
    }
}

//this problem deals with the shadow of a binary tree, refer to version 2 to have the solution to find the distance between two non null nodes in a binary tree
