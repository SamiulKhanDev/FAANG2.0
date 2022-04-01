public class Main {
    public static void main(String[] args) {

    }
}


class Solution
{
    public List<List<Integer>> fourSum(int[] nums, int target)
    {
        
        Arrays.sort(nums);
        int k = 4;
        if(nums.length<k)
        {
            return new ArrayList<>();
        }
        return ksum(nums,target,k,0);
    }
    
    private final List<List<Integer>> ksum(int[] nums,int target,int k,int index)
    {   
        if(k==2)
        {
            return twoSum(nums,target,index);
        }
        
        List<List<Integer>> mlist = new ArrayList<>();
        while(index<nums.length-k+1)
        {
            int num = nums[index];
            List<List<Integer>> kmoneSum = ksum(nums,target-num,k-1,index+1);//k minus 1
            for(List<Integer>li:kmoneSum)
            {
                li.add(num);
                mlist.add(li);
            }
            index++;
            while(nums[index-1]==nums[index] && index<nums.length-k+1) index++;
        }
        
        return mlist;
        
        
    }
    
    private final List<List<Integer>> twoSum(int[] nums,int target,int index)
    {
        List<List<Integer>> ans = new ArrayList<>();
        
        int i = index;
        int j = nums.length-1;
        while(i<j)
        {
            int numi = nums[i];
            int numj = nums[j];
            int total = numi+numj;
            if(total==target)
            {
                ans.add(new ArrayList<>(Arrays.asList(numi,numj)));
                i++;
                j--;
                while(i<j && nums[i-1]==nums[i]) i++;
                while(j>i && nums[j+1]==nums[j]) j--;
                
            }
            else if(total<target)
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        
        return ans;
    }
    
    
    
}
