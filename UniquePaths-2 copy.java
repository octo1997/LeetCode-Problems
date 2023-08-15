/**
 * Problem Description
 *
 * Given an integer array A of size N. You need to count the number of special elements in the given array.
 *
 * A element is special if removal of that element make the array balanced.
 *
 * Array will be balanced if sum of even index element equal to sum of odd index element.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 105
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 *
 * First and only argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 *
 * Return an integer denoting the count of special elements.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [2, 1, 6, 4]
 * Input 2:
 *
 *  A = [5, 5, 2, 5, 8]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  After deleting 1 from array : {2,6,4}
 *     (2+4) = (6)
 *  Hence 1 is the only special element, so count is 1
 * Explanation 2:
 *
 *  If we delete A[0] or A[1] , array will be balanced
 *     (5+5) = (2+8)
 *  So A[0] and A[1] are special elements, so count is 2.
 */

public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        int[] odd = new int[n];
        int[] even = new int[n];

        for(int i = 0;i < n; i++){
            if(i%2 == 0) {
                even[i] += (A[i] + (i >= 2 ? even[i - 2] : 0));
                odd[i] = i > 0 ? odd[i - 1] : 0;
            }
            else{
                odd[i] += (A[i] + (i >= 2 ? odd[i - 2] : 0));
                even[i] = even[i - 1];
            }
        }
        int ans = 0;
        for(int i = 0;i < n; i++){
            int lOS = i > 0 ? odd[i - 1] : 0;
            int rOS = odd[n - 1] - odd[i];
            int lES = i > 0 ? even[i - 1] : 0;
            int rES = even[n - 1] - even[i];

            if(lOS + rES == lES + rOS) ans++;
        }
        return ans;

    }
}
