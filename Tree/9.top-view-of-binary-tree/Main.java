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
    
    
    private static void getWidth(TreeNode node,int[] arr,int curr)
    {
        if(node==null) return;
        
        arr[0] = Math.min(arr[0],curr);
        arr[1] = Math.max(arr[1],curr);
        
        getWidth(node.left,arr,curr-1);
        getWidth(node.right,arr,curr+1);
        
        
    }

    public static ArrayList<Integer> TopView(TreeNode root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        int[] arr = new int[2];
        getWidth(root,arr,0);
        int len = arr[1]-arr[0]+1;
        for(int i = 0;i<len;i++)
        {
            ans.add(1001);
        }
        
        Queue<Pair> queue = new LinkedList<>();
        
        queue.add(new Pair(root,-arr[0]));
        int n = 0;
        while(queue.size()>0)
        {
            int size = queue.size();
           
            while(size-->0)
            {
                Pair rem = queue.poll();
                TreeNode node = rem.node;
                int level = rem.level;
                
                if(ans.get(level)==1001)
                {
                    ans.set(level,node.val);
                    n++;
                }
                if(n==ans.size())
                {
                    
                    break;
                }
                
                if(node.left!=null)
                {
                    queue.add(new Pair(node.left,level-1));
                }
                if(node.right!=null)
                {
                    queue.add(new Pair(node.right,level+1));
                }
                
            }
            if(n==ans.size())
            {
                
                break;
            }
            
        }
        
        return ans;

    }
    
    
    static class Pair
    {
        TreeNode node;
        int level;
        Pair(TreeNode node,int level)
        {
            this.node = node;
            this.level = level;
        }
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

        ArrayList<Integer> ans = TopView(root);
        for (Integer i : ans)
            System.out.print(i + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}