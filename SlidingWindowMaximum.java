import java.util.Objects;

/**
 *You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 *
 */

class Solution {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;
        return Objects.equals(window, solution.window);
    }

    @Override
    public int hashCode() {
        return Objects.hash(window);
    }

    Window window = new Window();
    public int[] maxSlidingWindow(int[] nums, int k) {
        window.arr.clear();
        window.k = k;
        int cnt = 0, n = nums.length;
        int[] ans = new int[n - k + 1];
        for(int i = 0; i < nums.length; i++){
            if(window.arr.size() == k){
                window.remove(nums[i - k]);
            }
            window.insert(nums[i]);
            int temp = window.getMaxElem();
            if(window.arr.size() == k) {
                ans[cnt++] = temp;
            }
        }

        return ans;


    }

    class Window{
        List<Integer> arr = new ArrayList();
        int k;

        public int getMaxElem(){
            if(arr.size() == k){
                return arr.get(arr.size() - 1);
            }
            return -100000;
        }

        public void insert(int a){
            int st = 0, en = arr.size() - 1;

            while(st <= en){
                int mid = (st + en) / 2;
                if(arr.get(mid) > a){
                    en = mid - 1;
                }else{
                    st = mid + 1;
                }
            }
            arr.add(st, a);
        }

        public void remove(int a){
            int st = 0, en = arr.size() - 1;
            while(st <= en){
                int mid = (st + en) / 2;
                if(arr.get(mid) > a){
                    en = mid - 1;
                }else{
                    st = mid + 1;
                }
            }

            arr.remove(en);
        }
    }
}