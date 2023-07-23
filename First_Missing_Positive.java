class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean flag = false;
        for(int i = 0; i < n; i++){
            if(nums[i] == 1) flag = true;
            if(nums[i] < 1) nums[i] = 1;
            else if(nums[i] > n) nums[i] = 1;
            
        }

        if(!flag) return 1;

        for(int i = 0; i < n; i++){
            int a = nums[i];
            nums[Math.abs(a) - 1] = nums[Math.abs(a) - 1] > 0 ? -nums[Math.abs(a) - 1] : nums[Math.abs(a) - 1];
        }

        for(int i = 0; i < n; i++){
            if(nums[i] > 0) return i + 1;
        }
        return n + 1;
    }
}