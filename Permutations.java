/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> lst = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return recur(lst);
    }

    private List<List<Integer>> recur(List<Integer> lst){
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(lst.size() == 1){
            List<Integer> inner = new ArrayList<Integer>();
            inner.add(lst.get(0));
            ans.add(inner);
            return ans;
        }

        for(int i = 0; i < lst.size(); i++){
            int tempi = lst.remove(i);
            List<List<Integer>> temp = recur(lst);
            for(List<Integer> tst: temp){
                tst.add(0, tempi);
                ans.add(tst);
            }
            lst.add(i, tempi);

        }
        return ans;


    }
}