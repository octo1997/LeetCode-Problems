/**
 * In the classic problem of the Towers of Hanoi, you have 3 towers numbered from 1 to 3 (left to right) and A disks numbered from 1 to A (top to bottom) of different sizes which can slide onto any tower.
 * The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on top of an even larger one).
 * You have the following constraints:
 *
 * Only one disk can be moved at a time.
 * A disk is slid off the top of one tower onto another tower.
 * A disk cannot be placed on top of a smaller disk.
 * You have to find the solution to the Tower of Hanoi problem.
 * You have to return a 2D array of dimensions M x 3, where M is the minimum number of moves needed to solve the problem.
 * In each row, there should be 3 integers (disk, start, end), where:
 *
 * disk - number of the disk being moved
 * start - number of the tower from which the disk is being moved
 * end - number of the tower to which the disk is being moved
 *
 *
 * Problem Constraints
 * 1 <= A <= 18
 *
 *
 * Input Format
 * The first argument is the integer A.
 *
 *
 * Output Format
 * Return a 2D array with dimensions M x 3 as mentioned above in the description.
 *
 *
 * Example Input
 * Input 1:
 * A = 2
 * Input 2:
 *
 * A = 3
 *
 *
 * Example Output
 * Output 1:
 * [1 1 2 ] [2 1 3 ] [1 2 3 ]
 * Output 2:
 *
 * [1 1 3 ] [2 1 2 ] [1 3 2 ] [3 1 3 ] [1 2 1 ] [2 2 3 ] [1 1 3 ]
 */

public class Solution {
    private final List<List<Integer>> ans = new ArrayList();
    public int[][] towerOfHanoi(int A) {
        ans.clear();
        solve(A, 1, 2, 3);

        int[][] ans1 = new int[ans.size()][3];
        for(int i = 0; i < ans.size(); i++){
            ans1[i][0] = ans.get(i).get(0);
            ans1[i][1] = ans.get(i).get(1);
            ans1[i][2] = ans.get(i).get(2);
        }
        return ans1;
    }

    private void solve(int A, int t1, int t2, int t3){
        if(A == 1) {
            ans.add(new ArrayList(){{add(A);add(t1);add(t3);}});
            return;
        }
        solve(A - 1, t1, t3, t2);
        ans.add(new ArrayList(){{add(A);add(t1);add(t3);}});
        solve(A - 1, t2, t1, t3);
    }
}
