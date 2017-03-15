public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        
        int N = nums.length;
        
        int ansSum = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int left = 0; left < N - 1; left++) {
            int mid = left + 1;
            int right = N - 1;
            while (mid < right) {
                int sum = nums[left] + nums[mid] + nums[right];
                if (min > Math.abs(sum - target)) {
                    min = Math.abs(sum - target);
                    ansSum = sum;
                }
                if (sum > target) {
                    right--;
                } else {
                    mid++;
                }
            }
        }
        return ansSum;  
    }
}
