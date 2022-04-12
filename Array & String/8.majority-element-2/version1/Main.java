public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int len = nums.length;
        HashMap<Integer, Integer> fmap = new HashMap<>();
        for (int num : nums) {
            int prev = fmap.getOrDefault(num, 0);
            fmap.put(num, prev + 1);
        }

        for (int key : fmap.keySet()) {
            if (fmap.get(key) > len / 3) {
                ans.add(key);
            }
            if (ans.size() == 2)
                break;
        }

        return ans;

    }
}

//see version2 
