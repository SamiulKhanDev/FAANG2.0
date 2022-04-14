public class Main {
    public static void main(String[] args) {

    }
}

class Solution{
    public Tree cloneTree(Tree tree)
    {
            
            if(tree==null) return null;
            HashMap<Tree,Tree> hm = new HashMap<>();
            Tree clone = clone(tree,hm);
            copy(tree,clone,hm);
            
            return clone;
            
     }
     
     public void copy(Tree tree,Tree clone,HashMap<Tree,Tree>hm)
     {
         if(clone==null) return;
         
         clone.random = hm.get(tree.random);
         copy(tree.left,clone.left,hm);
         copy(tree.right,clone.right,hm);
         
         
     }
     
     
     public Tree clone(Tree node,HashMap<Tree,Tree>hm)
     {
         if(node==null) return null;
         
         Tree cloneNode = new Tree(node.data);
         hm.put(node,cloneNode);
         cloneNode.left = clone(node.left,hm);
         cloneNode.right = clone(node.right,hm);
         return cloneNode;
         
     }
}
