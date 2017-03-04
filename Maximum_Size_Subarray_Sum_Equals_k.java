public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        int sum = 0;
        int N = nums.length;
        int max = 0;
        
        for (int i = 0; i < N; i++) {
            sum += nums[i];
            if (sum == k) {
                max = i + 1;
            } else if (hash.containsKey(sum - k)) {
                max = Math.max(max, i - hash.get(sum - k));
            }
            
            if (!hash.containsKey(sum)) {
                hash.put(sum, i);
            }
        }
        return max;
    }
}
