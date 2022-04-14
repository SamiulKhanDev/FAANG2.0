public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public List<List<String>> groupAnagrams(String[] strs)
    {
        
        HashMap<HashMap<Character,Integer>,List<String>> map = new HashMap<>();
        for(String str:strs)
        {
            HashMap<Character,Integer> curr = getFmap(str);
            List<String> prev = map.getOrDefault(curr,new ArrayList<>());
            prev.add(str);
            map.put(curr,prev);
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(HashMap<Character,Integer> key:map.keySet())
        {
            ans.add(map.get(key));
        }
        
        return ans;
        
    }
    
    public HashMap<Character,Integer> getFmap(String s)
    {
        HashMap<Character,Integer> fmap = new HashMap<>();
        for(char ch:s.toCharArray())
        {
            int prev = fmap.getOrDefault(ch,0);
            fmap.put(ch,prev+1);
        }
        
        
        return fmap;
    }
    
    
    
}
