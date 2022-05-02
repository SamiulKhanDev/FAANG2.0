import java.util.*;
public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    private class Pair implements Comparable<Pair>
    {
        String str;
        int len;
        Pair(String str,int len)
        {
            this.str = str;
            this.len = len;
        }
        public int compareTo(Pair o)
        {
            return this.len-o.len;
        }   
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        PriorityQueue<Pair> minheap = new PriorityQueue<>();
        HashSet<String> set = new HashSet<>();
        minheap.add(new Pair(beginWord,1));
        while(minheap.size()>0)
        {
            Pair rem = minheap.poll();
            if(rem.str.equals(endWord)) 
            {
                
                return rem.len;
            }
            if(set.contains(rem.str)) continue;
            set.add(rem.str);
            for(String nbr:wordList)
            {
                if(nbr.equals(rem.str)==false && set.contains(nbr)==false && isPossible(rem.str,nbr))
                {
                    minheap.add(new Pair(nbr,rem.len+1));
                }
            }   
        }
        return 0;
    }
    
    public boolean isPossible(String word,String nbr)
    {
        int count = 0;
        int len = word.length();
        for(int i = 0;i<len;i++)
        {
            if(word.charAt(i)!=nbr.charAt(i))
            {
                if(count==1) return false;
                count++;
            }
        }
        return true;
    } 
}
