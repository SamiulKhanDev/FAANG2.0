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
    
    private static class Pair
    {
        TreeNode node;
        int level;
        Pair(TreeNode node,int level)
        {
            this.node = node;
            this.level = level;
        }
    }
    private static void getWidth(TreeNode root,int curr,int[] arr)
    {
        if(root==null) return;
        
        arr[0] = Math.min(arr[0],curr);
        arr[1] = Math.max(arr[1],curr);
        
        getWidth(root.left,curr-1,arr);
        getWidth(root.right,curr+1,arr);
        
    }

    public static ArrayList<Integer> BottomView(TreeNode root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        int[] minmax = new int[2];
        getWidth(root,0,minmax);
        
        int len = minmax[1]-minmax[0]+1;
        for(int i = 0;i<len;i++)
        {
            ans.add(0);
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,-minmax[0]));
        while(queue.isEmpty()==false)
        {
            int size = queue.size();
            while(size-->0)
            {
                Pair rem = queue.poll();
                TreeNode node = rem.node;
                int level = rem.level;
                ans.set(level,node.val);
                
                if(node.left!=null)
                {
                    queue.add(new Pair(node.left,level-1));
                }
                if(node.right!=null)
                {
                    queue.add(new Pair(node.right,level+1));
                }
                
            }
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

        ArrayList<Integer> ans = BottomView(root);
        for (Integer i : ans)
            System.out.print(i + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}