public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public int k;
    public int KthSmallestElement(Node root, int K)
    {
        k = K;
        return solution(root);
    }
    
    public int solution(Node root)
    {
        if(root==null) return -1;
        int left = solution(root.left);
        if(left!=-1) return left;
        k--;
        if(k==0)
        {
            return root.data;
        }
        
        int right = solution(root.right);
        return right;
    }
}

