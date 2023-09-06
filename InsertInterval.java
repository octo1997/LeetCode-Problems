/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 *
 *
 * Problem Constraints
 * 0 <= |intervals| <= 105
 *
 *
 *
 * Input Format
 * First argument is the vector of intervals
 *
 * second argument is the new interval to be merged
 *
 *
 *
 * Output Format
 * Return the vector of intervals after merging
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
 * Input 2:
 *
 * Given intervals [1, 3], [6, 9] insert and merge [2, 6] .
 *
 *
 * Example Output
 * Output 1:
 *
 *  [ [1, 5], [6, 9] ]
 * Output 2:
 *
 *  [ [1, 9] ]
 */

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> in, Interval newIn) {
        int n = in.size();
        ArrayList<Interval> ans = new ArrayList();
        int index = 0;
        while(index < n){
            Interval cur = in.get(index);
            if(newIn == null) {
                ans.add(cur);
                index += 1;
                continue;
            }
            if(newIn.start > cur.end){
                ans.add(cur);
                index += 1;
            }
            else if(newIn.end < cur.start) {
                ans.add(newIn);
                newIn = null;
            }else{
                newIn.start = Math.min(cur.start, newIn.start);
                newIn.end = Math.max(cur.end, newIn.end);
                index++;
            }
        }
        if(newIn != null) ans.add(newIn);

        return ans;
    }
}
