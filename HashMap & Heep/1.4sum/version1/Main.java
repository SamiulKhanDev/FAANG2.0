public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> mans = new ArrayList<>();
        int len = nums.length;
        if (len < 4)
            return mans;
        Arrays.sort(nums);
        int i = 0;
        while (i < len - 3) {
            int num = nums[i];
            List<List<Integer>> ts = threeSum(nums, i + 1, len - 1, target - num);
            for (List<Integer> li : ts) {
                li.add(num);
                mans.add(li);
            }
            i++;
            while (nums[i - 1] == nums[i] && i < len - 3)
                i++;
        }
        return mans;
    }

    private final List<List<Integer>> twoSum(int[] nums, int i, int j, int target) {
        List<List<Integer>> list = new ArrayList<>();
        while (i < j) {
            int numi = nums[i];
            int numj = nums[j];
            if (numi + numj == target) {
                
                list.add(new ArrayList<>(Arrays.asList(numi,numj)));
                i++;
                j--;
                while (i < j && nums[i - 1] == nums[i])
                    i++;
                while (j > i && nums[j + 1] == nums[j])
                    j--;
            } else if (numi + numj < target) {
                i++;
            } else {
                j--;
            }
        }
        return list;
    }

    private final List<List<Integer>> threeSum(int[] nums, int i, int j, int target) {
        List<List<Integer>> list = new ArrayList<>();
        while (i < j - 1) {
            int num = nums[i];
            List<List<Integer>> ts = twoSum(nums, i + 1, j, target - num);
            for (List<Integer> li : ts) {
                li.add(num);
                list.add(li);
            }
            i++;
            while (nums[i - 1] == nums[i] && i < j - 1)
                i++;

        }

        return list;
    }
}

// version 2 off this problem solve tackle ksum problem,it is a generalize version which can solve for any value of k[2,3,4,5.....];










