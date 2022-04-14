public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public List<List<String>> groupAnagrams(String[] strs)
    {
        
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str:strs)
        {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String nstr = String.valueOf(arr);
            List<String> prev = map.getOrDefault(nstr,new ArrayList<>());
            prev.add(str);
            map.put(nstr,prev);
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(String key:map.keySet())
        {
            ans.add(map.get(key));
        }
        
        return ans;
        
    }
    
    
    
}
