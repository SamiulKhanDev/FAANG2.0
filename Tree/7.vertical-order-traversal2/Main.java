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
    
    
    public static void getWidth(TreeNode root,int currLevel,int[] arr)
    {
        if(root==null) return;
        
        
        arr[0] = Math.min(arr[0],currLevel);
        arr[1] = Math.max(arr[1],currLevel);
        
        getWidth(root.left,currLevel-1,arr);
        getWidth(root.right,currLevel+1,arr);
        
        
    }
    
    public static class Pair implements Comparable<Pair>
    {
        TreeNode node;
        int level;
        Pair(TreeNode node,int level)
        {
            this.node = node;
            this.level = level;
        }
        
        @Override
        public int compareTo(Pair o)
        {
            if(this.level!=o.level)
            {
                return Integer.compare(this.level,o.level);
            }
            else
            {
                return Integer.compare(this.node.val,o.node.val);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root)
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        
        int[] arr = new int[2];
        getWidth(root,0,arr);
        int len = arr[1] -arr[0]+1;
        for(int i = 0;i<len;i++)
        {
            ans.add(new ArrayList<>());
        }
        
        PriorityQueue<Pair> parent = new PriorityQueue<>();
        parent.add(new Pair(root,-arr[0]));
        
        while(parent.isEmpty()==false)
        {
            int size = parent.size();
            PriorityQueue<Pair> child = new PriorityQueue<>();
            
            while(size-->0)
            {
                Pair rem = parent.poll();
                TreeNode node = rem.node;
                int level = rem.level;
                
                ans.get(level).add(node.val);
                if(node.left!=null)
                {
                    child.add(new Pair(node.left,level-1));
                }
                if(node.right!=null)
                {
                    child.add(new Pair(node.right,level+1));
                }
                
            }
            
            parent = child;
            
            
        }
        
        
        return ans;

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

        ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal(root);
        int idx = 0;
        for (ArrayList<Integer> i : ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}