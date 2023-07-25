
/**
 * 
Problem Description
The government wants to set up B distribution offices across N cities for the distribution of food packets.

The population of the ith city is A[i]. Each city must have at least 1 office and every person is assigned to exactly one office in their own city.

Let M denote the minimum number of people that are assigned to any of the offices. Find the maximum value of M possible.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 106

1 <= B <= 5 x 105



Input Format
The first line of input contains an integer array A. 

The second line of input contains an integer B.



Output Format
Return one integer representing the maximum number of people who can get food in any single office.



Example Input
Input 1:

  A = [10000, 22000, 36000]
  B = 6
Input 2:

  A = [1, 1, 1]
  B = 4


Example Output
Output 1:

  10000
Output 2:

  0
 * 
 */

public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        Map<Integer, Integer> storer = new HashMap<Integer, Integer>();
        for(int a: A){
            storer.put(a, storer.getOrDefault(a, 0) + 1);
        }
        
        for(int b : B){
            if(storer.containsKey(b) && storer.get(b) > 0){
                ans.add(b);
                storer.put(b, storer.get(b) - 1);
            }
        }
        
        return ans;
    }
}