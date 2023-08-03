/**
 *77. Combinations
 * Medium
 * 7.5K
 * 205
 * Companies
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 * Example 2:
 *
 * Input: n = 1, k = 1
 * Output: [[1]]
 * Explanation: There is 1 choose 1 = 1 total combination.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 */

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if(k == 0){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(k == 1){
            while(n > 0) {
                List<Integer> temp = new ArrayList<Integer>();temp.add(n--);
                ans.add(temp);
            }
            return ans;
        }
        if(n <= 0 || k > n) return null;

        List<List<Integer>> ans1 = combine(n - 1, k - 1);
        List<List<Integer>> ans2 = combine(n - 1, k);
        if(ans1 != null){
            for(List<Integer> lst: ans1){
                if(lst.size() == k - 1){
                    lst.add(0, n);
                    ans.add(lst);
                }
            }
        }
        if(ans2 != null){
            for(List<Integer> lst: ans2){
                if(lst.size() == k){
                    ans.add(lst);
                }
            }
        }

        return ans;


    }
}